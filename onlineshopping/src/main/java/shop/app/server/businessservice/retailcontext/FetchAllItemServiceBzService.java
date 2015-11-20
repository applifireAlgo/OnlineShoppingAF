package shop.app.server.businessservice.retailcontext;
import java.util.List;
import shop.app.shared.retailcontext.FetchAllItems;

public interface FetchAllItemServiceBzService {

    public List<FetchAllItems> executeQueryFetchAllItems() throws Exception;
}
