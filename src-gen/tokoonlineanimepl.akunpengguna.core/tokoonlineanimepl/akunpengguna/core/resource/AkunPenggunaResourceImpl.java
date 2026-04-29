package tokoonlineanimepl.akunpengguna.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.akunpengguna.AkunPenggunaFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;
import tokoonlineanimepl.akunpengguna.core.service.AkunPenggunaServiceImpl;
//add other required packages


public class AkunPenggunaResourceImpl extends AkunPenggunaResourceComponent{
	
	private AkunPenggunaServiceImpl akunpenggunaServiceImpl = new AkunPenggunaServiceImpl();

	
    @Route(url="call/akunpengguna/save")
    public List<HashMap<String,Object>> saveAkunPengguna(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		AkunPengguna akunpengguna = createAkunPengguna(vmjExchange);
		return akunpenggunaServiceImpl.getAllAkunPengguna();
	}

    public AkunPengguna createAkunPengguna(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AkunPengguna result = akunpenggunaServiceImpl.createAkunPengguna(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public AkunPengguna createAkunPengguna(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AkunPengguna result = akunpenggunaServiceImpl.createAkunPengguna(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/akunpengguna/update")
    public HashMap<String, Object> updateAkunPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return akunpenggunaServiceImpl.updateAkunPengguna(requestBody);
		
	}

	
    @Route(url="call/akunpengguna/detail")
    public HashMap<String, Object> getAkunPengguna(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("");
		return akunpenggunaServiceImpl.getAkunPengguna(idStr);
	}

	
    @Route(url="call/akunpengguna/list")
    public List<HashMap<String,Object>> getAllAkunPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return akunpenggunaServiceImpl.getAllAkunPengguna();
	}

	
    @Route(url="call/akunpengguna/delete")
    public List<HashMap<String,Object>> deleteAkunPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return akunpenggunaServiceImpl.deleteAkunPengguna(requestBody);
	}


}
