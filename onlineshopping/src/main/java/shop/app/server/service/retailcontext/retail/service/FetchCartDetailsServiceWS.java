package shop.app.server.service.retailcontext.retail.service;
import com.athena.framework.server.bean.ResponseBean;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shop.app.server.businessservice.retailcontext.retail.FetchCartDetailsService;

@RestController
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping("/FetchCartDetailsServiceWS")
public class FetchCartDetailsServiceWS {

    @Autowired
    private FetchCartDetailsService fetchcartdetailsservice;

    @RequestMapping(value = "/fetchCartItems", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> fetchCartItems() throws Exception, SpartanBusinessValidationFailedException, SpartanDataNotFoundException, SpartanIncorrectDataException, SpartanPersistenceException {
        com.athena.framework.server.bean.ResponseBean responseBean = new com.athena.framework.server.bean.ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
        java.util.List<shop.app.shared.retailcontext.CartDetails> _ruleOutput = fetchcartdetailsservice.fetchCartItems();
        responseBean.add("success", true);
        responseBean.add("message", "Successfully executed ");
        responseBean.add("data", _ruleOutput);
        return new org.springframework.http.ResponseEntity<com.athena.framework.server.bean.ResponseBean>(responseBean, httpStatus);
    }
}
