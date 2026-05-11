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
public abstract class OrderDecorator extends OrderComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected OrderComponent record;

	public OrderDecorator () {
		super();
		this.id_pesanan =  UUID.randomUUID();
	}

	public OrderDecorator (UUID id_pesanan, OrderComponent record) {
		this.id_pesanan =  id_pesanan;
		this.record = record;
	}
	
	public OrderDecorator (OrderComponent record, String objectName) {
		this.id_pesanan =  UUID.randomUUID();
		this.record = record;
		this.objectName=objectName;
	}


	public UUID getId_pesanan() {
		return record.getId_pesanan();
	}
	public void setId_pesanan(UUID id_pesanan) {
		record.setId_pesanan(id_pesanan);
	}
	public String getStatus() {
		return record.getStatus();
	}
	public void setStatus(String status) {
		record.setStatus(status);
	}
	public String getTanggal_pesan() {
		return record.getTanggal_pesan();
	}
	public void setTanggal_pesan(String tanggal_pesan) {
		record.setTanggal_pesan(tanggal_pesan);
	}
	public int getTotal_harga() {
		return record.getTotal_harga();
	}
	public void setTotal_harga(int total_harga) {
		record.setTotal_harga(total_harga);
	}

	public OrderImpl getByUser(String email) {
		return record.getByUser(email);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
