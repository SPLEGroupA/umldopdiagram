package tokoonlineanimepl.akunpengguna.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface AkunPengguna {
	    public int getId_akun();
	    public void setId_akun(int id_akun);
	    public String getEmail();
	    public void setEmail(String email);
	    public String getNama();
	    public void setNama(String nama);
	    public String getAlamat();
	    public void setAlamat(String alamat);
	    public String getNo_telepon();
	    public void setNo_telepon(String no_telepon);
	HashMap<String, Object> toHashMap();
}
