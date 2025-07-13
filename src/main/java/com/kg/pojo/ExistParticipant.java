package com.kg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName exist_participant
 */
@TableName(value ="exist_participant")
@Data
public class ExistParticipant implements Serializable {
    /**
     * 
     */
    private String hazardId;

    /**
     * 
     */
    private String participantId;

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
        ExistParticipant other = (ExistParticipant) that;
        return (this.getHazardId() == null ? other.getHazardId() == null : this.getHazardId().equals(other.getHazardId()))
            && (this.getParticipantId() == null ? other.getParticipantId() == null : this.getParticipantId().equals(other.getParticipantId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHazardId() == null) ? 0 : getHazardId().hashCode());
        result = prime * result + ((getParticipantId() == null) ? 0 : getParticipantId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hazardId=").append(hazardId);
        sb.append(", participantId=").append(participantId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}