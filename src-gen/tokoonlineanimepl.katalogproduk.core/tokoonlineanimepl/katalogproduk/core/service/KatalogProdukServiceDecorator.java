package tokoonlineanimepl.katalogproduk.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;

public abstract class KatalogProdukServiceDecorator extends KatalogProdukServiceComponent{
	protected KatalogProdukServiceComponent record;

    public KatalogProdukServiceDecorator(KatalogProdukServiceComponent record) {
        this.record = record;
    }

	public KatalogProduk createKatalogProduk(Map<String, Object> requestBody){
		return record.createKatalogProduk(requestBody);
	}
	
    public KatalogProduk createKatalogProduk(Map<String, Object> requestBody, UUID id){
		return record.createKatalogProduk(requestBody, id);
	}

	public HashMap<String, Object> getKatalogProduk(String idStr){
		return record.getKatalogProduk(idStr);
	}

	public List<HashMap<String,Object>> getAllKatalogProduk(){
		return record.getAllKatalogProduk();
	}

    public HashMap<String, Object> updateKatalogProduk(Map<String, Object> requestBody){
		return record.updateKatalogProduk(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<KatalogProduk> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteKatalogProduk(Map<String, Object> requestBody){
		return record.deleteKatalogProduk(requestBody);
	}

	public HashMap<String, Object> getKatalogProdukById(UUID id){	
        return record.getKatalogProdukById(id);
    }

}
