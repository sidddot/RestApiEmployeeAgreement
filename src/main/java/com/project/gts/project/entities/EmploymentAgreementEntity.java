package com.project.gts.project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name="employment_agreements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentAgreementEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String employeeName;
    private String role;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long salary;
    private String terms;

    @Embedded
    private OtherDetails otherDetails;

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OtherDetails {
        private String department;
        private String manager;
    }
}
