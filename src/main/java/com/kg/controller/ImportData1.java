package com.kg.controller;//package com.kg.controller;
//
//import com.example.utils.ExcelUtils;
//import com.example.utils.IdWorkerUtils;
//import com.example.utils.Result;
//import com.kg.mapper.*;
//import com.kg.pojo.*;
//import com.kg.pojo.dto.ImportAllDto;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.List;
//
///**
// * @author Mr.Lan
// * @version 1.0
// * @ClassName ImportData$
// * @description d2rq数据导入数据库
// * @date 2024/6/27 13:55
// **/
//@RestController
//@RequestMapping("/ImportData")
//@Api(tags = "d2rq数据导入数据库")
//public class ImportData1 {
//    @Autowired
//    private EntityMapper entityMapper;
//
//    @Autowired
//    private HazardMapper hazardMapper;
//
//    @Autowired
//    private RiskMapper riskMapper;
//
//    @Autowired
//    private EventMapper eventMapper;
//
//    @Autowired
//    private ConsequenceMapper consequenceMapper;
//
//    @Autowired
//    private AppealMapper appealMapper;
//
//    @Autowired
//    private ParticipantMapper participantMapper;
//
//    @Autowired
//    private ResourceMapper resourceMapper;
//
//    @Autowired
//    private ParticipantActivityMapper participantActivityMapper;
//
//    @Autowired
//    private CollaborationNetworkMapper collaborationNetworkMapper;
//
//    @Autowired
//    private CollaborationNetworkActivityMapper collaborationNetworkActivityMapper;
//
//
//
//    //缺少易感于 和 可能触发
//    @ApiOperation("根据excel数据导入数据库")
//    @PostMapping("/AllImport")
//    @Transactional
//    public Result importentities(@RequestPart("file") MultipartFile file) throws Exception {
//        IdWorkerUtils idWorker = IdWorkerUtils.getInstance();
//        List<ImportAllDto> importAllDtos = ExcelUtils.readMultipartFile(file, ImportAllDto.class);
//        for (ImportAllDto data : importAllDtos) {
//            String uuid = idWorker.createUUID();
//            data.setId(uuid);
//            // 插入时间表数据
//            Time time = new Time();
//            time.setId(data.getId());
//            time.setOccurredAt(data.getOccurredAt());
//            time.setStartTime(data.getStartTime());
//            time.setEndTime(data.getEndTime());
//            timeMapper.insert(time);
//
//            // 插入地点表数据
//            Location location = new Location();
//            location.setId(data.getId());
//            location.setLocation(data.getLocation());
//            location.setLatitude(data.getLatitude());
//            location.setLongitude(data.getLongitude());
//            locationMapper.insert(location);
//
//            // 插入实体表数据
//            Entity entity = new Entity();
//            entity.setId(data.getId());
//            entity.setSubject(data.getSubject());
//            entity.setObject(data.getObject());
//            entityMapper.insert(entity);
//
//            // 插入隐患表数据
//            Hazard hazard = new Hazard();
//            hazard.setId(data.getId());
//            hazard.setDescription(data.getHazard());
//            hazardMapper.insert(hazard);
//
//            // 插入风险表数据
//            Risk risk = new Risk();
//            risk.setId(data.getId());
//            risk.setDescription(data.getRisk());
//            riskMapper.insert(risk);
//
//            // 插入事件表数据
//            Event event = new Event();
//            event.setId(data.getId());
//            event.setDescription(data.getEvent());
//            eventMapper.insert(event);
//
//            // 插入后果表数据
//            Consequence consequence = new Consequence();
//            consequence.setId(data.getId());
//            consequence.setDescription(data.getConsequence());
//            consequenceMapper.insert(consequence);
//
//            // 插入诉求表数据
//            Appeal appeal = new Appeal();
//            appeal.setId(data.getId());
//            appeal.setType1(data.getAppealType1());
//            appeal.setType2(data.getAppealType2());
//            appeal.setType3(data.getAppealType3());
//            appealMapper.insert(appeal);
//
//            // 插入参与者表数据
//            Participant participant = new Participant();
//            participant.setId(data.getId());
//            participant.setName(data.getParticipant());
//            participantMapper.insert(participant);
//
//            // 插入资源表数据
//            Resource resource = new Resource();
//            resource.setId(data.getId());
//            resource.setDescription(data.getResource());
//            resourceMapper.insert(resource);
//
//            // 插入参与者活动表数据
//            ParticipantActivity participantActivity = new ParticipantActivity();
//            participantActivity.setId(data.getId());
//            participantActivity.setParticipantId(data.getId());
//            participantActivity.setActivityDescription(data.getParticipantActivity());
//            participantActivityMapper.insert(participantActivity);
//
//            // 插入协作网络表数据
//            CollaborationNetwork collaborationNetwork = new CollaborationNetwork();
//            collaborationNetwork.setId(data.getId());
//            collaborationNetwork.setDescription(data.getCollaborationNetwork());
//            collaborationNetworkMapper.insert(collaborationNetwork);
//
//            // 插入协作网络活动表数据
//            CollaborationNetworkActivity collaborationNetworkActivity = new CollaborationNetworkActivity();
//            collaborationNetworkActivity.setId(data.getId());
//            collaborationNetworkActivity.setNetworkId(data.getId());
//            collaborationNetworkActivity.setActivityDescription(data.getCollaborationNetworkActivity());
//            collaborationNetworkActivityMapper.insert(collaborationNetworkActivity);
//
//            // 插入实体-隐患关联表数据
//            EntityHazard entityHazard = new EntityHazard();
//            entityHazard.setId(data.getId());
//            entityHazard.setEntityId(entity.getId());
//            entityHazard.setHazardId(hazard.getId());
//            entityHazardMapper.insert(entityHazard);
//
//            // 插入隐患-风险关联表数据
//            HazardRisk hazardRisk = new HazardRisk();
//            hazardRisk.setId(data.getId());
//            hazardRisk.setHazardId(hazard.getId());
//            hazardRisk.setRiskId(risk.getId());
//            hazardRiskMapper.insert(hazardRisk);
//
//            // 插入事件-风险关联表数据
//            EventRisk eventRisk = new EventRisk();
//            eventRisk.setId(data.getId());
//            eventRisk.setEventId(event.getId());
//            eventRisk.setRiskId(risk.getId());
//            eventRiskMapper.insert(eventRisk);
//
//            // 插入事件-后果关联表数据
//            EventConsequence eventConsequence = new EventConsequence();
//            eventConsequence.setId(data.getId());
//            eventConsequence.setEventId(event.getId());
//            eventConsequence.setConsequenceId(consequence.getId());
//            eventConsequenceMapper.insert(eventConsequence);
//
//            // 插入诉求-隐患关联表数据
//            AppealHazard appealHazard = new AppealHazard();
//            appealHazard.setId(data.getId());
//            appealHazard.setAppealId(appeal.getId());
//            appealHazard.setHazardId(hazard.getId());
//            appealHazardMapper.insert(appealHazard);
//
//            // 插入诉求-风险关联表数据
//            AppealRisk appealRisk = new AppealRisk();
//            appealRisk.setId(data.getId());
//            appealRisk.setAppealId(appeal.getId());
//            appealRisk.setRiskId(risk.getId());
//            appealRiskMapper.insert(appealRisk);
//
//            // 插入诉求-事件关联表数据
//            AppealEvent appealEvent = new AppealEvent();
//            appealEvent.setId(data.getId());
//            appealEvent.setAppealId(appeal.getId());
//            appealEvent.setEventId(event.getId());
//            appealEventMapper.insert(appealEvent);
//
//            // 插入诉求-后果关联表数据
//            AppealConsequence appealConsequence = new AppealConsequence();
//            appealConsequence.setId(data.getId());
//            appealConsequence.setAppealId(appeal.getId());
//            appealConsequence.setConsequenceId(consequence.getId());
//            appealConsequenceMapper.insert(appealConsequence);
//
//            // 插入诉求-参与者关联表数据
//            AppealParticipant appealParticipant = new AppealParticipant();
//            appealParticipant.setId(data.getId());
//            appealParticipant.setAppealId(appeal.getId());
//            appealParticipant.setParticipantId(participant.getId());
//            appealParticipantMapper.insert(appealParticipant);
//
//            // 插入诉求-参与者活动关联表数据
//            AppealParticipantActivity appealParticipantActivity = new AppealParticipantActivity();
//            appealParticipantActivity.setId(data.getId());
//            appealParticipantActivity.setAppealId(appeal.getId());
//            appealParticipantActivity.setActivityId(participantActivity.getId());
//            appealParticipantActivityMapper.insert(appealParticipantActivity);
//
//            // 插入诉求-协作网络关联表数据
//            AppealCollaborationNetwork appealCollaborationNetwork = new AppealCollaborationNetwork();
//            appealCollaborationNetwork.setId(data.getId());
//            appealCollaborationNetwork.setAppealId(appeal.getId());
//            appealCollaborationNetwork.setNetworkId(collaborationNetwork.getId());
//            appealCollaborationNetworkMapper.insert(appealCollaborationNetwork);
//
//            // 插入诉求-协作网络活动关联表数据
//            AppealCollaborationNetworkActivity appealCollaborationNetworkActivity = new AppealCollaborationNetworkActivity();
//            appealCollaborationNetworkActivity.setId(data.getId());
//            appealCollaborationNetworkActivity.setAppealId(appeal.getId());
//            appealCollaborationNetworkActivity.setActivityId(collaborationNetworkActivity.getId());
//            appealCollaborationNetworkActivityMapper.insert(appealCollaborationNetworkActivity);
//
//            // 插入诉求-资源关联表数据
//            AppealResource appealResource = new AppealResource();
//            appealResource.setId(data.getId());
//            appealResource.setAppealId(appeal.getId());
//            appealResource.setResourceId(resource.getId());
//            appealResourceMapper.insert(appealResource);
//
//            // 插入诉求-时间关联表数据
//            AppealTime appealTime = new AppealTime();
//            appealTime.setId(data.getId());
//            appealTime.setAppealId(appeal.getId());
//            appealTime.setTimeId(time.getId());
//            appealTimeMapper.insert(appealTime);
//
//            // 插入诉求-地点关联表数据
//            AppealLocation appealLocation = new AppealLocation();
//            appealLocation.setId(data.getId());
//            appealLocation.setAppealId(appeal.getId());
//            appealLocation.setLocationId(location.getId());
//            appealLocationMapper.insert(appealLocation);
//        }
//        return Result.success("");
//    }
//
//}
//
//
//
