package ru.sbertech.tradehouse.business;

import org.junit.*;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbertech.tradehouse.dao.ProductDao;
import ru.sbertech.tradehouse.domain.Product;

import java.util.List;

/**
 * Created by anton on 11/24/16.
 */
public class ProductManagerTest
{
    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void dispose() throws Exception {

    }

    @Test
    @Ignore
    public void addProduct() throws Exception {

    }

    @Test
    @Ignore
    public void updateProduct() throws Exception {

    }

    @Test
    public void getProduct() throws Exception {
//        ProductManager pm = new ProductManager();
//        ProductDao mock = Mockito.mock(ProductDao.class);
//        Mockito.when(Product.class).thenReturn(Product.class)
//        pm.setDao(mock);
//        pm.getProduct(1L);
        
        
    }

    @Test
    @Ignore
    public void deleteProduct() throws Exception {

    }

    @Test
    public void findProduct() throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"trade-house.xml"});

        ProductManager pm = context.getBean(ProductManager.class);
        List<Product> products = pm.findProduct();
        Assert.assertTrue(products != null);
    }

}