package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)


public class Smartphone extends Product {
    private String Manufacturer;


    public Smartphone(int id, String name, int price, String Manufacturer) {
        super(id, name, price);
        this.Manufacturer = Manufacturer;
    }

}
