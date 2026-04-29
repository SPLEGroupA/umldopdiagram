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
		String id_preorderStr = (String) requestBody.get("id_preorder");
		int id_preorder = Integer.parseInt(id_preorderStr);
		String tanggal_rilis = (String) requestBody.get("tanggal_rilis");
		String status = (String) requestBody.get("status");
		
		//to do: fix association attributes
		
		PreOrder preorder = PreOrderFactory.createPreOrder("tokoonlineanimepl.preorder.core.model.PreOrderImpl", id_preorder, tanggal_rilis, status, produk, akunPengguna);
		Repository.saveObject(preorder);
		return preorder;
	}

	public PreOrder createPreOrder(Map<String, Object> requestBody, int id){
		String id_preorderStr = (String) requestBody.get("id_preorder");
		int id_preorder = Integer.parseInt(id_preorderStr);
		String tanggal_rilis = (String) requestBody.get("tanggal_rilis");
		String status = (String) requestBody.get("status");
		
		//to do: fix association attributes
		PreOrder preorder = PreOrderFactory.createPreOrder("tokoonlineanimepl.preorder.core.model.PreOrderImpl",id_preorder, tanggal_rilis, status, produk, akunPengguna);
		Repository.saveObject(preorder);
		return preorder;
	}

    public HashMap<String, Object> updatePreOrder(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		PreOrder preorder = Repository.getObject(id);
		
		String id_preorderStr = (String) requestBody.get("id_preorder");
		preorder.setId_preorder(Integer.parseInt(id_preorderStr));
		
		preorder.setTanggal_rilis((String) requestBody.get("tanggal_rilis"));
		preorder.setStatus((String) requestBody.get("status"));
		
		Repository.updateObject(preorder);
		
		//to do: fix association attributes
		
		return preorder.toHashMap();
		
	}

    public HashMap<String, Object> getPreOrder(String idStr){
		int id = Integer.parseInt(idStr);
		PreOrder preorder = Repository.getObject(id);
		return preorder.toHashMap();
	}

	public HashMap<String, Object> getPreOrderById(int id){
		List<HashMap<String, Object>> preorderList = getAllPreOrder();
		for (HashMap<String, Object> preorder : preorderList){
			int record_id = ((Double) preorder.get("")).intValue();
			if (record_id == id){
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
		String idStr = ((String) requestBody.get(""));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllPreOrder();
	}

}
