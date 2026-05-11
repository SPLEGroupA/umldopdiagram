package tokoonlineanimepl.akunpengguna.sistemmembership.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import tokoonlineanimepl.akunpengguna.core.service.AkunPenggunaServiceDecorator;
import tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaImpl;
import tokoonlineanimepl.akunpengguna.core.service.AkunPenggunaServiceComponent;
import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;
import tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaDecorator;
import tokoonlineanimepl.akunpengguna.AkunPenggunaFactory;

public class AkunPenggunaServiceImpl extends AkunPenggunaServiceDecorator {
    public AkunPenggunaServiceImpl (AkunPenggunaServiceComponent record) {
        super(record);
    }

 	public AkunPengguna createAkunPengguna(Map<String, Object> requestBody){
		String membership_level = (String) requestBody.get("membership_level");
		String email = (String) requestBody.get("email");
		String nama = (String) requestBody.get("nama");
		String alamat = (String) requestBody.get("alamat");
		String no_telepon = (String) requestBody.get("no_telepon");
		AkunPengguna akunpenggunasistemmembership = record.createAkunPengguna(requestBody);
		AkunPengguna akunpenggunasistemmembershipdeco = AkunPenggunaFactory.createAkunPengguna("tokoonlineanimepl.akunpengguna.sistemmembership.model.AkunPenggunaImpl", akunpenggunasistemmembership, membership_level);
		Repository.saveObject(akunpenggunasistemmembershipdeco);
		return akunpenggunasistemmembershipdeco;
	}

    public AkunPengguna createAkunPengguna(Map<String, Object> requestBody, UUID id){	
		AkunPengguna savedAkunPengguna = Repository.getObject(id);
		String membership_level = (String) requestBody.get("membership_level");
		UUID recordAkunPenggunaId_akun = ((AkunPenggunaDecorator) savedAkunPengguna).getId_akun();
		AkunPengguna akunpengguna = record.createAkunPengguna(requestBody, recordAkunPenggunaId_akun);
		AkunPengguna akunpenggunasistemmembership = AkunPenggunaFactory.createAkunPengguna("tokoonlineanimepl.akunpengguna.sistemmembership.AkunPenggunaImpl", akunpengguna, membership_level);
		return akunpenggunasistemmembership;
	}

    public HashMap<String, Object> updateAkunPengguna(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_akun");
		UUID id = UUID.fromString(idStr);
		
		AkunPengguna akunpenggunasistemmembership = Repository.getObject(id);
		akunpenggunasistemmembership = createAkunPengguna(requestBody, id);
		
		Repository.updateObject(akunpenggunasistemmembership);
		akunpenggunasistemmembership = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return akunpenggunasistemmembership.toHashMap();
	}

	public HashMap<String, Object> getAkunPengguna(String idStr){
		UUID id = UUID.fromString(idStr);		
		AkunPengguna akunpenggunasistemmembership = Repository.getObject(id);
		return akunpenggunasistemmembership.toHashMap();
	}

	public HashMap<String, Object> getAkunPenggunaById(UUID id){
		List<HashMap<String, Object>> akunpenggunaList = getAllAkunPengguna();
		for (HashMap<String, Object> akunpengguna : akunpenggunaList){
			UUID akunpengguna_id = UUID.fromString((String) akunpengguna.get("id_akun"));
			if (akunpengguna_id.equals(id)){
				return akunpengguna;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllAkunPengguna(){
		List<AkunPengguna> List = Repository.getAllObject("akunpengguna_sistemmembership");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<AkunPengguna> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteAkunPengguna(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id_akun"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllAkunPengguna();
	}

	
	protected String checkMembership(UUID id_akun) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
