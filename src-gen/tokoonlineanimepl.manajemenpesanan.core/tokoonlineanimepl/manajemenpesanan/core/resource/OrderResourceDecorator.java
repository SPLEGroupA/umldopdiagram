package tokoonlineanimepl.manajemenpesanan.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.manajemenpesanan.core.model.Order;

public abstract class OrderResourceDecorator extends OrderResourceComponent{
	protected OrderResourceComponent record;

    public OrderResourceDecorator(OrderResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveOrder(VMJExchange vmjExchange){
		return record.saveOrder(vmjExchange);
	}

    public Order createOrder(VMJExchange vmjExchange){
		return record.createOrder(vmjExchange);
	}
	
	public Order createOrder(VMJExchange vmjExchange, int id){
		return record.createOrder(vmjExchange, id);
	}

    public HashMap<String, Object> updateOrder(VMJExchange vmjExchange){
		return record.updateOrder(vmjExchange);
	}

    public HashMap<String, Object> getOrder(VMJExchange vmjExchange){
		return record.getOrder(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllOrder(VMJExchange vmjExchange){
		return record.getAllOrder(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteOrder(VMJExchange vmjExchange){
		return record.deleteOrder(vmjExchange);
	}

	public OrderImpl getByUser(String email) {
		return record.getByUser(email);
	}
}
