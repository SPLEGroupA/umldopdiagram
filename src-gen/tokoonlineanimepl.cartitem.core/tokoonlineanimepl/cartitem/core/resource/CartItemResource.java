package tokoonlineanimepl.cartitem.core.resource;
import java.util.*;

import tokoonlineanimepl.cartitem.core.model.CartItem;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface CartItemResource {
    List<HashMap<String,Object>> saveCartItem(VMJExchange vmjExchange);
    HashMap<String, Object> updateCartItem(VMJExchange vmjExchange);
    HashMap<String, Object> getCartItem(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllCartItem(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteCartItem(VMJExchange vmjExchange);
}
