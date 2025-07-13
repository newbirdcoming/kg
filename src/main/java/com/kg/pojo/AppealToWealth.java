package com.kg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName appeal_to_wealth
 */
@TableName(value ="appeal_to_wealth")
@Data
public class AppealToWealth implements Serializable {
    /**
     * 
     */
    private String appealId;

    /**
     * 
     */
    private String wealthId;

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
        AppealToWealth other = (AppealToWealth) that;
        return (this.getAppealId() == null ? other.getAppealId() == null : this.getAppealId().equals(other.getAppealId()))
            && (this.getWealthId() == null ? other.getWealthId() == null : this.getWealthId().equals(other.getWealthId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAppealId() == null) ? 0 : getAppealId().hashCode());
        result = prime * result + ((getWealthId() == null) ? 0 : getWealthId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", appealId=").append(appealId);
        sb.append(", wealthId=").append(wealthId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}