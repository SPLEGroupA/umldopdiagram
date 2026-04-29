package tokoonlineanimepl.katalogproduk.core.model;

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


@Entity(name="produk_impl")
@Table(name="produk_impl")
public class ProdukImpl extends ProdukComponent {

	public ProdukImpl(int id_produk, String nama, int harga, String kategori, String deskripsi, int stok, String gambar_url) {
		this.id_produk = id_produk;
		this.nama = nama;
		this.harga = harga;
		this.kategori = kategori;
		this.deskripsi = deskripsi;
		this.stok = stok;
		this.gambar_url = gambar_url;
	}

	public ProdukImpl(String nama, int harga, String kategori, String deskripsi, int stok, String gambar_url) {
		Random r = new Random();
		this. = Math.abs(r.nextInt());
		this.id_produk = id_produk;
		this.nama = nama;
		this.harga = harga;
		this.kategori = kategori;
		this.deskripsi = deskripsi;
		this.stok = stok;
		this.gambar_url = gambar_url;
	}

	public ProdukImpl() { }

	public int getId_produk() {
		return this.id_produk;
	}

	public void setId_produk(int id_produk) {
		this.id_produk = id_produk;
	}
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	public int getHarga() {
		return this.harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}
	public String getKategori() {
		return this.kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public String getDeskripsi() {
		return this.deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	public int getStok() {
		return this.stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}
	public String getGambar_url() {
		return this.gambar_url;
	}

	public void setGambar_url(String gambar_url) {
		this.gambar_url = gambar_url;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> produkMap = new HashMap<String,Object>();
		produkMap.put("id_produk",getId_produk());
		produkMap.put("nama",getNama());
		produkMap.put("harga",getHarga());
		produkMap.put("kategori",getKategori());
		produkMap.put("deskripsi",getDeskripsi());
		produkMap.put("stok",getStok());
		produkMap.put("gambar_url",getGambar_url());

        return produkMap;
    }

}
