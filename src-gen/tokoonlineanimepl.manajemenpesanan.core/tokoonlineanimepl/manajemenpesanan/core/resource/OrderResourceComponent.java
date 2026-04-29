package tokoonlineanimepl.manajemenpesanan.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.manajemenpesanan.core.model.Order;
//add other required packages

public abstract class OrderResourceComponent implements OrderResource{
	
	public OrderResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveOrder(VMJExchange vmjExchange);
    public abstract Order createOrder(VMJExchange vmjExchange);
	public abstract Order createOrder(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateOrder(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getOrder(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllOrder(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteOrder(VMJExchange vmjExchange);

	public abstract OrderImpl getByUser(String email);
}
