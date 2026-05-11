package tokoonlineanimepl.keranjangbelanja.core.service;
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
import tokoonlineanimepl.keranjangbelanja.KeranjangBelanjaFactory;
import tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanja;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class KeranjangBelanjaServiceImpl extends KeranjangBelanjaServiceComponent{

    public KeranjangBelanja createKeranjangBelanja(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		
		KeranjangBelanja keranjangbelanja = KeranjangBelanjaFactory.createKeranjangBelanja("tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanjaImpl", akunPengguna);
		Repository.saveObject(keranjangbelanja);
		return keranjangbelanja;
	}

    public KeranjangBelanja createKeranjangBelanja(Map<String, Object> requestBody, UUID id){	
		UUID id_keranjang = id;
		
		//to do: fix association attributes
		KeranjangBelanja keranjangbelanja = KeranjangBelanjaFactory.createKeranjangBelanja("tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanjaImpl",id_keranjang, akunPengguna);
		Repository.saveObject(keranjangbelanja);
		return keranjangbelanja;
	}

    public HashMap<String, Object> updateKeranjangBelanja(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_keranjang");
		UUID id = UUID.fromString(idStr);		
		KeranjangBelanja keranjangbelanja = Repository.getObject(id);
		
		
		Repository.updateObject(keranjangbelanja);
		
		//to do: fix association attributes
		
		return keranjangbelanja.toHashMap();
		
	}

    public HashMap<String, Object> getKeranjangBelanja(String idStr){
		UUID id = UUID.fromString(idStr);		
		KeranjangBelanja keranjangbelanja = Repository.getObject(id);
		return keranjangbelanja.toHashMap();
	}

	public HashMap<String, Object> getKeranjangBelanjaById(UUID id){
		List<HashMap<String, Object>> keranjangbelanjaList = getAllKeranjangBelanja();
		for (HashMap<String, Object> keranjangbelanja : keranjangbelanjaList){
			UUID record_id = UUID.fromString((String) keranjangbelanja.get("id_keranjang"));
			if (record_id.equals(id)){
				return keranjangbelanja;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllKeranjangBelanja(){
		List<KeranjangBelanja> List = Repository.getAllObject("keranjangbelanja_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<KeranjangBelanja> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteKeranjangBelanja(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id_keranjang"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllKeranjangBelanja();
	}

	public KeranjangBelanjaImpl getByUser(String email) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public boolean addItem(UUID id_cart_item) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public OrderImpl checkout() {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
