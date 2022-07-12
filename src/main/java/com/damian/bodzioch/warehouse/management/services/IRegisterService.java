package com.damian.bodzioch.warehouse.management.services;

import com.damian.bodzioch.warehouse.management.model.User;

public interface IRegisterService {
    void validationForm(User user, String repeatPassword);
    void addNewUser(User user);
}
