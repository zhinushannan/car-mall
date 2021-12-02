package club.kwcoder.user.controller;

import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dto.UserDTO;
import club.kwcoder.server.service.UserRegisterService;
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
    public ResultBean<String> sendCode(@RequestBody UserDTO user) {
        String email = user.getEmail();
        boolean b = userRegisterService.sendCode(email);
        if (b) {
            return ResultBean.getSuccess("发送成功！", null);
        } else {
            return ResultBean.getError("未知错误，请稍后重试！");
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultBean<String> register(@RequestBody UserDTO register) {
        return userRegisterService.register(register);
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    public ResultBean<String> changePassword(@RequestBody UserDTO change) {
        return userRegisterService.changePassword(change);
    }

}
