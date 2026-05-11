package tokoonlineanimepl.keranjangbelanja.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.keranjangbelanja.core.model.CartItem;
//add other required packages

public abstract class CartItemResourceComponent implements CartItemResource{
	
	public CartItemResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveCartItem(VMJExchange vmjExchange);
    public abstract CartItem createCartItem(VMJExchange vmjExchange);
	public abstract CartItem createCartItem(VMJExchange vmjExchange, UUID id);
	public abstract HashMap<String, Object> updateCartItem(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getCartItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllCartItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteCartItem(VMJExchange vmjExchange);

	public abstract boolean setProduct(UUID id_produk, int quantity);

	public abstract CartItemImpl getByKeranjang(UUID id_keranjang);
}
