package com.sinotrans.hd.service.dto;

import java.time.ZonedDateTime;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sinotrans.hd.domain.PackageDetails} entity.
 */
public class PackageDetailsDTO implements Serializable {
    
    private Long id;

    private String trackingId;

    private String groupId;

    private String jobId;

    private Boolean isFinish;

    private ZonedDateTime finishTime;

    private String userCode;

    private Integer xNum;

    private Integer yNum;

    private String xy;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Boolean isIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }

    public ZonedDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(ZonedDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getxNum() {
        return xNum;
    }

    public void setxNum(Integer xNum) {
        this.xNum = xNum;
    }

    public Integer getyNum() {
        return yNum;
    }

    public void setyNum(Integer yNum) {
        this.yNum = yNum;
    }

    public String getXy() {
        return xy;
    }

    public void setXy(String xy) {
        this.xy = xy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PackageDetailsDTO)) {
            return false;
        }

        return id != null && id.equals(((PackageDetailsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PackageDetailsDTO{" +
            "id=" + getId() +
            ", trackingId='" + getTrackingId() + "'" +
            ", groupId='" + getGroupId() + "'" +
            ", jobId='" + getJobId() + "'" +
            ", isFinish='" + isIsFinish() + "'" +
            ", finishTime='" + getFinishTime() + "'" +
            ", userCode='" + getUserCode() + "'" +
            ", xNum=" + getxNum() +
            ", yNum=" + getyNum() +
            ", xy='" + getXy() + "'" +
            "}";
    }
}
