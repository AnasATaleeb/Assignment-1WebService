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

public class Doctor implements Serializable{
    @Id
    @GeneratedValue
    long id;
    @Column
    long emp_id;
    @Column
    String name;
    @Column
    String specialization;
    @Column
    char gender;
    @Column
    String phoneNumber;
    @Column
    long salary;

}
