package tokoonlineanimepl.pembayaran.core.model;

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
@Table(name="pembayaran_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PembayaranComponent implements Pembayaran{
	@Id
	protected UUID id_pembayaran; 
	protected String metode;
	protected int jumlah;
	protected String status;
	protected String pesanan_ref;
	protected String objectName = PembayaranComponent.class.getName();

	public PembayaranComponent() {

	} 

	public PembayaranComponent(
        UUID id_pembayaran, String metode, int jumlah, String status, String pesanan_ref
    ) {
        this.id_pembayaran = id_pembayaran;
        this.metode = metode;
        this.jumlah = jumlah;
        this.status = status;
        this.pesanan_ref = pesanan_ref;
    }

	public UUID getId_pembayaran() {
		return this.id_pembayaran;
	}

	public void setId_pembayaran(UUID id_pembayaran) {
		this.id_pembayaran = id_pembayaran;
	}
	public String getMetode() {
		return this.metode;
	}

	public void setMetode(String metode) {
		this.metode = metode;
	}
	public int getJumlah() {
		return this.jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getPesanan_ref() {
		return this.pesanan_ref;
	}

	public void setPesanan_ref(String pesanan_ref) {
		this.pesanan_ref = pesanan_ref;
	}
 

	@Override
    public String toString() {
        return "{" +
            " id_pembayaran='" + getId_pembayaran() + "'" +
            " metode='" + getMetode() + "'" +
            " jumlah='" + getJumlah() + "'" +
            " status='" + getStatus() + "'" +
            " pesanan_ref='" + getPesanan_ref() + "'" +
            "}";
    }
	
}
