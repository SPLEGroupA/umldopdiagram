package tokoonlineanimepl.keranjangbelanja.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="keranjangbelanja_impl")
@Table(name="keranjangbelanja_impl")
public class KeranjangBelanjaImpl extends KeranjangBelanjaComponent {

	public KeranjangBelanjaImpl(UUID id_keranjang, String akun_ref) {
		this.id_keranjang = id_keranjang;
		this.akun_ref = akun_ref;
	}

	public KeranjangBelanjaImpl(String akun_ref) {
		this.id_keranjang =  UUID.randomUUID();
		this.akun_ref = akun_ref;
	}

	public KeranjangBelanjaImpl() { }

	public UUID getId_keranjang() {
		return this.id_keranjang;
	}

	public void setId_keranjang(UUID id_keranjang) {
		this.id_keranjang = id_keranjang;
	}
	public String getAkun_ref() {
		return this.akun_ref;
	}

	public void setAkun_ref(String akun_ref) {
		this.akun_ref = akun_ref;
	}

	public boolean getByUser(String email) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public boolean addItem(UUID id_cart_item) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public boolean checkout() {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> keranjangbelanjaMap = new HashMap<String,Object>();
		keranjangbelanjaMap.put("id_keranjang",getId_keranjang());
		keranjangbelanjaMap.put("akun_ref",getAkun_ref());

        return keranjangbelanjaMap;
    }

}
