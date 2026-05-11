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
	protected String produk_ref;
	protected String akun_ref;
	protected String objectName = PreOrderComponent.class.getName();

	public PreOrderComponent() {

	} 

	public PreOrderComponent(
        UUID id_preorder, String tanggal_rilis, String status, String produk_ref, String akun_ref
    ) {
        this.id_preorder = id_preorder;
        this.tanggal_rilis = tanggal_rilis;
        this.status = status;
        this.produk_ref = produk_ref;
        this.akun_ref = akun_ref;
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
	public String getProduk_ref() {
		return this.produk_ref;
	}

	public void setProduk_ref(String produk_ref) {
		this.produk_ref = produk_ref;
	}
	public String getAkun_ref() {
		return this.akun_ref;
	}

	public void setAkun_ref(String akun_ref) {
		this.akun_ref = akun_ref;
	}
 

	@Override
    public String toString() {
        return "{" +
            " id_preorder='" + getId_preorder() + "'" +
            " tanggal_rilis='" + getTanggal_rilis() + "'" +
            " status='" + getStatus() + "'" +
            " produk_ref='" + getProduk_ref() + "'" +
            " akun_ref='" + getAkun_ref() + "'" +
            "}";
    }
	
}
