package com.project.Student.Management.System.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    public class Student{
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long userid;
        private String email;
        private String course ;
        private Integer year;
        private String name;




    }

