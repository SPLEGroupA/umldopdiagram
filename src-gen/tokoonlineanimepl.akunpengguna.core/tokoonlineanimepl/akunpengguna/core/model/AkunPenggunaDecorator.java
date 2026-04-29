package tokoonlineanimepl.akunpengguna.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class AkunPenggunaDecorator extends AkunPenggunaComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected AkunPenggunaComponent record;

	public AkunPenggunaDecorator () {
		super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
	}

	public AkunPenggunaDecorator (, AkunPenggunaComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public AkunPenggunaDecorator (AkunPenggunaComponent record, String objectName) {
		Random r = new Random();
		this. = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getId_akun() {
		return record.getId_akun();
	}
	public void setId_akun(int id_akun) {
		record.setId_akun(id_akun);
	}
	public String getEmail() {
		return record.getEmail();
	}
	public void setEmail(String email) {
		record.setEmail(email);
	}
	public String getNama() {
		return record.getNama();
	}
	public void setNama(String nama) {
		record.setNama(nama);
	}
	public String getAlamat() {
		return record.getAlamat();
	}
	public void setAlamat(String alamat) {
		record.setAlamat(alamat);
	}
	public String getNo_telepon() {
		return record.getNo_telepon();
	}
	public void setNo_telepon(String no_telepon) {
		record.setNo_telepon(no_telepon);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
