package com.sinotrans.hd.service;

import com.sinotrans.hd.domain.PackageDetails;
import com.sinotrans.hd.repository.PackageDetailsRepository;
import com.sinotrans.hd.service.dto.PackageDetailsDTO;
import com.sinotrans.hd.service.mapper.PackageDetailsMapper;
import com.sinotrans.hd.service.mapper.PackageDetailsMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link PackageDetails}.
 */
@Service
@Transactional
public class PackageDetailsService {

    private final Logger log = LoggerFactory.getLogger(PackageDetailsService.class);

    private final PackageDetailsRepository packageDetailsRepository;

    private final PackageDetailsMapping packageDetailsMapping;

    public PackageDetailsService(PackageDetailsRepository packageDetailsRepository, PackageDetailsMapping packageDetailsMapping) {
        this.packageDetailsRepository = packageDetailsRepository;
        this.packageDetailsMapping = packageDetailsMapping;
    }

    /**
     * Save a packageDetails.
     *
     * @param packageDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    public PackageDetailsDTO save(PackageDetailsDTO packageDetailsDTO) {
        log.debug("Request to save PackageDetails : {}", packageDetailsDTO);
        PackageDetails packageDetails = packageDetailsMapping.toEntity(packageDetailsDTO);
        packageDetails = packageDetailsRepository.save(packageDetails);
        return packageDetailsMapping.toDto(packageDetails);
    }

    /**
     * Get all the packageDetails.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<PackageDetailsDTO> findAll() {
        log.debug("Request to get all PackageDetails");
        return packageDetailsRepository.findAll().stream()
            .map(packageDetailsMapping::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one packageDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PackageDetailsDTO> findOne(Long id) {
        log.debug("Request to get PackageDetails : {}", id);
        return packageDetailsRepository.findById(id)
            .map(packageDetailsMapping::toDto);
    }

    /**
     * Delete the packageDetails by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete PackageDetails : {}", id);
        packageDetailsRepository.deleteById(id);
    }

    public PackageDetailsDTO findByTrackingIdAndUpdate(String trackingId, Integer i, Date time){
        Optional<PackageDetails> optional = packageDetailsRepository.findByTrackingId(trackingId);
        if (optional.isPresent()&&i==1){
            return packageDetailsMapping.toDto(optional.get());
        }else if(optional.isPresent()&&i==2){
            optional.get().setFinishTime(ZonedDateTime.ofInstant(time.toInstant(),ZoneId.of("Asia/Shanghai")));
            packageDetailsRepository.save(optional.get());
            return packageDetailsMapping.toDto(optional.get());
        } else {
            return new PackageDetailsDTO();
        }
    }
}
