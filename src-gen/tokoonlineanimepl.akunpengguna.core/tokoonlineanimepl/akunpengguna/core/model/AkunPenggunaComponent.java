package tokoonlineanimepl.akunpengguna.core.model;

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
@Table(name="akunpengguna_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AkunPenggunaComponent implements AkunPengguna{
	@Id
	protected UUID id_akun; 
	protected String email;
	protected String nama;
	protected String alamat;
	protected String no_telepon;
	protected String objectName = AkunPenggunaComponent.class.getName();

	public AkunPenggunaComponent() {

	} 

	public AkunPenggunaComponent(
        UUID id_akun, String email, String nama, String alamat, String no_telepon
    ) {
        this.id_akun = id_akun;
        this.email = email;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
    }

	public UUID getId_akun() {
		return this.id_akun;
	}

	public void setId_akun(UUID id_akun) {
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
 

	@Override
    public String toString() {
        return "{" +
            " id_akun='" + getId_akun() + "'" +
            " email='" + getEmail() + "'" +
            " nama='" + getNama() + "'" +
            " alamat='" + getAlamat() + "'" +
            " no_telepon='" + getNo_telepon() + "'" +
            "}";
    }
	
}
