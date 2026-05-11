package tokoonlineanimepl.cartitem.core.service;
import java.util.*;

import tokoonlineanimepl.cartitem.core.model.CartItem;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface CartItemService {
	CartItem createCartItem(Map<String, Object> requestBody);
	HashMap<String, Object> getCartItem(String idStr);
    HashMap<String, Object> updateCartItem(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllCartItem();
    List<HashMap<String,Object>> deleteCartItem(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<CartItem> List);
}
