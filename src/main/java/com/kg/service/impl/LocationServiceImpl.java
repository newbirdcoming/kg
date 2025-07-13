package com.kg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kg.pojo.Location;
import com.kg.service.LocationService;
import com.kg.mapper.LocationMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【location】的数据库操作Service实现
* @createDate 2024-07-08 22:06:29
*/
@Service
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location>
    implements LocationService{

}




