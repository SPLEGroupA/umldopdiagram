package tokoonlineanimepl.katalogproduk.reviewdanrating.model;

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

@Entity(name="katalogproduk_reviewdanrating")
@Table(name="katalogproduk_reviewdanrating")
public class KatalogProdukImpl extends KatalogProdukDecorator {

	protected int average_rating;
	public KatalogProdukImpl() {
        super();
		this.id_produk = UUID.randomUUID();
        this.objectName = KatalogProdukImpl.class.getName();
    }

	public KatalogProdukImpl(KatalogProdukComponent record, int average_rating) {
		super(record, KatalogProdukImpl.class.getName());
		this.average_rating = average_rating;
		this.objectName = KatalogProdukImpl.class.getName();
	}

	public int getAverage_rating() {
		return this.average_rating;
	}

	public void setAverage_rating(int average_rating) {
		this.average_rating = average_rating;
	}

	protected boolean addReview(UUID id_produk, int rating) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("id_produk", id_produk);
		map.put("average_rating", getAverage_rating());

        return map;
    }

}
