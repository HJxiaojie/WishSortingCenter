package com.sinotrans.hd.web.rest;

import com.sinotrans.hd.service.PackageDetailsService;
import com.sinotrans.hd.web.rest.errors.BadRequestAlertException;
import com.sinotrans.hd.service.dto.PackageDetailsDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.sinotrans.hd.domain.PackageDetails}.
 */
@RestController
@RequestMapping("/api")
public class PackageDetailsResource {

    private final Logger log = LoggerFactory.getLogger(PackageDetailsResource.class);

    private static final String ENTITY_NAME = "packageDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PackageDetailsService packageDetailsService;

    public PackageDetailsResource(PackageDetailsService packageDetailsService) {
        this.packageDetailsService = packageDetailsService;
    }

    /**
     * {@code POST  /package-details} : Create a new packageDetails.
     *
     * @param packageDetailsDTO the packageDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new packageDetailsDTO, or with status {@code 400 (Bad Request)} if the packageDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/package-details")
    public ResponseEntity<PackageDetailsDTO> createPackageDetails(@RequestBody PackageDetailsDTO packageDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save PackageDetails : {}", packageDetailsDTO);
        if (packageDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new packageDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PackageDetailsDTO result = packageDetailsService.save(packageDetailsDTO);
        return ResponseEntity.created(new URI("/api/package-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /package-details} : Updates an existing packageDetails.
     *
     * @param packageDetailsDTO the packageDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated packageDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the packageDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the packageDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/package-details")
    public ResponseEntity<PackageDetailsDTO> updatePackageDetails(@RequestBody PackageDetailsDTO packageDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update PackageDetails : {}", packageDetailsDTO);
        if (packageDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PackageDetailsDTO result = packageDetailsService.save(packageDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, packageDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /package-details} : get all the packageDetails.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of packageDetails in body.
     */
    @GetMapping("/package-details")
    public List<PackageDetailsDTO> getAllPackageDetails() {
        log.debug("REST request to get all PackageDetails");
        return packageDetailsService.findAll();
    }

    /**
     * {@code GET  /package-details/:id} : get the "id" packageDetails.
     *
     * @param id the id of the packageDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the packageDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/package-details/{id}")
    public ResponseEntity<PackageDetailsDTO> getPackageDetails(@PathVariable Long id) {
        log.debug("REST request to get PackageDetails : {}", id);
        Optional<PackageDetailsDTO> packageDetailsDTO = packageDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(packageDetailsDTO);
    }

    /**
     * {@code DELETE  /package-details/:id} : delete the "id" packageDetails.
     *
     * @param id the id of the packageDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/package-details/{id}")
    public ResponseEntity<Void> deletePackageDetails(@PathVariable Long id) {
        log.debug("REST request to delete PackageDetails : {}", id);
        packageDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    @GetMapping("/package-details/searchPackage/once/{trackingId}")
    public ResponseEntity<PackageDetailsDTO> getPackageDetailsByTrackingId(@PathVariable String trackingId) {
        log.debug("REST request to search PackageDetails Round : {}", 1);
        return ResponseEntity.ok(packageDetailsService.findByTrackingIdAndUpdate(trackingId,1, null));
    }

    @GetMapping("/package-details/searchPackage/twice/{trackingId}/{time}")
    public ResponseEntity<PackageDetailsDTO> getPackageDetailsByTrackingIdAndUpdate(@PathVariable String trackingId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date time) {
        log.debug("REST request to search PackageDetails Round : {}", 2);
        return ResponseEntity.ok(packageDetailsService.findByTrackingIdAndUpdate(trackingId,2,time));
    }
}
