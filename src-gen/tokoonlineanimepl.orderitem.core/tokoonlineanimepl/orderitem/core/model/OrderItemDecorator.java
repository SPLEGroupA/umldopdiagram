package tokoonlineanimepl.orderitem.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class OrderItemDecorator extends OrderItemComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected OrderItemComponent record;

	public OrderItemDecorator () {
		super();
		this.id_order_item =  UUID.randomUUID();
	}

	public OrderItemDecorator (UUID id_order_item, OrderItemComponent record) {
		this.id_order_item =  id_order_item;
		this.record = record;
	}
	
	public OrderItemDecorator (OrderItemComponent record, String objectName) {
		this.id_order_item =  UUID.randomUUID();
		this.record = record;
		this.objectName=objectName;
	}


	public UUID getId_order_item() {
		return record.getId_order_item();
	}
	public void setId_order_item(UUID id_order_item) {
		record.setId_order_item(id_order_item);
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
	public String getPesanan_ref() {
		return record.getPesanan_ref();
	}
	public void setPesanan_ref(String pesanan_ref) {
		record.setPesanan_ref(pesanan_ref);
	}
	public String getProduk_ref() {
		return record.getProduk_ref();
	}
	public void setProduk_ref(String produk_ref) {
		record.setProduk_ref(produk_ref);
	}

	public boolean getByPesanan(UUID id_pesanan) {
		return record.getByPesanan(id_pesanan);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
