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
		String id_cart_itemStr = (String) requestBody.get("id_cart_item");
		int id_cart_item = Integer.parseInt(id_cart_itemStr);
		String quantityStr = (String) requestBody.get("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String harga_satuanStr = (String) requestBody.get("harga_satuan");
		int harga_satuan = Integer.parseInt(harga_satuanStr);
		
		//to do: fix association attributes
		
		CartItem cartitem = CartItemFactory.createCartItem("tokoonlineanimepl.keranjangbelanja.core.model.CartItemImpl", id_cart_item, quantity, harga_satuan, keranjangBelanja, produk);
		Repository.saveObject(cartitem);
		return cartitem;
	}

	public CartItem createCartItem(Map<String, Object> requestBody, int id){
		String id_cart_itemStr = (String) requestBody.get("id_cart_item");
		int id_cart_item = Integer.parseInt(id_cart_itemStr);
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
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		CartItem cartitem = Repository.getObject(id);
		
		String id_cart_itemStr = (String) requestBody.get("id_cart_item");
		cartitem.setId_cart_item(Integer.parseInt(id_cart_itemStr));
		
		String quantityStr = (String) requestBody.get("quantity");
		cartitem.setQuantity(Integer.parseInt(quantityStr));
		
		String harga_satuanStr = (String) requestBody.get("harga_satuan");
		cartitem.setHarga_satuan(Integer.parseInt(harga_satuanStr));
		
		
		Repository.updateObject(cartitem);
		
		//to do: fix association attributes
		
		return cartitem.toHashMap();
		
	}

    public HashMap<String, Object> getCartItem(String idStr){
		int id = Integer.parseInt(idStr);
		CartItem cartitem = Repository.getObject(id);
		return cartitem.toHashMap();
	}

	public HashMap<String, Object> getCartItemById(int id){
		List<HashMap<String, Object>> cartitemList = getAllCartItem();
		for (HashMap<String, Object> cartitem : cartitemList){
			int record_id = ((Double) cartitem.get("")).intValue();
			if (record_id == id){
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
		String idStr = ((String) requestBody.get(""));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCartItem();
	}

	public boolean setProduct(int id_produk, int quantity) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public CartItemImpl getByKeranjang(int id_keranjang) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
