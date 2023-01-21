package uz.b.application.config.core;

import uz.b.application.auth.AuthUser;

public class GlobalVar {

    private final static ThreadLocal<AuthUser> AUTH_USER = ThreadLocal.withInitial(() -> null);
    private final static ThreadLocal<String> H_AUTH_TOKEN = ThreadLocal.withInitial(String::new);

    public static AuthUser getAuthUser() {
        return GlobalVar.AUTH_USER.get();
    }

    public static void setAuthUser(AuthUser authUser) {
        GlobalVar.AUTH_USER.set(authUser);
    }

    public static void clearContext() {
        GlobalVar.AUTH_USER.remove();
        GlobalVar.H_AUTH_TOKEN.remove();
    }

    public static String getAuthToken() {
        return GlobalVar.H_AUTH_TOKEN.get();
    }

    public static void setAuthToken(String authToken) {
        GlobalVar.H_AUTH_TOKEN.set(authToken);
    }
}
