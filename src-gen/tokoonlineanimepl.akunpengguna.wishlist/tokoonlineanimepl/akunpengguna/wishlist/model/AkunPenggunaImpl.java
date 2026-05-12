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

	protected String wishlist_items;
	public AkunPenggunaImpl() {
        super();
		this.id_akun = UUID.randomUUID();
        this.objectName = AkunPenggunaImpl.class.getName();
    }

	public AkunPenggunaImpl(AkunPenggunaComponent record, String wishlist_items) {
		super(record, AkunPenggunaImpl.class.getName());
		this.wishlist_items = wishlist_items;
		this.objectName = AkunPenggunaImpl.class.getName();
	}

	public String getWishlist_items() {
		return this.wishlist_items;
	}

	public void setWishlist_items(String wishlist_items) {
		this.wishlist_items = wishlist_items;
	}

	protected boolean addToWishlist(UUID id_akun, UUID id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	protected boolean removeFromWishlist(UUID id_akun, UUID id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("id_akun", id_akun);
		map.put("wishlist_items", getWishlist_items());

        return map;
    }

}
