package club.kwcoder.server.service;

import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dto.UserDTO;

import javax.servlet.http.HttpServletResponse;

public interface UserLoginService {

    ResultBean<String> login(UserDTO user);

    boolean hasLogin(String email, String token);

    void logout(String email, HttpServletResponse response);

}
