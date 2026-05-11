package tokoonlineanimepl.pembayaran.core.service;
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
import tokoonlineanimepl.pembayaran.PembayaranFactory;
import tokoonlineanimepl.pembayaran.core.model.Pembayaran;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class PembayaranServiceImpl extends PembayaranServiceComponent{

    public Pembayaran createPembayaran(Map<String, Object> requestBody){
		String metode = (String) requestBody.get("metode");
		String jumlahStr = (String) requestBody.get("jumlah");
		int jumlah = Integer.parseInt(jumlahStr);
		String status = (String) requestBody.get("status");
		String id_pesananStr = (String) requestBody.get("id_pesanan");
		int id_pesanan = Integer.parseInt(id_pesananStr);
		
		//to do: fix association attributes
		
		Pembayaran pembayaran = PembayaranFactory.createPembayaran("tokoonlineanimepl.pembayaran.core.model.PembayaranImpl", metode, jumlah, status, id_pesanan);
		Repository.saveObject(pembayaran);
		return pembayaran;
	}

    public Pembayaran createPembayaran(Map<String, Object> requestBody, UUID id){	
		UUID id_pembayaran = id;
		String metode = (String) requestBody.get("metode");
		String jumlahStr = (String) requestBody.get("jumlah");
		int jumlah = Integer.parseInt(jumlahStr);
		String status = (String) requestBody.get("status");
		String id_pesananStr = (String) requestBody.get("id_pesanan");
		int id_pesanan = Integer.parseInt(id_pesananStr);
		
		//to do: fix association attributes
		Pembayaran pembayaran = PembayaranFactory.createPembayaran("tokoonlineanimepl.pembayaran.core.model.PembayaranImpl",id_pembayaran, metode, jumlah, status, id_pesanan);
		Repository.saveObject(pembayaran);
		return pembayaran;
	}

    public HashMap<String, Object> updatePembayaran(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_pembayaran");
		UUID id = UUID.fromString(idStr);		
		Pembayaran pembayaran = Repository.getObject(id);
		
		pembayaran.setMetode((String) requestBody.get("metode"));
		String jumlahStr = (String) requestBody.get("jumlah");
		pembayaran.setJumlah(Integer.parseInt(jumlahStr));
		
		pembayaran.setStatus((String) requestBody.get("status"));
		String id_pesananStr = (String) requestBody.get("id_pesanan");
		pembayaran.setId_pesanan(Integer.parseInt(id_pesananStr));
		
		
		Repository.updateObject(pembayaran);
		
		//to do: fix association attributes
		
		return pembayaran.toHashMap();
		
	}

    public HashMap<String, Object> getPembayaran(String idStr){
		UUID id = UUID.fromString(idStr);		
		Pembayaran pembayaran = Repository.getObject(id);
		return pembayaran.toHashMap();
	}

	public HashMap<String, Object> getPembayaranById(UUID id){
		List<HashMap<String, Object>> pembayaranList = getAllPembayaran();
		for (HashMap<String, Object> pembayaran : pembayaranList){
			UUID record_id = UUID.fromString((String) pembayaran.get("id_pembayaran"));
			if (record_id.equals(id)){
				return pembayaran;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllPembayaran(){
		List<Pembayaran> List = Repository.getAllObject("pembayaran_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Pembayaran> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deletePembayaran(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id_pembayaran"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllPembayaran();
	}

}
