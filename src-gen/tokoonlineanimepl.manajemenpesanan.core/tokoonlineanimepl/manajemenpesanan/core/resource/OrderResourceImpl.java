package tokoonlineanimepl.manajemenpesanan.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.manajemenpesanan.OrderFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import tokoonlineanimepl.manajemenpesanan.core.model.Order;
import tokoonlineanimepl.manajemenpesanan.core.service.OrderServiceImpl;
//add other required packages


public class OrderResourceImpl extends OrderResourceComponent{
	
	private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

	
    @Route(url="call/manajemenpesanan/save")
    public List<HashMap<String,Object>> saveOrder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Order order = createOrder(vmjExchange);
		return orderServiceImpl.getAllOrder();
	}

    public Order createOrder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Order result = orderServiceImpl.createOrder(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
    public Order createOrder(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Order result = orderServiceImpl.createOrder(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/manajemenpesanan/update")
    public HashMap<String, Object> updateOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return orderServiceImpl.updateOrder(requestBody);
		
	}

	
    @Route(url="call/manajemenpesanan/detail")
    public HashMap<String, Object> getOrder(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id_pesanan");
		return orderServiceImpl.getOrder(idStr);
	}

	
    @Route(url="call/manajemenpesanan/list")
    public List<HashMap<String,Object>> getAllOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return orderServiceImpl.getAllOrder();
	}

	
    @Route(url="call/manajemenpesanan/delete")
    public List<HashMap<String,Object>> deleteOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return orderServiceImpl.deleteOrder(requestBody);
	}


	
	public OrderImpl getByUser(String email) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
