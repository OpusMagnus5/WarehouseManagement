package com.damian.bodzioch.warehouse.management.session;

import com.damian.bodzioch.warehouse.management.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionObject {
    private User user;

    public User getUser() {
        return user;
    }
}
