package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.CoreContactsRepository;
import shop.app.shared.contacts.CoreContacts;
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
import shop.app.shared.contacts.Gender;
import shop.app.server.repository.GenderRepository;
import shop.app.shared.location.Language;
import shop.app.server.repository.LanguageRepository;
import shop.app.shared.location.Timezone;
import shop.app.server.repository.TimezoneRepository;
import shop.app.shared.contacts.Title;
import shop.app.server.repository.TitleRepository;
import shop.app.shared.location.Address;
import shop.app.server.repository.AddressRepository;
import shop.app.shared.location.AddressType;
import shop.app.server.repository.AddressTypeRepository;
import shop.app.shared.location.City;
import shop.app.server.repository.CityRepository;
import shop.app.shared.location.Country;
import shop.app.server.repository.CountryRepository;
import shop.app.shared.location.State;
import shop.app.server.repository.StateRepository;
import shop.app.shared.contacts.CommunicationData;
import shop.app.shared.contacts.CommunicationGroup;
import shop.app.server.repository.CommunicationGroupRepository;
import shop.app.shared.contacts.CommunicationType;
import shop.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("yyqARUokSz8BFyReUahSCaSEstb8zKIWNEYO3m7c5h0JS3S8cb");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("21");
            language.setAlpha3("RYq");
            language.setAlpha4("VFsD");
            language.setAlpha4parentid(4);
            language.setLanguage("OyCGc7lNoPAGwvVHfqFhOqCOlQ0IngRfv1nXjQbkiRWgzM3bIf");
            language.setLanguageDescription("ABTdnqXpa2A9prJrsXxtD9oNzNzsx7RPXBzA5DwHI1OHKKBgb1");
            language.setLanguageIcon("a9X2zb6CWXfZVI7qg65cIHCAuITu9x55QYGmMA23jqXv6HAAGn");
            language.setLanguageType("QRAWnnIlYQ17sHIuP05eto2zTYAkjFuH");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("hXineF3jhaoQ9SLIs5pLyQZNPsMJYFlwx1kDIiHNs1L9Ibr8O8");
            timezone.setCountry("wKZ3lEl8kUW8JGpbQHaGeqJKuYhaHjvMCskzbiV3f1tkaJyDX9");
            timezone.setGmtLabel("2LLQDK7x5lePOMgR62o2af8lV5W34iFuURspaqAAmwt1cv0MzL");
            timezone.setTimeZoneLabel("xVVDNSddIfeSdvkT2Q3jfAxNWReOCmXQOpvjL6155Ide2JQ9yp");
            timezone.setUtcdifference(3);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("5uTE0KeXs0UPhs0ucc8FfC5OPtI5nuV9IjMkNd45AvAhZOeyK1");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(121);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("N1eyIh3TpKzpJQqiyUcAB1jNd8jQmueZrlTWtfxndEycgZJ1DL");
            corecontacts.setFirstName("h6m57pkmMIKolYi3tjHGZkzgzcQEmyueKdQBnaOppRZc7Rm79S");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("5iotRRx74CSekjFJOKAzWtadc0PnB8KsuvYimWgZbdzxn8yaPU");
            corecontacts.setMiddleName("3IVpvOT49USjEzWUZH2Qm2b7QcPeMRp62GBEsK7fAjxpOLAAbi");
            corecontacts.setNativeFirstName("Q3WVRYA9OSODgzOzvsKednWCyva46zyE28iLyIuMgvDFpvF6zl");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("fnb1zWAOlBEGBnbhxMB6ywxd497SOlhk63jBZKTuSVjmtgiFBl");
            corecontacts.setNativeMiddleName("3GvdJgmF55NcjKUt1BCK3pD8WSLzrwhXltnVCPOBZmBz1JSOGf");
            corecontacts.setNativeTitle("VKgCrX4EukQsuYQOn9RmNB4CsJClvcu03KkYQ1QAqCjHsQ3aFq");
            corecontacts.setPhoneNumber("sFrcMydvtW6P8yWtgb30");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("m2hq7EpkXqFFCrHFOM9bhzpKKJt2XrqHlEpab4oMiccslxpCP9");
            address.setAddress2("yIsdttgfC7Cd1F1z0gsceG9hXgDxEfCzArCModFiiGif4YuVt3");
            address.setAddress3("2uy3MFcmVCBEfjnIH3a2HAzrxZipDTytFUfC3A3qbfl6Y1AGk0");
            address.setAddressLabel("YNoTO6cybpS");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("e5KRocXg8XBhXVXXuev4zBHpwUqGKGm6m3iCbzj5xM7uPuR6r6");
            addresstype.setAddressTypeDesc("7Eqwt7umVh7xyZiZNRUstLpfvtrYPArwhylPgUuAPDT44OiVj5");
            addresstype.setAddressTypeIcon("2CDd8z9b0ydMAVP64t6mRoVZyE3HJ3z8QnxQl1aBvN4JQ10q2H");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("VRZBTw5fs0bhGXUE11AVFxKCJnZZ2IQA");
            city.setCityDescription("LhsL2eHbhpL1aHLAt3bqOZcLcmzw09sw9MA8B4UjcEjk88sKta");
            city.setCityFlag("64kyKF9jbyfb9IqmlLsgNgC7Mazft5Qik1SnwY51LsXVWGSUsW");
            city.setCityLatitude(9);
            city.setCityLongitude(5);
            city.setCityName("4p1IM8zC4ZxOornRRIxSULTAXMzKeoUq3CErAX542ipexnnIQo");
            Country country = new Country();
            country.setCapital("MDZJAIJFnfCOiKeRqOVkdDKVfCu9QFaY");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(4);
            country.setCountryCode1("MZt");
            country.setCountryCode2("up7");
            country.setCountryFlag("4HBwVr4rVnz0J5057l8d6tx8eIoQUkGJr2ta1IDXtxrQqDvjLC");
            country.setCountryName("QI7Q1Ee7CZz9M0yfEOZzL2uNp26iMDmybg2b0xLPdlVUV20mXO");
            country.setCurrencyCode("zWN");
            country.setCurrencyName("g7ZXrYTRYlse4cze94ykQJ0FGHMDH4QJ4h4XlNmwKKkhYgSd7S");
            country.setCurrencySymbol("vrNVOlJ7dD87ZDn3EGlfWZv9l1pvgfsN");
            country.setIsoNumeric(4);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("nQoxdCdRyJ7a7JH3u9SPtQVTUdaPbCyLOD7gsQCD1oHDPqa1Yy");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(2);
            state.setStateCode(2);
            state.setStateCodeChar2("a06SkMzxtenoJQths5Eyhl8Z0RFgaBV9");
            state.setStateCodeChar3("vnznAGY0EDt4gGmn3fkK2TVDE66ywwXc");
            state.setStateDescription("8cF3N2fjMxoIQupPAhb9UFu1rUvcPlfQqIUntaRh4ltSXWAvAT");
            state.setStateFlag("wBCu9DvohS1ZKs16NuikH9M6LJvwGPQKMrDz0AItXZayOcA69i");
            state.setStateName("mUGE2kxUQPvIU9psu41VdDcD5yH8EURalBHUPUZlblKDo4C06b");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("Kiy2WXmwRnQSDtl7TUxKQdqGthdJxGTk");
            city.setCityDescription("7YXDi9ZgxrLpg3xeP4PxSrZMwmiz7H9Cn0lyDBhMqURA4ECUja");
            city.setCityFlag("hoecpN1rpoJP2yRxYd4Rh3i7RDqqUcF0zgkGV5dVE6iMwBcEsM");
            city.setCityLatitude(6);
            city.setCityLongitude(3);
            city.setCityName("LZM0S9UewRrebJmForuyzNjl8onUWqKRgDUwXHSJ4WbLVPZxDv");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("WypMK48ckrSOc4mZV1PWxNlXeF325cd5IwZvjL3PJNekOjNmoY");
            address.setAddress2("f66glVlwWjubZxZ9xv032fsYaW2NmR5o85P5IetZt5SfEu75dO");
            address.setAddress3("HD3eliCqKgM68np3CXrrRZe3V9ULNCH8ytPc8YK2ORS6zR1HUR");
            address.setAddressLabel("zILp5lM7EyC");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("ahTPnmRZ7zvzU60GS6ADeVXvvUQGTLGI510qrQ3XQl3zTJ3Kvb");
            address.setLongitude("0daAQvg1KyMXfxALMrVvcP0oD0T7cDwo1YJokHvXGsUUYzCOV2");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("ut3fvS");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("EUJ");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("UGjhEsmfVCbTP59DlFLtFKSxvuQNGyMC9d7IzCY7eq3mlOvKOz");
            communicationgroup.setCommGroupName("w4YdEO04ErWKexUoE16cmSBZbDPtI0LDdgXyFGDlocORA5dwrY");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("cQkRSSglmy6BVnLx5r1cte0kaEdKT4cxk6uoTL695qA5YUYPAG");
            communicationtype.setCommTypeName("I8w6Ek1wXYslHOJAIFrJ6VvTZxyn07p3H6NPlUbFIwkQJJGy4M");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("ZkS");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(83);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("0BxoPrRsZhdadhRTMu04haLF3Rme2pLH1yxDAcsPlX1ZkU2J9X");
            corecontacts.setFirstName("6XjLnVXDhG07eNtJmlPYpcK2wl3sv0fMMu3nsvWlB1aOSoOcJ4");
            corecontacts.setLastName("5q8ns0ZAUfOwubQfKc40QQWVb047TIvYC3vUvi4RMn97zIrlyl");
            corecontacts.setMiddleName("29F3vFRIB8x0uRvjv7hZ09QNT8Akbv9hA4tQ6gBUHnmbiaC3pF");
            corecontacts.setNativeFirstName("MeuQLJA2Pf7exWv5OseYZ0ujC8GhwkL52Oq5GpxZoooVq4vA6K");
            corecontacts.setNativeLastName("8o0kpgflrclKhtNLx2W3sHhakmh2cWXb0XcSr8zfN0GMQTvw9s");
            corecontacts.setNativeMiddleName("e1bCasWzg4tPK6Qe0PwPUf16yE0blEi2gE2CnDqHxk89pXf98u");
            corecontacts.setNativeTitle("Qy22Obg1XjBu64DI3ovt6tNoKVtLK7390XC1y4baIAczVQB770");
            corecontacts.setPhoneNumber("uJGQd6cDK5Zxa3g2BTu9");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytimeZone() {
        try {
            java.util.List<CoreContacts> listoftimeZone = corecontactsRepository.findByTimeZone((java.lang.String) map.get("TimezonePrimaryKey"));
            if (listoftimeZone.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
