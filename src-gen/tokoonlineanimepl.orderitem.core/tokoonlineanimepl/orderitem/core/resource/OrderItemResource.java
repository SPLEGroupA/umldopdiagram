package tokoonlineanimepl.orderitem.core.resource;
import java.util.*;

import tokoonlineanimepl.orderitem.core.model.OrderItem;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface OrderItemResource {
    List<HashMap<String,Object>> saveOrderItem(VMJExchange vmjExchange);
    HashMap<String, Object> updateOrderItem(VMJExchange vmjExchange);
    HashMap<String, Object> getOrderItem(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllOrderItem(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteOrderItem(VMJExchange vmjExchange);
}
