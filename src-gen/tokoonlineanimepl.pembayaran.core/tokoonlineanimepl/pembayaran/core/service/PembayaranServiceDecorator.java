package tokoonlineanimepl.pembayaran.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.pembayaran.core.model.Pembayaran;

public abstract class PembayaranServiceDecorator extends PembayaranServiceComponent{
	protected PembayaranServiceComponent record;

    public PembayaranServiceDecorator(PembayaranServiceComponent record) {
        this.record = record;
    }

	public Pembayaran createPembayaran(Map<String, Object> requestBody){
		return record.createPembayaran(requestBody);
	}
	
    public Pembayaran createPembayaran(Map<String, Object> requestBody, UUID id){
		return record.createPembayaran(requestBody, id);
	}

	public HashMap<String, Object> getPembayaran(String idStr){
		return record.getPembayaran(idStr);
	}

	public List<HashMap<String,Object>> getAllPembayaran(){
		return record.getAllPembayaran();
	}

    public HashMap<String, Object> updatePembayaran(Map<String, Object> requestBody){
		return record.updatePembayaran(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Pembayaran> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deletePembayaran(Map<String, Object> requestBody){
		return record.deletePembayaran(requestBody);
	}

	public HashMap<String, Object> getPembayaranById(UUID id){	
        return record.getPembayaranById(id);
    }

}
