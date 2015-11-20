package shop.app.server.businessservice.defaultcontext.defaultdomain;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import shop.app.shared.retailcontext.CartDetails;

@Component
public class InputDTOTest {

    @Autowired
    private SessionDataMgtService sessionService;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    public CartDetails processTest(CartDetails cartDTO) throws SpartanIncorrectDataException, Exception, SpartanBusinessValidationFailedException, SpartanPersistenceException, SpartanDataNotFoundException {
        try {
        } catch (Exception e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException(e.getCause().getMessage());
        }
        return cartDTO;
    }
}
