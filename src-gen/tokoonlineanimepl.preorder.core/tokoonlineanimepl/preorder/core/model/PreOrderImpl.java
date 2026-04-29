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

	public PreOrderImpl(int id_preorder, String tanggal_rilis, String status, ProdukImpl produk, AkunPenggunaImpl akunPengguna) {
		this.id_preorder = id_preorder;
		this.tanggal_rilis = tanggal_rilis;
		this.status = status;
		this.produk = produk;
		this.akunPengguna = akunPengguna;
	}

	public PreOrderImpl(String tanggal_rilis, String status, ProdukImpl produk, AkunPenggunaImpl akunPengguna) {
		Random r = new Random();
		this. = Math.abs(r.nextInt());
		this.id_preorder = id_preorder;
		this.tanggal_rilis = tanggal_rilis;
		this.status = status;
		this.produk = produk;
		this.akunPengguna = akunPengguna;
	}

	public PreOrderImpl() { }

	public int getId_preorder() {
		return this.id_preorder;
	}

	public void setId_preorder(int id_preorder) {
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

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> preorderMap = new HashMap<String,Object>();
		preorderMap.put("id_preorder",getId_preorder());
		preorderMap.put("tanggal_rilis",getTanggal_rilis());
		preorderMap.put("status",getStatus());
		preorderMap.put("produk",getProduk());
		preorderMap.put("akunPengguna",getAkunPengguna());

        return preorderMap;
    }

}
