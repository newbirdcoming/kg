package com.kg.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kg.utils.ExcelImport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author Mr.Lan
 * @version 1.0
 * @ClassName ImportAllDto$
 * @description TODO
 * @date 2024/7/8 12:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportAllDto {


    private String id;


    @TableField(value = "number")
    @ExcelImport("编号")
    private String  number;

    @JsonFormat(pattern = "yyyy/M/d H:mm:ss")
    @DateTimeFormat(pattern = "yyyy/M/d H:mm:ss")
    @TableField(value = "time")
    @ExcelImport("时间")
    private LocalDateTime occurredAt;

    @TableField(value = "location")
    @ExcelImport("具体地址")
    private String location;

    @TableField(value = "subject")
    @ExcelImport("主体")
    private String subject;

    @TableField(value = "object")
    @ExcelImport("受体")
    private String object;

    @TableField(value = "hazard")
    @ExcelImport("隐患")
    private String hazard;

    @TableField(value = "risk")
    @ExcelImport("风险")
    private String risk;

    @TableField(value = "event")
    @ExcelImport("事件")
    private String event;

    @TableField(value = "consequence")
    @ExcelImport("后果")
    private String consequence;

    @TableField(value = "type1")
    @ExcelImport("诉求主题类别1")
    private String type1;

    @TableField(value = "type2")
    @ExcelImport("诉求主题类别2")
    private String type2;

    @TableField(value = "type3")
    @ExcelImport("诉求主题类别3")
    private String type3;

    @TableField(value = "participant")
    @ExcelImport("参与者")
    private String participant;

    @TableField(value = "wealth")
    @ExcelImport("资源")
    private String wealth;

    @TableField(value = "participant_activity")
    @ExcelImport("参与者活动")
    private String participantActivity;

    @TableField(value = "goal")
    @ExcelImport("目标")
    private String goal;

    @TableField(value = "collaboration_network")
    @ExcelImport("协作网络")
    private String collaborationNetwork;

    @TableField(value = "collaboration_network_activity")
    @ExcelImport("协作网络活动")
    private String collaborationNetworkActivity;

    @TableField(value = "content")
    @ExcelImport("诉求内容")
    private String content;

}
