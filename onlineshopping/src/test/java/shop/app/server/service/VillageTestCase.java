package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.VillageRepository;
import shop.app.shared.location.Village;
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
import shop.app.shared.location.Taluka;
import shop.app.server.repository.TalukaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase {

    @Autowired
    private VillageRepository<Village> villageRepository;

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
            country.setCapital("prIPDYctjJ85U2jKJPtwXwNdfLK1U2xx");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(6);
            country.setCountryCode1("7o2");
            country.setCountryCode2("8Gs");
            country.setCountryFlag("8RW82S2hGB4eZWEPbMgYraWoNFcswWsO47PlzC258HRA9Fii8E");
            country.setCountryName("51HVYyuraG8RIPBjBxBkB5z0InNxFaZrxhyRBnBV7Ey8h7Louy");
            country.setCurrencyCode("TJ3");
            country.setCurrencyName("oW10gCo4yrxtGxIOzPrWkWdDXNmJSLNmX1j1cVn8DxXzR8K1aT");
            country.setCurrencySymbol("X5GFu3OEeyg8tXK7C7ISIjHHpR2aiusK");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("HVboMRRCqnpg4bu0Sla56rtCR6zrMMwG");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("aZU7of4Hwkkg9vXQIeYuIDSGjBUgNZkguzkBheUFj2FhFM9IQN");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(9);
            state.setStateCode(0);
            state.setStateCodeChar2("v6HwLjr99CJvclNFur45NYwybN0iY5d5");
            state.setStateCodeChar3("IZ3Nszll4uC3S1Xr3ebktEs2PjonMiMm");
            state.setStateDescription("WVgGHObu854Xfw9fobC8WBGXEMtMdA6Zh6iV0yk7NG1rktQRDw");
            state.setStateFlag("R0w19Z5tLH7bv5o7qw3xrJZght5IGaltxKFeIMGUN6RxwGqEUe");
            state.setStateName("pbHYTUzvIvYsBduIUylwDAj6q6OuttmkYiPkHhPLHormY56mBH");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(1);
            region.setRegionCodeChar2("ynt6hzss9RhbQ2YBXUVXzCY501v4bTpr");
            region.setRegionDescription("LJV3cilXWUaqK5ZIMJ8C7WipZG5ioq8pHo9IIUqXBcDCbHgnjV");
            region.setRegionFlag("d0UvcT4MuwxsTZT7LUBjU9AGaX9FIMU7eFA2X1xEOQxD5O0TJ7");
            region.setRegionLatitude(8);
            region.setRegionLongitude(7);
            region.setRegionName("1y3YKJTrkZFtmtftZoYDMcVQfOblcR3bNHSuiQUDEK6veSARaN");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("LgTrzm4fYjcDl6CjImGKWb7So25CV4nP");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("AkY8BpPSPDrDpZ69m0jT4kkcVawhPQO6EE5atqU6X5Hxqj1pqT");
            district.setDistrictFlag("HqDxp9ggWoeGFZHp0eOn4YqFOyhcUYmcS3WuIuwanJopjTZRVi");
            district.setDistrictLatitude(8);
            district.setDistrictLongitude(7);
            district.setName("sdVnsqdqdYb3ulmVCzgBpv8qUYLXY24WxV3yv6STReYv0kbHg7");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("zfU3zQL876epcgG86XRkb1gj8NtGidcn");
            taluka.setTalukaDescription("xjoiHgEvYNtwKsAJ93deBrIkez2pJooXoNzJp0yDvHXp7ugyqw");
            taluka.setTalukaFlag("WEFY1N8TP4P3KnbgLhoNc66NT77Dq5Q55XiSKK1Bj1fIruYSnX");
            taluka.setTalukaLatitude(7);
            taluka.setTalukaLongitude(6);
            taluka.setTalukaName("JBGKkIqvLIOhqiLMkFTLxTX7LwTEYjOGAFYg2odECBFKMIA5hE");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("YZP50tRerkm4T1IJgHSh6n7bbrDedfFC");
            village.setVillageDescription("ieSxNM6AyqraVhoXkzacoJIaOCZsfqIjZdpvaKqQujC2MXSgdn");
            village.setVillageFlag("gghbqKTb5YuRSRhu5kYGus8qdEM61V25DGAy5uES5n7y0MQGqL");
            village.setVillageLatitude(0);
            village.setVillageLongtitude(11);
            village.setVillageName("vRN7n3RkatsWB4UQsVA2cqFUdOwPbJR0AQYQWwWx93pxkEpS3V");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.setEntityValidator(entityValidator);
            village.isValid();
            villageRepository.save(village);
            map.put("VillagePrimaryKey", village._getPrimarykey());
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

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            Village village = villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
            village.setVersionId(1);
            village.setVillageCode("qfpigPUze1aMXpCX87Fb6CotmL9WG7on");
            village.setVillageDescription("TvXYwVVbomLA1WTUPOemNRCbfCKyP2qcMIQs855peGhBy1P8W3");
            village.setVillageFlag("UNx7hSeL4s1p6qCjaDwJ1ebko32WYdfzRS5CsY08DGlC2wxp4m");
            village.setVillageLatitude(1);
            village.setVillageLongtitude(8);
            village.setVillageName("wHt5RQgKiakFED7OVhQwfTxIbwVYhiFnnaQ7SCuIrOIozrSWeF");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
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
            java.util.List<Village> listofregionId = villageRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
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
            java.util.List<Village> listofstateId = villageRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId((java.lang.String) map.get("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.delete((java.lang.String) map.get("VillagePrimaryKey")); /* Deleting refrenced data */
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
