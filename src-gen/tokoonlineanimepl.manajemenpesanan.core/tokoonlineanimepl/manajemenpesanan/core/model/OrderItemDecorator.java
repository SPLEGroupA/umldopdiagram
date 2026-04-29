package tokoonlineanimepl.manajemenpesanan.core.model;

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
		Random r = new Random();
		this. = Math.abs(r.nextInt());
	}

	public OrderItemDecorator (, OrderItemComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public OrderItemDecorator (OrderItemComponent record, String objectName) {
		Random r = new Random();
		this. = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getId_order_item() {
		return record.getId_order_item();
	}
	public void setId_order_item(int id_order_item) {
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

	public OrderItemImpl getByPesanan(int id_pesanan) {
		return record.getByPesanan(id_pesanan);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
