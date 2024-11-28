package com.aman.fullstackbackend.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;


 @Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    private Long id;
    @ManyToOne
    @JoinColumn(name = "domain_id")
    private Domain domain;
    @Column( name="username" ,nullable = false,unique = true)
    private String username;
    @Column(unique = true)
    private String name;
    @Column(unique=true)
    private String email;

    private String cgpa;

    private String photograph_path;


    private  String branch;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {

        this.branch = branch;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
