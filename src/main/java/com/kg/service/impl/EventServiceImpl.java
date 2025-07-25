package com.kg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kg.pojo.Event;
import com.kg.service.EventService;
import com.kg.mapper.EventMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【event】的数据库操作Service实现
* @createDate 2024-07-08 22:06:29
*/
@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event>
    implements EventService{

}




