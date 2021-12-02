package club.kwcoder.user.controller;

import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dto.UserDTO;
import club.kwcoder.server.service.UserRegisterService;
import club.kwcoder.server.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterController {

    @Autowired
    private UserRegisterService userRegisterService;

    @RequestMapping(value = "sendCode", method = RequestMethod.POST)
    public ResultBean<String> sendCode(@RequestBody String email) {
        boolean b = userRegisterService.sendCode(email);
        if (b) {
            return ResultBean.getSuccess("发送成功！", null);
        } else {
            return ResultBean.getError("未知错误，请稍后重试！");
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultBean<String> register(@RequestBody UserDTO register) {
        if (register.isPasswordEqualRepeat() || register.isEmailLegal()) {
            return ResultBean.getForbid("参数错误！");
        }
        if (userRegisterService.hasRegistered(register.getEmail())) {
            return ResultBean.getForbid("该邮箱已被注册！");
        }
        // 进行注册
        userRegisterService.register(register);
        return ResultBean.getSuccess("注册成功！", null);
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    public ResultBean<String> changePassword(@RequestBody UserDTO change) {
        if (change.isPasswordEqualRepeat() || change.isEmailLegal()) {
            return ResultBean.getForbid("参数错误！");
        }
        // 进行修改
        return userRegisterService.changePassword(change);
    }

}
