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


@Entity(name="katalogproduk_impl")
@Table(name="katalogproduk_impl")
public class KatalogProdukImpl extends KatalogProdukComponent {

	public KatalogProdukImpl(UUID id_produk, String nama, int harga, String kategori, String deskripsi, int stok, String gambar_url) {
		this.id_produk = id_produk;
		this.nama = nama;
		this.harga = harga;
		this.kategori = kategori;
		this.deskripsi = deskripsi;
		this.stok = stok;
		this.gambar_url = gambar_url;
	}

	public KatalogProdukImpl(String nama, int harga, String kategori, String deskripsi, int stok, String gambar_url) {
		this.id_produk =  UUID.randomUUID();
		this.nama = nama;
		this.harga = harga;
		this.kategori = kategori;
		this.deskripsi = deskripsi;
		this.stok = stok;
		this.gambar_url = gambar_url;
	}

	public KatalogProdukImpl() { }

	public UUID getId_produk() {
		return this.id_produk;
	}

	public void setId_produk(UUID id_produk) {
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
        HashMap<String, Object> katalogprodukMap = new HashMap<String,Object>();
		katalogprodukMap.put("id_produk",getId_produk());
		katalogprodukMap.put("nama",getNama());
		katalogprodukMap.put("harga",getHarga());
		katalogprodukMap.put("kategori",getKategori());
		katalogprodukMap.put("deskripsi",getDeskripsi());
		katalogprodukMap.put("stok",getStok());
		katalogprodukMap.put("gambar_url",getGambar_url());

        return katalogprodukMap;
    }

}
