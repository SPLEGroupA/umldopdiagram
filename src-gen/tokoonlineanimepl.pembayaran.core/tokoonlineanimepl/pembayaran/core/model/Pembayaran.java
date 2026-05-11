package tokoonlineanimepl.pembayaran.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Pembayaran {
	    public UUID getId_pembayaran();
	    public void setId_pembayaran(UUID id_pembayaran);
	    public String getMetode();
	    public void setMetode(String metode);
	    public int getJumlah();
	    public void setJumlah(int jumlah);
	    public String getStatus();
	    public void setStatus(String status);
	    public String getPesanan_ref();
	    public void setPesanan_ref(String pesanan_ref);
	HashMap<String, Object> toHashMap();
}
