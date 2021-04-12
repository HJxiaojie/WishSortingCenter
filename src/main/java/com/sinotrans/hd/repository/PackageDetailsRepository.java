package com.sinotrans.hd.repository;

import com.sinotrans.hd.domain.PackageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the PackageDetails entity.
 */
@Repository
public interface PackageDetailsRepository extends JpaRepository<PackageDetails, Long>, JpaSpecificationExecutor<PackageDetails> {
    Optional<PackageDetails> findByTrackingId(String trackingId);

    List<PackageDetails> findAllByJobId(String jobId);
}
