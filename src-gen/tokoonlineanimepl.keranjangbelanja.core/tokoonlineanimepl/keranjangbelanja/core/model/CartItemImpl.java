package tokoonlineanimepl.keranjangbelanja.core.model;

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

	public CartItemImpl(int id_cart_item, int quantity, int harga_satuan, KeranjangBelanjaImpl keranjangBelanja, ProdukImpl produk) {
		this.id_cart_item = id_cart_item;
		this.quantity = quantity;
		this.harga_satuan = harga_satuan;
		this.keranjangBelanja = keranjangBelanja;
		this.produk = produk;
	}

	public CartItemImpl(int quantity, int harga_satuan, KeranjangBelanjaImpl keranjangBelanja, ProdukImpl produk) {
		Random r = new Random();
		this. = Math.abs(r.nextInt());
		this.id_cart_item = id_cart_item;
		this.quantity = quantity;
		this.harga_satuan = harga_satuan;
		this.keranjangBelanja = keranjangBelanja;
		this.produk = produk;
	}

	public CartItemImpl() { }

	public int getId_cart_item() {
		return this.id_cart_item;
	}

	public void setId_cart_item(int id_cart_item) {
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

	public boolean setProduct(int id_produk, int quantity) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public CartItemImpl getByKeranjang(int id_keranjang) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> cartitemMap = new HashMap<String,Object>();
		cartitemMap.put("id_cart_item",getId_cart_item());
		cartitemMap.put("quantity",getQuantity());
		cartitemMap.put("harga_satuan",getHarga_satuan());
		cartitemMap.put("keranjangBelanja",getKeranjangBelanja());
		cartitemMap.put("produk",getProduk());

        return cartitemMap;
    }

}
