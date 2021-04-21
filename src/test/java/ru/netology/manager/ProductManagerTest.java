package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book item1 = new Book(1, "Oleg i more", 100, "K.Popov");
    private Book item2 = new Book(2, "Tishina v pobegah", 300, "K.Melkocvetik");
    private Book item3 = new Book(3, "Vozrojdenie roschi", 60, "E.Aitlin");
    private Smartphone item4 = new Smartphone(4, "Iphone", 100000, "USA");
    private Smartphone item5 = new Smartphone(5, "OnePlus", 60000, "China");
    private Smartphone item6 = new Smartphone(6, "Samsung", 70000, "South Korea");
    private Smartphone item7 = new Smartphone(7, "Mi", 30000, "China");

    @BeforeEach
    public void setUp() {

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
    }

    @Test
    void shouldProductFindByName() {

        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = new Product[]{item4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldBookFindByName() {

        Product[] actual = manager.searchBy("Vozrojdenie roschi");
        Product[] expected = new Product[]{item3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldBookFindByAuthor() {

        Product[] actual = manager.searchBy("K.Popov");
        Product[] expected = new Product[]{item1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldSmartPhoneFindByName() {

        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = new Product[]{item4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldSmartPhoneFindByManufacture() {

        Product[] actual = manager.searchBy("China");
        Product[] expected = new Product[]{item5, item7};
        assertArrayEquals(expected, actual);
    }
}