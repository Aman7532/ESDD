package com.aman.fullstackbackend.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "domain")
    private List<User> students;
    private String branch;
    private int capacity;
    private String qualification;
    private String batch;

    // Constructors, getters, and setters
    // Constructors
    public Domain() {
    }

    public Domain(String branch, int capacity, String qualification, String batch) {
        this.branch = branch;
        this.capacity = capacity;
        this.qualification = qualification;
        this.batch = batch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
