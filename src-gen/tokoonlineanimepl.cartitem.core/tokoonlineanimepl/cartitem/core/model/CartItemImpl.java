package tokoonlineanimepl.cartitem.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="cartitem_impl")
@Table(name="cartitem_impl")
public class CartItemImpl extends CartItemComponent {

	public CartItemImpl(UUID id_cart_item, int quantity, int harga_satuan, String keranjang_ref, String produk_ref) {
		this.id_cart_item = id_cart_item;
		this.quantity = quantity;
		this.harga_satuan = harga_satuan;
		this.keranjang_ref = keranjang_ref;
		this.produk_ref = produk_ref;
	}

	public CartItemImpl(int quantity, int harga_satuan, String keranjang_ref, String produk_ref) {
		this.id_cart_item =  UUID.randomUUID();
		this.quantity = quantity;
		this.harga_satuan = harga_satuan;
		this.keranjang_ref = keranjang_ref;
		this.produk_ref = produk_ref;
	}

	public CartItemImpl() { }

	public UUID getId_cart_item() {
		return this.id_cart_item;
	}

	public void setId_cart_item(UUID id_cart_item) {
		this.id_cart_item = id_cart_item;
	}
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getHarga_satuan() {
		return this.harga_satuan;
	}

	public void setHarga_satuan(int harga_satuan) {
		this.harga_satuan = harga_satuan;
	}
	public String getKeranjang_ref() {
		return this.keranjang_ref;
	}

	public void setKeranjang_ref(String keranjang_ref) {
		this.keranjang_ref = keranjang_ref;
	}
	public String getProduk_ref() {
		return this.produk_ref;
	}

	public void setProduk_ref(String produk_ref) {
		this.produk_ref = produk_ref;
	}

	public boolean setProduct(UUID id_produk, int quantity) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public boolean getByKeranjang(UUID id_keranjang) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> cartitemMap = new HashMap<String,Object>();
		cartitemMap.put("id_cart_item",getId_cart_item());
		cartitemMap.put("quantity",getQuantity());
		cartitemMap.put("harga_satuan",getHarga_satuan());
		cartitemMap.put("keranjang_ref",getKeranjang_ref());
		cartitemMap.put("produk_ref",getProduk_ref());

        return cartitemMap;
    }

}
