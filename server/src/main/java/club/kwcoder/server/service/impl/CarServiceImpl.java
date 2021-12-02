package club.kwcoder.server.service.impl;

import club.kwcoder.server.bean.PageBean;
import club.kwcoder.server.dataobject.BrowseDO;
import club.kwcoder.server.dataobject.BrowseDOExample;
import club.kwcoder.server.dataobject.CarDO;
import club.kwcoder.server.dataobject.CarDOExample;
import club.kwcoder.server.dto.CarDTO;
import club.kwcoder.server.mapper.BrowseMapper;
import club.kwcoder.server.mapper.CarMapper;
import club.kwcoder.server.service.CarService;
import club.kwcoder.server.utils.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private BrowseMapper browseMapper;

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
    public void list(PageBean<CarDTO> page, String email) {
        this.list(page);
        List<CarDTO> carDTOS = page.getData();
        List<String> ids = new ArrayList<>();
        for (CarDTO car : carDTOS) {
            ids.add(car.getId());
        }
        BrowseDOExample example = new BrowseDOExample();
        example.or()
                .andCarIdIn(ids)
                .andUserEmailEqualTo(email);
        List<BrowseDO> browseDOS = browseMapper.selectByExample(example);

        this.setFrequencyAndLastBrowse(browseDOS, carDTOS);
    }

    @Override
    public void history(PageBean<CarDTO> page, String email) {
        // 分页查询浏览记录
        PageHelper.startPage(page.getPage(), page.getSize());
        BrowseDOExample browseDOExample = new BrowseDOExample();
        browseDOExample.or().andUserEmailEqualTo(email);
        List<BrowseDO> browseDOS = browseMapper.selectByExample(browseDOExample);

        // 提取需要查询的汽车id
        List<String> ids = new ArrayList<>();
        for (BrowseDO browseDO : browseDOS) {
            ids.add(browseDO.getCarId());
        }

        List<CarDTO> carDTOS = new ArrayList<>();
        if (ids.size() != 0) {
            CarDOExample carDOExample = new CarDOExample();
            carDOExample.or().andIdIn(ids);
            List<CarDO> carDOS = carMapper.selectByExample(carDOExample);
            carDTOS = CopyUtil.copyList(carDOS, CarDTO.class);
        }
        this.setFrequencyAndLastBrowse(browseDOS, carDTOS);

        PageInfo<BrowseDO> pageInfo = PageInfo.of(browseDOS);
        page
                .setTotal(pageInfo.getTotal())
                .setData(carDTOS);
    }

    /**
     * 根据浏览记录列表和汽车传输对象列表填充浏览次数和浏览时间
     *
     * @param browseDOS 浏览记录列表
     * @param carDTOS   汽车传输对象列表
     */
    private void setFrequencyAndLastBrowse(List<BrowseDO> browseDOS, List<CarDTO> carDTOS) {
        Map<String, BrowseDO> idAndFrequency = new HashMap<>();
        for (BrowseDO browse : browseDOS) {
            idAndFrequency.put(browse.getCarId(), browse);
        }
        for (CarDTO car : carDTOS) {
            if (null != idAndFrequency.get(car.getId())) {
                car.setLastBrowse(idAndFrequency.get(car.getId()).getLastBrowse());
                car.setFrequency(idAndFrequency.get(car.getId()).getFrequency());
            }
        }
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
