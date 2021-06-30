package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)

public class Book extends Product {
    private String bookAuthor;

    public Book(int id, String name, int price, String bookAuthor) {
        super(id, name, price);
        this.bookAuthor = bookAuthor;
    }
}