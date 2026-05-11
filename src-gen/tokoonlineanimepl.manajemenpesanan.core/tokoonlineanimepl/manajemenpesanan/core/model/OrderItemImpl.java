package tokoonlineanimepl.manajemenpesanan.core.model;

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

	public OrderItemImpl(UUID id_order_item, int quantity, int harga_satuan, OrderImpl pesanan, ProdukImpl produk) {
		this.id_order_item = id_order_item;
		this.quantity = quantity;
		this.harga_satuan = harga_satuan;
		this.pesanan = pesanan;
		this.produk = produk;
	}

	public OrderItemImpl(int quantity, int harga_satuan, OrderImpl pesanan, ProdukImpl produk) {
		this.id_order_item =  UUID.randomUUID();
		this.quantity = quantity;
		this.harga_satuan = harga_satuan;
		this.pesanan = pesanan;
		this.produk = produk;
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

	public OrderItemImpl getByPesanan(UUID id_pesanan) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> orderitemMap = new HashMap<String,Object>();
		orderitemMap.put("id_order_item",getId_order_item());
		orderitemMap.put("quantity",getQuantity());
		orderitemMap.put("harga_satuan",getHarga_satuan());
		orderitemMap.put("pesanan",getPesanan());
		orderitemMap.put("produk",getProduk());

        return orderitemMap;
    }

}
