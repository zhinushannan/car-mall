package club.kwcoder.admin.controller;

import club.kwcoder.server.bean.PageBean;
import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dto.UserDTO;
import club.kwcoder.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ResultBean<PageBean<UserDTO>> list(@RequestBody PageBean<UserDTO> page) {
        userService.list(page);
        return ResultBean.getSuccess("查询用户列表成功！", page);
    }

    @RequestMapping(value = "reset", method = RequestMethod.PUT)
    public ResultBean<String> resetPassword(@RequestParam String email) {
        userService.resetPassword(email);
        return ResultBean.getSuccess("重置用户密码成功！", null);
    }

}
