package tokoonlineanimepl.keranjangbelanja.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class CartItemDecorator extends CartItemComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected CartItemComponent record;

	public CartItemDecorator () {
		super();
		this.id_cart_item =  UUID.randomUUID();
	}

	public CartItemDecorator (UUID id_cart_item, CartItemComponent record) {
		this.id_cart_item =  id_cart_item;
		this.record = record;
	}
	
	public CartItemDecorator (CartItemComponent record, String objectName) {
		this.id_cart_item =  UUID.randomUUID();
		this.record = record;
		this.objectName=objectName;
	}


	public UUID getId_cart_item() {
		return record.getId_cart_item();
	}
	public void setId_cart_item(UUID id_cart_item) {
		record.setId_cart_item(id_cart_item);
	}
	public int getQuantity() {
		return record.getQuantity();
	}
	public void setQuantity(int quantity) {
		record.setQuantity(quantity);
	}
	public int getHarga_satuan() {
		return record.getHarga_satuan();
	}
	public void setHarga_satuan(int harga_satuan) {
		record.setHarga_satuan(harga_satuan);
	}

	public boolean setProduct(UUID id_produk, int quantity) {
		return record.setProduct(id_produk, quantity);
	}

	public CartItemImpl getByKeranjang(UUID id_keranjang) {
		return record.getByKeranjang(id_keranjang);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
