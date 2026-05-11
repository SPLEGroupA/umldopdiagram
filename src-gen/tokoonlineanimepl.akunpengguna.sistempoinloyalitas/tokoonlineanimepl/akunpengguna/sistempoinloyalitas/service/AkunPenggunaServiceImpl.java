package tokoonlineanimepl.akunpengguna.sistempoinloyalitas.service;

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
		String poinStr = (String) requestBody.get("poin");
		int poin = Integer.parseInt(poinStr);
		String email = (String) requestBody.get("email");
		String nama = (String) requestBody.get("nama");
		String alamat = (String) requestBody.get("alamat");
		String no_telepon = (String) requestBody.get("no_telepon");
		AkunPengguna akunpenggunasistempoinloyalitas = record.createAkunPengguna(requestBody);
		AkunPengguna akunpenggunasistempoinloyalitasdeco = AkunPenggunaFactory.createAkunPengguna("tokoonlineanimepl.akunpengguna.sistempoinloyalitas.model.AkunPenggunaImpl", akunpenggunasistempoinloyalitas, poin);
		Repository.saveObject(akunpenggunasistempoinloyalitasdeco);
		return akunpenggunasistempoinloyalitasdeco;
	}

    public AkunPengguna createAkunPengguna(Map<String, Object> requestBody, UUID id){	
		AkunPengguna savedAkunPengguna = Repository.getObject(id);
		String poinStr = (String) requestBody.get("poin");
		int poin = Integer.parseInt(poinStr);
		UUID recordAkunPenggunaId_akun = ((AkunPenggunaDecorator) savedAkunPengguna).getId_akun();
		AkunPengguna akunpengguna = record.createAkunPengguna(requestBody, recordAkunPenggunaId_akun);
		AkunPengguna akunpenggunasistempoinloyalitas = AkunPenggunaFactory.createAkunPengguna("tokoonlineanimepl.akunpengguna.sistempoinloyalitas.AkunPenggunaImpl", akunpengguna, poin);
		return akunpenggunasistempoinloyalitas;
	}

    public HashMap<String, Object> updateAkunPengguna(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_akun");
		UUID id = UUID.fromString(idStr);
		
		AkunPengguna akunpenggunasistempoinloyalitas = Repository.getObject(id);
		akunpenggunasistempoinloyalitas = createAkunPengguna(requestBody, id);
		
		Repository.updateObject(akunpenggunasistempoinloyalitas);
		akunpenggunasistempoinloyalitas = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return akunpenggunasistempoinloyalitas.toHashMap();
	}

	public HashMap<String, Object> getAkunPengguna(String idStr){
		UUID id = UUID.fromString(idStr);		
		AkunPengguna akunpenggunasistempoinloyalitas = Repository.getObject(id);
		return akunpenggunasistempoinloyalitas.toHashMap();
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
		List<AkunPengguna> List = Repository.getAllObject("akunpengguna_sistempoinloyalitas");
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

	
	protected boolean redeemPoin(UUID id_akun, int jumlah_poin) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
