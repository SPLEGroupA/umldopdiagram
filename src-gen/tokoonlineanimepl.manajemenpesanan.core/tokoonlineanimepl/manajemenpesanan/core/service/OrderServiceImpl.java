package tokoonlineanimepl.manajemenpesanan.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.manajemenpesanan.OrderFactory;
import tokoonlineanimepl.manajemenpesanan.core.model.Order;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class OrderServiceImpl extends OrderServiceComponent{

    public Order createOrder(Map<String, Object> requestBody){
		String status = (String) requestBody.get("status");
		String tanggal_pesan = (String) requestBody.get("tanggal_pesan");
		String total_hargaStr = (String) requestBody.get("total_harga");
		int total_harga = Integer.parseInt(total_hargaStr);
		
		//to do: fix association attributes
		
		Order order = OrderFactory.createOrder("tokoonlineanimepl.manajemenpesanan.core.model.OrderImpl", status, tanggal_pesan, total_harga, akunPengguna);
		Repository.saveObject(order);
		return order;
	}

    public Order createOrder(Map<String, Object> requestBody, UUID id){	
		UUID id_pesanan = id;
		String status = (String) requestBody.get("status");
		String tanggal_pesan = (String) requestBody.get("tanggal_pesan");
		String total_hargaStr = (String) requestBody.get("total_harga");
		int total_harga = Integer.parseInt(total_hargaStr);
		
		//to do: fix association attributes
		Order order = OrderFactory.createOrder("tokoonlineanimepl.manajemenpesanan.core.model.OrderImpl",id_pesanan, status, tanggal_pesan, total_harga, akunPengguna);
		Repository.saveObject(order);
		return order;
	}

    public HashMap<String, Object> updateOrder(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_pesanan");
		UUID id = UUID.fromString(idStr);		
		Order order = Repository.getObject(id);
		
		order.setStatus((String) requestBody.get("status"));
		order.setTanggal_pesan((String) requestBody.get("tanggal_pesan"));
		String total_hargaStr = (String) requestBody.get("total_harga");
		order.setTotal_harga(Integer.parseInt(total_hargaStr));
		
		
		Repository.updateObject(order);
		
		//to do: fix association attributes
		
		return order.toHashMap();
		
	}

    public HashMap<String, Object> getOrder(String idStr){
		UUID id = UUID.fromString(idStr);		
		Order order = Repository.getObject(id);
		return order.toHashMap();
	}

	public HashMap<String, Object> getOrderById(UUID id){
		List<HashMap<String, Object>> orderList = getAllOrder();
		for (HashMap<String, Object> order : orderList){
			UUID record_id = UUID.fromString((String) order.get("id_pesanan"));
			if (record_id.equals(id)){
				return order;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllOrder(){
		List<Order> List = Repository.getAllObject("order_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Order> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteOrder(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id_pesanan"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllOrder();
	}

	public OrderImpl getByUser(String email) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
