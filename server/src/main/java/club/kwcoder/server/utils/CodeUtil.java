package club.kwcoder.server.utils;


public class CodeUtil {

    public static String getCode() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i ++) {
            code.append((int) (Math.random() * 10));
        }
        return code.toString();
    }

}
