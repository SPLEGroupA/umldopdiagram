package tokoonlineanimepl.keranjangbelanja.core.service;
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
import tokoonlineanimepl.keranjangbelanja.CartItemFactory;
import tokoonlineanimepl.keranjangbelanja.core.model.CartItem;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class CartItemServiceImpl extends CartItemServiceComponent{

    public CartItem createCartItem(Map<String, Object> requestBody){
		String quantityStr = (String) requestBody.get("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String harga_satuanStr = (String) requestBody.get("harga_satuan");
		int harga_satuan = Integer.parseInt(harga_satuanStr);
		
		//to do: fix association attributes
		
		CartItem cartitem = CartItemFactory.createCartItem("tokoonlineanimepl.keranjangbelanja.core.model.CartItemImpl", quantity, harga_satuan, keranjangBelanja, produk);
		Repository.saveObject(cartitem);
		return cartitem;
	}

    public CartItem createCartItem(Map<String, Object> requestBody, UUID id){	
		UUID id_cart_item = id;
		String quantityStr = (String) requestBody.get("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String harga_satuanStr = (String) requestBody.get("harga_satuan");
		int harga_satuan = Integer.parseInt(harga_satuanStr);
		
		//to do: fix association attributes
		CartItem cartitem = CartItemFactory.createCartItem("tokoonlineanimepl.keranjangbelanja.core.model.CartItemImpl",id_cart_item, quantity, harga_satuan, keranjangBelanja, produk);
		Repository.saveObject(cartitem);
		return cartitem;
	}

    public HashMap<String, Object> updateCartItem(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_cart_item");
		UUID id = UUID.fromString(idStr);		
		CartItem cartitem = Repository.getObject(id);
		
		String quantityStr = (String) requestBody.get("quantity");
		cartitem.setQuantity(Integer.parseInt(quantityStr));
		
		String harga_satuanStr = (String) requestBody.get("harga_satuan");
		cartitem.setHarga_satuan(Integer.parseInt(harga_satuanStr));
		
		
		Repository.updateObject(cartitem);
		
		//to do: fix association attributes
		
		return cartitem.toHashMap();
		
	}

    public HashMap<String, Object> getCartItem(String idStr){
		UUID id = UUID.fromString(idStr);		
		CartItem cartitem = Repository.getObject(id);
		return cartitem.toHashMap();
	}

	public HashMap<String, Object> getCartItemById(UUID id){
		List<HashMap<String, Object>> cartitemList = getAllCartItem();
		for (HashMap<String, Object> cartitem : cartitemList){
			UUID record_id = UUID.fromString((String) cartitem.get("id_cart_item"));
			if (record_id.equals(id)){
				return cartitem;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllCartItem(){
		List<CartItem> List = Repository.getAllObject("cartitem_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<CartItem> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteCartItem(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id_cart_item"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllCartItem();
	}

	public boolean setProduct(UUID id_produk, int quantity) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public CartItemImpl getByKeranjang(UUID id_keranjang) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
