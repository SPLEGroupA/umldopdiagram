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
	    public ProdukImpl getProduk();
	    public void setProduk(ProdukImpl produk);
	    public AkunPenggunaImpl getAkunPengguna();
	    public void setAkunPengguna(AkunPenggunaImpl akunPengguna);
	HashMap<String, Object> toHashMap();
}
