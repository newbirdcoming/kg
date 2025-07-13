package com.kg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kg.pojo.Time;
import com.kg.service.TimeService;
import com.kg.mapper.TimeMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【time】的数据库操作Service实现
* @createDate 2024-07-08 22:06:30
*/
@Service
public class TimeServiceImpl extends ServiceImpl<TimeMapper, Time>
    implements TimeService{

}




