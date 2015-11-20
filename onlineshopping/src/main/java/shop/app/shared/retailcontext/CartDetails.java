package shop.app.shared.retailcontext;
import com.athena.server.bizService.DTOMapperInterface;

public class CartDetails implements DTOMapperInterface {

    private String itemName;

    private Double itemPrice;

    private Integer cartQty;

    private Double subTotal;

    public CartDetails(Object[] aryObject) {
        if (aryObject != null) {
            itemName = (java.lang.String) aryObject[0];
            itemPrice = (java.lang.Double) aryObject[1];
            cartQty = (java.lang.Integer) aryObject[2];
            subTotal = (java.lang.Double) aryObject[3];
        } else {
            itemName = null;
            itemPrice = null;
            cartQty = null;
            subTotal = null;
        }
    }

    public String getItemName() {
        return itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public Integer getCartQty() {
        return cartQty;
    }

    public Double getSubTotal() {
        return subTotal;
    }
}
