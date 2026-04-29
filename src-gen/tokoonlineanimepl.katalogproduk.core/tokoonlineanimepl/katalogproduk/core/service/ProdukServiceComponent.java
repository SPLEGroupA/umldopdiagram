package tokoonlineanimepl.katalogproduk.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.katalogproduk.core.model.Produk;
//add other required packages

public abstract class ProdukServiceComponent implements ProdukService{
	protected RepositoryUtil<Produk> Repository;

    public ProdukServiceComponent(){
        this.Repository = new RepositoryUtil<Produk>(tokoonlineanimepl.katalogproduk.core.model.ProdukComponent.class);
    }	

    public abstract Produk createProduk(Map<String, Object> requestBody);
	public abstract Produk createProduk(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateProduk(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getProduk(String idStr);
    public abstract List<HashMap<String,Object>> getAllProduk();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Produk> List);
    public abstract List<HashMap<String,Object>> deleteProduk(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getProdukById(int id);

}
