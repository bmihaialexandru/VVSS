
import com.sun.javaws.exceptions.InvalidArgumentException;
import model.Product;
import repository.StoreRepository;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by mihai on 3/28/2018.
 */
public class TopDownTest {
    Product p1;
    StoreRepository repo;

    @org.junit.Before
    public void setUp() throws Exception {
        p1 = new Product(1000, "a", "a", 3);

        repo = new StoreRepository();
    }

    @org.junit.Test
    public void addValidProduct() throws Exception {

        repo.addNewProduct(p1);
        assertEquals(repo.getAllProducts().size(), 1);
    }


    @org.junit.Test
    public void integrationAddListCategory() throws Exception {
        String q=repo.addNewProduct(p1);
        ArrayList<Product> s=repo.getProductsCategory("a");
        assertEquals(s.size(), 1);

        s=repo.getProductsCategory("a");
        assertEquals(s.size(), 1);
        assertEquals(s.get(0),p1);
    }

    @org.junit.Test
    public void integrationTestAll() throws Exception {
        repo.addNewProduct(p1);
        assertEquals(repo.getAllProducts().size(), 1);

        ArrayList<Product> s=repo.stockSituation();
        assertEquals(s.size(), 1);
        assertEquals(s.get(0),p1);

        s=repo.getProductsCategory("a");
        assertEquals(s.size(), 1);
        assertEquals(s.get(0),p1);


    }

}