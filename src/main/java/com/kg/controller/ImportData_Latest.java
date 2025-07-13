package com.kg.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kg.mapper.*;
import com.kg.pojo.*;
import com.kg.pojo.dto.ImportAllNewDto;
import com.kg.utils.ExcelUtils;
import com.kg.utils.IdWorkerUtils;
import com.kg.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

import static com.kg.utils.ProducelatAndLong.getRandomLatitude;
import static com.kg.utils.ProducelatAndLong.getRandomLongitude;
import static com.kg.utils.RandomTimeGeneratorUtils.generateRandomDateTime;

/**
 * @author Mr.Lan
 * @version 1.0
 * @ClassName ImportData$
 * @description d2rq数据导入数据库
 * @date 2024/6/27 13:55
 **/
@RestController
@Api(tags = "excel导入最新")
@RequestMapping("/excelImporLatest")
public class ImportData_Latest {

    @Autowired
    private TimeMapper timeMapper;

    @Autowired
    private LocationMapper locationMapper;

    @Autowired
    private EntityMapper entityMapper;

    @Autowired
    private HazardMapper hazardMapper;

    @Autowired
    private CollaborativeActivityMapper collaborativeActivityMapper;


    @Autowired
    private RiskMapper riskMapper;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private EmployMapper employMapper;

    @Autowired
    private ConsequenceMapper consequenceMapper;

    @Autowired
    private AppealMapper appealMapper;

    @Autowired
    private ParticipantMapper participantMapper;

    @Autowired
    private WealthMapper resourceMapper;

    @Autowired
    private ParticipantActivityMapper participantActivityMapper;

    @Autowired
    private CollaborationNetworkMapper collaborationNetworkMapper;

    @Autowired
    private CooperationMapper cooperationMapper;

    @Autowired
    private AppealToEntityMapper appealToEntityMapper;


    @Autowired
    private CollaborationNetworkActivityMapper collaborationNetworkActivityMapper;

    @Autowired
    private SusceptibleToMapper entityHazardMapper;

    @Autowired
    private ExistRiskMapper hazardRiskMapper;

    @Autowired
    private MayTriggerMapper eventRiskMapper;

    @Autowired
    private LeadsToMapper eventConsequenceMapper;

    @Autowired
    private AppealToHazardMapper appealHazardMapper;

    @Autowired
    private AppealToRiskMapper appealRiskMapper;

    @Autowired
    private AppealToEventMapper appealEventMapper;

    @Autowired
    private AppealToConsequenceMapper appealConsequenceMapper;

    @Autowired
    private AppealToParticipantMapper appealParticipantMapper;

    @Autowired
    private AppealToParticipantActivityMapper appealParticipantActivityMapper;

    @Autowired
    private AppealToCollaborationNetworkMapper appealCollaborationNetworkMapper;

    @Autowired
    private AppealToCollaborationNetworkActivityMapper appealCollaborationNetworkActivityMapper;

    @Autowired
    private AppealToWealthMapper appealResourceMapper;


    @Autowired
    private ExistParticipantMapper existParticipantMapper;

    @Autowired
    private AppealToTimeMapper appealTimeMapper;

    @Autowired
    private AppealToLocationMapper appealLocationMapper;


    @Autowired
    private ConductMapper conductMapper;


    @Autowired
    private ParticipantToLocationMapper participantToLocationMapper;

    @Autowired
    private CollaborativeToLocationMapper collaborativeToLocationMapper;

    
    @Autowired
    private TypeOneMapper typeOneMapper;

    @Autowired
    private TypeTwoMapper typeTwoMapper;

    @Autowired
    private TypeThreeMapper typeThreeMapper;
    
    @Autowired
    private AppealToTypeOneMapper appealToTypeOneMapper;

    @Autowired
    private AppealToTypeTwoMapper appealToTypeTwoMapper;

    @Autowired
    private AppealToTypeThreeMapper appealToTypeThreeMapper;

