package shop.app.server.businessservice.retailcontext;
import org.springframework.stereotype.Component;
import com.athena.server.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.Override;
import java.util.List;
import shop.app.shared.retailcontext.CartDetails;

@Component
public class CartDetailsBzServiceImpl implements CartDetailsBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<CartDetails> executeQueryCartDetails(String userId1) throws Exception {
        java.util.List<shop.app.shared.retailcontext.CartDetails> listDtoInterface = new java.util.ArrayList<shop.app.shared.retailcontext.CartDetails>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "F4377525-1918-47BC-A3AC-DADD9A98C492");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            atg.taglib.json.util.JSONObject jsonObjectUserId1 = new atg.taglib.json.util.JSONObject();
            jsonObjectUserId1.put("name", "userId");
            jsonObjectUserId1.put("value", userId1);
            jsonObjectUserId1.put("datatype", "VARCHAR");
            jsonObjectUserId1.put("index", 1);
            jsonArray.add(jsonObjectUserId1);
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("shop.app.shared.retailcontext.CartDetails", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
