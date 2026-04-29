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
import tokoonlineanimepl.manajemenpesanan.OrderItemFactory;
import tokoonlineanimepl.manajemenpesanan.core.model.OrderItem;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class OrderItemServiceImpl extends OrderItemServiceComponent{

    public OrderItem createOrderItem(Map<String, Object> requestBody){
		String id_order_itemStr = (String) requestBody.get("id_order_item");
		int id_order_item = Integer.parseInt(id_order_itemStr);
		String quantityStr = (String) requestBody.get("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String harga_satuanStr = (String) requestBody.get("harga_satuan");
		int harga_satuan = Integer.parseInt(harga_satuanStr);
		
		//to do: fix association attributes
		
		OrderItem orderitem = OrderItemFactory.createOrderItem("tokoonlineanimepl.manajemenpesanan.core.model.OrderItemImpl", id_order_item, quantity, harga_satuan, pesanan, produk);
		Repository.saveObject(orderitem);
		return orderitem;
	}

	public OrderItem createOrderItem(Map<String, Object> requestBody, int id){
		String id_order_itemStr = (String) requestBody.get("id_order_item");
		int id_order_item = Integer.parseInt(id_order_itemStr);
		String quantityStr = (String) requestBody.get("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String harga_satuanStr = (String) requestBody.get("harga_satuan");
		int harga_satuan = Integer.parseInt(harga_satuanStr);
		
		//to do: fix association attributes
		OrderItem orderitem = OrderItemFactory.createOrderItem("tokoonlineanimepl.manajemenpesanan.core.model.OrderItemImpl",id_order_item, quantity, harga_satuan, pesanan, produk);
		Repository.saveObject(orderitem);
		return orderitem;
	}

    public HashMap<String, Object> updateOrderItem(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		OrderItem orderitem = Repository.getObject(id);
		
		String id_order_itemStr = (String) requestBody.get("id_order_item");
		orderitem.setId_order_item(Integer.parseInt(id_order_itemStr));
		
		String quantityStr = (String) requestBody.get("quantity");
		orderitem.setQuantity(Integer.parseInt(quantityStr));
		
		String harga_satuanStr = (String) requestBody.get("harga_satuan");
		orderitem.setHarga_satuan(Integer.parseInt(harga_satuanStr));
		
		
		Repository.updateObject(orderitem);
		
		//to do: fix association attributes
		
		return orderitem.toHashMap();
		
	}

    public HashMap<String, Object> getOrderItem(String idStr){
		int id = Integer.parseInt(idStr);
		OrderItem orderitem = Repository.getObject(id);
		return orderitem.toHashMap();
	}

	public HashMap<String, Object> getOrderItemById(int id){
		List<HashMap<String, Object>> orderitemList = getAllOrderItem();
		for (HashMap<String, Object> orderitem : orderitemList){
			int record_id = ((Double) orderitem.get("")).intValue();
			if (record_id == id){
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
		String idStr = ((String) requestBody.get(""));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllOrderItem();
	}

	public OrderItemImpl getByPesanan(int id_pesanan) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
