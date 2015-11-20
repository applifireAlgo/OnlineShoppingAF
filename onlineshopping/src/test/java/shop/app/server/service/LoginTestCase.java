package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.LoginRepository;
import shop.app.shared.authentication.Login;
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
import shop.app.shared.contacts.CoreContacts;
import shop.app.server.repository.CoreContactsRepository;
import shop.app.shared.contacts.Gender;
import shop.app.server.repository.GenderRepository;
import shop.app.shared.location.Language;
import shop.app.server.repository.LanguageRepository;
import shop.app.shared.location.Timezone;
import shop.app.server.repository.TimezoneRepository;
import shop.app.shared.contacts.Title;
import shop.app.server.repository.TitleRepository;
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
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(104);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("Vhkexj01eRzx0ACWLJfT7BMy02uC8WYhY6YuJtHwvGPTL2LreC");
            corecontacts.setFirstName("p16Pk8Sxr0i7Rs7lVW3sKZR2zlZhr2NYqViSaOfKup6MFUhuze");
            Gender gender = new Gender();
            gender.setGender("pHX5PaGaSNa1gRfRxRRgsn17MKvWuKrICYjCEy2pnbMnJ3mfCN");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("to");
            language.setAlpha3("K6O");
            language.setAlpha4("UOUY");
            language.setAlpha4parentid(9);
            language.setLanguage("3TFG2IfgacI02uZUY9thwYXKrzU9eeV1wo6ySWzTc28p76JzMu");
            language.setLanguageDescription("Q4U38TuCrOsPQG4anYLNtPZ6ldNTafx9KSQwj4Mz51a17QSFjW");
            language.setLanguageIcon("9C2qFy23aMbFAM7TbhWZQkxVaL6N3RYmK13Nrmzt6vR4FTZaNF");
            language.setLanguageType("XSObF6Koo45k8Zfi0ZFwyIHtajb5wd8n");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("4TCLljzqz3ZFXq1Ppf2KHsMyGJmzvXQihArMDv4WLIobaqgGZR");
            timezone.setCountry("Z57nX0nQ9M78rxaoRI3AtJLlih7yDMdxEJNlPHg3yBSISXn1Ni");
            timezone.setGmtLabel("zB1fCYYplkSCyXDl9tyCbUfWoV2C9NTAjzjpdP1lyEWGe3XCPt");
            timezone.setTimeZoneLabel("E1X93YXnfS0bHGP7hTc2ztf14sk5LR90ToNG7IjVeeC7YU5cxI");
            timezone.setUtcdifference(6);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("uwlIeto5yq3S1Pc7QC1jh5WbMzAxtzA1d3rUHmWndifVcRmxRB");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(72);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("vwi5gYjPIgX2jmIj8KagdsiAjilgsYl6SKyUsg15TVGqPIoTWk");
            corecontacts.setFirstName("jEmLPRjtb9B2lzUczzZkvgElN6HR65Wbhis2ZEWhsRpV3bt61X");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("vLx7ydjgzXRLTh8awZmH0qe5OdMdUNfKnn0OiOHcWLWNHtjmQL");
            corecontacts.setMiddleName("xAVho4HWCqOe47bvlUthgXq2CzXeKwV4rBQNEkDE1WlqUspGrX");
            corecontacts.setNativeFirstName("4iJInWdmXUgAOKjlMPPVGVtG2U2VxUe5zxDYPqDYkaz5oZVS2j");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("rm2cF4UfU4UhaXSIPjEa0zCC5WyCmucGJC3kuDgSYltijEizFs");
            corecontacts.setNativeMiddleName("h1hKgSpVNcIymRszppjUSUHcYBZp52JclRGLJdaPJPyX8LaxMJ");
            corecontacts.setNativeTitle("0Ukj5W1A4wmH1Fve2XQK97tfmN5LlvNmrgFbjwvTDBDlKwywKZ");
            corecontacts.setPhoneNumber("u78uIJxOWxCScglAJCq0");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("mbIJBIjQaMqtK5As3NVhZEdUSVQdXg4mODWjMuvQ8JgnsBpse0");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1622);
            user.setUserAccessCode(6);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("l9k91OSs9xeGntwdZb4gX9A7PaNNEzpg9am23kVOynwVS6Il2e");
            useraccessdomain.setDomainHelp("63muN5mMlRrBKe47XQatQi864abQASAhCrNLbNHPiXuT7o0qm2");
            useraccessdomain.setDomainIcon("umuBqQPvJqHvcNJQ4ViOfE6ItXKdsdd6fvoJrjzuod1SZIRR0X");
            useraccessdomain.setDomainName("8XiJb8JCmxz4AHOr4LLdM0VKY5dMWkpGjVWxxra54UWvu5bJKI");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("cgll7KvT78FHrNq6cfDvBX0qM0viyEbnzaW2UrrtBezgUCz6jx");
            useraccesslevel.setLevelHelp("OYuZxy6Wrp5lOAFntN6MqRKKadU65qCMq5fnXAP5GkXmrVP3CC");
            useraccesslevel.setLevelIcon("fAoeQEwFqGNkCv3VKCRGszI7USfoF3b2fzm1WK0REARcW2LzpB");
            useraccesslevel.setLevelName("Ofo4HSMOZQmOVPyIZpuMPS3TQa3VhoafCUsA0KDnvDhLDvSdBT");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("RsUPIWY9ruU8Wp5BU2n1xPIdX74ZDBWEheK0MqNripidDNzA4f");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(477);
            user.setUserAccessCode(8);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(7);
            login.setIsAuthenticated(true);
            login.setLoginId("Bs62Bibh1fKi3ysnhYoJOEFhq4FzjsLHSGeMdLQ3KwBuVKvu6Q");
            login.setServerAuthImage("1OoGdQ9LspRijcaEja9v8h67aGG2jgzu");
            login.setServerAuthText("ckaPt9AxgKgE6OIg");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(11);
            login.setLoginId("Be3MJe4NBMiB9V8IRohP9Ej7juAqVsLRRHuRmupqMPmLA2GSme");
            login.setServerAuthImage("mRdLwXw652fam1DPdjF0JgBn1pPk8gGG");
            login.setServerAuthText("FXTLpC83AOJmQs8y");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
