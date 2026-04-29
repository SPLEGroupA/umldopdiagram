package tokoonlineanimepl.katalogproduk.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Produk {
	    public int getId_produk();
	    public void setId_produk(int id_produk);
	    public String getNama();
	    public void setNama(String nama);
	    public int getHarga();
	    public void setHarga(int harga);
	    public String getKategori();
	    public void setKategori(String kategori);
	    public String getDeskripsi();
	    public void setDeskripsi(String deskripsi);
	    public int getStok();
	    public void setStok(int stok);
	    public String getGambar_url();
	    public void setGambar_url(String gambar_url);
	HashMap<String, Object> toHashMap();
}
