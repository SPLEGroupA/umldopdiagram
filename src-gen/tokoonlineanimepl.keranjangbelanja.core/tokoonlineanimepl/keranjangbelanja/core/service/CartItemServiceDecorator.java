package tokoonlineanimepl.keranjangbelanja.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.keranjangbelanja.core.model.CartItem;

public abstract class CartItemServiceDecorator extends CartItemServiceComponent{
	protected CartItemServiceComponent record;

    public CartItemServiceDecorator(CartItemServiceComponent record) {
        this.record = record;
    }

	public CartItem createCartItem(Map<String, Object> requestBody){
		return record.createCartItem(requestBody);
	}
	
    public CartItem createCartItem(Map<String, Object> requestBody, UUID id){
		return record.createCartItem(requestBody, id);
	}

	public HashMap<String, Object> getCartItem(String idStr){
		return record.getCartItem(idStr);
	}

	public List<HashMap<String,Object>> getAllCartItem(){
		return record.getAllCartItem();
	}

    public HashMap<String, Object> updateCartItem(Map<String, Object> requestBody){
		return record.updateCartItem(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<CartItem> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteCartItem(Map<String, Object> requestBody){
		return record.deleteCartItem(requestBody);
	}

	public HashMap<String, Object> getCartItemById(UUID id){	
        return record.getCartItemById(id);
    }

	public boolean setProduct(UUID id_produk, int quantity) {
		return record.setProduct(id_produk, quantity);
	}

	public CartItemImpl getByKeranjang(UUID id_keranjang) {
		return record.getByKeranjang(id_keranjang);
	}
}
