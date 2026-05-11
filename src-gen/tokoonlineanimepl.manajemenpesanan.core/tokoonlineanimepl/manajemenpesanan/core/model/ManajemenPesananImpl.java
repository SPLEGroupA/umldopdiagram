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


@Entity(name="manajemenpesanan_impl")
@Table(name="manajemenpesanan_impl")
public class ManajemenPesananImpl extends ManajemenPesananComponent {

	public ManajemenPesananImpl(UUID id_pesanan, String status, String tanggal_pesan, int total_harga, String akun_ref) {
		this.id_pesanan = id_pesanan;
		this.status = status;
		this.tanggal_pesan = tanggal_pesan;
		this.total_harga = total_harga;
		this.akun_ref = akun_ref;
	}

	public ManajemenPesananImpl(String status, String tanggal_pesan, int total_harga, String akun_ref) {
		this.id_pesanan =  UUID.randomUUID();
		this.status = status;
		this.tanggal_pesan = tanggal_pesan;
		this.total_harga = total_harga;
		this.akun_ref = akun_ref;
	}

	public ManajemenPesananImpl() { }

	public UUID getId_pesanan() {
		return this.id_pesanan;
	}

	public void setId_pesanan(UUID id_pesanan) {
		this.id_pesanan = id_pesanan;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getTanggal_pesan() {
		return this.tanggal_pesan;
	}

	public void setTanggal_pesan(String tanggal_pesan) {
		this.tanggal_pesan = tanggal_pesan;
	}
	public int getTotal_harga() {
		return this.total_harga;
	}

	public void setTotal_harga(int total_harga) {
		this.total_harga = total_harga;
	}
	public String getAkun_ref() {
		return this.akun_ref;
	}

	public void setAkun_ref(String akun_ref) {
		this.akun_ref = akun_ref;
	}

	public boolean getByUser(String email) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> manajemenpesananMap = new HashMap<String,Object>();
		manajemenpesananMap.put("id_pesanan",getId_pesanan());
		manajemenpesananMap.put("status",getStatus());
		manajemenpesananMap.put("tanggal_pesan",getTanggal_pesan());
		manajemenpesananMap.put("total_harga",getTotal_harga());
		manajemenpesananMap.put("akun_ref",getAkun_ref());

        return manajemenpesananMap;
    }

}
