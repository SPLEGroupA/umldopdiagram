package tokoonlineanimepl.orderitem.core.model;

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


@Entity(name="orderitem_impl")
@Table(name="orderitem_impl")
public class OrderItemImpl extends OrderItemComponent {

	public OrderItemImpl(UUID id_order_item, int quantity, int harga_satuan, String pesanan_ref, String produk_ref) {
		this.id_order_item = id_order_item;
		this.quantity = quantity;
		this.harga_satuan = harga_satuan;
		this.pesanan_ref = pesanan_ref;
		this.produk_ref = produk_ref;
	}

	public OrderItemImpl(int quantity, int harga_satuan, String pesanan_ref, String produk_ref) {
		this.id_order_item =  UUID.randomUUID();
		this.quantity = quantity;
		this.harga_satuan = harga_satuan;
		this.pesanan_ref = pesanan_ref;
		this.produk_ref = produk_ref;
	}

	public OrderItemImpl() { }

	public UUID getId_order_item() {
		return this.id_order_item;
	}

	public void setId_order_item(UUID id_order_item) {
		this.id_order_item = id_order_item;
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
	public String getPesanan_ref() {
		return this.pesanan_ref;
	}

	public void setPesanan_ref(String pesanan_ref) {
		this.pesanan_ref = pesanan_ref;
	}
	public String getProduk_ref() {
		return this.produk_ref;
	}

	public void setProduk_ref(String produk_ref) {
		this.produk_ref = produk_ref;
	}

	public boolean getByPesanan(UUID id_pesanan) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> orderitemMap = new HashMap<String,Object>();
		orderitemMap.put("id_order_item",getId_order_item());
		orderitemMap.put("quantity",getQuantity());
		orderitemMap.put("harga_satuan",getHarga_satuan());
		orderitemMap.put("pesanan_ref",getPesanan_ref());
		orderitemMap.put("produk_ref",getProduk_ref());

        return orderitemMap;
    }

}
