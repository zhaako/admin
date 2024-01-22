package com.spring.zhakoproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "lastname", length = 200)
    private String lastname;
    @Column(name = "firstname", length = 200)
    private String firstname;
    @Column(name = "login", length = 200)
    private String login;
    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Gender gender;

}

