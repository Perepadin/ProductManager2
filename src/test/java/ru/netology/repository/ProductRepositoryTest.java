package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();

    Book book1 = new Book(0, "Мираж", 500, "Соня Смитт");
    Book book2 = new Book(1, "Страж", 199, "Алексей Пехов");
    Smartphone smartphone1 = new Smartphone(2, "Iphone19", 99000, "Apple");
    Smartphone smartphone2 = new Smartphone(3, "Iphone15", 70200, "Apple");
    Smartphone smartphone3 = new Smartphone(4, "Sony21", 10200, "Сони");

    @Test
    void shouldSaveItem() {
        repository.save(book1);
        repository.save(smartphone1);

        Product[] expected = new Product[]{book1, smartphone1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDeleteById() {
        // проверка удаления по ID
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        repository.removeById(3);

        assertArrayEquals(new Product[]{book1, book2, smartphone1, smartphone3}, repository.findAll());
    }

    @Disabled
    @Test
    public void shouldFailTestAndShowDescription() {
        // проверка падение теста с надписью ID не найден
        repository.save(coreJava);

        repository.removeById(7);
    }

    @Test
    public void negativeId() {
        // проверка с отрицательным ID
        repository.save(coreJava);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(-3);
        });
    }

    @Test
    public void outOfLength() {
        // проверка ID с выходом за граничные значения
        repository.save(coreJava);
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(10);
        });
    }
}