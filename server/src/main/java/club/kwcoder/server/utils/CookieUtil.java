package club.kwcoder.server.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static void addCookie(String name, String value, int maxAge, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
