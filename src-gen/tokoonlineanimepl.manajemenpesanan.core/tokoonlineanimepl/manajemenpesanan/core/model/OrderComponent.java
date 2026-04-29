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
@Table(name="order_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OrderComponent implements Order{
	protected String status;
	protected String tanggal_pesan;
	protected int total_harga;
	@ManyToOne(targetEntity=tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaComponent.class)
	public AkunPengguna akunPengguna;
	protected String objectName = OrderComponent.class.getName();

	public OrderComponent() {

	} 

	public OrderComponent(
        int id_pesanan, String status, String tanggal_pesan, int total_harga, AkunPenggunaImpl akunPengguna
    ) {
        this.id_pesanan = id_pesanan;
        this.status = status;
        this.tanggal_pesan = tanggal_pesan;
        this.total_harga = total_harga;
        this.akunPengguna = akunPengguna;
    }

	public int getId_pesanan() {
		return this.id_pesanan;
	}

	public void setId_pesanan(int id_pesanan) {
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
	public abstract AkunPenggunaImpl getAkunPengguna();
	public abstract void setAkunPengguna(AkunPenggunaImpl akunPengguna);
	
 
	public abstract OrderImpl getByUser(String email);

	@Override
    public String toString() {
        return "{" +
            " id_pesanan='" + getId_pesanan() + "'" +
            " status='" + getStatus() + "'" +
            " tanggal_pesan='" + getTanggal_pesan() + "'" +
            " total_harga='" + getTotal_harga() + "'" +
            " akunPengguna='" + getAkunPengguna() + "'" +
            "}";
    }
	
}