    @ApiOperation("d2rq导入数据")
    @PostMapping("/D2rqimportTable")
    @Transactional
    public Result importEntities(@RequestPart("file") MultipartFile file) throws Exception {
        IdWorkerUtils idWorker = IdWorkerUtils.getInstance();
        List<ImportAllNewDto> importAllDtos = ExcelUtils.readMultipartFile(file, ImportAllNewDto.class);
        try {
            for (ImportAllNewDto data : importAllDtos) {
                // 插入地点表数据
                String locationId = null;
                String location = data.getLocation();
                if (location != null) {
                    LambdaQueryWrapper<Location> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Location::getLocation, location);
                    Location locationNode = locationMapper.selectOne(addressLambdaQueryWrapper);
                    if (locationNode == null) {
                        locationId = idWorker.createUUID();
                        Location location1 = new Location();
                        location1.setId(locationId);
                        location1.setLocation(location);
                        double randomLongitude = getRandomLongitude();
                        double randomLatitude = getRandomLatitude();
                        location1.setLatitude(randomLatitude);
                        location1.setLongitude(randomLongitude);
                        locationMapper.insert(location1);
                    } else {
                        locationId = locationNode.getId();
                    }
                }


//                // 插入参与者地点表数据
//                String ParticipantLocationId = null;
//                String participantLocation = data.getParticipantLocation();
//                if (participantLocation != null) {
//                    LambdaQueryWrapper<Location> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                    addressLambdaQueryWrapper.eq(Location::getLocation, participantLocation);
//                    Location locationNode = locationMapper.selectOne(addressLambdaQueryWrapper);
//                    if (locationNode == null) {
//                        ParticipantLocationId = idWorker.createUUID();
//                        Location location1 = new Location();
//                        location1.setId(ParticipantLocationId);
//                        location1.setLocation(participantLocation);
//                        double randomLongitude = getRandomLongitude();
//                        double randomLatitude = getRandomLatitude();
//                        location1.setLatitude(randomLatitude);
//                        location1.setLongitude(randomLongitude);
//                        locationMapper.insert(location1);
//                    } else {
//                        ParticipantLocationId = locationNode.getId();
//                    }
//
//                }


                String ParticipantLocationId = null;
                String participantLocation = data.getParticipantLocation();
                if (participantLocation != null) {
                    LambdaQueryWrapper<Location> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Location::getLocation, participantLocation);
                    Location locationNode = locationMapper.selectOne(addressLambdaQueryWrapper);
                    if (locationNode == null) {
                        locationId = idWorker.createUUID();
                        Location location1 = new Location();
                        location1.setId(locationId);
                        location1.setLocation(participantLocation);
                        double randomLongitude = getRandomLongitude();
                        double randomLatitude = getRandomLatitude();
                        location1.setLatitude(randomLatitude);
                        location1.setLongitude(randomLongitude);
                        locationMapper.insert(location1);
                    } else {
                        ParticipantLocationId = locationNode.getId();
                    }
                }

//                // 插入协作网络地点表数据
//                String collaborationNetworkLocationId = null;
//                String collaborationNetworkLocation = data.getLocation();
//                if (collaborationNetworkLocation != null) {
//                    LambdaQueryWrapper<Location> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                    addressLambdaQueryWrapper.eq(Location::getLocation, collaborationNetworkLocation);
//                    Location locationNode = locationMapper.selectOne(addressLambdaQueryWrapper);
//                    if (locationNode == null) {
//                        collaborationNetworkLocationId = idWorker.createUUID();
//                        Location location1 = new Location();
//                        location1.setId(collaborationNetworkLocationId);
//                        location1.setLocation(collaborationNetworkLocation);
//                        double randomLongitude = getRandomLongitude();
//                        double randomLatitude = getRandomLatitude();
//                        location1.setLatitude(randomLatitude);
//                        location1.setLongitude(randomLongitude);
//                        locationMapper.insert(location1);
//                    } else {
//                        collaborationNetworkLocationId = locationNode.getId();
//                    }
//
//                }

                String collaborationNetworkLocationId = null;
                String collaborationNetworkLocation = data.getCollaborationNetworkLocation();
                if (collaborationNetworkLocation != null) {
                    LambdaQueryWrapper<Location> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Location::getLocation, collaborationNetworkLocation);
                    Location locationNode = locationMapper.selectOne(addressLambdaQueryWrapper);
                    if (locationNode == null) {
                        locationId = idWorker.createUUID();
                        Location location1 = new Location();
                        location1.setId(locationId);
                        location1.setLocation(collaborationNetworkLocation);
                        double randomLongitude = getRandomLongitude();
                        double randomLatitude = getRandomLatitude();
                        location1.setLatitude(randomLatitude);
                        location1.setLongitude(randomLongitude);
                        locationMapper.insert(location1);
                    } else {
                        collaborationNetworkLocationId = locationNode.getId();
                    }
                }





