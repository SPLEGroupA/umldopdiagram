package tokoonlineanimepl.keranjangbelanja.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface KeranjangBelanja {
	    public UUID getId_keranjang();
	    public void setId_keranjang(UUID id_keranjang);
	    public String getAkun_ref();
	    public void setAkun_ref(String akun_ref);
	public boolean getByUser(String email);
	public boolean addItem(UUID id_cart_item);
	public boolean checkout();
	HashMap<String, Object> toHashMap();
}
