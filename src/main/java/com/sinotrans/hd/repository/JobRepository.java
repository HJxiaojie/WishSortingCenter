package com.sinotrans.hd.repository;

import com.sinotrans.hd.domain.Job;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Job entity.
 */

@Repository
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {

    List<Job> findAllByJobId(String jid);

    @Query(nativeQuery = true, value = "select * from job where job_id=?1")
    List<Job> searchJobsByID(String jid);

    @Query(nativeQuery = true, value = "select * from job where is_current=true")
    List<Job> findAllCurrentJob();
}
