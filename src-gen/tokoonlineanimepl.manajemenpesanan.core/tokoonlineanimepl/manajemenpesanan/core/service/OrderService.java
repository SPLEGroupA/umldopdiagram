package tokoonlineanimepl.manajemenpesanan.core.service;
import java.util.*;

import tokoonlineanimepl.manajemenpesanan.core.model.Order;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface OrderService {
	Order createOrder(Map<String, Object> requestBody);
	HashMap<String, Object> getOrder(String idStr);
    HashMap<String, Object> updateOrder(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllOrder();
    List<HashMap<String,Object>> deleteOrder(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Order> List);
}
