package tokoonlineanimepl.manajemenpesanan.core.model;

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
@Table(name="manajemenpesanan_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ManajemenPesananComponent implements ManajemenPesanan{
	@Id
	protected UUID id_pesanan; 
	protected String status;
	protected String tanggal_pesan;
	protected int total_harga;
	protected String akun_ref;
	protected String objectName = ManajemenPesananComponent.class.getName();

	public ManajemenPesananComponent() {

	} 

	public ManajemenPesananComponent(
        UUID id_pesanan, String status, String tanggal_pesan, int total_harga, String akun_ref
    ) {
        this.id_pesanan = id_pesanan;
        this.status = status;
        this.tanggal_pesan = tanggal_pesan;
        this.total_harga = total_harga;
        this.akun_ref = akun_ref;
    }

	public UUID getId_pesanan() {
		return this.id_pesanan;
	}

	public void setId_pesanan(UUID id_pesanan) {
		this.id_pesanan = id_pesanan;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getTanggal_pesan() {
		return this.tanggal_pesan;
	}

	public void setTanggal_pesan(String tanggal_pesan) {
		this.tanggal_pesan = tanggal_pesan;
	}
	public int getTotal_harga() {
		return this.total_harga;
	}

	public void setTotal_harga(int total_harga) {
		this.total_harga = total_harga;
	}
	public String getAkun_ref() {
		return this.akun_ref;
	}

	public void setAkun_ref(String akun_ref) {
		this.akun_ref = akun_ref;
	}
 
	public abstract boolean getByUser(String email);

	@Override
    public String toString() {
        return "{" +
            " id_pesanan='" + getId_pesanan() + "'" +
            " status='" + getStatus() + "'" +
            " tanggal_pesan='" + getTanggal_pesan() + "'" +
            " total_harga='" + getTotal_harga() + "'" +
            " akun_ref='" + getAkun_ref() + "'" +
            "}";
    }
	
}
