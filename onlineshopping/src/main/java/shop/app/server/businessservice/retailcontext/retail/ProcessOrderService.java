package shop.app.server.businessservice.retailcontext.retail;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.ruleengine.server.bzservice.RuleEngineInterface;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.app.server.repository.CartRepository;
import shop.app.server.repository.OrderMainRepository;
import shop.app.shared.retail.Cart;
import shop.app.shared.retail.OrderMain;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class ProcessOrderService {

    @Autowired
    private SessionDataMgtService sessionService;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private UpdateStockService updateStockService;

    @Autowired
    private CartRepository<Cart> cartRepository;

    @Autowired
    private RuleEngineInterface ruleEngineInterface;

    @Autowired
    private OrderMainRepository<OrderMain> orderMainRepository;

    public void processOrder() throws SpartanIncorrectDataException, Exception, SpartanBusinessValidationFailedException, SpartanPersistenceException, SpartanDataNotFoundException {
        try {
            java.lang.String userId = (java.lang.String) sessionService.getSessionData("userId");
            if (userId == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
            }
            if (userId == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("invalid parameter");
            }
            java.util.List<shop.app.shared.retail.Cart> cart_0 = cartRepository.findByUserId(userId);
            shop.app.shared.retailcontext.acl.OrderACL orderacl_1 = new shop.app.shared.retailcontext.acl.OrderACL(cart_0);
            if (orderacl_1.getOrder() == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("invalid parameter");
            }
            shop.app.shared.retail.OrderMain ordermain_2 = orderMainRepository.save(orderacl_1.getOrder());
            updateStockService.processStockUpdate();
            ruleEngineInterface.initialize("b8d477e9-b696-4736-b0f6-2c668284f54a");
            ruleEngineInterface.add(cart_0);
            ruleEngineInterface.add(orderacl_1);
            ruleEngineInterface.add(ordermain_2);
            ruleEngineInterface.add(runtimeLogInfoHelper);
            ruleEngineInterface.executeRule();
            orderMainRepository.update((shop.app.shared.retail.OrderMain) ruleEngineInterface.getResult("ordermain_2"));
        } catch (com.athena.framework.server.exception.biz.RuleInitException | com.athena.framework.server.exception.biz.RuleExecuteException | com.athena.framework.server.exception.biz.RuleWorkingMemoryException | com.athena.framework.server.exception.biz.RuleDataException e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3005");
        } catch (Exception e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException(e.getCause().getMessage());
        }
    }
}
