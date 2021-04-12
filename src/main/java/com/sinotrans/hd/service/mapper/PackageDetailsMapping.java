package com.sinotrans.hd.service.mapper;

import com.sinotrans.hd.domain.PackageDetails;
import com.sinotrans.hd.service.dto.PackageDetailsDTO;
import com.sinotrans.hd.service.utils.MatrixUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackageDetailsMapping {
    public PackageDetailsDTO toDto(PackageDetails packageDetails){
        PackageDetailsDTO dto = new PackageDetailsDTO();
        dto.setId(packageDetails.getId());
        dto.setJobId(packageDetails.getJobId());
        dto.setGroupId(packageDetails.getGroupId());
        dto.setIsFinish(packageDetails.isIsFinish());
        dto.setFinishTime(packageDetails.getFinishTime());
        dto.setTrackingId(packageDetails.getTrackingId());
        dto.setUserCode(packageDetails.getUserCode());
        dto.setxNum(packageDetails.getxNum());
        dto.setyNum(packageDetails.getyNum());
        dto.setXy(packageDetails.getXy());
        return dto;
    }

    public PackageDetails toEntity(PackageDetailsDTO packageDetailsDTO){
        PackageDetails entity = new PackageDetails();
        entity.setId(packageDetailsDTO.getId());
        entity.setJobId(packageDetailsDTO.getJobId());
        entity.setGroupId(packageDetailsDTO.getGroupId());
        entity.setIsFinish(packageDetailsDTO.isIsFinish());
        entity.setFinishTime(packageDetailsDTO.getFinishTime());
        entity.setTrackingId(packageDetailsDTO.getTrackingId());
        entity.setUserCode(packageDetailsDTO.getUserCode());
        entity.setxNum(new MatrixUtil().toXMatrixInt(Integer.valueOf(packageDetailsDTO.getGroupId())));
        entity.setyNum(new MatrixUtil().toYMatrixInt(Integer.valueOf(packageDetailsDTO.getGroupId())));
        entity.setXy(numberToLetter(entity.getxNum())+"-"+entity.getyNum());
        return entity;
    }

    public List<PackageDetailsDTO> toDtoList(List<PackageDetails> packageDetailsList){
        List<PackageDetailsDTO> dtoList = new ArrayList<>();
        packageDetailsList.forEach(item->{
            dtoList.add(toDto(item));
        });
        return dtoList;
    }

    public List<PackageDetails> toEntityList(List<PackageDetailsDTO> packageDetailsDTOList){
        List<PackageDetails> entityList = new ArrayList<>();
        packageDetailsDTOList.forEach(item ->{
            entityList.add(toEntity(item));
        });
        return entityList;
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
