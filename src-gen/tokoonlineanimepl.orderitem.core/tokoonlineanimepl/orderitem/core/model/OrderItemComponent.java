package tokoonlineanimepl.orderitem.core.model;

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
	@Id
	protected UUID id_order_item; 
	protected int quantity;
	protected int harga_satuan;
	protected String pesanan_ref;
	protected String produk_ref;
	protected String objectName = OrderItemComponent.class.getName();

	public OrderItemComponent() {

	} 

	public OrderItemComponent(
        UUID id_order_item, int quantity, int harga_satuan, String pesanan_ref, String produk_ref
    ) {
        this.id_order_item = id_order_item;
        this.quantity = quantity;
        this.harga_satuan = harga_satuan;
        this.pesanan_ref = pesanan_ref;
        this.produk_ref = produk_ref;
    }

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
 
	public abstract boolean getByPesanan(UUID id_pesanan);

	@Override
    public String toString() {
        return "{" +
            " id_order_item='" + getId_order_item() + "'" +
            " quantity='" + getQuantity() + "'" +
            " harga_satuan='" + getHarga_satuan() + "'" +
            " pesanan_ref='" + getPesanan_ref() + "'" +
            " produk_ref='" + getProduk_ref() + "'" +
            "}";
    }
	
}
