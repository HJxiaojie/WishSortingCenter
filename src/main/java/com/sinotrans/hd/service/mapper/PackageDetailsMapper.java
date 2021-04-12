package com.sinotrans.hd.service.mapper;


import com.sinotrans.hd.domain.PackageDetails;
import com.sinotrans.hd.service.dto.PackageDetailsDTO;
import org.springframework.stereotype.Service;

public interface PackageDetailsMapper extends EntityMapper<PackageDetailsDTO, PackageDetails> {



    default PackageDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setId(id);
        return packageDetails;
    }
}
