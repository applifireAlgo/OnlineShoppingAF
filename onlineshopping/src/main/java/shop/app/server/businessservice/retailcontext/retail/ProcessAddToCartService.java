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
public class ProcessAddToCartService {

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

    public void addToCart(Cart entity) throws SpartanIncorrectDataException, Exception, SpartanBusinessValidationFailedException, SpartanPersistenceException, SpartanDataNotFoundException {
        try {
            if (entity == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("invalid parameter");
            }
            shop.app.shared.retail.Cart cart_13 = cartRepository.save(entity);
            if (cart_13.getItemId() == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("invalid parameter");
            }
            shop.app.shared.retail.Item item_14 = itemRepository.findById(cart_13.getItemId());
            ruleEngineInterface.initialize("5210d851-645a-42fa-911d-ac9be2646753");
            ruleEngineInterface.add(cart_13);
            ruleEngineInterface.add(item_14);
            ruleEngineInterface.add(runtimeLogInfoHelper);
            ruleEngineInterface.add(entity);
            ruleEngineInterface.executeRule();
            cartRepository.update((shop.app.shared.retail.Cart) ruleEngineInterface.getResult("cart_13"));
        } catch (com.athena.framework.server.exception.biz.RuleInitException | com.athena.framework.server.exception.biz.RuleExecuteException | com.athena.framework.server.exception.biz.RuleWorkingMemoryException | com.athena.framework.server.exception.biz.RuleDataException e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3005");
        } catch (Exception e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException(e.getCause().getMessage());
        }
    }
}
