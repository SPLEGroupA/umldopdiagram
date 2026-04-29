package tokoonlineanimepl.keranjangbelanja.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface KeranjangBelanja {
	    public int getId_keranjang();
	    public void setId_keranjang(int id_keranjang);
	    public AkunPenggunaImpl getAkunPengguna();
	    public void setAkunPengguna(AkunPenggunaImpl akunPengguna);
	public KeranjangBelanjaImpl getByUser(String email);
	public OrderImpl checkout();
	HashMap<String, Object> toHashMap();
}
