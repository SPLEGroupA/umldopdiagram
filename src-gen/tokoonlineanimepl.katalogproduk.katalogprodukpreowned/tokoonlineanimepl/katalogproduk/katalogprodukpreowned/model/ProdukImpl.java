package tokoonlineanimepl.katalogproduk.katalogprodukpreowned.model;

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

@Entity(name="katalogproduk_katalogprodukpreowned")
@Table(name="katalogproduk_katalogprodukpreowned")
public class ProdukImpl extends ProdukDecorator {

	protected String kondisi;
	public ProdukImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = ProdukImpl.class.getName();
    }

	public ProdukImpl(ProdukComponent record, String kondisi) {
		super(record, ProdukImpl.class.getName());
		this.kondisi = kondisi;
		this.objectName = ProdukImpl.class.getName();
	}

	public String getKondisi() {
		return this.kondisi;
	}

	public void setKondisi(String kondisi) {
		this.kondisi = kondisi;
	}

	protected boolean checkPreOwned() {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("", );
		map.put("kondisi", getKondisi());

        return map;
    }

}
