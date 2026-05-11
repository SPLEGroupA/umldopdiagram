package tokoonlineanimepl.keranjangbelanja.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanja;
//add other required packages

public abstract class KeranjangBelanjaResourceComponent implements KeranjangBelanjaResource{
	
	public KeranjangBelanjaResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveKeranjangBelanja(VMJExchange vmjExchange);
    public abstract KeranjangBelanja createKeranjangBelanja(VMJExchange vmjExchange);
	public abstract KeranjangBelanja createKeranjangBelanja(VMJExchange vmjExchange, UUID id);
	public abstract HashMap<String, Object> updateKeranjangBelanja(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getKeranjangBelanja(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllKeranjangBelanja(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteKeranjangBelanja(VMJExchange vmjExchange);

	public abstract KeranjangBelanjaImpl getByUser(String email);

	public abstract boolean addItem(UUID id_cart_item);

	public abstract OrderImpl checkout();
}
