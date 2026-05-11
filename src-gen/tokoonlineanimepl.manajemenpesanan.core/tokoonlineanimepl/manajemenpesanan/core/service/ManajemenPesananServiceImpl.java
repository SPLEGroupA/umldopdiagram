package tokoonlineanimepl.manajemenpesanan.core.service;
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
import tokoonlineanimepl.manajemenpesanan.ManajemenPesananFactory;
import tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesanan;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class ManajemenPesananServiceImpl extends ManajemenPesananServiceComponent{

    public ManajemenPesanan createManajemenPesanan(Map<String, Object> requestBody){
		String status = (String) requestBody.get("status");
		String tanggal_pesan = (String) requestBody.get("tanggal_pesan");
		String total_hargaStr = (String) requestBody.get("total_harga");
		int total_harga = Integer.parseInt(total_hargaStr);
		String akun_ref = (String) requestBody.get("akun_ref");
		
		//to do: fix association attributes
		
		ManajemenPesanan manajemenpesanan = ManajemenPesananFactory.createManajemenPesanan("tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesananImpl", status, tanggal_pesan, total_harga, akun_ref);
		Repository.saveObject(manajemenpesanan);
		return manajemenpesanan;
	}

    public ManajemenPesanan createManajemenPesanan(Map<String, Object> requestBody, UUID id){	
		UUID id_pesanan = id;
		String status = (String) requestBody.get("status");
		String tanggal_pesan = (String) requestBody.get("tanggal_pesan");
		String total_hargaStr = (String) requestBody.get("total_harga");
		int total_harga = Integer.parseInt(total_hargaStr);
		String akun_ref = (String) requestBody.get("akun_ref");
		
		//to do: fix association attributes
		ManajemenPesanan manajemenpesanan = ManajemenPesananFactory.createManajemenPesanan("tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesananImpl",id_pesanan, status, tanggal_pesan, total_harga, akun_ref);
		Repository.saveObject(manajemenpesanan);
		return manajemenpesanan;
	}

    public HashMap<String, Object> updateManajemenPesanan(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_pesanan");
		UUID id = UUID.fromString(idStr);		
		ManajemenPesanan manajemenpesanan = Repository.getObject(id);
		
		manajemenpesanan.setStatus((String) requestBody.get("status"));
		manajemenpesanan.setTanggal_pesan((String) requestBody.get("tanggal_pesan"));
		String total_hargaStr = (String) requestBody.get("total_harga");
		manajemenpesanan.setTotal_harga(Integer.parseInt(total_hargaStr));
		
		manajemenpesanan.setAkun_ref((String) requestBody.get("akun_ref"));
		
		Repository.updateObject(manajemenpesanan);
		
		//to do: fix association attributes
		
		return manajemenpesanan.toHashMap();
		
	}

    public HashMap<String, Object> getManajemenPesanan(String idStr){
		UUID id = UUID.fromString(idStr);		
		ManajemenPesanan manajemenpesanan = Repository.getObject(id);
		return manajemenpesanan.toHashMap();
	}

	public HashMap<String, Object> getManajemenPesananById(UUID id){
		List<HashMap<String, Object>> manajemenpesananList = getAllManajemenPesanan();
		for (HashMap<String, Object> manajemenpesanan : manajemenpesananList){
			UUID record_id = UUID.fromString((String) manajemenpesanan.get("id_pesanan"));
			if (record_id.equals(id)){
				return manajemenpesanan;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllManajemenPesanan(){
		List<ManajemenPesanan> List = Repository.getAllObject("manajemenpesanan_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<ManajemenPesanan> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteManajemenPesanan(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id_pesanan"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllManajemenPesanan();
	}

	public boolean getByUser(String email) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
