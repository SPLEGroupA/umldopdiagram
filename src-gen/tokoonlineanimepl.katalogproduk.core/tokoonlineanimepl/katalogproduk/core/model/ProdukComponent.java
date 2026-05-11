package tokoonlineanimepl.katalogproduk.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="produk_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProdukComponent implements Produk{
	@Id
	protected UUID id_produk; 
	protected String nama;
	protected int harga;
	protected String kategori;
	protected String deskripsi;
	protected int stok;
	protected String gambar_url;
	protected String objectName = ProdukComponent.class.getName();

	public ProdukComponent() {

	} 

	public ProdukComponent(
        UUID id_produk, String nama, int harga, String kategori, String deskripsi, int stok, String gambar_url
    ) {
        this.id_produk = id_produk;
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
        this.stok = stok;
        this.gambar_url = gambar_url;
    }

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
 

	@Override
    public String toString() {
        return "{" +
            " id_produk='" + getId_produk() + "'" +
            " nama='" + getNama() + "'" +
            " harga='" + getHarga() + "'" +
            " kategori='" + getKategori() + "'" +
            " deskripsi='" + getDeskripsi() + "'" +
            " stok='" + getStok() + "'" +
            " gambar_url='" + getGambar_url() + "'" +
            "}";
    }
	
}
