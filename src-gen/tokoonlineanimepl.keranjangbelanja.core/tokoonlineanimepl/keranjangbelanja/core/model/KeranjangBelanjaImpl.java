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

	public KeranjangBelanjaImpl(int id_keranjang, AkunPenggunaImpl akunPengguna) {
		this.id_keranjang = id_keranjang;
		this.akunPengguna = akunPengguna;
	}

	public KeranjangBelanjaImpl(AkunPenggunaImpl akunPengguna) {
		Random r = new Random();
		this. = Math.abs(r.nextInt());
		this.id_keranjang = id_keranjang;
		this.akunPengguna = akunPengguna;
	}

	public KeranjangBelanjaImpl() { }

	public int getId_keranjang() {
		return this.id_keranjang;
	}

	public void setId_keranjang(int id_keranjang) {
		this.id_keranjang = id_keranjang;
	}

	public KeranjangBelanjaImpl getByUser(String email) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public boolean addItem(int id_cart_item) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public OrderImpl checkout() {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> keranjangbelanjaMap = new HashMap<String,Object>();
		keranjangbelanjaMap.put("id_keranjang",getId_keranjang());
		keranjangbelanjaMap.put("akunPengguna",getAkunPengguna());

        return keranjangbelanjaMap;
    }

}
