package shop.app.server.businessservice.retailcontext.retail;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.app.server.businessservice.retailcontext.FetchAllItemServiceBzService;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import shop.app.shared.retailcontext.FetchAllItems;

@Component
public class FetchItemList {

    @Autowired
    private SessionDataMgtService sessionService;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private FetchAllItemServiceBzService fetchAllItemServiceBzService;

    public List<FetchAllItems> itemList() throws SpartanIncorrectDataException, Exception, SpartanBusinessValidationFailedException, SpartanPersistenceException, SpartanDataNotFoundException {
        java.util.List<shop.app.shared.retailcontext.FetchAllItems> fetchallitems_0 = null;
        try {
            fetchallitems_0 = fetchAllItemServiceBzService.executeQueryFetchAllItems();
            return fetchallitems_0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException(e.getCause().getMessage());
        }
    }
}
