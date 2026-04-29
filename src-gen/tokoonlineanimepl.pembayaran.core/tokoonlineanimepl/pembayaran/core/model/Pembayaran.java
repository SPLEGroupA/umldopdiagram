package tokoonlineanimepl.pembayaran.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Pembayaran {
	    public int getId_pembayaran();
	    public void setId_pembayaran(int id_pembayaran);
	    public String getMetode();
	    public void setMetode(String metode);
	    public int getJumlah();
	    public void setJumlah(int jumlah);
	    public String getStatus();
	    public void setStatus(String status);
	    public int getId_pesanan();
	    public void setId_pesanan(int id_pesanan);
	HashMap<String, Object> toHashMap();
}
