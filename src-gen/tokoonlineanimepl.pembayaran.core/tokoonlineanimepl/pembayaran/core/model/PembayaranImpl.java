package tokoonlineanimepl.pembayaran.core.model;

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


@Entity(name="pembayaran_impl")
@Table(name="pembayaran_impl")
public class PembayaranImpl extends PembayaranComponent {

	public PembayaranImpl(UUID id_pembayaran, String metode, int jumlah, String status, int id_pesanan) {
		this.id_pembayaran = id_pembayaran;
		this.metode = metode;
		this.jumlah = jumlah;
		this.status = status;
		this.id_pesanan = id_pesanan;
	}

	public PembayaranImpl(String metode, int jumlah, String status) {
		this.id_pembayaran =  UUID.randomUUID();
		this.metode = metode;
		this.jumlah = jumlah;
		this.status = status;
		this.id_pesanan = id_pesanan;
	}

	public PembayaranImpl() { }

	public UUID getId_pembayaran() {
		return this.id_pembayaran;
	}

	public void setId_pembayaran(UUID id_pembayaran) {
		this.id_pembayaran = id_pembayaran;
	}
	public String getMetode() {
		return this.metode;
	}

	public void setMetode(String metode) {
		this.metode = metode;
	}
	public int getJumlah() {
		return this.jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public int getId_pesanan() {
		return this.id_pesanan;
	}

	public void setId_pesanan(int id_pesanan) {
		this.id_pesanan = id_pesanan;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> pembayaranMap = new HashMap<String,Object>();
		pembayaranMap.put("id_pembayaran",getId_pembayaran());
		pembayaranMap.put("metode",getMetode());
		pembayaranMap.put("jumlah",getJumlah());
		pembayaranMap.put("status",getStatus());
		pembayaranMap.put("id_pesanan",getId_pesanan());

        return pembayaranMap;
    }

}
