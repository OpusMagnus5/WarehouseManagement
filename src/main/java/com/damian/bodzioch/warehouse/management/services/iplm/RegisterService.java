package com.damian.bodzioch.warehouse.management.services.iplm;

import com.damian.bodzioch.warehouse.management.database.IUserDAO;
import com.damian.bodzioch.warehouse.management.exceptions.LoginTooShort;
import com.damian.bodzioch.warehouse.management.exceptions.PasswordDoNotMatch;
import com.damian.bodzioch.warehouse.management.exceptions.PasswordTooShort;
import com.damian.bodzioch.warehouse.management.model.User;
import com.damian.bodzioch.warehouse.management.services.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements IRegisterService {
    @Autowired
    IUserDAO userDAO;

    public void validationForm(User user, String repeatPassword){
        if (user.getLogin().length() < 5){
            throw new LoginTooShort();
        }else if (user.getPassword().length() < 5){
            throw new PasswordTooShort();
        }else if (!user.getPassword().equals(repeatPassword)){
            throw new PasswordDoNotMatch();
        }
    }

    public void addNewUser(User user){
        userDAO.addUser(user);
    }
}
