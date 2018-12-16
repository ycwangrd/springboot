package ths.projects.study.java;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;

/**
 * @author: wangrd
 * @since: 2018年11月25日 22:11:52
 * @Desc:
 */
public class ProcessTest {

    public static void main(String[] args) {
        String result = execCmd("java -version", null);
        System.out.println(result);
        result = execCmd("mvn -version", new File("/Users/ycwangrd"));
        System.out.println(result);
        result = execCmd("ifconfig", null);
        System.out.println(result);
        result = execCmd("java ths.projects.study.java.SoutTest", new File("/Users/ycwangrd/Java/projects/GitHub/study/JavaTest/target/classes/"));
        System.out.println(result);
    }

    private static String execCmd(String cmd, File dir) {
        StringBuilder result = new StringBuilder();

        Process process;
        BufferedReader bufferIn = null, bufferError = null;

        try {
            // 执行命令, 返回一个子进程对象（命令在子进程中执行）
            process = Runtime.getRuntime().exec(cmd, null, dir);

            // 方法阻塞, 等待命令执行完成（成功会返回0）
            process.waitFor();

            // 获取命令执行结果, 有两个结果: 正常的输出 和 错误的输出（PS: 子进程的输出就是主进程的输入）
            bufferIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            bufferError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));

            // 读取输出
            String line;
            while ((line = bufferIn.readLine()) != null) {
                result.append(line).append('\n');
            }
            while ((line = bufferError.readLine()) != null) {
                result.append(line).append('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(bufferError);
            closeStream(bufferIn);
        }
        return result.toString();
    }

    /**
     * 关闭流
     *
     * @param stream
     */
    private static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception e) {
                // nothing
            }
        }
    }
}
