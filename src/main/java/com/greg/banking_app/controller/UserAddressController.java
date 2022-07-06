package com.greg.banking_app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/addresses")
public class UserAddressController {

    @GetMapping("{userId}")
    public String getUserAddresses(@PathVariable Long userId) {
        return "List of user addresses";
    }

    @GetMapping("{userId}/{addressId}")
    public String getUserAddress(@PathVariable Long userId, @PathVariable Long addressId) {
        return "Specific address";
    }

    @PostMapping
    public String createAddress() {
        return "Address has been greate";
    }

    @PutMapping
    public String updateAddress() {
        return "Addres has been updated";
    }

    @DeleteMapping("{addressId}")
    public String deleteAddress(@PathVariable Long addressId) {
        return "Address deleted";
    }
}
