package tokoonlineanimepl.manajemenpesanan.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface OrderItem {
	    public int getId_order_item();
	    public void setId_order_item(int id_order_item);
	    public int getQuantity();
	    public void setQuantity(int quantity);
	    public int getHarga_satuan();
	    public void setHarga_satuan(int harga_satuan);
	    public OrderImpl getPesanan();
	    public void setPesanan(OrderImpl pesanan);
	    public ProdukImpl getProduk();
	    public void setProduk(ProdukImpl produk);
	public OrderItemImpl getByPesanan(int id_pesanan);
	HashMap<String, Object> toHashMap();
}
