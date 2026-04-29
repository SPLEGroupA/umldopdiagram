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
		Random r = new Random();
		this. = Math.abs(r.nextInt());
	}

	public PreOrderDecorator (, PreOrderComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public PreOrderDecorator (PreOrderComponent record, String objectName) {
		Random r = new Random();
		this. = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getId_preorder() {
		return record.getId_preorder();
	}
	public void setId_preorder(int id_preorder) {
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


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
