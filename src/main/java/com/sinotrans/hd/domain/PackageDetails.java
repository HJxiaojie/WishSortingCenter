package com.sinotrans.hd.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A PackageDetails.
 */
@Entity
@Table(name = "package_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PackageDetails extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tracking_id")
    private String trackingId;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "job_id")
    private String jobId;

    @Column(name = "is_finish")
    private Boolean isFinish;

    @Column(name = "finish_time")
    private ZonedDateTime finishTime;

    @Column(name = "user_code")
    private String userCode;

    @Column(name = "x_num")
    private Integer xNum;

    @Column(name = "y_num")
    private Integer yNum;

    @Column(name = "xy")
    private String xy;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public PackageDetails trackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getGroupId() {
        return groupId;
    }

    public PackageDetails groupId(String groupId) {
        this.groupId = groupId;
        return this;
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

    public PackageDetails isFinish(Boolean isFinish) {
        this.isFinish = isFinish;
        return this;
    }

    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }

    public ZonedDateTime getFinishTime() {
        return finishTime;
    }

    public PackageDetails finishTime(ZonedDateTime finishTime) {
        this.finishTime = finishTime;
        return this;
    }

    public void setFinishTime(ZonedDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public String getUserCode() {
        return userCode;
    }

    public PackageDetails userCode(String userCode) {
        this.userCode = userCode;
        return this;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getxNum() {
        return xNum;
    }

    public PackageDetails xNum(Integer xNum) {
        this.xNum = xNum;
        return this;
    }

    public void setxNum(Integer xNum) {
        this.xNum = xNum;
    }

    public Integer getyNum() {
        return yNum;
    }

    public PackageDetails yNum(Integer yNum) {
        this.yNum = yNum;
        return this;
    }

    public void setyNum(Integer yNum) {
        this.yNum = yNum;
    }

    public String getXy() {
        return xy;
    }

    public PackageDetails xy(String xy) {
        this.xy = xy;
        return this;
    }

    public void setXy(String xy) {
        this.xy = xy;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PackageDetails)) {
            return false;
        }
        return id != null && id.equals(((PackageDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PackageDetails{" +
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
