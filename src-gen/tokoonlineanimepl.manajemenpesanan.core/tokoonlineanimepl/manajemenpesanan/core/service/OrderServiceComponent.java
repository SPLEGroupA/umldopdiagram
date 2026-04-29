package tokoonlineanimepl.manajemenpesanan.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.manajemenpesanan.core.model.Order;
//add other required packages

public abstract class OrderServiceComponent implements OrderService{
	protected RepositoryUtil<Order> Repository;

    public OrderServiceComponent(){
        this.Repository = new RepositoryUtil<Order>(tokoonlineanimepl.manajemenpesanan.core.model.OrderComponent.class);
    }	

    public abstract Order createOrder(Map<String, Object> requestBody);
	public abstract Order createOrder(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateOrder(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getOrder(String idStr);
    public abstract List<HashMap<String,Object>> getAllOrder();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Order> List);
    public abstract List<HashMap<String,Object>> deleteOrder(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getOrderById(int id);

	public abstract OrderImpl getByUser(String email);
}
