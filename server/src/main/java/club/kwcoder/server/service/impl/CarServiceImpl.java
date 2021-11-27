package club.kwcoder.server.service.impl;

import club.kwcoder.server.bean.PageBean;
import club.kwcoder.server.dataobject.CarDO;
import club.kwcoder.server.dataobject.CarDOExample;
import club.kwcoder.server.dto.CarDTO;
import club.kwcoder.server.mapper.CarMapper;
import club.kwcoder.server.service.CarService;
import club.kwcoder.server.utils.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public void save(CarDTO car) {
        // 插入
        if (StringUtils.isBlank(car.getId())) {
            car.setId(UUID.randomUUID().toString());
            CarDO carDO = CopyUtil.copy(car, CarDO.class);
            LocalDateTime now = LocalDateTime.now();
            carDO
                    .setCreatedGmt(now)
                    .setModifiedGmt(now);
            carMapper.insert(carDO);
        }
        // 修改
        else {
            CarDO carDO = CopyUtil.copy(car, CarDO.class);
            carDO.setModifiedGmt(LocalDateTime.now());
            carMapper.updateByPrimaryKey(carDO);
        }
    }

    @Override
    public void list(PageBean<CarDTO> page) {
        PageHelper.startPage(page.getPage(), page.getSize());
        List<CarDO> carDOS = carMapper.selectByExample(new CarDOExample());
        PageInfo<CarDO> pageInfo = PageInfo.of(carDOS);
        List<CarDTO> carDTOS = CopyUtil.copyList(carDOS, CarDTO.class);
        page
                .setTotal(pageInfo.getTotal())
                .setData(carDTOS);
    }

    @Override
    public CarDTO query(String id) {
        CarDO carDO = carMapper.selectByPrimaryKey(id);
        return CopyUtil.copy(carDO, CarDTO.class);
    }

    @Override
    public void delete(String id) {
        carMapper.deleteByPrimaryKey(id);
    }
}
