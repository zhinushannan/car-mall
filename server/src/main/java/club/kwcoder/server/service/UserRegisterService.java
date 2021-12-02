package club.kwcoder.server.service;

import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dto.UserDTO;

public interface UserRegisterService {

    boolean sendCode(String email);

    boolean hasRegistered(String email);

    ResultBean<String> register(UserDTO user);

    ResultBean<String> changePassword(UserDTO user);

}
