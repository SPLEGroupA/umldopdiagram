package tokoonlineanimepl.akunpengguna.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.akunpengguna.AkunPenggunaFactory;
import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class AkunPenggunaServiceImpl extends AkunPenggunaServiceComponent{

    public AkunPengguna createAkunPengguna(Map<String, Object> requestBody){
		String email = (String) requestBody.get("email");
		String nama = (String) requestBody.get("nama");
		String alamat = (String) requestBody.get("alamat");
		String no_telepon = (String) requestBody.get("no_telepon");
		
		//to do: fix association attributes
		
		AkunPengguna akunpengguna = AkunPenggunaFactory.createAkunPengguna("tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaImpl", email, nama, alamat, no_telepon);
		Repository.saveObject(akunpengguna);
		return akunpengguna;
	}

    public AkunPengguna createAkunPengguna(Map<String, Object> requestBody, UUID id){	
		UUID id_akun = id;
		String email = (String) requestBody.get("email");
		String nama = (String) requestBody.get("nama");
		String alamat = (String) requestBody.get("alamat");
		String no_telepon = (String) requestBody.get("no_telepon");
		
		//to do: fix association attributes
		AkunPengguna akunpengguna = AkunPenggunaFactory.createAkunPengguna("tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaImpl",id_akun, email, nama, alamat, no_telepon);
		Repository.saveObject(akunpengguna);
		return akunpengguna;
	}

    public HashMap<String, Object> updateAkunPengguna(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_akun");
		UUID id = UUID.fromString(idStr);		
		AkunPengguna akunpengguna = Repository.getObject(id);
		
		akunpengguna.setEmail((String) requestBody.get("email"));
		akunpengguna.setNama((String) requestBody.get("nama"));
		akunpengguna.setAlamat((String) requestBody.get("alamat"));
		akunpengguna.setNo_telepon((String) requestBody.get("no_telepon"));
		
		Repository.updateObject(akunpengguna);
		
		//to do: fix association attributes
		
		return akunpengguna.toHashMap();
		
	}

    public HashMap<String, Object> getAkunPengguna(String idStr){
		UUID id = UUID.fromString(idStr);		
		AkunPengguna akunpengguna = Repository.getObject(id);
		return akunpengguna.toHashMap();
	}

	public HashMap<String, Object> getAkunPenggunaById(UUID id){
		List<HashMap<String, Object>> akunpenggunaList = getAllAkunPengguna();
		for (HashMap<String, Object> akunpengguna : akunpenggunaList){
			UUID record_id = UUID.fromString((String) akunpengguna.get("id_akun"));
			if (record_id.equals(id)){
				return akunpengguna;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllAkunPengguna(){
		List<AkunPengguna> List = Repository.getAllObject("akunpengguna_impl");
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

}
