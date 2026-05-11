package tokoonlineanimepl.katalogproduk.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;
//add other required packages

public abstract class KatalogProdukResourceComponent implements KatalogProdukResource{
	
	public KatalogProdukResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveKatalogProduk(VMJExchange vmjExchange);
    public abstract KatalogProduk createKatalogProduk(VMJExchange vmjExchange);
	public abstract KatalogProduk createKatalogProduk(VMJExchange vmjExchange, UUID id);
	public abstract HashMap<String, Object> updateKatalogProduk(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getKatalogProduk(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllKatalogProduk(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteKatalogProduk(VMJExchange vmjExchange);

}
