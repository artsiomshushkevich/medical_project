package com.vetardim.model;

import javax.persistence.*;

/**
 * Created by vitalyorlov on 21.03.16.
 */
@Entity
@Table(name = "medical.doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "second_name")
    private String secondname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "qualification")
    private String qualification;
    @Column(name = "position")
    private String position;
    @Column(name = "id_specialization")
    private String idSpecialization;
    @Column(name = "id_departments")
    private String idDepartmetns;

    public Doctor (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIdSpecialization() {
        return idSpecialization;
    }

    public void setIdSpecialization(String idSpecialization) {
        this.idSpecialization = idSpecialization;
    }

    public String getIdDepartmetns() {
        return idDepartmetns;
    }

    public void setIdDepartmetns(String idDepartmetns) {
        this.idDepartmetns = idDepartmetns;
    }
}

