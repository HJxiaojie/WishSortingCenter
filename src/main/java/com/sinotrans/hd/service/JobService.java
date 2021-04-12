package com.sinotrans.hd.service;

import com.sinotrans.hd.domain.Job;
import com.sinotrans.hd.domain.PackageDetails;
import com.sinotrans.hd.repository.JobRepository;
import com.sinotrans.hd.repository.PackageDetailsRepository;
import com.sinotrans.hd.service.dto.JobDTO;
import com.sinotrans.hd.service.mapper.JobMapper;
import com.sinotrans.hd.service.mapper.JobMapping;
import io.jsonwebtoken.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Job}.
 */
@Service
@Transactional
public class JobService {

    private final Logger log = LoggerFactory.getLogger(JobService.class);

    private final JobRepository jobRepository;

    @Autowired
    public JobMapping jobMapping;

    @Autowired
    private PackageDetailsRepository packageDetailsRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    /**
     * Save a job.
     *
     * @param jobDTO the entity to save.
     * @return the persisted entity.
     */
    public JobDTO save(JobDTO jobDTO) {
        log.debug("Request to save Job : {}", jobDTO);
        Job job = jobMapping.jobDtotoJob(jobDTO);
        job = jobRepository.save(job);
        return jobMapping.jobtoJobDTO(job);
    }

    /**
     * Get all the jobs.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<JobDTO> findAll() {
        log.debug("Request to get all Jobs");
        return jobRepository.findAll().stream()
            .map(jobMapping::jobtoJobDTO)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one job by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<JobDTO> findOne(Long id) {
        log.debug("Request to get Job : {}", id);
        return jobRepository.findById(id)
            .map(jobMapping::jobtoJobDTO);
    }

    /**
     * Delete the job by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Job : {}", id);
        jobRepository.deleteById(id);
    }

    public List<JobDTO> findAllByJobId(String jobId) {
        log.debug("Request to get all Jobs By JobID");
        return jobMapping.jobListtoJobDTOList(jobRepository.findAllByJobId(jobId));
    }

    public List<PackageDetails> finishCurrentJob() {
        List<Job> allCurrentJob = jobRepository.findAllCurrentJob();
        if (allCurrentJob.size()>1) throw new IOException("当前任务数越界！");
        List<PackageDetails> packageDetails = packageDetailsRepository.findAllByJobId(allCurrentJob.get(0).getJobId());
        packageDetails.forEach(item->{
            item.setIsFinish(true);
        });
        try {
            allCurrentJob.forEach(item->{
                item.setIsCurrent(false);
            });
            jobRepository.saveAll(allCurrentJob);
        }catch (Exception e){
            e.getMessage();
        }
        return packageDetailsRepository.saveAll(packageDetails);
    }
}
