package com.damian.bodzioch.warehouse.management.services.iplm;

import com.damian.bodzioch.warehouse.management.database.IProductDAO;
import com.damian.bodzioch.warehouse.management.model.OrderInBasket;
import com.damian.bodzioch.warehouse.management.model.Product;
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
        for (OrderInBasket element : this.sessionObject.getBasket()){
            if (element.getProduct().getId() == id){
                element.setQuantity(element.getQuantity() + 1);
                this.sessionObject.setQuantityProductsInBasket(this.sessionObject.getQuantityProductsInBasket() + 1);
                return;
            }
        }

        for (Product product : productDAO.getProductsDatabase()){
            if (product.getId() == id){
                this.sessionObject.getBasket().add(new OrderInBasket(product, 1));
                this.sessionObject.setQuantityProductsInBasket(this.sessionObject.getQuantityProductsInBasket() + 1);
            }
        }
        //TODO dorobić sprawdzenie dostępnej ilości produktów przed wsadzeniem do koszyka
    }
}
