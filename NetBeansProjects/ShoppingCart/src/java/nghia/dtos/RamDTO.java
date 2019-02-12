/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghia.dtos;

import java.io.Serializable;

/**
 *
 * @author mickw
 */
public class RamDTO implements Serializable {

    private String id, name;
    private float price;
    private int quantitiy;

    public RamDTO() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantitiy() {
        return quantitiy;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantitiy(int quantitiy) {
        this.quantitiy = quantitiy;
    }

}
