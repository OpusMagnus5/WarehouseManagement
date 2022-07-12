package com.damian.bodzioch.warehouse.management.services;

import com.damian.bodzioch.warehouse.management.model.User;

import java.util.Optional;

public interface ILoginService {
    void logIn(User user);
    Optional isLogged();
}
