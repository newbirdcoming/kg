package com.kg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName appeal_to_time
 */
@TableName(value ="appeal_to_time")
@Data
public class AppealToTime implements Serializable {
    /**
     * 
     */
    private String appealId;

    /**
     * 
     */
    private String timeId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AppealToTime other = (AppealToTime) that;
        return (this.getAppealId() == null ? other.getAppealId() == null : this.getAppealId().equals(other.getAppealId()))
            && (this.getTimeId() == null ? other.getTimeId() == null : this.getTimeId().equals(other.getTimeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAppealId() == null) ? 0 : getAppealId().hashCode());
        result = prime * result + ((getTimeId() == null) ? 0 : getTimeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", appealId=").append(appealId);
        sb.append(", timeId=").append(timeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}