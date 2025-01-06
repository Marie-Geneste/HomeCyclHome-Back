package com.homecyclhome.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "business")

public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_business;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "slug",nullable = false)
    private String slug;
    @Column(name = "color",nullable = true)
    private String color;
    @Column(name= "mail", nullable = false)
    private String mail;

    public void setId_business(long id) {
    }
}
