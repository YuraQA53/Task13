import org.junit.jupiter.api.Test;
import ru.netology.realm.Book;
import ru.netology.realm.Product;
import ru.netology.realm.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    private final ProductRepository repo = new ProductRepository();
    Product product = new Product(21, "bread", 35);
    Product book = new Book(22, "инструкция iPhone 14 Pro Max", 70, "Автор");
    Product smartphone = new Smartphone(23, "iPhone 14 Pro Max", 164990, "Apple");

    @Test
    public void saveTest() {

        repo.save(product);
        repo.save(book);
        repo.save(smartphone);


        Product[] expected = {product, book, smartphone};
        Product[] actual = repo.getProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void savesOneProduct() {

        repo.save(book);

        Product[] expected = {book};
        Product[] actual = repo.getProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeId() {

        repo.save(product);
        repo.save(book);
        repo.save(smartphone);
        repo.removeById(21);

        Product[] expected = {book, smartphone};
        Product[] actual = repo.getProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAllId() {

        repo.save(product);
        repo.save(book);
        repo.save(smartphone);
        repo.removeById(21);
        repo.removeById(22);
        repo.removeById(23);

        Product[] expected = {};
        Product[] actual = repo.getProducts();

        assertArrayEquals(expected, actual);
    }

}




