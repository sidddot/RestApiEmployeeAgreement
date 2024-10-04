package com.project.gts.project.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.gts.project.dto.EmploymentAgreementDTO;
import com.project.gts.project.services.EmploymentAgreementService;

import java.util.List;

@RestController
@RequestMapping("/api/employment-agreements")
public class EmploymentAgreementController {

    private static final Logger logger = LoggerFactory.getLogger(EmploymentAgreementController.class);

    @Autowired
    private EmploymentAgreementService employmentAgreementService;

    // CREATE
    @Operation(summary = "Create Employment Agreement", description = "Create a new employment agreement.")
    @PostMapping
    public ResponseEntity<EmploymentAgreementDTO> createAgreement(@Valid @RequestBody EmploymentAgreementDTO employmentAgreement) {
        EmploymentAgreementDTO createdAgreement = employmentAgreementService.createEmploymentAgreement(employmentAgreement);
        logger.info("Employment agreement created with ID: {}", createdAgreement.getId());
        return new ResponseEntity<>(createdAgreement, HttpStatus.CREATED);
    }

    // Get by id
    @Operation(summary = "Get Employment Agreement", description = "Retrieve an employment agreement by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<EmploymentAgreementDTO> getAgreementById(
            @Parameter(description = "ID of the employment agreement to retrieve") @PathVariable Long id) {
        EmploymentAgreementDTO agreement = employmentAgreementService.getEmploymentAgreementById(id);
        return new ResponseEntity<>(agreement, HttpStatus.OK);
    }

    //list all
    @Operation(summary = "List all Employment Agreements", description = "Retrieve a list of all employment agreements.")
    @GetMapping
    public List<EmploymentAgreementDTO> listEmploymentAgreements() {
        return employmentAgreementService.listEmploymentAgreements();
    }

    //update
    @Operation(summary = "Update Employment Agreement", description = "Update an existing employment agreement by its ID.")
    @PutMapping("/{id}")
    public ResponseEntity<EmploymentAgreementDTO> updateAgreement( 
            @Parameter(description = "ID of the employment agreement to update") @PathVariable Long id,
            @Valid @RequestBody EmploymentAgreementDTO updatedAgreement) {
        
        logger.info("Updating employment agreement with ID: {}", id);
        EmploymentAgreementDTO agreement = employmentAgreementService.updateEmploymentAgreement(id, updatedAgreement);
        
        if (agreement != null) {
            return new ResponseEntity<>(agreement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @Operation(summary = "Delete Employment Agreement", description = "Delete an employment agreement by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgreement(
            @Parameter(description = "ID of the employment agreement to delete") @PathVariable Long id) {

        logger.info("Employment agreement deleted with ID: {}", id);
        employmentAgreementService.deleteEmploymentAgreement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // SEARCH
    @Operation(summary = "Search Employment Agreements", description = "Search employment agreements by employee name and role")
    @GetMapping("/search")
    public ResponseEntity<List<EmploymentAgreementDTO>> searchAgreements(
            @Parameter(description = "Employee Name to search for") @RequestParam(value = "employeeName", required = false) String employeeName,
            @Parameter(description = "Role to search for") @RequestParam(value = "role", required = false) String role) {
        
        List<EmploymentAgreementDTO> results = employmentAgreementService.searchEmploymentAgreements(employeeName, role);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}