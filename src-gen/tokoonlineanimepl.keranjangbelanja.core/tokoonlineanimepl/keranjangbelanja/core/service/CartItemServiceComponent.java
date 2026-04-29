package tokoonlineanimepl.keranjangbelanja.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.keranjangbelanja.core.model.CartItem;
//add other required packages

public abstract class CartItemServiceComponent implements CartItemService{
	protected RepositoryUtil<CartItem> Repository;

    public CartItemServiceComponent(){
        this.Repository = new RepositoryUtil<CartItem>(tokoonlineanimepl.keranjangbelanja.core.model.CartItemComponent.class);
    }	

    public abstract CartItem createCartItem(Map<String, Object> requestBody);
	public abstract CartItem createCartItem(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateCartItem(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getCartItem(String idStr);
    public abstract List<HashMap<String,Object>> getAllCartItem();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<CartItem> List);
    public abstract List<HashMap<String,Object>> deleteCartItem(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getCartItemById(int id);

	public abstract boolean setProduct(int id_produk, int quantity);

	public abstract CartItemImpl getByKeranjang(int id_keranjang);
}
