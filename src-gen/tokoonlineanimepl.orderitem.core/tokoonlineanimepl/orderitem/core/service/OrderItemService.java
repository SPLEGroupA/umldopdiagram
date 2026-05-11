package tokoonlineanimepl.orderitem.core.service;
import java.util.*;

import tokoonlineanimepl.orderitem.core.model.OrderItem;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface OrderItemService {
	OrderItem createOrderItem(Map<String, Object> requestBody);
	HashMap<String, Object> getOrderItem(String idStr);
    HashMap<String, Object> updateOrderItem(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllOrderItem();
    List<HashMap<String,Object>> deleteOrderItem(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<OrderItem> List);
}
