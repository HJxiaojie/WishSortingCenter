package com.sinotrans.hd.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A Job.
 */
@Entity
@Table(name = "job")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Job extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "version")
    private String version;

    @Column(name = "job_id")
    private String jobId;

    @Column(name = "is_current")
    private Boolean isCurrent;

    @Column(name = "start_time")
    private ZonedDateTime startTime;

    @Column(name = "finish_time")
    private ZonedDateTime finishTime;

    @Column(name = "total_groups")
    private Integer totalGroups;

    @Column(name = "total_parcels")
    private Integer totalParcels;

    @Column(name = "x_num")
    private Integer xNum;

    @Column(name = "y_num")
    private Integer yNum;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public Job version(String version) {
        this.version = version;
        return this;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getJobId() {
        return jobId;
    }

    public Job jobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Boolean isIsCurrent() {
        return isCurrent;
    }

    public Job isCurrent(Boolean isCurrent) {
        this.isCurrent = isCurrent;
        return this;
    }

    public void setIsCurrent(Boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public Job startTime(ZonedDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getFinishTime() {
        return finishTime;
    }

    public Job finishTime(ZonedDateTime finishTime) {
        this.finishTime = finishTime;
        return this;
    }

    public void setFinishTime(ZonedDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getTotalGroups() {
        return totalGroups;
    }

    public Job totalGroups(Integer totalGroups) {
        this.totalGroups = totalGroups;
        return this;
    }

    public void setTotalGroups(Integer totalGroups) {
        this.totalGroups = totalGroups;
    }

    public Integer getTotalParcels() {
        return totalParcels;
    }

    public Job totalParcels(Integer totalParcels) {
        this.totalParcels = totalParcels;
        return this;
    }

    public void setTotalParcels(Integer totalParcels) {
        this.totalParcels = totalParcels;
    }

    public Integer getxNum() {
        return xNum;
    }

    public Job xNum(Integer xNum) {
        this.xNum = xNum;
        return this;
    }

    public void setxNum(Integer xNum) {
        this.xNum = xNum;
    }

    public Integer getyNum() {
        return yNum;
    }

    public Job yNum(Integer yNum) {
        this.yNum = yNum;
        return this;
    }

    public void setyNum(Integer yNum) {
        this.yNum = yNum;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Job)) {
            return false;
        }
        return id != null && id.equals(((Job) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Job{" +
            "id=" + getId() +
            ", version='" + getVersion() + "'" +
            ", jobId='" + getJobId() + "'" +
            ", isCurrent='" + isIsCurrent() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", finishTime='" + getFinishTime() + "'" +
            ", totalGroups=" + getTotalGroups() +
            ", totalParcels=" + getTotalParcels() +
            ", xNum=" + getxNum() +
            ", yNum=" + getyNum() +
            "}";
    }
}
