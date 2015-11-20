package shop.app.server.businessservice.retailcontext;
import org.springframework.stereotype.Component;
import com.athena.server.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.Override;
import java.util.List;
import shop.app.shared.retailcontext.FetchAllItems;

@Component
public class FetchAllItemServiceBzServiceImpl implements FetchAllItemServiceBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<FetchAllItems> executeQueryFetchAllItems() throws Exception {
        java.util.List<shop.app.shared.retailcontext.FetchAllItems> listDtoInterface = new java.util.ArrayList<shop.app.shared.retailcontext.FetchAllItems>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "BF88963F-0F5D-4C91-8B09-6F25FF3D6715");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("shop.app.shared.retailcontext.FetchAllItems", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
