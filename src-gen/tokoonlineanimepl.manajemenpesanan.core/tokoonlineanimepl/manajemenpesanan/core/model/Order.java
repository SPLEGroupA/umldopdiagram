package tokoonlineanimepl.manajemenpesanan.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Order {
	    public int getId_pesanan();
	    public void setId_pesanan(int id_pesanan);
	    public String getStatus();
	    public void setStatus(String status);
	    public String getTanggal_pesan();
	    public void setTanggal_pesan(String tanggal_pesan);
	    public int getTotal_harga();
	    public void setTotal_harga(int total_harga);
	    public AkunPenggunaImpl getAkunPengguna();
	    public void setAkunPengguna(AkunPenggunaImpl akunPengguna);
	public OrderImpl getByUser(String email);
	HashMap<String, Object> toHashMap();
}
