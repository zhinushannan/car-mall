package club.kwcoder.server.service;

import club.kwcoder.server.bean.PageBean;
import club.kwcoder.server.dto.CarDTO;

public interface CarService {

    void save(CarDTO car);

    void list(PageBean<CarDTO> page);

    CarDTO query(String id);

    void delete(String id);
}
