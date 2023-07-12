package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product item1 = new Product(3, "Молоко", 50);
    Product item2 = new Product(5, "Кефир", 30);
    Product item3 = new Product(9, "Ряженка", 45);
    Product item4 = new Product(11, "Сметана", 75);
    Product item5 = new Product(15, "Йогурт", 27);


    @Test

    public void deletingExistentElement() {
        ShopRepository repository = new ShopRepository();
        repository.add(3, item1);
        repository.add(5, item2);
        repository.add(9, item3);
        repository.add(11, item4);
        repository.add(15, item5);
        repository.removeById(5);

        Product[] expected = {item1, item3, item4, item5};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test

    public void deletingNonExistentElement() {
        ShopRepository repository = new ShopRepository();
        repository.add(3, item1);
        repository.add(5, item2);
        repository.add(9, item3);
        repository.add(11, item4);
        repository.add(15, item5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(10);
        });
    }

    @Test

    public void addExistentElement() {
        ShopRepository repository = new ShopRepository();
        repository.add(3, item1);
        repository.add(5, item2);
        repository.add(9, item3);
        repository.add(11, item4);
        repository.add(15, item5);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.add(9, item3);
        });
    }

    @Test

    public void addNonExistentElement() {
        ShopRepository repository = new ShopRepository();
        repository.add(3, item1);
        repository.add(5, item2);
        repository.add(9, item3);
        repository.add(11, item4);
        repository.add(15, item5);


        Product[] expected = {item1, item2, item3, item4, item5};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

}

