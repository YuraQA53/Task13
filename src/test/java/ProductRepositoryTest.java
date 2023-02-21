import org.junit.jupiter.api.Test;
import ru.netology.realm.Book;
import ru.netology.realm.Product;
import ru.netology.realm.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    private final ProductRepository repo = new ProductRepository();
    Product product = new Product(12, "bread", 35);
    Product book = new Book(15, "Властелин колец. Хранители кольца", 50, "Толкин Джон Рональд Руэл");
    Product smartphone = new Smartphone(19, "iPhone 14 Pro Max", 164990, "Apple");

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
        repo.removeById(12);

        Product[] expected = {book, smartphone};
        Product[] actual = repo.getProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAllId() {

        repo.save(product);
        repo.save(book);
        repo.save(smartphone);
        repo.removeById(12);
        repo.removeById(15);
        repo.removeById(19);

        Product[] expected = {};
        Product[] actual = repo.getProducts();

        assertArrayEquals(expected, actual);
    }

}




