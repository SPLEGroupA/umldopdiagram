package tokoonlineanimepl.manajemenpesanan.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.manajemenpesanan.core.model.OrderItem;
//add other required packages

public abstract class OrderItemResourceComponent implements OrderItemResource{
	
	public OrderItemResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveOrderItem(VMJExchange vmjExchange);
    public abstract OrderItem createOrderItem(VMJExchange vmjExchange);
	public abstract OrderItem createOrderItem(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateOrderItem(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getOrderItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllOrderItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteOrderItem(VMJExchange vmjExchange);

	public abstract OrderItemImpl getByPesanan(int id_pesanan);
}
