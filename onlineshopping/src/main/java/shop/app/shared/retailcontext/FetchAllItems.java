package shop.app.shared.retailcontext;
import com.athena.server.bizService.DTOMapperInterface;

public class FetchAllItems implements DTOMapperInterface {

    private String brandName;

    private String productName;

    private String categoryName;

    private String itemId;

    private String itemName;

    private Double itemPrice;

    private Integer itemStock;

    private String itemIcon;

    private Integer versionId;

    private Integer activeStatus;

    public FetchAllItems(Object[] aryObject) {
        if (aryObject != null) {
            brandName = (java.lang.String) aryObject[0];
            productName = (java.lang.String) aryObject[1];
            categoryName = (java.lang.String) aryObject[2];
            itemId = (java.lang.String) aryObject[3];
            itemName = (java.lang.String) aryObject[4];
            itemPrice = (java.lang.Double) aryObject[5];
            itemStock = (java.lang.Integer) aryObject[6];
            itemIcon = (java.lang.String) aryObject[7];
            versionId = (java.lang.Integer) aryObject[8];
            activeStatus = (java.lang.Integer) aryObject[9];
        } else {
            brandName = null;
            productName = null;
            categoryName = null;
            itemId = null;
            itemName = null;
            itemPrice = null;
            itemStock = null;
            itemIcon = null;
            versionId = null;
            activeStatus = null;
        }
    }

    public String getBrandName() {
        return brandName;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public Integer getItemStock() {
        return itemStock;
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }
}
