package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.CartRepository;
import shop.app.shared.retail.Cart;
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
import shop.app.shared.retail.Item;
import shop.app.server.repository.ItemRepository;
import shop.app.shared.retail.Brand;
import shop.app.server.repository.BrandRepository;
import shop.app.shared.retail.Product;
import shop.app.server.repository.ProductRepository;
import shop.app.shared.retail.Category;
import shop.app.server.repository.CategoryRepository;
import shop.app.shared.authentication.User;
import shop.app.server.repository.UserRepository;
import shop.app.shared.authentication.UserAccessDomain;
import shop.app.server.repository.UserAccessDomainRepository;
import shop.app.shared.authentication.UserAccessLevel;
import shop.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CartTestCase {

    @Autowired
    private CartRepository<Cart> cartRepository;

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
            Item item = new Item();
            Brand brand = new Brand();
            brand.setBrandName("3ypV6sIx2WJJIVOULkoCjLs0e39IyfDnE7JvMpj6MYQGEY0wwg");
            Product product = new Product();
            product.setProductName("CvkndEO9lW0Hc9nIYB1sAYUkLKJSqtoAhEm40LtSGHGib5N8Mf");
            Product ProductTest = productRepository.save(product);
            map.put("ProductPrimaryKey", product._getPrimarykey());
            brand.setBrandName("xJXwnlC20un0vIhMJNVWdhYECkzVEBBqN5jkqIqmzAfKRNWOv3");
            brand.setProduct((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Brand BrandTest = brandRepository.save(brand);
            map.put("BrandPrimaryKey", brand._getPrimarykey());
            Category category = new Category();
            category.setBrand((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
            category.setCategoryName("wJB6h5PaR3KbdGUxgxuD82TkvfVyUqlxDIRuC0kMYUs9ccTRIY");
            category.setProduct((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Category CategoryTest = categoryRepository.save(category);
            map.put("CategoryPrimaryKey", category._getPrimarykey());
            item.setBrand((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setCategory((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setItemIcon("eJQ");
            item.setItemName("Am2DVoNXMXptnQZTohwhi0wYrE1cyyyT8HaFq1fcMWgJpRikqd");
            item.setItemPrice(12.34);
            item.setItemStock(2147483647);
            item.setProduct((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Item ItemTest = itemRepository.save(item);
            map.put("ItemPrimaryKey", item._getPrimarykey());
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("zabi5Uad0mNSGpOsvD4dWIgdAWAeFJq40b1AtfrZvI77IswLRo");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(292);
            user.setUserAccessCode(6);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("lrgcad1RhNgirIJE71WSTemy1pZzl8zSJaHqQSUgshyrHMiwZv");
            useraccessdomain.setDomainHelp("qPQZoFLLK2W1SBr2zvXh5i3fhWyUGicLbtezxQ1NElH5g6jLUm");
            useraccessdomain.setDomainIcon("1YoN9N1Ps0KXkbrQl9d4gjLtSGYSXrkjCEY5MbCtZeemWfteRh");
            useraccessdomain.setDomainName("VClBaH13jTzPnZUfoXzrbQL1z4wL84YkuALB1uMltgruFg9bSE");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("yXNmoN1xd26oIgFCZRkBzEQ6kKVi2w6CgK2tuzv2FgPKoNKMiE");
            useraccesslevel.setLevelHelp("U3wZ5bNMqGfWTaQPq3gey8voY5ILtIBuqhtChmxUv37pMvt47b");
            useraccesslevel.setLevelIcon("9x4poprX1q16ybsvAsNOKYNGsYPUgU8iBj50dw8cf7lswjS7E5");
            useraccesslevel.setLevelName("XDjdl29qnui8UyJ8EsNamsdebofQNwLVJ6orbckTZlS0T7arIm");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("H0RY26msMjl8tWJzLlsUmrHfDU6GyxsQmufPn5LTVV0Co92htO");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1489);
            user.setUserAccessCode(7);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            User UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
            Cart cart = new Cart();
            cart.setCartQty(2147483647);
            cart.setItemId((java.lang.String) ItemTest._getPrimarykey()); /* ******Adding refrenced table data */
            cart.setItemName("OU9DwcWRHYNjG3Di9PXrrOxnp3WVvjdLKPKRMtetHFl94B7T8B");
            cart.setItemPrice(12.34);
            cart.setSubTotal(12.34);
            cart.setUserId((java.lang.String) UserTest._getPrimarykey());
            cart.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            cart.setEntityValidator(entityValidator);
            cart.isValid();
            cartRepository.save(cart);
            map.put("CartPrimaryKey", cart._getPrimarykey());
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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CartPrimaryKey"));
            Cart cart = cartRepository.findById((java.lang.String) map.get("CartPrimaryKey"));
            cart.setCartQty(2147483647);
            cart.setItemName("pxF5dS3mAejYYh04wBoB8hl6LHzBW5bocszBBeM45Mzffvj8d0");
            cart.setItemPrice(12.34);
            cart.setSubTotal(12.34);
            cart.setVersionId(1);
            cart.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cartRepository.update(cart);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CartPrimaryKey"));
            cartRepository.findById((java.lang.String) map.get("CartPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByitemId() {
        try {
            java.util.List<Cart> listofitemId = cartRepository.findByItemId((java.lang.String) map.get("ItemPrimaryKey"));
            if (listofitemId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<Cart> listofuserId = cartRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CartPrimaryKey"));
            cartRepository.delete((java.lang.String) map.get("CartPrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
