import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.realm.Book;
import ru.netology.realm.Product;
import ru.netology.realm.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product = new Product(21, "bread", 35);
    Product book = new Book(22, "инструкция iPhone 14 Pro Max ", 70, "Автор");
    Product smartphone = new Smartphone(23, "iPhone 14 Pro Max", 164990, "Apple");

    @Test
    void shouldAdd() {
        manager.add(book);
        Product[] expected = {book};
        Product[] actual = repo.getProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddAll() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        Product[] expected = {book, smartphone, product};
        Product[] actual = repo.getProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    void WhenOneProductFits() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name = "bread";
        Product[] expected = {product};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    void WhenFewProductsSuit() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name = "iPhone 14 Pro Max";
        Product[] expected = {book, smartphone};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }


    @Test
    void WhenProductsNotSuit() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name = "Google pixel";
        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

}


