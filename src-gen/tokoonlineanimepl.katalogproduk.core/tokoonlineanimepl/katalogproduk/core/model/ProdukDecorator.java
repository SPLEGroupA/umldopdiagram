package tokoonlineanimepl.katalogproduk.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ProdukDecorator extends ProdukComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ProdukComponent record;

	public ProdukDecorator () {
		super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
	}

	public ProdukDecorator (, ProdukComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public ProdukDecorator (ProdukComponent record, String objectName) {
		Random r = new Random();
		this. = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getId_produk() {
		return record.getId_produk();
	}
	public void setId_produk(int id_produk) {
		record.setId_produk(id_produk);
	}
	public String getNama() {
		return record.getNama();
	}
	public void setNama(String nama) {
		record.setNama(nama);
	}
	public int getHarga() {
		return record.getHarga();
	}
	public void setHarga(int harga) {
		record.setHarga(harga);
	}
	public String getKategori() {
		return record.getKategori();
	}
	public void setKategori(String kategori) {
		record.setKategori(kategori);
	}
	public String getDeskripsi() {
		return record.getDeskripsi();
	}
	public void setDeskripsi(String deskripsi) {
		record.setDeskripsi(deskripsi);
	}
	public int getStok() {
		return record.getStok();
	}
	public void setStok(int stok) {
		record.setStok(stok);
	}
	public String getGambar_url() {
		return record.getGambar_url();
	}
	public void setGambar_url(String gambar_url) {
		record.setGambar_url(gambar_url);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
