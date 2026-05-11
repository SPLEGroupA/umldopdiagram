package tokoonlineanimepl.orderitem.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface OrderItem {
	    public UUID getId_order_item();
	    public void setId_order_item(UUID id_order_item);
	    public int getQuantity();
	    public void setQuantity(int quantity);
	    public int getHarga_satuan();
	    public void setHarga_satuan(int harga_satuan);
	    public String getPesanan_ref();
	    public void setPesanan_ref(String pesanan_ref);
	    public String getProduk_ref();
	    public void setProduk_ref(String produk_ref);
	public boolean getByPesanan(UUID id_pesanan);
	HashMap<String, Object> toHashMap();
}
