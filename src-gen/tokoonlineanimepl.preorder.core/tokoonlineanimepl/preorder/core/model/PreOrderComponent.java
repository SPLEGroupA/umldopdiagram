package tokoonlineanimepl.preorder.core.model;

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
@Table(name="preorder_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PreOrderComponent implements PreOrder{
	@Id
	protected UUID id_preorder; 
	protected String tanggal_rilis;
	protected String status;
	@ManyToOne(targetEntity=tokoonlineanimepl.produk.core.model.ProdukComponent.class)
	public Produk produk;
	@ManyToOne(targetEntity=tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaComponent.class)
	public AkunPengguna akunPengguna;
	protected String objectName = PreOrderComponent.class.getName();

	public PreOrderComponent() {

	} 

	public PreOrderComponent(
        UUID id_preorder, String tanggal_rilis, String status, ProdukImpl produk, AkunPenggunaImpl akunPengguna
    ) {
        this.id_preorder = id_preorder;
        this.tanggal_rilis = tanggal_rilis;
        this.status = status;
        this.produk = produk;
        this.akunPengguna = akunPengguna;
    }

	public UUID getId_preorder() {
		return this.id_preorder;
	}

	public void setId_preorder(UUID id_preorder) {
		this.id_preorder = id_preorder;
	}
	public String getTanggal_rilis() {
		return this.tanggal_rilis;
	}

	public void setTanggal_rilis(String tanggal_rilis) {
		this.tanggal_rilis = tanggal_rilis;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public abstract ProdukImpl getProduk();
	public abstract void setProduk(ProdukImpl produk);
	
	public abstract AkunPenggunaImpl getAkunPengguna();
	public abstract void setAkunPengguna(AkunPenggunaImpl akunPengguna);
	
 

	@Override
    public String toString() {
        return "{" +
            " id_preorder='" + getId_preorder() + "'" +
            " tanggal_rilis='" + getTanggal_rilis() + "'" +
            " status='" + getStatus() + "'" +
            " produk='" + getProduk() + "'" +
            " akunPengguna='" + getAkunPengguna() + "'" +
            "}";
    }
	
}
