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
		Random r = new Random();
		this. = Math.abs(r.nextInt());
	}

	public OrderDecorator (, OrderComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public OrderDecorator (OrderComponent record, String objectName) {
		Random r = new Random();
		this. = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getId_pesanan() {
		return record.getId_pesanan();
	}
	public void setId_pesanan(int id_pesanan) {
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
