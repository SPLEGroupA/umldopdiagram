package tokoonlineanimepl.pembayaran.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PembayaranDecorator extends PembayaranComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PembayaranComponent record;

	public PembayaranDecorator () {
		super();
		this.id_pembayaran =  UUID.randomUUID();
	}

	public PembayaranDecorator (UUID id_pembayaran, PembayaranComponent record) {
		this.id_pembayaran =  id_pembayaran;
		this.record = record;
	}
	
	public PembayaranDecorator (PembayaranComponent record, String objectName) {
		this.id_pembayaran =  UUID.randomUUID();
		this.record = record;
		this.objectName=objectName;
	}


	public UUID getId_pembayaran() {
		return record.getId_pembayaran();
	}
	public void setId_pembayaran(UUID id_pembayaran) {
		record.setId_pembayaran(id_pembayaran);
	}
	public String getMetode() {
		return record.getMetode();
	}
	public void setMetode(String metode) {
		record.setMetode(metode);
	}
	public int getJumlah() {
		return record.getJumlah();
	}
	public void setJumlah(int jumlah) {
		record.setJumlah(jumlah);
	}
	public String getStatus() {
		return record.getStatus();
	}
	public void setStatus(String status) {
		record.setStatus(status);
	}
	public int getId_pesanan() {
		return record.getId_pesanan();
	}
	public void setId_pesanan(int id_pesanan) {
		record.setId_pesanan(id_pesanan);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
