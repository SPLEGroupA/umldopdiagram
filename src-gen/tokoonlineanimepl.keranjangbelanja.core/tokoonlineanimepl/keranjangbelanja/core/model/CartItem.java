package tokoonlineanimepl.keranjangbelanja.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface CartItem {
	    public int getId_cart_item();
	    public void setId_cart_item(int id_cart_item);
	    public int getQuantity();
	    public void setQuantity(int quantity);
	    public int getHarga_satuan();
	    public void setHarga_satuan(int harga_satuan);
	    public KeranjangBelanjaImpl getKeranjangBelanja();
	    public void setKeranjangBelanja(KeranjangBelanjaImpl keranjangBelanja);
	    public ProdukImpl getProduk();
	    public void setProduk(ProdukImpl produk);
	public boolean setProduct(int id_produk, int quantity);
	public CartItemImpl getByKeranjang(int id_keranjang);
	HashMap<String, Object> toHashMap();
}
