package tokoonlineanimepl.katalogproduk.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.katalogproduk.core.model.Produk;

public abstract class ProdukServiceDecorator extends ProdukServiceComponent{
	protected ProdukServiceComponent record;

    public ProdukServiceDecorator(ProdukServiceComponent record) {
        this.record = record;
    }

	public Produk createProduk(Map<String, Object> requestBody){
		return record.createProduk(requestBody);
	}
	
	public Produk createProduk(Map<String, Object> requestBody, int id){
		return record.createProduk(requestBody, id);
	}

	public HashMap<String, Object> getProduk(String idStr){
		return record.getProduk(idStr);
	}

	public List<HashMap<String,Object>> getAllProduk(){
		return record.getAllProduk();
	}

    public HashMap<String, Object> updateProduk(Map<String, Object> requestBody){
		return record.updateProduk(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Produk> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteProduk(Map<String, Object> requestBody){
		return record.deleteProduk(requestBody);
	}

	public HashMap<String, Object> getProdukById(int id){
        return record.getProdukById(id);
    }

}
