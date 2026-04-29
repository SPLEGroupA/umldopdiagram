package tokoonlineanimepl.manajemenpesanan.core.resource;
import java.util.*;

import tokoonlineanimepl.manajemenpesanan.core.model.Order;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface OrderResource {
    List<HashMap<String,Object>> saveOrder(VMJExchange vmjExchange);
    HashMap<String, Object> updateOrder(VMJExchange vmjExchange);
    HashMap<String, Object> getOrder(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllOrder(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteOrder(VMJExchange vmjExchange);
}
