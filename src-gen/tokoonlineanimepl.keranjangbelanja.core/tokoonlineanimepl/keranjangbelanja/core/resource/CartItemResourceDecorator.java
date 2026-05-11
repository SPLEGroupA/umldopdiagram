package tokoonlineanimepl.keranjangbelanja.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.keranjangbelanja.core.model.CartItem;

public abstract class CartItemResourceDecorator extends CartItemResourceComponent{
	protected CartItemResourceComponent record;

    public CartItemResourceDecorator(CartItemResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveCartItem(VMJExchange vmjExchange){
		return record.saveCartItem(vmjExchange);
	}

    public CartItem createCartItem(VMJExchange vmjExchange){
		return record.createCartItem(vmjExchange);
	}
	
	public CartItem createCartItem(VMJExchange vmjExchange, UUID id){
		return record.createCartItem(vmjExchange, id);
	}

    public HashMap<String, Object> updateCartItem(VMJExchange vmjExchange){
		return record.updateCartItem(vmjExchange);
	}

    public HashMap<String, Object> getCartItem(VMJExchange vmjExchange){
		return record.getCartItem(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllCartItem(VMJExchange vmjExchange){
		return record.getAllCartItem(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteCartItem(VMJExchange vmjExchange){
		return record.deleteCartItem(vmjExchange);
	}

	public boolean setProduct(UUID id_produk, int quantity) {
		return record.setProduct(id_produk, quantity);
	}

	public CartItemImpl getByKeranjang(UUID id_keranjang) {
		return record.getByKeranjang(id_keranjang);
	}
}
