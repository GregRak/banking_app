package com.greg.banking_app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USER_ADDRESS")
public class UserAddress {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ADDRESS", unique = true)
    private Long addressId;

    @NotNull
    @Column(name = "ADDRESS_LINE")
    private String addressLine;

    @NotNull
    @Column(name = "ZIPCODE")
    private String zipCode;

    @NotNull
    @Column(name = "CITY")
    private String city;

    @NotNull
    @Column(name = "IS_CORRESPONDENCE")
    private boolean correspondence;

    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;
}
