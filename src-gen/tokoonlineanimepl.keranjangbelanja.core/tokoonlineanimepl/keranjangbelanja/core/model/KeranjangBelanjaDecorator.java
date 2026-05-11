package tokoonlineanimepl.keranjangbelanja.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class KeranjangBelanjaDecorator extends KeranjangBelanjaComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected KeranjangBelanjaComponent record;

	public KeranjangBelanjaDecorator () {
		super();
		this.id_keranjang =  UUID.randomUUID();
	}

	public KeranjangBelanjaDecorator (UUID id_keranjang, KeranjangBelanjaComponent record) {
		this.id_keranjang =  id_keranjang;
		this.record = record;
	}
	
	public KeranjangBelanjaDecorator (KeranjangBelanjaComponent record, String objectName) {
		this.id_keranjang =  UUID.randomUUID();
		this.record = record;
		this.objectName=objectName;
	}


	public UUID getId_keranjang() {
		return record.getId_keranjang();
	}
	public void setId_keranjang(UUID id_keranjang) {
		record.setId_keranjang(id_keranjang);
	}

	public KeranjangBelanjaImpl getByUser(String email) {
		return record.getByUser(email);
	}

	public boolean addItem(UUID id_cart_item) {
		return record.addItem(id_cart_item);
	}

	public OrderImpl checkout() {
		return record.checkout();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
