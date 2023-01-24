package uz.b.application.config.utils;

public class CoreUtils {

    public static Integer generateSmsCode() {
        return (int) (Math.random() * 89999 + 10000);
    }
}
