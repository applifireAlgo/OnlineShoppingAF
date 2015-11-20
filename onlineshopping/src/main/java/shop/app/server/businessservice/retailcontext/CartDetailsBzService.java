package shop.app.server.businessservice.retailcontext;
import java.util.List;
import shop.app.shared.retailcontext.CartDetails;

public interface CartDetailsBzService {

    public List<CartDetails> executeQueryCartDetails(String userId1) throws Exception;
}
