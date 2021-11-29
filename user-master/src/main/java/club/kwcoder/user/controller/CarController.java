package club.kwcoder.user.controller;

import club.kwcoder.server.bean.PageBean;
import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dto.CarDTO;
import club.kwcoder.server.service.CarService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultBean<PageBean<CarDTO>> list(@RequestBody PageBean<CarDTO> page) {
        carService.list(page);
        return ResultBean.getSuccess("查询成功！", page);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResultBean<CarDTO> query(@RequestParam String id) {
        CarDTO car = carService.query(id);
        return ResultBean.getSuccess("查询成功！", car);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultBean<String> save(@RequestBody CarDTO car) {
        if (car.isLegal()) {
            return ResultBean.getForbid("参数错误！");
        }
        carService.save(car);
        return ResultBean.getSuccess("保存成功！", car.getId());
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResultBean<String> update(@RequestBody CarDTO car) {
        if (car.isLegal() || null == carService.query(car.getId())) {
            return ResultBean.getForbid("参数错误！");
        }
        carService.save(car);
        return ResultBean.getSuccess("保存成功！", car.getId());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResultBean<String> delete(@RequestParam String id) {
        if (StringUtils.isBlank(id)) {
            return ResultBean.getForbid("参数错误！");
        }
        if (null == carService.query(id)) {
            return ResultBean.getForbid("车辆不存在！");
        }
        carService.delete(id);
        return ResultBean.getSuccess("删除成功！", null);
    }

}
