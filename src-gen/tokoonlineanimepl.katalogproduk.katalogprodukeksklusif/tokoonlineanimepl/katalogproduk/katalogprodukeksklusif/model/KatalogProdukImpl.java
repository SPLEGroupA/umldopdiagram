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

	protected boolean is_eksklusif;
	public KatalogProdukImpl() {
        super();
		this.id_produk = UUID.randomUUID();
        this.objectName = KatalogProdukImpl.class.getName();
    }

	public KatalogProdukImpl(KatalogProdukComponent record, boolean is_eksklusif) {
		super(record, KatalogProdukImpl.class.getName());
		this.is_eksklusif = is_eksklusif;
		this.objectName = KatalogProdukImpl.class.getName();
	}

	public boolean getIs_eksklusif() {
		return this.is_eksklusif;
	}

	public void setIs_eksklusif(boolean is_eksklusif) {
		this.is_eksklusif = is_eksklusif;
	}

	protected boolean checkEksklusif(UUID id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("id_produk", id_produk);
		map.put("is_eksklusif", getIs_eksklusif());

        return map;
    }

}
