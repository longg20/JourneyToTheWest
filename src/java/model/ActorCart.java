/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.RegistrationDTO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Long
 */
public class ActorCart implements Serializable {
    private String calamityName;
    private HashMap<String, RegistrationDTO> cart;

    public String getCalamityName() {
        return calamityName;
    }

    public HashMap<String, RegistrationDTO> getCart() {
        return cart;
    }

    public ActorCart(String calamityName) {
        this.calamityName = calamityName;
        this.cart = new HashMap<>();
    }
    
    public void addToCart(String key, RegistrationDTO dto) throws Exception {
        if (this.cart.containsKey(key))
            return;
        else
            this.cart.put(key, dto);
    }
    
    public void remove(String key) throws Exception {
        if (this.cart.containsKey(key))
            this.cart.remove(key);
    }
    
    public void updateDescription(String key, String description) throws Exception {
        if (this.cart.containsKey(key)) {
            this.cart.get(key).setRoleDescription(description);
        }
    }
    
    public void load(List<RegistrationDTO> list) throws Exception {
        for (int i = 0; i < list.size(); i ++) {
            String key = (list.get(i).getId() + list.get(i).getRoleName()).toLowerCase();
            addToCart(key, (list.get(i)));
        }
    }
}
