package com.kg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName exist_risk
 */
@TableName(value ="exist_risk")
@Data
public class ExistRisk implements Serializable {
    /**
     * 
     */
    private String hazardId;

    /**
     * 
     */
    private String riskId;

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
        ExistRisk other = (ExistRisk) that;
        return (this.getHazardId() == null ? other.getHazardId() == null : this.getHazardId().equals(other.getHazardId()))
            && (this.getRiskId() == null ? other.getRiskId() == null : this.getRiskId().equals(other.getRiskId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHazardId() == null) ? 0 : getHazardId().hashCode());
        result = prime * result + ((getRiskId() == null) ? 0 : getRiskId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hazardId=").append(hazardId);
        sb.append(", riskId=").append(riskId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}