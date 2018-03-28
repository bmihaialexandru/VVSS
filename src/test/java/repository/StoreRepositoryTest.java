package repository;

import com.sun.javaws.exceptions.InvalidArgumentException;
import model.Product;

import static org.junit.Assert.*;

/**
 * Created by mihai on 3/28/2018.
 */
public class StoreRepositoryTest {
    Product p1,p2;
    StoreRepository repo;

    @org.junit.Before
    public void setUp() throws Exception {
        p1=new Product(1,"a","a",3);
        p2=new Product(2,"b","b",1);
        repo=new StoreRepository();
    }

    @org.junit.Test
    public void addValidProduct() throws Exception {

        repo.addNewProduct(p1);
        assertEquals(repo.getAllProducts().size(),1);
    }

    @org.junit.Test
    public void addInvalidProduct() throws Exception {

        try {

            repo.addNewProduct(p2);
        }
        catch (IllegalArgumentException e){

            assertEquals(repo.getAllProducts().size(),0);
        }
    }


}