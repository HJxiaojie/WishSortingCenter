package com.sinotrans.hd.service.mapper;

import com.sinotrans.hd.domain.Job;
import com.sinotrans.hd.service.dto.JobDTO;
import com.sinotrans.hd.service.utils.MatrixUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobMapping {
    public JobDTO jobtoJobDTO(Job job){
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setJobId(job.getJobId());
        jobDTO.setIsCurrent(job.isIsCurrent());
        jobDTO.setStartTime(job.getFinishTime());
        jobDTO.setFinishTime(job.getFinishTime());
        jobDTO.setTotalGroups(job.getTotalGroups());
        jobDTO.setTotalParcels(job.getTotalParcels());
        jobDTO.setVersion(job.getVersion());
        jobDTO.setxNum(job.getxNum());
        jobDTO.setyNum(job.getyNum());
        jobDTO.setXyMatrix(numberToLetter(job.getxNum())+"-"+job.getyNum());
        return jobDTO;
    }

    public Job jobDtotoJob(JobDTO jobDTO){
        Job job = new Job();
        job.setId(jobDTO.getId());
        job.setJobId(jobDTO.getJobId());
        job.setIsCurrent(jobDTO.isIsCurrent());
        job.setStartTime(jobDTO.getStartTime());
        job.setFinishTime(jobDTO.getFinishTime());
        job.setTotalGroups(jobDTO.getTotalGroups());
        job.setTotalParcels(jobDTO.getTotalParcels());
        job.setVersion(jobDTO.getVersion());
        job.setxNum(new MatrixUtil().toXMatrixInt(jobDTO.getTotalGroups()));
        job.setyNum(new MatrixUtil().toYMatrixInt(jobDTO.getTotalGroups()));
        return job;
    }

    public List<JobDTO> jobListtoJobDTOList(List<Job> jobList){
        List<JobDTO> jobDTOList = new ArrayList<>();
        jobList.forEach(job -> {
            jobDTOList.add(this.jobtoJobDTO(job));
        });
        return jobDTOList;
    }

    public List<Job> jobDTOListtoJobList(List<JobDTO> jobDTOList){
        List<Job> jobList= new ArrayList<>();
        jobDTOList.forEach(jobDTO -> {
            jobList.add(this.jobDtotoJob(jobDTO));
        });
        return jobList;
    }

    public static String numberToLetter(int num) {
        if (num <= 0) {
            return null;
        }
        String letter = "";
        num--;
        do {
            if (letter.length() > 0) {
                num--;
            }
            letter = ((char) (num % 26 + (int) 'A')) + letter;
            num = (int) ((num - num % 26) / 26);
        } while (num > 0);
        return letter;
    }
}
