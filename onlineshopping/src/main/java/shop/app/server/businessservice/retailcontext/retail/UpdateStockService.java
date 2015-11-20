package shop.app.server.businessservice.retailcontext.retail;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.ruleengine.server.bzservice.RuleEngineInterface;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.app.server.repository.CartRepository;
import shop.app.server.repository.ItemRepository;
import shop.app.shared.retail.Cart;
import shop.app.shared.retail.Item;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class UpdateStockService {

    @Autowired
    private SessionDataMgtService sessionService;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private ItemRepository<Item> itemRepository;

    @Autowired
    private CartRepository<Cart> cartRepository;

    @Autowired
    private RuleEngineInterface ruleEngineInterface;

    public void processStockUpdate() throws SpartanIncorrectDataException, Exception, SpartanBusinessValidationFailedException, SpartanPersistenceException, SpartanDataNotFoundException {
        try {
            java.lang.String userId = (java.lang.String) sessionService.getSessionData("userId");
            if (userId == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
            }
            if (userId == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("invalid parameter");
            }
            java.util.List<shop.app.shared.retail.Cart> cart_16 = cartRepository.findByUserId(userId);
            for (shop.app.shared.retail.Cart _cart_16 : cart_16) {
                if (_cart_16.getItemId() == null) {
                    throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("invalid parameter");
                }
                shop.app.shared.retail.Item item_17 = itemRepository.findById(_cart_16.getItemId());
                ruleEngineInterface.initialize("d4c022af-1765-43a4-a20a-9a9d1e79a882");
                ruleEngineInterface.add(_cart_16);
                ruleEngineInterface.add(item_17);
                ruleEngineInterface.add(runtimeLogInfoHelper);
                ruleEngineInterface.executeRule();
                itemRepository.update((shop.app.shared.retail.Item) ruleEngineInterface.getResult("item_17"));
                cartRepository.update((shop.app.shared.retail.Cart) ruleEngineInterface.getResult("cart_16"));
            }
        } catch (com.athena.framework.server.exception.biz.RuleInitException | com.athena.framework.server.exception.biz.RuleExecuteException | com.athena.framework.server.exception.biz.RuleWorkingMemoryException | com.athena.framework.server.exception.biz.RuleDataException e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3005");
        } catch (Exception e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException(e.getCause().getMessage());
        }
    }
}
