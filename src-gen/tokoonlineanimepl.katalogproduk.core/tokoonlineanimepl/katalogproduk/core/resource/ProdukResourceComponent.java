package tokoonlineanimepl.katalogproduk.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.katalogproduk.core.model.Produk;
//add other required packages

public abstract class ProdukResourceComponent implements ProdukResource{
	
	public ProdukResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveProduk(VMJExchange vmjExchange);
    public abstract Produk createProduk(VMJExchange vmjExchange);
	public abstract Produk createProduk(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateProduk(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getProduk(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllProduk(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteProduk(VMJExchange vmjExchange);

}
