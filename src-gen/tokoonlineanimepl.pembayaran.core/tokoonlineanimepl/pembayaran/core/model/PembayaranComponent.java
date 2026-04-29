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
	protected String metode;
	protected int jumlah;
	protected String status;
	protected String objectName = PembayaranComponent.class.getName();

	public PembayaranComponent() {

	} 

	public PembayaranComponent(
        int id_pembayaran, String metode, int jumlah, String status, int id_pesanan
    ) {
        this.id_pembayaran = id_pembayaran;
        this.metode = metode;
        this.jumlah = jumlah;
        this.status = status;
        this.id_pesanan = id_pesanan;
    }

	public int getId_pembayaran() {
		return this.id_pembayaran;
	}

	public void setId_pembayaran(int id_pembayaran) {
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
	public int getId_pesanan() {
		return this.id_pesanan;
	}

	public void setId_pesanan(int id_pesanan) {
		this.id_pesanan = id_pesanan;
	}
 

	@Override
    public String toString() {
        return "{" +
            " id_pembayaran='" + getId_pembayaran() + "'" +
            " metode='" + getMetode() + "'" +
            " jumlah='" + getJumlah() + "'" +
            " status='" + getStatus() + "'" +
            " id_pesanan='" + getId_pesanan() + "'" +
            "}";
    }
	
}
