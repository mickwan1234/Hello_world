/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghia.dtos;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author mickw
 */
public class CartObj implements Serializable {

    private HashMap<String, RamDTO> cart;
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, RamDTO> getCart() {
        return cart;
    }

    public CartObj() {
        this.customerName = "Guest";
        this.cart = new HashMap<>();
    }

    public CartObj(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }
    public void addToCart(RamDTO dto) throws Exception{
        if(this.cart.containsKey(dto.getId())){
            int quantity = this.cart.get(dto.getId()).getQuantitiy() +1;
            dto.setQuantitiy(quantity);
        }
        this.cart.put(dto.getId(), dto);
    }
    public void removeCart(String id) throws Exception{
        if(this.cart.containsKey(id)){
            this.cart.remove(id);
        }
        
    }
    
    public float getTotal() throws Exception{
        float total=0;
        for(RamDTO dto: this.cart.values()){
            total+= dto.getQuantitiy()*dto.getPrice();
        }
        return total;
    }
    public void updateCart(String cartID, int quantity) throws Exception{
        if(this.cart.containsKey(cartID)){
            this.cart.get(cartID).setQuantitiy(quantity);
        }
    }
    
}
