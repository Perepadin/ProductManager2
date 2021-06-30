package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {


    @Test
    void test() {
        Book book = new Book();
    }

    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
        book.setId(1);
        book.setName("Фэнтези");
        book.setPrice(150);
        book.setBookAuthor("Алекей Пехов");

        assertEquals(1, book.getId());
        assertEquals("Фэнтези", book.getName());
        assertEquals(150, book.getPrice());
        assertEquals("Алекей Пехов", book.getBookAuthor());
    }

    @Test
    void shouldCastFromBaseClass() {
        Product product = new Book();

        if (product instanceof Book) {
            Book book = (Book) product;

        }
    }

    @Test
    public void shouldNotCastToDifferentClass() {
        Product product = new Book();

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
        } else {
            System.out.println("Not found");
        }
    }
}