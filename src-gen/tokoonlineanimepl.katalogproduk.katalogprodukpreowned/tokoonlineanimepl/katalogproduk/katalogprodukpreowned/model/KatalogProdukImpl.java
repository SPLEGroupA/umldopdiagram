package tokoonlineanimepl.katalogproduk.katalogprodukpreowned.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import tokoonlineanimepl.katalogproduk.core.model.KatalogProdukDecorator;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProdukComponent;

@Entity(name="katalogproduk_katalogprodukpreowned")
@Table(name="katalogproduk_katalogprodukpreowned")
public class KatalogProdukImpl extends KatalogProdukDecorator {

	protected String kondisi;
	public KatalogProdukImpl() {
        super();
		this.id_produk = UUID.randomUUID();
        this.objectName = KatalogProdukImpl.class.getName();
    }

	public KatalogProdukImpl(KatalogProdukComponent record, String kondisi) {
		super(record, KatalogProdukImpl.class.getName());
		this.kondisi = kondisi;
		this.objectName = KatalogProdukImpl.class.getName();
	}

	public String getKondisi() {
		return this.kondisi;
	}

	public void setKondisi(String kondisi) {
		this.kondisi = kondisi;
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("id_produk", id_produk);
		map.put("kondisi", getKondisi());

        return map;
    }

}
