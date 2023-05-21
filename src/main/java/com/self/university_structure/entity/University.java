package com.self.university_structure.entity;

import com.self.university_structure.dto.request.UniversityForm;
import com.self.university_structure.utils.DateHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "UNIVERSITY")
@NoArgsConstructor
public class University extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "OPENED_DATE")
    private LocalDate openedDate;

    public University(UniversityForm form) {
        super.setId(form.getId());
        super.setActive(true);
        this.name = form.getName();
        this.address = form.getAddress();
        this.openedDate = DateHelper.convertStringToDate(form.getOpenedDate(), "dd/MM/yyyy");
        if (form.getId() == null)
            this.setCreatedAt(LocalDateTime.now());
        else
            this.setUpdatedAt(LocalDateTime.now());
    }
}
