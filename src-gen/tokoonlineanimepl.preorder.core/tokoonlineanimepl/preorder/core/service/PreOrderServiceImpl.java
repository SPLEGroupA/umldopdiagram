package tokoonlineanimepl.preorder.core.service;
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
import tokoonlineanimepl.preorder.PreOrderFactory;
import tokoonlineanimepl.preorder.core.model.PreOrder;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class PreOrderServiceImpl extends PreOrderServiceComponent{

    public PreOrder createPreOrder(Map<String, Object> requestBody){
		String tanggal_rilis = (String) requestBody.get("tanggal_rilis");
		String status = (String) requestBody.get("status");
		String produk_ref = (String) requestBody.get("produk_ref");
		String akun_ref = (String) requestBody.get("akun_ref");
		
		//to do: fix association attributes
		
		PreOrder preorder = PreOrderFactory.createPreOrder("tokoonlineanimepl.preorder.core.model.PreOrderImpl", tanggal_rilis, status, produk_ref, akun_ref);
		Repository.saveObject(preorder);
		return preorder;
	}

    public PreOrder createPreOrder(Map<String, Object> requestBody, UUID id){	
		UUID id_preorder = id;
		String tanggal_rilis = (String) requestBody.get("tanggal_rilis");
		String status = (String) requestBody.get("status");
		String produk_ref = (String) requestBody.get("produk_ref");
		String akun_ref = (String) requestBody.get("akun_ref");
		
		//to do: fix association attributes
		PreOrder preorder = PreOrderFactory.createPreOrder("tokoonlineanimepl.preorder.core.model.PreOrderImpl",id_preorder, tanggal_rilis, status, produk_ref, akun_ref);
		Repository.saveObject(preorder);
		return preorder;
	}

    public HashMap<String, Object> updatePreOrder(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_preorder");
		UUID id = UUID.fromString(idStr);		
		PreOrder preorder = Repository.getObject(id);
		
		preorder.setTanggal_rilis((String) requestBody.get("tanggal_rilis"));
		preorder.setStatus((String) requestBody.get("status"));
		preorder.setProduk_ref((String) requestBody.get("produk_ref"));
		preorder.setAkun_ref((String) requestBody.get("akun_ref"));
		
		Repository.updateObject(preorder);
		
		//to do: fix association attributes
		
		return preorder.toHashMap();
		
	}

    public HashMap<String, Object> getPreOrder(String idStr){
		UUID id = UUID.fromString(idStr);		
		PreOrder preorder = Repository.getObject(id);
		return preorder.toHashMap();
	}

	public HashMap<String, Object> getPreOrderById(UUID id){
		List<HashMap<String, Object>> preorderList = getAllPreOrder();
		for (HashMap<String, Object> preorder : preorderList){
			UUID record_id = UUID.fromString((String) preorder.get("id_preorder"));
			if (record_id.equals(id)){
				return preorder;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllPreOrder(){
		List<PreOrder> List = Repository.getAllObject("preorder_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<PreOrder> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deletePreOrder(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id_preorder"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllPreOrder();
	}

}
