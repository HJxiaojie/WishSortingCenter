package com.sinotrans.hd.service.mapper;


import com.sinotrans.hd.domain.Job;
import com.sinotrans.hd.service.dto.JobDTO;


public interface JobMapper extends EntityMapper<JobDTO, Job> {


    default Job fromId(Long id) {
        if (id == null) {
            return null;
        }
        Job job = new Job();
        job.setId(id);
        return job;
    }
}
