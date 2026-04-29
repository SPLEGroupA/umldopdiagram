package tokoonlineanimepl.manajemenpesanan.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="orderitem_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OrderItemComponent implements OrderItem{
	protected int quantity;
	protected int harga_satuan;
	@ManyToOne(targetEntity=tokoonlineanimepl.order.core.model.OrderComponent.class)
	public Order pesanan;
	@ManyToOne(targetEntity=tokoonlineanimepl.produk.core.model.ProdukComponent.class)
	public Produk produk;
	protected String objectName = OrderItemComponent.class.getName();

	public OrderItemComponent() {

	} 

	public OrderItemComponent(
        int id_order_item, int quantity, int harga_satuan, OrderImpl pesanan, ProdukImpl produk
    ) {
        this.id_order_item = id_order_item;
        this.quantity = quantity;
        this.harga_satuan = harga_satuan;
        this.pesanan = pesanan;
        this.produk = produk;
    }

	public int getId_order_item() {
		return this.id_order_item;
	}

	public void setId_order_item(int id_order_item) {
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
	public abstract OrderImpl getPesanan();
	public abstract void setPesanan(OrderImpl pesanan);
	
	public abstract ProdukImpl getProduk();
	public abstract void setProduk(ProdukImpl produk);
	
 
	public abstract OrderItemImpl getByPesanan(int id_pesanan);

	@Override
    public String toString() {
        return "{" +
            " id_order_item='" + getId_order_item() + "'" +
            " quantity='" + getQuantity() + "'" +
            " harga_satuan='" + getHarga_satuan() + "'" +
            " pesanan='" + getPesanan() + "'" +
            " produk='" + getProduk() + "'" +
            "}";
    }
	
}
