package tokoonlineanimepl.akunpengguna.wishlist.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaDecorator;
import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;
import tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaComponent;

@Entity(name="akunpengguna_wishlist")
@Table(name="akunpengguna_wishlist")
public class AkunPenggunaImpl extends AkunPenggunaDecorator {

	public AkunPenggunaImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = AkunPenggunaImpl.class.getName();
    }

	public AkunPenggunaImpl(AkunPenggunaComponent record) {
		super(record, AkunPenggunaImpl.class.getName());
		this.objectName = AkunPenggunaImpl.class.getName();
	}


	protected boolean addToWishlist(int id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	protected boolean removeFromWishlist(int id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("", );

        return map;
    }

}
