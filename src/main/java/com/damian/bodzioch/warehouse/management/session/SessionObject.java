package com.damian.bodzioch.warehouse.management.session;

import com.damian.bodzioch.warehouse.management.model.OrderInBasket;
import com.damian.bodzioch.warehouse.management.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Optional;

@Component
@SessionScope
public class SessionObject {
    private User user;

    private HashSet<OrderInBasket> basket = new HashSet<>();

    private int quantityProductsInBasket = 0;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HashSet<OrderInBasket> getBasket() {
        return basket;
    }

    public void setBasket(HashSet<OrderInBasket> basket) {
        this.basket = basket;
    }

    public int getQuantityProductsInBasket() {
        return quantityProductsInBasket;
    }

    public void setQuantityProductsInBasket(int quantityProductsInBasket) {
        this.quantityProductsInBasket = quantityProductsInBasket;
    }

    public Optional<OrderInBasket> getOrderByProductID(int id){
        for (OrderInBasket orderInBasket : this.basket){
            if (orderInBasket.getProduct().getId() == id){
                return Optional.of(orderInBasket);
            }
        }
        return Optional.empty();
    }
}
