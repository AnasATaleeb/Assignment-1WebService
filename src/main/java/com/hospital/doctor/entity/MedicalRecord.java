package com.hospital.doctor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class MedicalRecord implements Serializable {
    @Id
    @GeneratedValue
    long id;
    @Column
    long patient_id;
    @Column
    long doctor_id;
    @Column
    String treatment;
    @Column
    String medicine;
}
