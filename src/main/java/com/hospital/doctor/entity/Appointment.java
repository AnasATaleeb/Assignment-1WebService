package com.hospital.doctor.entity;


import com.fasterxml.jackson.core.SerializableString;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Appointment implements Serializable {
    @Id
    @GeneratedValue
    long id;
    @Column
    long patient_id;
    @Column
    long doctor_id;
    @Column
    Date date;
    @Column
    String time;
}
