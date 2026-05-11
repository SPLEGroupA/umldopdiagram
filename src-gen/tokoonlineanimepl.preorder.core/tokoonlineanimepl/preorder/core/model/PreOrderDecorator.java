package tokoonlineanimepl.preorder.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PreOrderDecorator extends PreOrderComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PreOrderComponent record;

	public PreOrderDecorator () {
		super();
		this.id_preorder =  UUID.randomUUID();
	}

	public PreOrderDecorator (UUID id_preorder, PreOrderComponent record) {
		this.id_preorder =  id_preorder;
		this.record = record;
	}
	
	public PreOrderDecorator (PreOrderComponent record, String objectName) {
		this.id_preorder =  UUID.randomUUID();
		this.record = record;
		this.objectName=objectName;
	}


	public UUID getId_preorder() {
		return record.getId_preorder();
	}
	public void setId_preorder(UUID id_preorder) {
		record.setId_preorder(id_preorder);
	}
	public String getTanggal_rilis() {
		return record.getTanggal_rilis();
	}
	public void setTanggal_rilis(String tanggal_rilis) {
		record.setTanggal_rilis(tanggal_rilis);
	}
	public String getStatus() {
		return record.getStatus();
	}
	public void setStatus(String status) {
		record.setStatus(status);
	}
	public String getProduk_ref() {
		return record.getProduk_ref();
	}
	public void setProduk_ref(String produk_ref) {
		record.setProduk_ref(produk_ref);
	}
	public String getAkun_ref() {
		return record.getAkun_ref();
	}
	public void setAkun_ref(String akun_ref) {
		record.setAkun_ref(akun_ref);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
