package tokoonlineanimepl.cartitem.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.cartitem.CartItemFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import tokoonlineanimepl.cartitem.core.model.CartItem;
import tokoonlineanimepl.cartitem.core.service.CartItemServiceImpl;
//add other required packages


public class CartItemResourceImpl extends CartItemResourceComponent{
	
	private CartItemServiceImpl cartitemServiceImpl = new CartItemServiceImpl();

	
    @Route(url="call/cartitem/save")
    public List<HashMap<String,Object>> saveCartItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		CartItem cartitem = createCartItem(vmjExchange);
		return cartitemServiceImpl.getAllCartItem();
	}

    public CartItem createCartItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CartItem result = cartitemServiceImpl.createCartItem(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
    public CartItem createCartItem(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CartItem result = cartitemServiceImpl.createCartItem(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/cartitem/update")
    public HashMap<String, Object> updateCartItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return cartitemServiceImpl.updateCartItem(requestBody);
		
	}

	
    @Route(url="call/cartitem/detail")
    public HashMap<String, Object> getCartItem(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id_cart_item");
		return cartitemServiceImpl.getCartItem(idStr);
	}

	
    @Route(url="call/cartitem/list")
    public List<HashMap<String,Object>> getAllCartItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return cartitemServiceImpl.getAllCartItem();
	}

	
    @Route(url="call/cartitem/delete")
    public List<HashMap<String,Object>> deleteCartItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return cartitemServiceImpl.deleteCartItem(requestBody);
	}


	
	public boolean setProduct(UUID id_produk, int quantity) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	
	public boolean getByKeranjang(UUID id_keranjang) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
