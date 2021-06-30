package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;



class ProductManagerTest {
    ProductRepository productRepository = new ProductRepository();
    ProductManager productManager = new ProductManager(productRepository);

    Book book1 = new Book(0, "Мираж", 500, "Соня Смитт");
    Book book2 = new Book(1, "Страж", 199, "Алексей Пехов");
    Smartphone smartphone1 = new Smartphone(2, "Iphone19", 99000, "Apple");
    Smartphone smartphone2 = new Smartphone(3, "Iphone15", 70200, "Apple");
    Smartphone smartphone3 = new Smartphone(4, "Sony21", 10200, "Сони");

    @Test
    void searchByMany() {
        productManager.addProduct(book1);
        productManager.addProduct(book2);
        productManager.addProduct(smartphone1);
        productManager.addProduct(smartphone2);
        productManager.addProduct(smartphone3);

        assertArrayEquals(new Product[]{book1,smartphone3}, productManager.searchBy("Со"));
    }

    @Test
    void searchByOneTrue() {
        productManager.addProduct(book1);

        assertArrayEquals(new Product[]{book1},productManager.searchBy("Со"));
    }

    @Test
    void searchByOneFalse() {
        productManager.addProduct(smartphone1);

        assertArrayEquals(new Product[]{},productManager.searchBy("Со"));
    }

    @Test
    void searchByZero() {
        assertArrayEquals(new Product[]{},productManager.searchBy("В"));
    }
}

