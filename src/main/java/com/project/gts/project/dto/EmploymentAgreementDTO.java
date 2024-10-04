package com.project.gts.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValidDateRange(message = "Start date must be before end date")
public class EmploymentAgreementDTO {

    private Long id;

	@NotNull(message = "Employee name cannot be null")
    private String employeeName;
	@NotNull(message = "Role cannot be null")
    private String role;

	@NotNull(message = "Start date cannot be null")
	@FutureOrPresent(message = "Start date cannot be in the past")
    private LocalDate startDate;
	@NotNull(message = "End date cannot be null")
    @Future(message = "End date must be in the future")
    private LocalDate endDate;

    @Min(value = 0, message = "Salary must be positive")
    private Long salary;
    private String terms;
    private OtherDetailsDTO otherDetails;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OtherDetailsDTO {
        private String department;
        private String manager;
    }
}
