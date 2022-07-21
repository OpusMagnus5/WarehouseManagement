package com.damian.bodzioch.warehouse.management.services.iplm;

import com.damian.bodzioch.warehouse.management.database.IProductDAO;
import com.damian.bodzioch.warehouse.management.exceptions.LackOfProduct;
import com.damian.bodzioch.warehouse.management.model.OrderInBasket;
import com.damian.bodzioch.warehouse.management.services.IBasketService;
import com.damian.bodzioch.warehouse.management.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BasketService implements IBasketService {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IProductDAO productDAO;

    public void addProductToBasket(int id){

        if (this.productDAO.getProductByID(id).isEmpty() || (this.sessionObject.getOrderByProductID(id).isPresent() &&
                this.sessionObject.getOrderByProductID(id).get().getQuantity() + 1 > this.productDAO.getProductByID(id).get().getQuantity())){
            throw new LackOfProduct();
        }

        if (this.sessionObject.getOrderByProductID(id).isPresent()){
            this.sessionObject.getOrderByProductID(id).get().setQuantity(this.sessionObject.getOrderByProductID(id).get().getQuantity() + 1);
            this.sessionObject.setQuantityProductsInBasket(this.sessionObject.getQuantityProductsInBasket() + 1);
        }

        if (this.sessionObject.getOrderByProductID(id).isEmpty()){
            this.sessionObject.getBasket().add(new OrderInBasket(this.productDAO.getProductByID(id).get(), 1));
            this.sessionObject.setQuantityProductsInBasket(this.sessionObject.getQuantityProductsInBasket() + 1);
        }
    }

    public void removeProductFromBasket(int id){
        this.sessionObject.setQuantityProductsInBasket(this.sessionObject.getQuantityProductsInBasket() -
                this.sessionObject.getOrderByProductID(id).get().getQuantity());
        this.sessionObject.getBasket().remove(this.sessionObject.getOrderByProductID(id).get());
    }
}
