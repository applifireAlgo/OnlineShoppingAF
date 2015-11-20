package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.TalukaRepository;
import shop.app.shared.location.Taluka;
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
import shop.app.shared.location.Country;
import shop.app.server.repository.CountryRepository;
import shop.app.shared.location.District;
import shop.app.server.repository.DistrictRepository;
import shop.app.shared.location.Region;
import shop.app.server.repository.RegionRepository;
import shop.app.shared.location.State;
import shop.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TalukaTestCase {

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

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
            Country country = new Country();
            country.setCapital("uPTIoCpcA8SxG2jXPTOjY7NQ2bK06Mje");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(4);
            country.setCountryCode1("eNB");
            country.setCountryCode2("uTn");
            country.setCountryFlag("GgU3wpcLUdyt80lFzc7LkAHyxqHCLmN9LlSanJVku8Zc66pmfN");
            country.setCountryName("Ty4ESIN0PWCGrLWsJp2sHSVgVP8fdZSaogP91uXqTuD9lKpatE");
            country.setCurrencyCode("SYJ");
            country.setCurrencyName("I3Xu256s2liujXvr73xbSW9zWEACvbtCVzKUcC2E2YzZnhPzjW");
            country.setCurrencySymbol("ztL2ehFlHsyqgOcF2V355CeSh6oCGgZI");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("o5T2QZsba4BVCWuRBBk1yL77zHG5UXUT");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("D9PFQYFvFy6fliLFOQIJ2Arpf97HENbfTocsVcvUuzcHez7CLv");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(1);
            state.setStateCode(2);
            state.setStateCodeChar2("Zfykp18KyVTUcc7P1uXtMNlB09TZnq39");
            state.setStateCodeChar3("gJaHtRHqenIHQ3nUHrSDbPKo6wlwREwJ");
            state.setStateDescription("IHP4cPLm3UzHSW5KVL7Nc6Sr87GCpjXJN3RPic9yabxcxw3ua4");
            state.setStateFlag("0soE7V9qkVPWhYfPYiyOYBkClX9EYKaSa5NKhuuVnKhpip1wP7");
            state.setStateName("Y2b0M1xUfX2XekirfbMTanQNAFZMEmfjF6DZWVNDNJAkycE4QH");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(0);
            region.setRegionCodeChar2("ELzn5aIDvqpkQ4v35HQdyvcRzeGJKp8D");
            region.setRegionDescription("QUNPPCvygK3OKKan4IByfGXA5xbGFaojRcguhmkSTnQzaJgnfD");
            region.setRegionFlag("Zv5fu5Am5YCYPyCOPijFr0OCRvDUfjDOKlkk9tRNa3hQHx7WYn");
            region.setRegionLatitude(6);
            region.setRegionLongitude(4);
            region.setRegionName("zGGciiXrmyJ2tgpJ0wh9biG1LspFvvFll6khJOqkXX0szTnqb7");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("dwZQFXayV5qIOrhvBJ3LbIFP7O4hT4zY");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("zqvFlrwg6W5wKVknz0hG1GM6Z2y643HqyLgJLVs7tP9ekjvw1w");
            district.setDistrictFlag("z3s7aKA7NRQdzB6q3YqflIwVAUxEJ4Bn1Q25fT7DlHE7UOQxex");
            district.setDistrictLatitude(5);
            district.setDistrictLongitude(9);
            district.setName("N9oZDbz2QMch6nYGfxEgUVTz0Op7MX2rWHQWKJVq76lDlm3Y9v");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey());
            taluka.setTalukaCode("g3CnaigXVE7S07z7VD9CAzM313Q6okox");
            taluka.setTalukaDescription("pODvTiW7CyhtCcGg4zWaGwAHtr5S49PcqF8QXXnjODa0y44Lqc");
            taluka.setTalukaFlag("s7VmExzJXmvXrd8JdYg9BSclt6KyT3K0YnQBgtNa2yziu9SIBA");
            taluka.setTalukaLatitude(3);
            taluka.setTalukaLongitude(4);
            taluka.setTalukaName("zifWfa2ly9nlOj1se3QH7NPNWOexu1CKR5K8DMk2pFaAjAFIhx");
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            taluka.setEntityValidator(entityValidator);
            taluka.isValid();
            talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            Taluka taluka = talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
            taluka.setTalukaCode("GYX4pjA6HRejLtY4k1EytfQGqRcpE4Zk");
            taluka.setTalukaDescription("YEb1TcNK9uKJgWbxBAFMocB0P3buaQyLqEXjqVfqMDPtkP6HfE");
            taluka.setTalukaFlag("RU5ssrQb3Rfopl0xZ5zJNLQn61dYZCODAP1fqCtfBVQxtrS4nQ");
            taluka.setTalukaLatitude(2);
            taluka.setTalukaLongitude(8);
            taluka.setTalukaName("b8RUhfGRAkpBpWVyeQN5RmZ1uZOmimLbmvVkqG9kVxSyredANW");
            taluka.setVersionId(1);
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            talukaRepository.update(taluka);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Taluka> listofcountryId = talukaRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Taluka> listofdistrictId = talukaRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Taluka> listofregionId = talukaRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
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
            java.util.List<Taluka> listofstateId = talukaRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
