package com.kg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @TableName appeal
 */
@TableName(value ="appeal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appeal implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 
     */
    private String number;

    /**
     *
     */
    private String type1;

    /**
     *
     */
    private String type2;

    /**
     *
     */
    private String type3;

    /**
     * 
     */
    private String content;


}