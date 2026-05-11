package tokoonlineanimepl.orderitem.core.service;
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
import tokoonlineanimepl.orderitem.OrderItemFactory;
import tokoonlineanimepl.orderitem.core.model.OrderItem;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class OrderItemServiceImpl extends OrderItemServiceComponent{

    public OrderItem createOrderItem(Map<String, Object> requestBody){
		String quantityStr = (String) requestBody.get("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String harga_satuanStr = (String) requestBody.get("harga_satuan");
		int harga_satuan = Integer.parseInt(harga_satuanStr);
		String pesanan_ref = (String) requestBody.get("pesanan_ref");
		String produk_ref = (String) requestBody.get("produk_ref");
		
		//to do: fix association attributes
		
		OrderItem orderitem = OrderItemFactory.createOrderItem("tokoonlineanimepl.orderitem.core.model.OrderItemImpl", quantity, harga_satuan, pesanan_ref, produk_ref);
		Repository.saveObject(orderitem);
		return orderitem;
	}

    public OrderItem createOrderItem(Map<String, Object> requestBody, UUID id){	
		UUID id_order_item = id;
		String quantityStr = (String) requestBody.get("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String harga_satuanStr = (String) requestBody.get("harga_satuan");
		int harga_satuan = Integer.parseInt(harga_satuanStr);
		String pesanan_ref = (String) requestBody.get("pesanan_ref");
		String produk_ref = (String) requestBody.get("produk_ref");
		
		//to do: fix association attributes
		OrderItem orderitem = OrderItemFactory.createOrderItem("tokoonlineanimepl.orderitem.core.model.OrderItemImpl",id_order_item, quantity, harga_satuan, pesanan_ref, produk_ref);
		Repository.saveObject(orderitem);
		return orderitem;
	}

    public HashMap<String, Object> updateOrderItem(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_order_item");
		UUID id = UUID.fromString(idStr);		
		OrderItem orderitem = Repository.getObject(id);
		
		String quantityStr = (String) requestBody.get("quantity");
		orderitem.setQuantity(Integer.parseInt(quantityStr));
		
		String harga_satuanStr = (String) requestBody.get("harga_satuan");
		orderitem.setHarga_satuan(Integer.parseInt(harga_satuanStr));
		
		orderitem.setPesanan_ref((String) requestBody.get("pesanan_ref"));
		orderitem.setProduk_ref((String) requestBody.get("produk_ref"));
		
		Repository.updateObject(orderitem);
		
		//to do: fix association attributes
		
		return orderitem.toHashMap();
		
	}

    public HashMap<String, Object> getOrderItem(String idStr){
		UUID id = UUID.fromString(idStr);		
		OrderItem orderitem = Repository.getObject(id);
		return orderitem.toHashMap();
	}

	public HashMap<String, Object> getOrderItemById(UUID id){
		List<HashMap<String, Object>> orderitemList = getAllOrderItem();
		for (HashMap<String, Object> orderitem : orderitemList){
			UUID record_id = UUID.fromString((String) orderitem.get("id_order_item"));
			if (record_id.equals(id)){
				return orderitem;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllOrderItem(){
		List<OrderItem> List = Repository.getAllObject("orderitem_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<OrderItem> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteOrderItem(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id_order_item"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllOrderItem();
	}

	public boolean getByPesanan(UUID id_pesanan) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
