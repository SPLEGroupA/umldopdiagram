package tokoonlineanimepl.preorder.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface PreOrder {
	    public UUID getId_preorder();
	    public void setId_preorder(UUID id_preorder);
	    public String getTanggal_rilis();
	    public void setTanggal_rilis(String tanggal_rilis);
	    public String getStatus();
	    public void setStatus(String status);
	    public String getProduk_ref();
	    public void setProduk_ref(String produk_ref);
	    public String getAkun_ref();
	    public void setAkun_ref(String akun_ref);
	HashMap<String, Object> toHashMap();
}
