package tokoonlineanimepl.manajemenpesanan.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.manajemenpesanan.core.model.Order;

public abstract class OrderServiceDecorator extends OrderServiceComponent{
	protected OrderServiceComponent record;

    public OrderServiceDecorator(OrderServiceComponent record) {
        this.record = record;
    }

	public Order createOrder(Map<String, Object> requestBody){
		return record.createOrder(requestBody);
	}
	
    public Order createOrder(Map<String, Object> requestBody, UUID id){
		return record.createOrder(requestBody, id);
	}

	public HashMap<String, Object> getOrder(String idStr){
		return record.getOrder(idStr);
	}

	public List<HashMap<String,Object>> getAllOrder(){
		return record.getAllOrder();
	}

    public HashMap<String, Object> updateOrder(Map<String, Object> requestBody){
		return record.updateOrder(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Order> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteOrder(Map<String, Object> requestBody){
		return record.deleteOrder(requestBody);
	}

	public HashMap<String, Object> getOrderById(UUID id){	
        return record.getOrderById(id);
    }

	public OrderImpl getByUser(String email) {
		return record.getByUser(email);
	}
}