                // 插入实体表数据
                String entityId = null;
                String subject = data.getSubject();
                String object = data.getObject();
                if (subject != null || object != null) {
                    LambdaQueryWrapper<Entity> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Entity::getSubject, subject);
                    addressLambdaQueryWrapper.eq(Entity::getObject, object);
                    Entity entityNode = entityMapper.selectOne(addressLambdaQueryWrapper);
                    if (entityNode == null) {
                        entityId = idWorker.createUUID();
                        Entity entity = new Entity();
                        entity.setId(entityId);
                        entity.setSubject(subject);
                        entity.setObject(object);
                        entityMapper.insert(entity);
                    } else {
                        entityId = entityNode.getId();
                    }
                }


                // 插入隐患表数据
                String hazardId = null;
                String hazard = data.getHazard();
                if (hazard != null) {
                    LambdaQueryWrapper<Hazard> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Hazard::getName, hazard);
                    Hazard hazardNode = hazardMapper.selectOne(addressLambdaQueryWrapper);
                    if (hazardNode == null) {
                        hazardId = idWorker.createUUID();
                        Hazard hazard1 = new Hazard();
                        hazard1.setId(hazardId);
                        hazard1.setName(hazard);
                        hazardMapper.insert(hazard1);
                    } else {
                        hazardId = hazardNode.getId();
                    }
                }

                // 插入风险表数据

                String riskId = null;
                String riseName = data.getRisk();
                if (riseName != null) {
                    LambdaQueryWrapper<Risk> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Risk::getName, riseName);
                    Risk riskNode = riskMapper.selectOne(addressLambdaQueryWrapper);
                    if (riskNode == null) {
                        riskId = idWorker.createUUID();
                        Risk risk = new Risk();
                        risk.setId(riskId);
                        risk.setName(riseName);
                        riskMapper.insert(risk);
                    } else {
                        riskId = riskNode.getId();
                    }
                }

                // 插入事件表数据
                String eventId = null;
                String eventName = data.getEvent();
                if (eventName != null) {
                    LambdaQueryWrapper<Event> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Event::getName, eventName);
                    Event eventNode = eventMapper.selectOne(addressLambdaQueryWrapper);
                    if (eventNode == null) {
                        eventId = idWorker.createUUID();
                        Event event = new Event();
                        event.setId(eventId);
                        event.setName(eventName);
                        eventMapper.insert(event);
                    } else {
                        eventId = eventNode.getId();
                    }
                }

                // 插入后果表数据
                String consequenceId = null;
                String consequenceName = data.getConsequence();
                if (eventName != null) {
                    LambdaQueryWrapper<Consequence> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Consequence::getName, consequenceName);
                    Consequence consequenceNode = consequenceMapper.selectOne(addressLambdaQueryWrapper);
                    if (consequenceNode == null) {
                        consequenceId = idWorker.createUUID();
                        Consequence consequence = new Consequence();
                        consequence.setId(consequenceId);
                        consequence.setName(consequenceName);
                        consequenceMapper.insert(consequence);
                    } else {
                        consequenceId = consequenceNode.getId();
                    }
                }


                // 插入诉求表数据
                String appealId = null;
                String number = data.getNumber();
                //插入类型一
                String type1 = data.getType1();
                String type2 = data.getType2();
                String type3 = data.getType3();
                if (number != null) {
                    LambdaQueryWrapper<Appeal> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Appeal::getNumber, number);
                    Appeal AppealNode = appealMapper.selectOne(addressLambdaQueryWrapper);
                    if (AppealNode == null) {
                        appealId = idWorker.createUUID();
                        Appeal appeal = new Appeal();
                        appeal.setId(appealId);
                        appeal.setNumber(number);
                        appeal.setType1(type1);
                        appeal.setType2(type2);
                        appeal.setType3(type3);
                        appealMapper.insert(appeal);
                    } else {
                        appealId = AppealNode.getId();
                    }
                }


//                String type1Id = null;
//                if (type1 != null) {
//                    LambdaQueryWrapper<TypeOne> typeOneLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                    typeOneLambdaQueryWrapper.eq(TypeOne::getName,type1);
//                    TypeOne typeOne = typeOneMapper.selectOne(typeOneLambdaQueryWrapper);
//                    if (typeOne == null) {
//                        type1Id = idWorker.createUUID();
//                        TypeOne typeOne1 = new TypeOne();
//                        typeOne1.setId(type1Id);
//                        typeOne1.setName(type1);
//                        typeOneMapper.insert(typeOne1);
//                    } else {
//                        type1Id = typeOne.getId();
//                    }
//                }
//                //插入类型二
//                String type2Id = null;
//                if (type2 != null) {
//                    LambdaQueryWrapper<TypeTwo> typeOneLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                    typeOneLambdaQueryWrapper.eq(TypeTwo::getName,type2);
//                    TypeTwo typeTwo = typeTwoMapper.selectOne(typeOneLambdaQueryWrapper);
//                    if (typeTwo == null) {
//                        type2Id = idWorker.createUUID();
//                        TypeTwo typeTwo1 = new TypeTwo();
//                        typeTwo1.setId(type2Id);
//                        typeTwo1.setName(type2);
//                        typeTwoMapper.insert(typeTwo1);
//                    } else {
//                        type2Id = typeTwo.getId();
//                    }
//                }
//
//                //插入类型三
//                String type3Id = null;
//                if (type3 != null) {
//                    LambdaQueryWrapper<TypeThree> typeOneLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                    typeOneLambdaQueryWrapper.eq(TypeThree::getName,type3);
//                    TypeThree typeThree = typeThreeMapper.selectOne(typeOneLambdaQueryWrapper);
//                    if (typeThree == null) {
//                        type3Id = idWorker.createUUID();
//                        TypeThree typeThree1 = new TypeThree();
//                        typeThree1.setId(type3Id);
//                        typeThree1.setName(type3);
//                        typeThreeMapper.insert(typeThree1);
//                    } else {
//                        type3Id = typeThree.getId();
//                    }
//                }
                //                //时间节点
