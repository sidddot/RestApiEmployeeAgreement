package com.project.gts.project.dto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, EmploymentAgreementDTO> {
    @Override
    public boolean isValid(EmploymentAgreementDTO dto, ConstraintValidatorContext context) {
        if (dto.getStartDate() != null && dto.getEndDate() != null) {
            return dto.getStartDate().isBefore(dto.getEndDate());
        }
        return true; // return true if either date is null, allowing @NotNull to handle null checks
    }
}

