package ths.project.thsboot.persistence.security;

/**
 * @author: wangrd
 * @since: 2018年07月29日 09:52:28
 * @Desc:
 */
public class CurrentUserHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static String getUser() {
        return holder.get() == null ? "unkown" : holder.get();
    }

    public static void setUser(String user) {
        holder.set(user);
    }
}
