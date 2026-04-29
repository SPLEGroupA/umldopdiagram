package tokoonlineanimepl.akunpengguna.core.model;

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


@Entity(name="akunpengguna_impl")
@Table(name="akunpengguna_impl")
public class AkunPenggunaImpl extends AkunPenggunaComponent {

	public AkunPenggunaImpl(int id_akun, String email, String nama, String alamat, String no_telepon) {
		this.id_akun = id_akun;
		this.email = email;
		this.nama = nama;
		this.alamat = alamat;
		this.no_telepon = no_telepon;
	}

	public AkunPenggunaImpl(String email, String nama, String alamat, String no_telepon) {
		Random r = new Random();
		this. = Math.abs(r.nextInt());
		this.id_akun = id_akun;
		this.email = email;
		this.nama = nama;
		this.alamat = alamat;
		this.no_telepon = no_telepon;
	}

	public AkunPenggunaImpl() { }

	public int getId_akun() {
		return this.id_akun;
	}

	public void setId_akun(int id_akun) {
		this.id_akun = id_akun;
	}
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getNo_telepon() {
		return this.no_telepon;
	}

	public void setNo_telepon(String no_telepon) {
		this.no_telepon = no_telepon;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> akunpenggunaMap = new HashMap<String,Object>();
		akunpenggunaMap.put("id_akun",getId_akun());
		akunpenggunaMap.put("email",getEmail());
		akunpenggunaMap.put("nama",getNama());
		akunpenggunaMap.put("alamat",getAlamat());
		akunpenggunaMap.put("no_telepon",getNo_telepon());

        return akunpenggunaMap;
    }

}
