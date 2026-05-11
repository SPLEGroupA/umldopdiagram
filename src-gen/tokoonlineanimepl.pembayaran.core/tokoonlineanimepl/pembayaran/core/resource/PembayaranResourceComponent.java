package tokoonlineanimepl.pembayaran.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.pembayaran.core.model.Pembayaran;
//add other required packages

public abstract class PembayaranResourceComponent implements PembayaranResource{
	
	public PembayaranResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> savePembayaran(VMJExchange vmjExchange);
    public abstract Pembayaran createPembayaran(VMJExchange vmjExchange);
	public abstract Pembayaran createPembayaran(VMJExchange vmjExchange, UUID id);
	public abstract HashMap<String, Object> updatePembayaran(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getPembayaran(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllPembayaran(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deletePembayaran(VMJExchange vmjExchange);

}
