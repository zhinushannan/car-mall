package club.kwcoder.server.service;

import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dto.UserDTO;

public interface UserRegisterService {

    boolean hasRegistered(String email);

    void register(UserDTO user);

    ResultBean<String> changePassword(UserDTO user);

}