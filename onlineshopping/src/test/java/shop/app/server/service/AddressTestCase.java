package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.AddressRepository;
import shop.app.shared.location.Address;
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
import shop.app.shared.location.AddressType;
import shop.app.server.repository.AddressTypeRepository;
import shop.app.shared.location.City;
import shop.app.server.repository.CityRepository;
import shop.app.shared.location.Country;
import shop.app.server.repository.CountryRepository;
import shop.app.shared.location.State;
import shop.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("uV9UelEHadoAMQ4k4FwXz3JSEBjIJUr9v12IAbG36VS61TdGLF");
            addresstype.setAddressTypeDesc("16PbMehnX7Rjyix53DvZy4UuAmYnFhZ0m2fgjRLJgrZC7nFlJt");
            addresstype.setAddressTypeIcon("qlYs4yQ3EuxNomVe2TvDgF3r4CLKnEzrE5tIdOuuAtU2nrlism");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("kW3bvy99nMUzdsU6c43k3VPGWbwbfTeW");
            city.setCityDescription("9d1LuGIZBHKB6O6mDUxSbZRnbyIvhqAdvf0q7gHMDVgwnWZD8H");
            city.setCityFlag("1lRUtfCTGmeVPtNCb62BT62Z0nkH1zIgteSbpEnD8Sj1epU4BC");
            city.setCityLatitude(8);
            city.setCityLongitude(2);
            city.setCityName("PgD0dvF2y9PbJkCJm70xSyfZMBJrfpOH0pFkI7sPbvLf8GqZzO");
            Country country = new Country();
            country.setCapital("wlkWa0QXhXdi2IQMFRAYYm7HAdgOBW6k");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(1);
            country.setCountryCode1("x0V");
            country.setCountryCode2("OBA");
            country.setCountryFlag("d4tACYso6jTTc9vYEM6N6v63QD5lFxhAHLRgOAFHm58hShiCZN");
            country.setCountryName("GXz4XPEOypUobXYawmyXJ44SMG8YFnwLDWExc9V1uinNFqt12a");
            country.setCurrencyCode("7hg");
            country.setCurrencyName("IXV6C3hgEvd1HuIvkNxR8TPBd95UzYi0Hv6JuEqyaeHjHSFl0V");
            country.setCurrencySymbol("H02df8M0KAaI9pXpouRwDfC7HCUrWvFV");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("fgfHRQhNhotH5rUvChvG2SnxWGs6fxNUOrEihEpV14vgcoC8ho");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(5);
            state.setStateCode(0);
            state.setStateCodeChar2("9lbtYeAYfURrTibDm2IFxyYUdHdVegc8");
            state.setStateCodeChar3("EcpMfZOTNCsAsVnBP64xo1jIDaa0jBhN");
            state.setStateDescription("8Qcka0VXFdswR5xCh8fgcEFQSS57H9j8aGkr8Ede2GpN4kDFn5");
            state.setStateFlag("HwlR1OF3Y5j8bSx7FwWZjze0txt26yTqIi9ke8NByWUwOTByfu");
            state.setStateName("QPvxKHlAm78bruq14yn1DjTQzLLadDgGXSbCmUZCV3Pt1qvNrP");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("m9Q6YqrUgYLFVo9C1ajbPOF8sxZZaPcn");
            city.setCityDescription("y926VrbYypLV4cWSSygrm4EMhP44r1cnVsysUPLZjVQhLpW3L0");
            city.setCityFlag("ySBd6MJpSulRHnmqMynl32jr8hseav9X0ze6nBShorXB072sVH");
            city.setCityLatitude(10);
            city.setCityLongitude(6);
            city.setCityName("qlfWR5CKtOgIg7kC93IioZaR0BQoM8ft3YeKjMxEs8OwtWAFKW");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("ZOSJh6qtfBLaJGeHV5TUyFYHnotezfFvt01tF2hf5242j6AHV1");
            address.setAddress2("Up24CxvGzEakgcnX5rwWkZY82qL93A8aUJT83ZTD8pjSwIGj8F");
            address.setAddress3("xhVF3EqymKpBmDMBMXApf3Sf6kVnSMMU6KfM0wAch6hYmO2Js0");
            address.setAddressLabel("lE7mrQKsSJh");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("phbkxby7SVWTT7mXXGl5BrTgJ9SPsW9Qir7LmNtkqJnsi2OzlK");
            address.setLongitude("ePVHpAsNVSH6cv9GuhM4eu8rev5XrOanIoHa5tvIFMuekXNi7H");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("eJi8RH");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("eYRaz6EpGTqebOOSkMYNpIxQTcx4DwKDQmdvem2nskYlzVaRTN");
            address.setAddress2("lLpf1UeMFNpFBuwsrAX7VSyLhAZdi5LgAYpcAShC1dBR9jHjqz");
            address.setAddress3("WLYOFPfrA61eo31DFzC0P0YwLLt0AuAkXrY4c2KuGdYEN1OzRI");
            address.setAddressLabel("L0gFiqv50Av");
            address.setLatitude("wpMdq5qseXItuRkdANg8TFWjdG2ssh19KtjSqC8OLAA2QnlAxp");
            address.setLongitude("SWHj1NLXbEhYfjb5DKQu2ORpcLQpORKUh2S3qBBr9Xau6lIhvL");
            address.setVersionId(1);
            address.setZipcode("m4IlFe");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
