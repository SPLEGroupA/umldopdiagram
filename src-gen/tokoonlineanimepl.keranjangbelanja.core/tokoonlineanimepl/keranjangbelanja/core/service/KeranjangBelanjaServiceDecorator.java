package tokoonlineanimepl.keranjangbelanja.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanja;

public abstract class KeranjangBelanjaServiceDecorator extends KeranjangBelanjaServiceComponent{
	protected KeranjangBelanjaServiceComponent record;

    public KeranjangBelanjaServiceDecorator(KeranjangBelanjaServiceComponent record) {
        this.record = record;
    }

	public KeranjangBelanja createKeranjangBelanja(Map<String, Object> requestBody){
		return record.createKeranjangBelanja(requestBody);
	}
	
	public KeranjangBelanja createKeranjangBelanja(Map<String, Object> requestBody, int id){
		return record.createKeranjangBelanja(requestBody, id);
	}

	public HashMap<String, Object> getKeranjangBelanja(String idStr){
		return record.getKeranjangBelanja(idStr);
	}

	public List<HashMap<String,Object>> getAllKeranjangBelanja(){
		return record.getAllKeranjangBelanja();
	}

    public HashMap<String, Object> updateKeranjangBelanja(Map<String, Object> requestBody){
		return record.updateKeranjangBelanja(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<KeranjangBelanja> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteKeranjangBelanja(Map<String, Object> requestBody){
		return record.deleteKeranjangBelanja(requestBody);
	}

	public HashMap<String, Object> getKeranjangBelanjaById(int id){
        return record.getKeranjangBelanjaById(id);
    }

	public KeranjangBelanjaImpl getByUser(String email) {
		return record.getByUser(email);
	}

	public boolean addItem(int id_cart_item) {
		return record.addItem(id_cart_item);
	}

	public OrderImpl checkout() {
		return record.checkout();
	}
}
