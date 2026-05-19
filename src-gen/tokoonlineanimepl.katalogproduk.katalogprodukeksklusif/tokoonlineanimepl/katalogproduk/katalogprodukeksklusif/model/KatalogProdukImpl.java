package tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.model;

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

@Entity(name="katalogproduk_katalogprodukeksklusif")
@Table(name="katalogproduk_katalogprodukeksklusif")
public class KatalogProdukImpl extends KatalogProdukDecorator {

	protected String label_eksklusif;
	public KatalogProdukImpl() {
        super();
		this.id_produk = UUID.randomUUID();
        this.objectName = KatalogProdukImpl.class.getName();
    }

	public KatalogProdukImpl(KatalogProdukComponent record, String label_eksklusif) {
		super(record, KatalogProdukImpl.class.getName());
		this.label_eksklusif = label_eksklusif;
		this.objectName = KatalogProdukImpl.class.getName();
	}

	public String getLabel_eksklusif() {
		return this.label_eksklusif;
	}

	public void setLabel_eksklusif(String label_eksklusif) {
		this.label_eksklusif = label_eksklusif;
	}

	protected String getKeteranganEksklusif() {
		if (this.label_eksklusif == null || this.label_eksklusif.trim().isEmpty()) {
			return "Produk Eksklusif";
		}
		return this.label_eksklusif;
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("id_produk", id_produk);
		map.put("label_eksklusif", getLabel_eksklusif());
		map.put("keterangan_eksklusif", getKeteranganEksklusif());

        return map;
    }

}
