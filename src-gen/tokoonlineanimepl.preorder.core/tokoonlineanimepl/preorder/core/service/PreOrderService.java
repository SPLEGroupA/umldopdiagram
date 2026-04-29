package tokoonlineanimepl.preorder.core.service;
import java.util.*;

import tokoonlineanimepl.preorder.core.model.PreOrder;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface PreOrderService {
	PreOrder createPreOrder(Map<String, Object> requestBody);
	HashMap<String, Object> getPreOrder(String idStr);
    HashMap<String, Object> updatePreOrder(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllPreOrder();
    List<HashMap<String,Object>> deletePreOrder(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<PreOrder> List);
}
