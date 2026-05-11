package tokoonlineanimepl.manajemenpesanan.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.manajemenpesanan.OrderItemFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import tokoonlineanimepl.manajemenpesanan.core.model.OrderItem;
import tokoonlineanimepl.manajemenpesanan.core.service.OrderItemServiceImpl;
//add other required packages


public class OrderItemResourceImpl extends OrderItemResourceComponent{
	
	private OrderItemServiceImpl orderitemServiceImpl = new OrderItemServiceImpl();

	
    @Route(url="call/manajemenpesanan/save")
    public List<HashMap<String,Object>> saveOrderItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		OrderItem orderitem = createOrderItem(vmjExchange);
		return orderitemServiceImpl.getAllOrderItem();
	}

    public OrderItem createOrderItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			OrderItem result = orderitemServiceImpl.createOrderItem(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
    public OrderItem createOrderItem(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			OrderItem result = orderitemServiceImpl.createOrderItem(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/manajemenpesanan/update")
    public HashMap<String, Object> updateOrderItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return orderitemServiceImpl.updateOrderItem(requestBody);
		
	}

	
    @Route(url="call/manajemenpesanan/detail")
    public HashMap<String, Object> getOrderItem(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id_order_item");
		return orderitemServiceImpl.getOrderItem(idStr);
	}

	
    @Route(url="call/manajemenpesanan/list")
    public List<HashMap<String,Object>> getAllOrderItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return orderitemServiceImpl.getAllOrderItem();
	}

	
    @Route(url="call/manajemenpesanan/delete")
    public List<HashMap<String,Object>> deleteOrderItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return orderitemServiceImpl.deleteOrderItem(requestBody);
	}


	
	public OrderItemImpl getByPesanan(UUID id_pesanan) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
