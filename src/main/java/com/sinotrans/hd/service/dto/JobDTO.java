package com.sinotrans.hd.service.dto;

import java.time.ZonedDateTime;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sinotrans.hd.domain.Job} entity.
 */
public class JobDTO implements Serializable {

    private Long id;

    private String version;

    private String jobId;

    private Boolean isCurrent;

    private ZonedDateTime startTime;

    private ZonedDateTime finishTime;

    private Integer totalGroups;

    private Integer totalParcels;

    private Integer xNum;

    private Integer yNum;

    private String xyMatrix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Boolean isIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(ZonedDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getTotalGroups() {
        return totalGroups;
    }

    public void setTotalGroups(Integer totalGroups) {
        this.totalGroups = totalGroups;
    }

    public Integer getTotalParcels() {
        return totalParcels;
    }

    public void setTotalParcels(Integer totalParcels) {
        this.totalParcels = totalParcels;
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

    public String getXyMatrix() {
        return xyMatrix;
    }

    public void setXyMatrix(String xyMatrix) {
        this.xyMatrix = xyMatrix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobDTO)) {
            return false;
        }

        return id != null && id.equals(((JobDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "JobDTO{" +
            "id=" + id +
            ", version='" + version + '\'' +
            ", jobId='" + jobId + '\'' +
            ", isCurrent=" + isCurrent +
            ", startTime=" + startTime +
            ", finishTime=" + finishTime +
            ", totalGroups=" + totalGroups +
            ", totalParcels=" + totalParcels +
            ", xNum=" + xNum +
            ", yNum=" + yNum +
            ", xyMatrix='" + xyMatrix + '\'' +
            '}';
    }
}
