package tokoonlineanimepl.katalogproduk.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;
//add other required packages

public abstract class KatalogProdukServiceComponent implements KatalogProdukService{
	protected RepositoryUtil<KatalogProduk> Repository;

    public KatalogProdukServiceComponent(){
        this.Repository = new RepositoryUtil<KatalogProduk>(tokoonlineanimepl.katalogproduk.core.model.KatalogProdukComponent.class);
    }	

    public abstract KatalogProduk createKatalogProduk(Map<String, Object> requestBody);
	public abstract KatalogProduk createKatalogProduk(Map<String, Object> requestBody, UUID id);
	public abstract HashMap<String, Object> updateKatalogProduk(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getKatalogProduk(String idStr);
    public abstract List<HashMap<String,Object>> getAllKatalogProduk();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<KatalogProduk> List);
    public abstract List<HashMap<String,Object>> deleteKatalogProduk(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getKatalogProdukById(UUID id);	

}
