package club.kwcoder.admin.controller;

import club.kwcoder.server.bean.PageBean;
import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dto.CarDTO;
import club.kwcoder.server.dto.UserDTO;
import club.kwcoder.server.service.CarService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ResultBean<PageBean<CarDTO>> list(@RequestBody PageBean<CarDTO> page) {
        System.out.println(page);
        carService.list(page);
        return ResultBean.getSuccess("查询成功！", page);
    }

}
