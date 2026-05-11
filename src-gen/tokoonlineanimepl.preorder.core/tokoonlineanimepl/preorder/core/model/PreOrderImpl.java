package tokoonlineanimepl.preorder.core.model;

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


@Entity(name="preorder_impl")
@Table(name="preorder_impl")
public class PreOrderImpl extends PreOrderComponent {

	public PreOrderImpl(UUID id_preorder, String tanggal_rilis, String status, String produk_ref, String akun_ref) {
		this.id_preorder = id_preorder;
		this.tanggal_rilis = tanggal_rilis;
		this.status = status;
		this.produk_ref = produk_ref;
		this.akun_ref = akun_ref;
	}

	public PreOrderImpl(String tanggal_rilis, String status, String produk_ref, String akun_ref) {
		this.id_preorder =  UUID.randomUUID();
		this.tanggal_rilis = tanggal_rilis;
		this.status = status;
		this.produk_ref = produk_ref;
		this.akun_ref = akun_ref;
	}

	public PreOrderImpl() { }

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

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> preorderMap = new HashMap<String,Object>();
		preorderMap.put("id_preorder",getId_preorder());
		preorderMap.put("tanggal_rilis",getTanggal_rilis());
		preorderMap.put("status",getStatus());
		preorderMap.put("produk_ref",getProduk_ref());
		preorderMap.put("akun_ref",getAkun_ref());

        return preorderMap;
    }

}
