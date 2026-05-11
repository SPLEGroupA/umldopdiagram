package tokoonlineanimepl.orderitem.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.orderitem.core.model.OrderItem;

public abstract class OrderItemServiceDecorator extends OrderItemServiceComponent{
	protected OrderItemServiceComponent record;

    public OrderItemServiceDecorator(OrderItemServiceComponent record) {
        this.record = record;
    }

	public OrderItem createOrderItem(Map<String, Object> requestBody){
		return record.createOrderItem(requestBody);
	}
	
    public OrderItem createOrderItem(Map<String, Object> requestBody, UUID id){
		return record.createOrderItem(requestBody, id);
	}

	public HashMap<String, Object> getOrderItem(String idStr){
		return record.getOrderItem(idStr);
	}

	public List<HashMap<String,Object>> getAllOrderItem(){
		return record.getAllOrderItem();
	}

    public HashMap<String, Object> updateOrderItem(Map<String, Object> requestBody){
		return record.updateOrderItem(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<OrderItem> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteOrderItem(Map<String, Object> requestBody){
		return record.deleteOrderItem(requestBody);
	}

	public HashMap<String, Object> getOrderItemById(UUID id){	
        return record.getOrderItemById(id);
    }

	public boolean getByPesanan(UUID id_pesanan) {
		return record.getByPesanan(id_pesanan);
	}
}
