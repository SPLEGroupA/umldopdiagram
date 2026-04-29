package tokoonlineanimepl.katalogproduk.reviewdanrating.model;

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

@Entity(name="katalogproduk_reviewdanrating")
@Table(name="katalogproduk_reviewdanrating")
public class ProdukImpl extends ProdukDecorator {

	protected int average_rating;
	public ProdukImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = ProdukImpl.class.getName();
    }

	public ProdukImpl(ProdukComponent record, int average_rating) {
		super(record, ProdukImpl.class.getName());
		this.average_rating = average_rating;
		this.objectName = ProdukImpl.class.getName();
	}

	public int getAverage_rating() {
		return this.average_rating;
	}

	public void setAverage_rating(int average_rating) {
		this.average_rating = average_rating;
	}

	protected boolean addReview(int rating) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("", );
		map.put("average_rating", getAverage_rating());

        return map;
    }

}
