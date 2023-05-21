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
public class Patient implements Serializable {
    @Id
    @GeneratedValue
    long id;
    @Column
    String name;
    @Column
    int age;
    @Column
    char gender;
    @Column
    String phoneNumber;
}
