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


@Entity(name="order_impl")
@Table(name="order_impl")
public class OrderImpl extends OrderComponent {

	public OrderImpl(UUID id_pesanan, String status, String tanggal_pesan, int total_harga, AkunPenggunaImpl akunPengguna) {
		this.id_pesanan = id_pesanan;
		this.status = status;
		this.tanggal_pesan = tanggal_pesan;
		this.total_harga = total_harga;
		this.akunPengguna = akunPengguna;
	}

	public OrderImpl(String status, String tanggal_pesan, int total_harga, AkunPenggunaImpl akunPengguna) {
		this.id_pesanan =  UUID.randomUUID();
		this.status = status;
		this.tanggal_pesan = tanggal_pesan;
		this.total_harga = total_harga;
		this.akunPengguna = akunPengguna;
	}

	public OrderImpl() { }

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

	public OrderImpl getByUser(String email) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> orderMap = new HashMap<String,Object>();
		orderMap.put("id_pesanan",getId_pesanan());
		orderMap.put("status",getStatus());
		orderMap.put("tanggal_pesan",getTanggal_pesan());
		orderMap.put("total_harga",getTotal_harga());
		orderMap.put("akunPengguna",getAkunPengguna());

        return orderMap;
    }

}
