package tokoonlineanimepl.akunpengguna.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;

public abstract class AkunPenggunaServiceDecorator extends AkunPenggunaServiceComponent{
	protected AkunPenggunaServiceComponent record;

    public AkunPenggunaServiceDecorator(AkunPenggunaServiceComponent record) {
        this.record = record;
    }

	public AkunPengguna createAkunPengguna(Map<String, Object> requestBody){
		return record.createAkunPengguna(requestBody);
	}
	
	public AkunPengguna createAkunPengguna(Map<String, Object> requestBody, int id){
		return record.createAkunPengguna(requestBody, id);
	}

	public HashMap<String, Object> getAkunPengguna(String idStr){
		return record.getAkunPengguna(idStr);
	}

	public List<HashMap<String,Object>> getAllAkunPengguna(){
		return record.getAllAkunPengguna();
	}

    public HashMap<String, Object> updateAkunPengguna(Map<String, Object> requestBody){
		return record.updateAkunPengguna(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<AkunPengguna> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteAkunPengguna(Map<String, Object> requestBody){
		return record.deleteAkunPengguna(requestBody);
	}

	public HashMap<String, Object> getAkunPenggunaById(int id){
        return record.getAkunPenggunaById(id);
    }

}
