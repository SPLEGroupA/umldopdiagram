package tokoonlineanimepl.manajemenpesanan.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesanan;

public abstract class ManajemenPesananServiceDecorator extends ManajemenPesananServiceComponent{
	protected ManajemenPesananServiceComponent record;

    public ManajemenPesananServiceDecorator(ManajemenPesananServiceComponent record) {
        this.record = record;
    }

	public ManajemenPesanan createManajemenPesanan(Map<String, Object> requestBody){
		return record.createManajemenPesanan(requestBody);
	}
	
    public ManajemenPesanan createManajemenPesanan(Map<String, Object> requestBody, UUID id){
		return record.createManajemenPesanan(requestBody, id);
	}

	public HashMap<String, Object> getManajemenPesanan(String idStr){
		return record.getManajemenPesanan(idStr);
	}

	public List<HashMap<String,Object>> getAllManajemenPesanan(){
		return record.getAllManajemenPesanan();
	}

    public HashMap<String, Object> updateManajemenPesanan(Map<String, Object> requestBody){
		return record.updateManajemenPesanan(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<ManajemenPesanan> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteManajemenPesanan(Map<String, Object> requestBody){
		return record.deleteManajemenPesanan(requestBody);
	}

	public HashMap<String, Object> getManajemenPesananById(UUID id){	
        return record.getManajemenPesananById(id);
    }

	public boolean getByUser(String email) {
		return record.getByUser(email);
	}
}
