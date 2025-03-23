package com.karan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // will generate the Primary Key in database and autoincrement
                                                        // the column itself using unique values
    private Long uid;
    @Column(unique = true, nullable = false)
    private String Uname;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String pass;
    @Enumerated(EnumType.STRING)
    private RoleEnum role; // USER OR ADMIN NOTHING ELSE (USED ENUM)
}
