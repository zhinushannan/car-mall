package club.kwcoder.server.service;

import club.kwcoder.server.bean.PageBean;
import club.kwcoder.server.dto.UserDTO;

public interface UserService {

    void list(PageBean<UserDTO> page);

    void resetPassword(String email);

}
