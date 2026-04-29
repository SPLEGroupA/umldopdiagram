package tokoonlineanimepl.preorder.core.resource;
import java.util.*;

import tokoonlineanimepl.preorder.core.model.PreOrder;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface PreOrderResource {
    List<HashMap<String,Object>> savePreOrder(VMJExchange vmjExchange);
    HashMap<String, Object> updatePreOrder(VMJExchange vmjExchange);
    HashMap<String, Object> getPreOrder(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPreOrder(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePreOrder(VMJExchange vmjExchange);
}
