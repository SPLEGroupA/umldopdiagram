package tokoonlineanimepl.manajemenpesanan.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.manajemenpesanan.core.model.OrderItem;
//add other required packages

public abstract class OrderItemServiceComponent implements OrderItemService{
	protected RepositoryUtil<OrderItem> Repository;

    public OrderItemServiceComponent(){
        this.Repository = new RepositoryUtil<OrderItem>(tokoonlineanimepl.manajemenpesanan.core.model.OrderItemComponent.class);
    }	

    public abstract OrderItem createOrderItem(Map<String, Object> requestBody);
	public abstract OrderItem createOrderItem(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateOrderItem(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getOrderItem(String idStr);
    public abstract List<HashMap<String,Object>> getAllOrderItem();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<OrderItem> List);
    public abstract List<HashMap<String,Object>> deleteOrderItem(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getOrderItemById(int id);

	public abstract OrderItemImpl getByPesanan(int id_pesanan);
}
