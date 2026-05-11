package tokoonlineanimepl.keranjangbelanja.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="keranjangbelanja_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KeranjangBelanjaComponent implements KeranjangBelanja{
	@Id
	protected UUID id_keranjang; 
	@ManyToOne(targetEntity=tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaComponent.class)
	public AkunPengguna akunPengguna;
	protected String objectName = KeranjangBelanjaComponent.class.getName();

	public KeranjangBelanjaComponent() {

	} 

	public KeranjangBelanjaComponent(
        UUID id_keranjang, AkunPenggunaImpl akunPengguna
    ) {
        this.id_keranjang = id_keranjang;
        this.akunPengguna = akunPengguna;
    }

	public UUID getId_keranjang() {
		return this.id_keranjang;
	}

	public void setId_keranjang(UUID id_keranjang) {
		this.id_keranjang = id_keranjang;
	}
	public abstract AkunPenggunaImpl getAkunPengguna();
	public abstract void setAkunPengguna(AkunPenggunaImpl akunPengguna);
	
 
	public abstract KeranjangBelanjaImpl getByUser(String email);

	public abstract boolean addItem(UUID id_cart_item);

	public abstract OrderImpl checkout();

	@Override
    public String toString() {
        return "{" +
            " id_keranjang='" + getId_keranjang() + "'" +
            " akunPengguna='" + getAkunPengguna() + "'" +
            "}";
    }
	
}
