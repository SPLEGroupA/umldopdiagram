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
public abstract class ManajemenPesananDecorator extends ManajemenPesananComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ManajemenPesananComponent record;

	public ManajemenPesananDecorator () {
		super();
		this.id_pesanan =  UUID.randomUUID();
	}

	public ManajemenPesananDecorator (UUID id_pesanan, ManajemenPesananComponent record) {
		this.id_pesanan =  id_pesanan;
		this.record = record;
	}
	
	public ManajemenPesananDecorator (ManajemenPesananComponent record, String objectName) {
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
	public String getAkun_ref() {
		return record.getAkun_ref();
	}
	public void setAkun_ref(String akun_ref) {
		record.setAkun_ref(akun_ref);
	}

	public boolean getByUser(String email) {
		return record.getByUser(email);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
