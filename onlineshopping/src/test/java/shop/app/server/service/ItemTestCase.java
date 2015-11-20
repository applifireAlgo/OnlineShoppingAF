package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.ItemRepository;
import shop.app.shared.retail.Item;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import shop.app.shared.retail.Brand;
import shop.app.server.repository.BrandRepository;
import shop.app.shared.retail.Product;
import shop.app.server.repository.ProductRepository;
import shop.app.shared.retail.Category;
import shop.app.server.repository.CategoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class ItemTestCase {

    @Autowired
    private ItemRepository<Item> itemRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            Brand brand = new Brand();
            brand.setBrandName("NNPmFX3qEFRujTTccvcANOfuXivoO0eIxgfA6Dg3z9aoyxzWye");
            Product product = new Product();
            product.setProductName("nUaDzB2szUWrrpf4YUEzDxwjnN2fDaIcOe3xgyduZUAdva3DYN");
            Product ProductTest = productRepository.save(product);
            map.put("ProductPrimaryKey", product._getPrimarykey());
            brand.setBrandName("KuQf5aS2IL0zj8LN1agou9sIbywQJu2yHw6l3uh0XP76gNY543");
            brand.setProduct((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Brand BrandTest = brandRepository.save(brand);
            map.put("BrandPrimaryKey", brand._getPrimarykey());
            Category category = new Category();
            category.setBrand((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
            category.setCategoryName("lAqxGIw6TQt0Y7GIctneulM3EfNCKBiW7nxS1Awh0p3iCWan1q");
            category.setProduct((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Category CategoryTest = categoryRepository.save(category);
            map.put("CategoryPrimaryKey", category._getPrimarykey());
            Item item = new Item();
            item.setBrand((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setCategory((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setItemIcon("p2A");
            item.setItemName("B5H1qAikihYRGrnoNiQZHZ8iICxhbOxXfa84GagLDXjWws1Rum");
            item.setItemPrice(12.34);
            item.setItemStock(2147483647);
            item.setProduct((java.lang.String) ProductTest._getPrimarykey());
            item.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            item.setEntityValidator(entityValidator);
            item.isValid();
            itemRepository.save(item);
            map.put("ItemPrimaryKey", item._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private BrandRepository<Brand> brandRepository;

    @Autowired
    private ProductRepository<Product> productRepository;

    @Autowired
    private CategoryRepository<Category> categoryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ItemPrimaryKey"));
            Item item = itemRepository.findById((java.lang.String) map.get("ItemPrimaryKey"));
            item.setItemIcon("kYo");
            item.setItemName("UQcAsbiIcy3CBowTmyZh0EFITnwkYdkrQr4u0BaKaYoet8rsj5");
            item.setItemPrice(12.34);
            item.setItemStock(2147483647);
            item.setVersionId(1);
            item.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            itemRepository.update(item);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBybrand() {
        try {
            java.util.List<Item> listofbrand = itemRepository.findByBrand((java.lang.String) map.get("BrandPrimaryKey"));
            if (listofbrand.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycategory() {
        try {
            java.util.List<Item> listofcategory = itemRepository.findByCategory((java.lang.String) map.get("CategoryPrimaryKey"));
            if (listofcategory.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ItemPrimaryKey"));
            itemRepository.findById((java.lang.String) map.get("ItemPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByproduct() {
        try {
            java.util.List<Item> listofproduct = itemRepository.findByProduct((java.lang.String) map.get("ProductPrimaryKey"));
            if (listofproduct.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFetchItemDetails() {
        try {
            itemRepository.FetchItemDetails("ab");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ItemPrimaryKey"));
            itemRepository.delete((java.lang.String) map.get("ItemPrimaryKey")); /* Deleting refrenced data */
            categoryRepository.delete((java.lang.String) map.get("CategoryPrimaryKey")); /* Deleting refrenced data */
            brandRepository.delete((java.lang.String) map.get("BrandPrimaryKey")); /* Deleting refrenced data */
            productRepository.delete((java.lang.String) map.get("ProductPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
