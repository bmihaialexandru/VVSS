package repository;

import com.sun.javaws.exceptions.InvalidArgumentException;
import model.Product;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by mihai on 3/28/2018.
 */
public class StoreRepositoryTest {
    Product p1, p2, pinvalid1, pinvalid2, pinvalid3, pinvalid4, pinvalid5;
    StoreRepository repo;

    @org.junit.Before
    public void setUp() throws Exception {
        p1 = new Product(1, "a", "a", 3);
        p2 = new Product(2, "b", "b", 1);

        pinvalid1 = new Product(-1, "b", "b", 1);
        pinvalid2 = new Product(0, "b", "b", 1);
        pinvalid3 = new Product(3, "b", "b", -1);
        pinvalid4 = new Product(4, "b", "b", 0);
        pinvalid5=new Product(5, "b2", "b", 0);

        repo = new StoreRepository();
    }

    @org.junit.Test
    public void addValidProduct() throws Exception {

        repo.addNewProduct(p1);
        assertEquals(repo.getAllProducts().size(), 1);
    }

    @org.junit.Test
    public void addInvalidProduct() throws Exception {

        repo.addNewProduct(p1);
        try {

            repo.addNewProduct(p1);
            assertEquals(false, true);
        } catch (IllegalArgumentException e) {

            assertEquals(repo.getAllProducts().size(), 1);
        }
    }

    @org.junit.Test
    public void addProductNegativeCode() throws Exception {
        String s=repo.addNewProduct(pinvalid1);
        assertEquals("code q", s);

    }

    @org.junit.Test
    public void addProductZeroCode() throws Exception {
        String s=repo.addNewProduct(pinvalid2);
        assertEquals("code q", s);
    }

    @org.junit.Test
    public void addProductNegativeQuantity() throws Exception {
        String s=repo.addNewProduct(pinvalid3);
        assertEquals("code q", s);
    }
    @org.junit.Test
    public void addProductZeroQuantity() throws Exception {
        String s=repo.addNewProduct(pinvalid4);
        assertEquals("code q", s);
    }

    @org.junit.Test
    public void addProductNumberName() throws Exception {
        String s=repo.addNewProduct(pinvalid5);
        assertEquals("code q", s);
    }

    @org.junit.Test
    public void listCategoryEmptyList() throws Exception {
        ArrayList<Product> s=repo.getProductsCategory("a");
        assertEquals(s.size(), 0);
    }


    @org.junit.Test
    public void listCategoryHappyCase() throws Exception {
        String q=repo.addNewProduct(p1);
        ArrayList<Product> s=repo.getProductsCategory("a");
        assertEquals(s.size(), 1);
    }

    @org.junit.Test
    public void listCategoryEmptyResult() throws Exception {
        String q=repo.addNewProduct(p1);
        ArrayList<Product> s=repo.getProductsCategory("b");
        assertEquals(s.size(), 0);
    }



}