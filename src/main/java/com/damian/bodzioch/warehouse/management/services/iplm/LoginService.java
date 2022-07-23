package com.damian.bodzioch.warehouse.management.services.iplm;

import com.damian.bodzioch.warehouse.management.database.IUserDAO;
import com.damian.bodzioch.warehouse.management.exceptions.LoginOrPasswordDoNotMatch;
import com.damian.bodzioch.warehouse.management.model.User;
import com.damian.bodzioch.warehouse.management.services.ILoginService;
import com.damian.bodzioch.warehouse.management.session.SessionObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LoginService implements ILoginService {
    @Autowired
    IUserDAO userDatabase;

    @Resource
    SessionObject sessionObject;

    public void logIn(User user){
            for (User element : this.userDatabase.getUserDatabase()){
                if (element.getLogin().equals(user.getLogin()) && element.getPassword().equals(DigestUtils.md5Hex(user.getPassword()))){
                    this.sessionObject.setUser(element);
                    break;
                }
            }
            if (this.sessionObject.getUser() == null){
                throw new LoginOrPasswordDoNotMatch();
            }
    }

    public Optional isLogged(){
        if (this.sessionObject.getUser() != null){
            return Optional.of(this.sessionObject.getUser());
        }
        return Optional.empty();
    }
}
