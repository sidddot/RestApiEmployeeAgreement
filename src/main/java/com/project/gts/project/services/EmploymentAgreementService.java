package com.project.gts.project.services;

import com.project.gts.project.dto.EmploymentAgreementDTO;
import com.project.gts.project.entities.EmploymentAgreementEntity;
import com.project.gts.project.repositories.EmploymentAgreementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmploymentAgreementService {

    private final EmploymentAgreementRepository employmentAgreementRepository;
    private final ModelMapper modelMapper;

    public EmploymentAgreementService(EmploymentAgreementRepository employmentAgreementRepository, ModelMapper modelMapper) {
        this.employmentAgreementRepository = employmentAgreementRepository;
        this.modelMapper = modelMapper;
    }

    public EmploymentAgreementDTO createEmploymentAgreement(EmploymentAgreementDTO employmentAgreementDTO) {
        EmploymentAgreementEntity entity = modelMapper.map(employmentAgreementDTO, EmploymentAgreementEntity.class);
        EmploymentAgreementEntity savedEntity = employmentAgreementRepository.save(entity);
        return modelMapper.map(savedEntity, EmploymentAgreementDTO.class);
    }

    public EmploymentAgreementDTO getEmploymentAgreementById(Long id) {
        EmploymentAgreementEntity entity = employmentAgreementRepository.findById(id).orElseThrow();
        return modelMapper.map(entity, EmploymentAgreementDTO.class);
    }

    public EmploymentAgreementDTO updateEmploymentAgreement(Long id, EmploymentAgreementDTO employmentAgreementDTO) {
        EmploymentAgreementEntity entity = employmentAgreementRepository.findById(id).orElseThrow();
        modelMapper.map(employmentAgreementDTO, entity);
        EmploymentAgreementEntity updatedEntity = employmentAgreementRepository.save(entity);
        return modelMapper.map(updatedEntity, EmploymentAgreementDTO.class);
    }

    public void deleteEmploymentAgreement(Long id) {
        employmentAgreementRepository.deleteById(id);
    }

    public List<EmploymentAgreementDTO> listEmploymentAgreements() {
        return employmentAgreementRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, EmploymentAgreementDTO.class))
                .collect(Collectors.toList());
    }

    public List<EmploymentAgreementDTO> searchEmploymentAgreements(String employeeName, String role) {
        return employmentAgreementRepository.searchAgreements(employeeName, role)
                .stream()
                .map(entity -> modelMapper.map(entity, EmploymentAgreementDTO.class))
                .collect(Collectors.toList());
    }
}
