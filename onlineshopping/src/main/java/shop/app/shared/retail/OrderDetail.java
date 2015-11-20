package shop.app.shared.retail;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import javax.persistence.Embedded;
import shop.app.shared.EntityAudit;
import shop.app.shared.SystemInfo;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;

@Table(name = "ast_OrderDetail_TP")
@Entity
public class OrderDetail implements Serializable, CommonEntityInterface, Comparator<OrderDetail> {

    @Column(name = "price")
    @JsonProperty("price")
    @NotNull
    @Min(0)
    @Max(999999)
    private Double price;

    @Column(name = "qty")
    @JsonProperty("qty")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer qty;

    @Column(name = "subTotal")
    @JsonProperty("subTotal")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double subTotal;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "orderdetId")
    @JsonProperty("orderdetId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String orderdetId;

    @Column(name = "itemId")
    @JsonProperty("itemId")
    private String itemId;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private OrderMain orderMain;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double _price) {
        if (_price != null) {
            this.price = _price;
        }
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer _qty) {
        if (_qty != null) {
            this.qty = _qty;
        }
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double _subTotal) {
        if (_subTotal != null) {
            this.subTotal = _subTotal;
        }
    }

    public String getPrimaryKey() {
        return orderdetId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return orderdetId;
    }

    public String getOrderdetId() {
        return orderdetId;
    }

    public void setOrderdetId(String _orderdetId) {
        this.orderdetId = _orderdetId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String _itemId) {
        this.itemId = _itemId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    public OrderMain getOrderMain() {
        return orderMain;
    }

    public void setOrderMain(OrderMain _orderMain) {
        this.orderMain = _orderMain;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SpartanConstraintViolationException, SpartanIncorrectDataException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
        } else {
            throw new SpartanIncorrectDataException("Entity validator is not set");
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (orderdetId == null) {
            return super.hashCode();
        } else {
            return orderdetId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            shop.app.shared.retail.OrderDetail other = (shop.app.shared.retail.OrderDetail) obj;
            if (orderdetId == null) {
                return false;
            } else if (!orderdetId.equals(other.orderdetId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }

    @Transient
    @JsonIgnore
    private String fieldName;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String _fieldName) {
        this.fieldName = _fieldName;
    }

    @Override
    public int compare(OrderDetail object1, OrderDetail object2) {
        switch(((fieldName))) {
            case "orderdetId":
                return (object1.getOrderdetId().compareTo(object2.getOrderdetId()) == 0) ? 0 : ((object1.getOrderdetId().compareTo(object2.getOrderdetId()) > 0) ? 1 : -1);
            case "subTotal":
                return (object1.getSubTotal().compareTo(object2.getSubTotal()) == 0) ? 0 : ((object1.getSubTotal().compareTo(object2.getSubTotal()) > 0) ? 1 : -1);
        }
        return 0;
    }
}
