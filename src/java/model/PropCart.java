/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.Prop;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Long
 */
public class PropCart implements Serializable {
    private String calamityName;
    private HashMap<String, Prop> cart;

    public String getCalamityName() {
        return calamityName;
    }

    public HashMap<String, Prop> getCart() {
        return cart;
    }

    public PropCart(String calamityName) {
        this.calamityName = calamityName;
        this.cart = new HashMap<>();
    }
    
    public void addToCart(Prop prop) throws Exception {
        if (this.cart.containsKey(prop.getId())) {
            int quantity = this.cart.get(prop.getId()).getQuantity() + prop.getQuantity();
            prop.setQuantity(quantity);
        }
        this.cart.put(prop.getId(), prop);
    }
    
    public void remove(String id) throws Exception {
        if (this.cart.containsKey(id))
            this.cart.remove(id);
    }
    
    public void update(String id, int quantity) throws Exception {
        if (this.cart.containsKey(id))
            this.cart.get(id).setQuantity(quantity);
    }
    
    public void load(List<Prop> list) throws Exception {
        for (int i = 0; i < list.size(); i ++) {
            addToCart(list.get(i));
        }
    }
}
