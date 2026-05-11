package tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import tokoonlineanimepl.katalogproduk.core.model.ProdukDecorator;
import tokoonlineanimepl.katalogproduk.core.model.Produk;
import tokoonlineanimepl.katalogproduk.core.model.ProdukComponent;

@Entity(name="katalogproduk_katalogprodukeksklusif")
@Table(name="katalogproduk_katalogprodukeksklusif")
public class ProdukImpl extends ProdukDecorator {

	protected boolean is_eksklusif;
	public ProdukImpl() {
        super();
		this.id_produk = UUID.randomUUID();
        this.objectName = ProdukImpl.class.getName();
    }

	public ProdukImpl(ProdukComponent record, boolean is_eksklusif) {
		super(record, ProdukImpl.class.getName());
		this.is_eksklusif = is_eksklusif;
		this.objectName = ProdukImpl.class.getName();
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
