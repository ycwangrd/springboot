package ths.project.thsboot.web.config;

import com.google.gson.Gson;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author: wangrd
 * @since: 2018年07月30日 15:06:19
 * @Desc:
 */
@Component  //声明组件
@Aspect //  声明切面
@ComponentScan  //组件自动扫描
@EnableAspectJAutoProxy //spring自动切换JDK动态代理和CGLIB
public class GirlAspect {
    /**
     * Spring AOP 支持在切入点表达式中使用如下的AspectJ切入点指定者：
     * 1：execution：匹配方法执行的连接点，这是你将会用到的Spring的最主要的切入点指定者。
     * 2：within：限定匹配特定类型的连接点（在使用SpringAOP的时候，在匹配的类型中定义的方法的执行）。
     * 3：this：限定匹配特定的连接点（使用Spring AOP的时候方法的执行），其中bean reference（Spring AOP 代理）是指定类型的实例。
     * 4： target：限定匹配特定的连接点（使用SpringAOP的时候方法的执行），其中目标对象（被代理的appolication object）是指定类型的实例。
     * 5： args：限定匹配特定的连接点（使用Spring AOP的时候方法的执行），其中参数是指定类型的实例。
     * 6： @target：限定匹配特定的连接点（使用SpringAOP的时候方法的执行），其中执行的对象的类已经有指定类型的注解。
     * 7： @args：限定匹配特定的连接点（使用SpringAOP的时候方法的执行），其中实际传入参数的运行时类型有指定类型的注解。
     * 8： @within：限定匹配特定的连接点，其中连接点所在类型已指定注解（在使用Spring AOP的时候，所执行的方法所在类型已指定注解）。
     * 9： @annotation：限定匹配特定的连接点（使用SpringAOP的时候方法的执行），其中连接点的主题有某种给定的注解
     * 合并切入点表达式
     * 切入点表达式可以使用‘&&', '||' 和'!'来合并.还可以通过名字来指向切入点表达式。
     */

    /**
     * 自定义日志
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 打印类method的名称以及参数
     *
     * @param point 切面
     */
    private void printMethodParams(JoinPoint point) {
        if (point == null) {
            return;
        }
        // 类名
        String className = point.getTarget().getClass().getName();
        // Signature 包含了方法名、申明类型以及地址等信息
        String methodName = point.getSignature().getName();
        // 重新定义日志
        logger = LoggerFactory.getLogger(point.getTarget().getClass());
        logger.info("className={}, methodName={}", className, methodName);
        // 获取方法的参数值数组。
        Object[] args = point.getArgs();

        try {
            // 获取方法参数名称
            String[] paramNames = getParamterNames(className, methodName);
            // 打印方法的参数名和参数值
            printParam(paramNames, args);
        } catch (Exception e) {
            logger = LoggerFactory.getLogger(getClass());
            logger.error(e.getCause().getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 打印方法参数值  基本类型直接打印，非基本类型需要重写toString方法
     *
     * @param paramsArgsName  参数名
     * @param paramsArgsValue 参数值
     */
    private void printParam(String[] paramsArgsName, Object[] paramsArgsValue) {
        if (ArrayUtils.isEmpty(paramsArgsName) || ArrayUtils.isEmpty(paramsArgsValue)) {
            logger.info("该方法没有参数");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < paramsArgsName.length; i++) {
            //参数名
            String name = paramsArgsName[i];
            //参数值
            Object value = paramsArgsValue[i];
            buffer.append("参数:" + name);
            if (value != null) {
                if (isPrimite(value.getClass())) {
                    buffer.append("=" + value + "  ,");
                } else {
                    buffer.append("=" + value.toString() + "  ,");
                }
            } else {
                buffer.append("为空.");
            }
        }
        logger.info(buffer.toString());
    }

    /**
     * 判断参数类型是否是基本类型
     *
     * @param clazz 参数类型
     * @return
     */
    private boolean isPrimite(Class<?> clazz) {
        if (clazz.isPrimitive() || clazz.getName().equalsIgnoreCase("String")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取方法参数名称列表
     *
     * @param className  类名
     * @param methodName 方法名
     * @return
     */
    private String[] getParamterNames(String className, String methodName) throws Exception {
        // 通过Class.forName能确定该class是否存在
        Class<?> clazz = Class.forName(className);
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get(clazz.getName());
        CtMethod ctMethod = ctClass.getDeclaredMethod(methodName);
        MethodInfo methodInfo = ctMethod.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            logger.info("{}的{}方法没有参数", className, methodName);
        }
        String[] paramNames = new String[ctMethod.getParameterTypes().length];
        int pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1;
        for (int i = 0; i < paramNames.length; i++) {
            paramNames[i] = attr.variableName(i + pos);
        }
        return paramNames;
    }

    /**
     * <li>Before       : 在方法执行前进行切面</li>
     * <li>execution    : 定义切面表达式</li>
     * <p>public * com.eparty.ccp.*.impl..*.*(..)
     * <li>public :匹配所有目标类的public方法，不写则匹配所有访问权限</li>
     * <li>第一个* :方法返回值类型，*代表所有类型 </li>
     * <li>第二个* :包路径的通配符</li>
     * <li>第三个..* :表示impl这个目录下所有的类，包括子目录的类</li>
     * <li>第四个*(..) : *表示所有任意方法名,..表示任意参数</li>
     * </p>
     *
     * @param point 切面
     */
    @Before(value = "execution(public * ths.project.thsboot.web.controller.*Controller.*(..))")
    public void before(JoinPoint point) {
        this.printMethodParams(point);
    }

    private void printResult(JoinPoint point, Object returnValue) {
        // 重新定义日志
        logger = LoggerFactory.getLogger(point.getTarget().getClass());
        logger.info("返回值是:" + new Gson().toJson(returnValue));
    }

    @AfterReturning(pointcut = "execution(public * ths.project.thsboot.web.controller.*Controller.*(..))", returning = "returnValue")
    public void afterReturn(JoinPoint point, Object returnValue) {
        this.printResult(point, returnValue);
    }

//    private void aspectTest(JoinPoint point, String aspect) {
//        System.out.println(LocalDateTime.now().toString() + ":aspectTest:" + point + "," + aspect);
//    }
//
//    @After(value = "execution(public * ths.project.thsboot.web.controller.*Controller.*(..))")
//    public void doAfter(JoinPoint point) {
//        this.aspectTest(point, "after");
//    }
//
//    @Around(value = "execution(public * ths.project.thsboot.web.controller.*Controller.*(..))")
//    public void doAround(JoinPoint point) {
//        this.aspectTest(point, "around");
//    }
}
