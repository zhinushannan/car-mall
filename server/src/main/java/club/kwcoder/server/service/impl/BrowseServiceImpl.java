package club.kwcoder.server.service.impl;

import club.kwcoder.server.dataobject.BrowseDO;
import club.kwcoder.server.dataobject.BrowseDOKey;
import club.kwcoder.server.mapper.BrowseMapper;
import club.kwcoder.server.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BrowseServiceImpl implements BrowseService {

    @Autowired
    private BrowseMapper browseMapper;

    @Override
    public void browse(String carId, String email) {
        BrowseDO browseDO = browseMapper.selectByPrimaryKey(new BrowseDOKey(carId, email));
        if (null == browseDO) {
            browseDO = new BrowseDO();
            browseDO
                    .setLastBrowse(LocalDateTime.now())
                    .setFrequency(1)
                    .setCarId(carId)
                    .setUserEmail(email);
            browseMapper.insert(browseDO);
        } else {
            browseDO
                    .setLastBrowse(LocalDateTime.now())
                    .setFrequency(browseDO.getFrequency() + 1);
            browseMapper.updateByPrimaryKey(browseDO);
        }
    }
}
