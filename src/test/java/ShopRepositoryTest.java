import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ShopRepositoryTest {
    @Test
    public void generatingANotFoundException() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "Мяч", 1000);
        Product product2 = new Product(22, "Кукла", 2000);
        Product product3 = new Product(33, "Скакалка", 3000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(44)
        );

    }

    @Test
    public void successOfDeletingAnExistingElement() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "Мяч", 1000);
        Product product2 = new Product(22, "Кукла", 2000);
        Product product3 = new Product(33, "Скакалка", 3000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(11);
        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }


}