//                String timeId = null;
//                LocalDateTime occurredAt = data.getOccurredAt();
//                if (occurredAt != null) {
//                    //存在就给timeid
//                    LambdaQueryWrapper<Time> timeLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                    timeLambdaQueryWrapper.eq(Time::getOccurredAt, occurredAt);
//                    Time timeNode = timeMapper.selectOne(timeLambdaQueryWrapper);
//                    if (timeNode == null) {
//                        timeId = idWorker.createUUID();
//                        data.setId(timeId);
//                        // 插入时间表数据
//                        Time time = new Time();
//                        time.setId(timeId);
//                        time.setOccurredAt(occurredAt);
//                        timeMapper.insert(time);
//                    } else {
//                        timeId = timeNode.getId();
//                    }
//                }


                //时间随机生成 一旦存在则不生成
                String timeId = null;
                LocalDateTime occurredAt = data.getOccurredAt();
                //诉求是否存在时间(诉求时间存在就说明有了)
                LambdaQueryWrapper<AppealToTime> appealToTimeLambdaQueryWrapper = new LambdaQueryWrapper<>();
                appealToTimeLambdaQueryWrapper.eq(AppealToTime::getAppealId, appealId);
                AppealToTime appealToTime1 = appealTimeMapper.selectOne(appealToTimeLambdaQueryWrapper);
                if (appealToTime1 == null) {
                    occurredAt = generateRandomDateTime(12);
                }
                if (occurredAt != null) {
                    //存在就给timeid
                    LambdaQueryWrapper<Time> timeLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    timeLambdaQueryWrapper.eq(Time::getOccurredAt, occurredAt);
                    Time timeNode = timeMapper.selectOne(timeLambdaQueryWrapper);
                    if (timeNode == null) {
                        timeId = idWorker.createUUID();
                        data.setId(timeId);
                        // 插入时间表数据
                        Time time = new Time();
                        time.setId(timeId);
                        time.setOccurredAt(occurredAt);
                        timeMapper.insert(time);
                    } else {
                        timeId = timeNode.getId();
                    }
                }

                // 插入参与者表数据
                String ParticipantId = null;
                String ParticipantName = data.getParticipant();
                if (ParticipantName != null) {
                    LambdaQueryWrapper<Participant> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Participant::getName, ParticipantName);
                    Participant participantNode = participantMapper.selectOne(addressLambdaQueryWrapper);
                    if (participantNode == null) {
                        ParticipantId = idWorker.createUUID();
                        Participant participant = new Participant();
                        participant.setId(ParticipantId);
                        participant.setName(ParticipantName);
                        participantMapper.insert(participant);
                    } else {
                        ParticipantId = participantNode.getId();
                    }
                }


                // 插入资源表数据
                String WealthId = null;
                String WealthName = data.getWealth();
                if (WealthName != null) {
                    LambdaQueryWrapper<Wealth> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Wealth::getName, WealthName);
                    Wealth wealthNode = resourceMapper.selectOne(addressLambdaQueryWrapper);
                    if (wealthNode == null) {
                        WealthId = idWorker.createUUID();
                        Wealth wealth = new Wealth();
                        wealth.setId(WealthId);
                        wealth.setName(WealthName);
                        resourceMapper.insert(wealth);
                    } else {
                        WealthId = wealthNode.getId();
                    }
                }


                // 插入参与者活动表数据
                String ParticipantActivityId = null;
                String ParticipantActivityName = data.getParticipantActivity();
                if (ParticipantActivityName != null) {
                    LambdaQueryWrapper<ParticipantActivity> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(ParticipantActivity::getName, ParticipantActivityName);
                    ParticipantActivity participantActivityNode = participantActivityMapper.selectOne(addressLambdaQueryWrapper);
                    if (participantActivityNode == null) {
                        ParticipantActivityId = idWorker.createUUID();
                        ParticipantActivity participantActivity = new ParticipantActivity();
                        participantActivity.setId(ParticipantActivityId);
                        participantActivity.setName(ParticipantActivityName);
                        participantActivityMapper.insert(participantActivity);
                    } else {
                        ParticipantActivityId = participantActivityNode.getId();
                    }
                }


                // 插入协作网络表数据
                String CollaborationNetworkId = null;
                String CollaborationNetworkName = data.getCollaborationNetwork();
                if (CollaborationNetworkName != null) {
                    LambdaQueryWrapper<CollaborationNetwork> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(CollaborationNetwork::getName, CollaborationNetworkName);
                    CollaborationNetwork collaborationNetworkNode = collaborationNetworkMapper.selectOne(addressLambdaQueryWrapper);
                    if (collaborationNetworkNode == null) {
                        CollaborationNetworkId = idWorker.createUUID();
                        CollaborationNetwork collaborationNetwork = new CollaborationNetwork();
                        collaborationNetwork.setId(CollaborationNetworkId);
                        collaborationNetwork.setName(CollaborationNetworkName);
                        collaborationNetworkMapper.insert(collaborationNetwork);
                    } else {
                        CollaborationNetworkId = collaborationNetworkNode.getId();
                    }
                }


                // 插入协作网络活动表数据
                String CollaborationNetworkActivityId = null;
                String CollaborationNetworkActivityName = data.getCollaborationNetworkActivity();
                if (CollaborationNetworkActivityName != null) {
                    LambdaQueryWrapper<CollaborationNetworkActivity> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(CollaborationNetworkActivity::getName, CollaborationNetworkActivityName);
                    CollaborationNetworkActivity collaborationNetworkActivityNode = collaborationNetworkActivityMapper.selectOne(addressLambdaQueryWrapper);
                    if (collaborationNetworkActivityNode == null) {
                        CollaborationNetworkActivityId = idWorker.createUUID();
                        CollaborationNetworkActivity collaborationNetworkActivity = new CollaborationNetworkActivity();
                        collaborationNetworkActivity.setId(CollaborationNetworkActivityId);
                        collaborationNetworkActivity.setName(CollaborationNetworkActivityName);
                        collaborationNetworkActivityMapper.insert(collaborationNetworkActivity);
                    } else {
                        CollaborationNetworkActivityId = collaborationNetworkActivityNode.getId();
                    }
                }


                // {参与者，使用，资源}
                if (ParticipantId != null && WealthId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<Employ> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Employ::getParticipantId, ParticipantId);
                    addressLambdaQueryWrapper.eq(Employ::getWealthId, WealthId);
                    Employ employNode = employMapper.selectOne(addressLambdaQueryWrapper);
                    if (employNode == null) {
                        Employ employ = new Employ();
                        employ.setParticipantId(ParticipantId);
                        employ.setWealthId(WealthId);
                        employMapper.insert(employ);
                    }
                }

                // {参与者，进行，参与者活动}

                if (ParticipantId != null && ParticipantActivityId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<Conduct> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Conduct::getParticipantId, ParticipantId);
                    addressLambdaQueryWrapper.eq(Conduct::getActivityId, ParticipantActivityId);
                    Conduct conductNode = conductMapper.selectOne(addressLambdaQueryWrapper);
                    if (conductNode == null) {
                        Conduct conduct = new Conduct();
                        conduct.setParticipantId(ParticipantId);
                        conduct.setActivityId(ParticipantActivityId);
                        conductMapper.insert(conduct);
                    }
                }


                //{参与者，协作，协作网络}
                if (ParticipantId != null && CollaborationNetworkId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<Cooperation> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(Cooperation::getParticipantId, ParticipantId);
                    addressLambdaQueryWrapper.eq(Cooperation::getParticipantId, ParticipantActivityId);
                    Cooperation cooperationNode = cooperationMapper.selectOne(addressLambdaQueryWrapper);
                    if (cooperationNode == null) {
                        Cooperation cooperation = new Cooperation();
                        cooperation.setParticipantId(ParticipantId);
                        cooperation.setNetworkId(CollaborationNetworkId);
                        cooperationMapper.insert(cooperation);
                    }
                }

                // {协作网络，协作活动，协作网络活动}
                if (CollaborationNetworkId != null && CollaborationNetworkActivityId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<CollaborativeActivity> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(CollaborativeActivity::getNetworkId, CollaborationNetworkId);
                    addressLambdaQueryWrapper.eq(CollaborativeActivity::getActivityId, CollaborationNetworkActivityId);
                    CollaborativeActivity collaborativeActivityNode = collaborativeActivityMapper.selectOne(addressLambdaQueryWrapper);
                    if (collaborativeActivityNode == null) {
                        CollaborativeActivity collaborativeActivity = new CollaborativeActivity();
                        collaborativeActivity.setNetworkId(CollaborationNetworkId);
                        collaborativeActivity.setActivityId(CollaborationNetworkActivityId);
                        collaborativeActivityMapper.insert(collaborativeActivity);
                    }
                }

                //{隐患，存在参与者，参与者}，
                if (hazardId != null && ParticipantId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<ExistParticipant> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(ExistParticipant::getHazardId, hazardId);
                    addressLambdaQueryWrapper.eq(ExistParticipant::getParticipantId, ParticipantId);
                    ExistParticipant existParticipantNode = existParticipantMapper.selectOne(addressLambdaQueryWrapper);
                    if (existParticipantNode == null) {
                        ExistParticipant existParticipant = new ExistParticipant();
                        existParticipant.setHazardId(hazardId);
                        existParticipant.setParticipantId(ParticipantId);
                        existParticipantMapper.insert(existParticipant);
                    } else {
                    }
                }
                // 插入实体-隐患关联表数据
                if (entityId != null && hazardId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<SusceptibleTo> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(SusceptibleTo::getEntityId, entityId);
                    addressLambdaQueryWrapper.eq(SusceptibleTo::getHazardId, hazardId);
                    SusceptibleTo susceptibleToNode = entityHazardMapper.selectOne(addressLambdaQueryWrapper);
                    if (susceptibleToNode == null) {
                        SusceptibleTo susceptibleTo = new SusceptibleTo();
                        susceptibleTo.setEntityId(entityId);
                        susceptibleTo.setHazardId(hazardId);
                        entityHazardMapper.insert(susceptibleTo);
                    }
                }


                // 插入隐患-风险关联表数据
                if (hazardId != null && riskId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<ExistRisk> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(ExistRisk::getHazardId, hazardId);
                    addressLambdaQueryWrapper.eq(ExistRisk::getRiskId, riskId);
                    ExistRisk existRiskNode = hazardRiskMapper.selectOne(addressLambdaQueryWrapper);
                    if (existRiskNode == null) {
                        ExistRisk existRisk = new ExistRisk();
                        existRisk.setRiskId(riskId);
                        existRisk.setHazardId(hazardId);
                        hazardRiskMapper.insert(existRisk);
                    }
                }

                // 插入事件-风险关联表数据
                if (eventId != null && riskId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<MayTrigger> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(MayTrigger::getEventId, eventId);
                    addressLambdaQueryWrapper.eq(MayTrigger::getRiskId, riskId);
                    MayTrigger mayTriggerNode = eventRiskMapper.selectOne(addressLambdaQueryWrapper);
                    if (mayTriggerNode == null) {
                        MayTrigger mayTrigger = new MayTrigger();
                        mayTrigger.setRiskId(riskId);
                        mayTrigger.setEventId(eventId);
                        eventRiskMapper.insert(mayTrigger);
                    }
                }

                // 插入事件-后果关联表数据
                if (eventId != null && consequenceId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<LeadsTo> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(LeadsTo::getEventId, eventId);
                    addressLambdaQueryWrapper.eq(LeadsTo::getConsequenceId, consequenceId);
                    LeadsTo leadsToNode = eventConsequenceMapper.selectOne(addressLambdaQueryWrapper);
                    if (leadsToNode == null) {
                        LeadsTo leadsTo = new LeadsTo();
                        leadsTo.setConsequenceId(consequenceId);
                        leadsTo.setEventId(eventId);
                        eventConsequenceMapper.insert(leadsTo);
                    }
                }

                // 插入诉求-实体关联表数据
                if (appealId != null && entityId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<AppealToEntity> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(AppealToEntity::getAppealId, appealId);
                    addressLambdaQueryWrapper.eq(AppealToEntity::getEntityId, entityId);
                    AppealToEntity appealToEntityNode = appealToEntityMapper.selectOne(addressLambdaQueryWrapper);
                    if (appealToEntityNode == null) {
                        AppealToEntity appealToEntity = new AppealToEntity();
                        appealToEntity.setAppealId(appealId);
                        appealToEntity.setEntityId(entityId);
                        appealToEntityMapper.insert(appealToEntity);
                    }
                }


                // 插入诉求-隐患关联表数据
                if (appealId != null && hazardId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<AppealToHazard> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(AppealToHazard::getAppealId, appealId);
                    addressLambdaQueryWrapper.eq(AppealToHazard::getHazardId, hazardId);
                    AppealToHazard appealToHazardNode = appealHazardMapper.selectOne(addressLambdaQueryWrapper);
                    if (appealToHazardNode == null) {
                        AppealToHazard appealToHazard = new AppealToHazard();
                        appealToHazard.setAppealId(appealId);
                        appealToHazard.setHazardId(hazardId);
                        appealHazardMapper.insert(appealToHazard);
                    }
                }

                // 插入诉求-风险关联表数据
                if (appealId != null && riskId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<AppealToRisk> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(AppealToRisk::getAppealId, appealId);
                    addressLambdaQueryWrapper.eq(AppealToRisk::getRiskId, riskId);
                    AppealToRisk appealToRiskNode = appealRiskMapper.selectOne(addressLambdaQueryWrapper);
                    if (appealToRiskNode == null) {
                        AppealToRisk appealToRisk = new AppealToRisk();
                        appealToRisk.setAppealId(appealId);
                        appealToRisk.setRiskId(riskId);
                        appealRiskMapper.insert(appealToRisk);
                    }
                }

                // 插入诉求-事件关联表数据
                if (appealId != null && eventId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<AppealToEvent> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(AppealToEvent::getAppealId, appealId);
                    addressLambdaQueryWrapper.eq(AppealToEvent::getEventId, eventId);
                    AppealToEvent appealToEventNode = appealEventMapper.selectOne(addressLambdaQueryWrapper);
                    if (appealToEventNode == null) {
                        AppealToEvent appealToEvent = new AppealToEvent();
                        appealToEvent.setAppealId(appealId);
                        appealToEvent.setEventId(eventId);
                        appealEventMapper.insert(appealToEvent);
                    }
                }

                // 插入诉求-后果关联表数据
                if (appealId != null && consequenceId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<AppealToConsequence> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(AppealToConsequence::getAppealId, appealId);
                    addressLambdaQueryWrapper.eq(AppealToConsequence::getConsequenceId, consequenceId);
                    AppealToConsequence appealToConsequenceNode = appealConsequenceMapper.selectOne(addressLambdaQueryWrapper);
                    if (appealToConsequenceNode == null) {
                        AppealToConsequence appealToConsequence = new AppealToConsequence();
                        appealToConsequence.setAppealId(appealId);
                        appealToConsequence.setConsequenceId(consequenceId);
                        appealConsequenceMapper.insert(appealToConsequence);
                    }
                }


                // 插入诉求-参与者关联表数据
                if (appealId != null && ParticipantId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<AppealToParticipant> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(AppealToParticipant::getAppealId, appealId);
                    addressLambdaQueryWrapper.eq(AppealToParticipant::getParticipantId, ParticipantId);
                    AppealToParticipant appealToParticipantNode = appealParticipantMapper.selectOne(addressLambdaQueryWrapper);
                    if (appealToParticipantNode == null) {
                        AppealToParticipant appealToParticipant = new AppealToParticipant();
                        appealToParticipant.setAppealId(appealId);
                        appealToParticipant.setParticipantId(ParticipantId);
                        appealParticipantMapper.insert(appealToParticipant);
                    }
                }

                // 插入诉求-参与者活动关联表数据
                if (appealId != null && ParticipantActivityId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<AppealToParticipantActivity> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(AppealToParticipantActivity::getAppealId, appealId);
                    addressLambdaQueryWrapper.eq(AppealToParticipantActivity::getActivityId, ParticipantActivityId);
                    AppealToParticipantActivity appealToParticipantActivityNode = appealParticipantActivityMapper.selectOne(addressLambdaQueryWrapper);
                    if (appealToParticipantActivityNode == null) {
                        AppealToParticipantActivity appealToParticipantActivity = new AppealToParticipantActivity();
                        appealToParticipantActivity.setAppealId(appealId);
                        appealToParticipantActivity.setActivityId(ParticipantActivityId);
                        appealParticipantActivityMapper.insert(appealToParticipantActivity);
                    }
                }


                // 插入诉求-协作网络关联表数据
                if (appealId != null && CollaborationNetworkId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<AppealToCollaborationNetwork> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(AppealToCollaborationNetwork::getAppealId, appealId);
                    addressLambdaQueryWrapper.eq(AppealToCollaborationNetwork::getNetworkId, CollaborationNetworkId);
                    AppealToCollaborationNetwork appealToCollaborationNetworkNode = appealCollaborationNetworkMapper.selectOne(addressLambdaQueryWrapper);
                    if (appealToCollaborationNetworkNode == null) {
                        AppealToCollaborationNetwork appealToCollaborationNetwork = new AppealToCollaborationNetwork();
                        appealToCollaborationNetwork.setAppealId(appealId);
                        appealToCollaborationNetwork.setNetworkId(CollaborationNetworkId);
                        appealCollaborationNetworkMapper.insert(appealToCollaborationNetwork);
                    }
                }


                // 插入诉求-协作网络活动关联表数据
                if (appealId != null && CollaborationNetworkActivityId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<AppealToCollaborationNetworkActivity> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(AppealToCollaborationNetworkActivity::getAppealId, appealId);
                    addressLambdaQueryWrapper.eq(AppealToCollaborationNetworkActivity::getActivityId, CollaborationNetworkActivityId);
                    AppealToCollaborationNetworkActivity appealToCollaborationNetworkActivityNode = appealCollaborationNetworkActivityMapper.selectOne(addressLambdaQueryWrapper);
                    if (appealToCollaborationNetworkActivityNode == null) {
                        AppealToCollaborationNetworkActivity appealToCollaborationNetworkActivity = new AppealToCollaborationNetworkActivity();
                        appealToCollaborationNetworkActivity.setAppealId(appealId);
                        appealToCollaborationNetworkActivity.setActivityId(CollaborationNetworkActivityId);
                        appealCollaborationNetworkActivityMapper.insert(appealToCollaborationNetworkActivity);
                    }
                }

                // 插入诉求-资源关联表数据
                if (appealId != null && WealthId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<AppealToWealth> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(AppealToWealth::getAppealId, appealId);
                    addressLambdaQueryWrapper.eq(AppealToWealth::getWealthId, WealthId);
                    AppealToWealth appealToWealthNode = appealResourceMapper.selectOne(addressLambdaQueryWrapper);
                    if (appealToWealthNode == null) {
                        AppealToWealth appealToWealth = new AppealToWealth();
                        appealToWealth.setAppealId(appealId);
                        appealToWealth.setWealthId(WealthId);
                        appealResourceMapper.insert(appealToWealth);
                    }
                }

                // 插入诉求-时间关联表数据
                if (timeId != null && appealId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<AppealToTime> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(AppealToTime::getAppealId, appealId);
                    addressLambdaQueryWrapper.eq(AppealToTime::getTimeId, timeId);
                    AppealToTime Node = appealTimeMapper.selectOne(addressLambdaQueryWrapper);
                    if (Node == null) {
                        AppealToTime appealToTime = new AppealToTime();
                        appealToTime.setAppealId(appealId);
                        appealToTime.setTimeId(timeId);
                        appealTimeMapper.insert(appealToTime);
                    }
                }

                // 插入诉求-地点关联表数据
                if (appealId != null && locationId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<AppealToLocation> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(AppealToLocation::getAppealId, appealId);
                    addressLambdaQueryWrapper.eq(AppealToLocation::getLocationId, locationId);
                    AppealToLocation appealToLocationNode = appealLocationMapper.selectOne(addressLambdaQueryWrapper);
                    if (appealToLocationNode == null) {
                        AppealToLocation appealToLocation = new AppealToLocation();
                        appealToLocation.setAppealId(appealId);
                        appealToLocation.setLocationId(locationId);
                        appealLocationMapper.insert(appealToLocation);
                    }
                }


