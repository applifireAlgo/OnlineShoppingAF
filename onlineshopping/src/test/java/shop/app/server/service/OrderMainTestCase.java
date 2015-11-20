package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.OrderMainRepository;
import shop.app.shared.retail.OrderMain;
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
import shop.app.shared.retail.OrderDetail;
import shop.app.shared.retail.Item;
import shop.app.server.repository.ItemRepository;
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
public class OrderMainTestCase {

    @Autowired
    private OrderMainRepository<OrderMain> ordermainRepository;

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
            OrderMain ordermain = new OrderMain();
            ordermain.setOrderDate(new java.sql.Date(123456789));
            ordermain.setTotal(12.34);
            ordermain.setUserId("j43yPbpfbYizRZtGOgmGlFzGMgc3u7N0I2W4L43Rdauqd75i8w");
            java.util.List<OrderDetail> listOfOrderDetail = new java.util.ArrayList<OrderDetail>();
            OrderDetail orderdetail = new OrderDetail();
            Item item = new Item();
            Brand brand = new Brand();
            brand.setBrandName("qjy8Qji9NLGEBuAFeqJoHUgM31QPQ2UCgf415iL9jbn880HHAL");
            Product product = new Product();
            product.setProductName("npDDvL7HVY6ORdjkuyjwqAgYJyXR4dbqxwpqQ6Odq87ftuXYJA");
            Product ProductTest = productRepository.save(product);
            map.put("ProductPrimaryKey", product._getPrimarykey());
            brand.setBrandName("CKSWh03sgPA2DeesvhmB6fc0eTAuQ9bC3IHWqxQl2mHNHPBMQQ");
            brand.setProduct((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Brand BrandTest = brandRepository.save(brand);
            map.put("BrandPrimaryKey", brand._getPrimarykey());
            Category category = new Category();
            category.setBrand((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
            category.setCategoryName("KSSvTQ5lPBH6qPfUXEOc07uYUrmo60CTRukSYykc4ylEY3LSnz");
            category.setProduct((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Category CategoryTest = categoryRepository.save(category);
            map.put("CategoryPrimaryKey", category._getPrimarykey());
            item.setBrand((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setCategory((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setItemIcon("ucT");
            item.setItemName("R5w3SGXEq6VsKvcOWmGcnUg7jzLDf6FNMj6IdRdkNMaFVcNtLF");
            item.setItemPrice(12.34);
            item.setItemStock(2147483647);
            item.setProduct((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Item ItemTest = itemRepository.save(item);
            map.put("ItemPrimaryKey", item._getPrimarykey());
            orderdetail.setItemId((java.lang.String) ItemTest._getPrimarykey());
            orderdetail.setOrderMain(ordermain);
            orderdetail.setPrice(12.34);
            orderdetail.setQty(2147483647);
            orderdetail.setSubTotal(12.34);
            listOfOrderDetail.add(orderdetail);
            ordermain.addAllOrderDetail(listOfOrderDetail);
            ordermain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            ordermain.setEntityValidator(entityValidator);
            ordermain.isValid();
            ordermainRepository.save(ordermain);
            map.put("OrderMainPrimaryKey", ordermain._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ItemRepository<Item> itemRepository;

    @Autowired
    private BrandRepository<Brand> brandRepository;

    @Autowired
    private ProductRepository<Product> productRepository;

    @Autowired
    private CategoryRepository<Category> categoryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("OrderMainPrimaryKey"));
            OrderMain ordermain = ordermainRepository.findById((java.lang.String) map.get("OrderMainPrimaryKey"));
            ordermain.setOrderDate(new java.sql.Date(123456789));
            ordermain.setTotal(12.34);
            ordermain.setUserId("QtFVcBB0HaYBv7Xch7H84UrKzIgdL7FqFxhOb9FGp372UvWjRe");
            ordermain.setVersionId(1);
            ordermain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            ordermainRepository.update(ordermain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("OrderMainPrimaryKey"));
            ordermainRepository.findById((java.lang.String) map.get("OrderMainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("OrderMainPrimaryKey"));
            ordermainRepository.delete((java.lang.String) map.get("OrderMainPrimaryKey")); /* Deleting refrenced data */
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