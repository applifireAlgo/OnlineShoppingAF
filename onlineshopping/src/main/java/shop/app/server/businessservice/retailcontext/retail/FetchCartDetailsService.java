package shop.app.server.businessservice.retailcontext.retail;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.app.server.repository.CartRepository;
import shop.app.shared.retail.Cart;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import shop.app.server.businessservice.retailcontext.CartDetailsBzService;
import shop.app.shared.retailcontext.CartDetails;

@Component
public class FetchCartDetailsService {

    @Autowired
    private SessionDataMgtService sessionService;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private CartRepository<Cart> cartRepository;

    @Autowired
    private CartDetailsBzService cartDetailsBzService;

    public List<CartDetails> fetchCartItems() throws SpartanIncorrectDataException, Exception, SpartanBusinessValidationFailedException, SpartanPersistenceException, SpartanDataNotFoundException {
        java.util.List<shop.app.shared.retailcontext.CartDetails> cartdetails_9 = null;
        try {
            java.lang.String userId = (java.lang.String) sessionService.getSessionData("userId");
            if (userId == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
            }
            cartdetails_9 = cartDetailsBzService.executeQueryCartDetails(userId);
            return cartdetails_9;
        } catch (Exception e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException(e.getCause().getMessage());
        }
    }
}