//                // 插入诉求-类型一关联表数据
//                if (appealId != null && type1Id != null) {
//                    //查询关系是否存在
//                    LambdaQueryWrapper<AppealToTypeOne> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                    addressLambdaQueryWrapper.eq(AppealToTypeOne::getAppealId, appealId);
//                    addressLambdaQueryWrapper.eq(AppealToTypeOne::getTypeOneId, type1Id);
//                    AppealToTypeOne appealToTypeOne1 = appealToTypeOneMapper.selectOne(addressLambdaQueryWrapper);
//                    if (appealToTypeOne1 == null) {
//                        AppealToTypeOne appealToLocation = new AppealToTypeOne();
//                        appealToLocation.setAppealId(appealId);
//                        appealToLocation.setTypeOneId(type1Id);
//                        appealToTypeOneMapper.insert(appealToLocation);
//                    }
//                }
//
//                // 插入诉求-类型二关联表数据
//                if (appealId != null && type2Id != null) {
//                    //查询关系是否存在
//                    LambdaQueryWrapper<AppealToTypeTwo> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                    addressLambdaQueryWrapper.eq(AppealToTypeTwo::getAppealId, appealId);
//                    addressLambdaQueryWrapper.eq(AppealToTypeTwo::getTypeTwoId, type2Id);
//                    AppealToTypeTwo appealToTypeTwo2 = appealToTypeTwoMapper.selectOne(addressLambdaQueryWrapper);
//                    if (appealToTypeTwo2 == null) {
//                        AppealToTypeTwo appealToLocation = new AppealToTypeTwo();
//                        appealToLocation.setAppealId(appealId);
//                        appealToLocation.setTypeTwoId(type2Id);
//                        appealToTypeTwoMapper.insert(appealToLocation);
//                    }
//                }
//
//                // 插入诉求-类型三关联表数据
//                if (appealId != null && type3Id != null) {
//                    //查询关系是否存在
//                    LambdaQueryWrapper<AppealToTypeThree> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                    addressLambdaQueryWrapper.eq(AppealToTypeThree::getAppealId, appealId);
//                    addressLambdaQueryWrapper.eq(AppealToTypeThree::getTypeThreeId, type3Id);
//                    AppealToTypeThree appealToTypeThree3 = appealToTypeThreeMapper.selectOne(addressLambdaQueryWrapper);
//                    if (appealToTypeThree3 == null) {
//                        AppealToTypeThree appealToLocation = new AppealToTypeThree();
//                        appealToLocation.setAppealId(appealId);
//                        appealToLocation.setTypeThreeId(type3Id);
//                        appealToTypeThreeMapper.insert(appealToLocation);
//                    }
//                }
                
                


                // 插入参与者-地点关联表数据
                if (ParticipantId != null && ParticipantLocationId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<ParticipantToLocation> addressLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    addressLambdaQueryWrapper.eq(ParticipantToLocation::getParticipantId, ParticipantId);
                    addressLambdaQueryWrapper.eq(ParticipantToLocation::getLocationId, ParticipantLocationId);
                    ParticipantToLocation participantToLocation = participantToLocationMapper.selectOne(addressLambdaQueryWrapper);
                    if (participantToLocation == null) {
                        ParticipantToLocation participantToLocation1 = new ParticipantToLocation();
                        participantToLocation1.setParticipantId(ParticipantId);
                        participantToLocation1.setLocationId(ParticipantLocationId);
                        participantToLocationMapper.insert(participantToLocation1);
                    }
                }


                // 插入协作网络-地点关联表数据
                if (CollaborationNetworkId != null && collaborationNetworkLocationId != null) {
                    //查询关系是否存在
                    LambdaQueryWrapper<CollaborativeToLocation> collaborativeToLocationLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    collaborativeToLocationLambdaQueryWrapper.eq(CollaborativeToLocation::getNetworkId, CollaborationNetworkId);
                    collaborativeToLocationLambdaQueryWrapper.eq(CollaborativeToLocation::getLocationId, collaborationNetworkLocationId);
                    CollaborativeToLocation collaborativeToLocation = collaborativeToLocationMapper.selectOne(collaborativeToLocationLambdaQueryWrapper);
                    if (collaborativeToLocation == null) {
                        CollaborativeToLocation collaborativeToLocation1 = new CollaborativeToLocation();
                        collaborativeToLocation1.setNetworkId(CollaborationNetworkId);
                        collaborativeToLocation1.setLocationId(collaborationNetworkLocationId);
                        collaborativeToLocationMapper.insert(collaborativeToLocation1);
                    }
                }
            }
            return Result.success("数据导入成功");
        } catch (
                Exception e) {
            e.printStackTrace();
            return Result.fail("数据导入失败");
        }
    }
}



