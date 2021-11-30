package club.kwcoder.user.controller;

import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dto.UserDTO;
import club.kwcoder.server.service.UserLoginService;
import club.kwcoder.server.utils.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import club.kwcoder.server.consts.UserConst;

@RestController
public class LoginController {

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultBean<String> login(@RequestBody UserDTO user,
                                    HttpServletResponse response) {
        if (user.isEmailLegal() || StringUtils.isBlank(user.getPassword())) {
            return ResultBean.getError("参数错误！");
        }
        ResultBean<String> login = userLoginService.login(user);

        if (login.getSuccess()) {
            Cookie emailCookie = new Cookie("email", user.getEmail());
            emailCookie.setMaxAge(UserConst.USER_LOGIN_AGE);
            emailCookie.setPath("/");

            String token = UUID.randomUUID().toString();
            Cookie tokenCookie = new Cookie("token", token);
            tokenCookie.setMaxAge(UserConst.USER_LOGIN_AGE);
            tokenCookie.setPath("/");

            response.addCookie(emailCookie);
            response.addCookie(tokenCookie);

            redisUtil.setString("email:" + user.getEmail(), token, UserConst.USER_LOGIN_AGE, TimeUnit.SECONDS);
        }
        return login;
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ResultBean<String> logout(@CookieValue("email") String email) {
        redisUtil.del(email);
        return ResultBean.getSuccess("退出成功！", null);
    }

}
