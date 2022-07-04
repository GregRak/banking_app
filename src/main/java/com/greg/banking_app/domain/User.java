package com.greg.banking_app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_USER", unique = true)
    private Long userId;

    @NotNull
    @Column(name = "PESEL", unique = true)
    private String peselNumber;

    @NotNull
    @Column(name = "FIRSTNAME")
    private String firstName;

    @NotNull
    @Column(name = "LASTNAME")
    private String lastName;

    @NotNull
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "TELEPHONE")
    private String telephone;

    @NotNull
    @Column(name = "IS_ACTIVE")
    private boolean active;

    @OneToMany(
            targetEntity = UserAddress.class,
            mappedBy = "user",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<UserAddress> addresses;

    @OneToMany(
            targetEntity = Account.class,
            mappedBy = "user",
            cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER
    )
    private List<Account> accounts;
}
