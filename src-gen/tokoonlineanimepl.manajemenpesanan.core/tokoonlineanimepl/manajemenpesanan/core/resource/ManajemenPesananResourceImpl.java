package tokoonlineanimepl.manajemenpesanan.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.manajemenpesanan.ManajemenPesananFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesanan;
import tokoonlineanimepl.manajemenpesanan.core.service.ManajemenPesananServiceImpl;
//add other required packages


public class ManajemenPesananResourceImpl extends ManajemenPesananResourceComponent{
	
	private ManajemenPesananServiceImpl manajemenpesananServiceImpl = new ManajemenPesananServiceImpl();

	
    @Route(url="call/manajemenpesanan/save")
    public List<HashMap<String,Object>> saveManajemenPesanan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		ManajemenPesanan manajemenpesanan = createManajemenPesanan(vmjExchange);
		return manajemenpesananServiceImpl.getAllManajemenPesanan();
	}

    public ManajemenPesanan createManajemenPesanan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ManajemenPesanan result = manajemenpesananServiceImpl.createManajemenPesanan(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
    public ManajemenPesanan createManajemenPesanan(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ManajemenPesanan result = manajemenpesananServiceImpl.createManajemenPesanan(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/manajemenpesanan/update")
    public HashMap<String, Object> updateManajemenPesanan(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return manajemenpesananServiceImpl.updateManajemenPesanan(requestBody);
		
	}

	
    @Route(url="call/manajemenpesanan/detail")
    public HashMap<String, Object> getManajemenPesanan(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id_pesanan");
		return manajemenpesananServiceImpl.getManajemenPesanan(idStr);
	}

	
    @Route(url="call/manajemenpesanan/list")
    public List<HashMap<String,Object>> getAllManajemenPesanan(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return manajemenpesananServiceImpl.getAllManajemenPesanan();
	}

	
    @Route(url="call/manajemenpesanan/delete")
    public List<HashMap<String,Object>> deleteManajemenPesanan(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return manajemenpesananServiceImpl.deleteManajemenPesanan(requestBody);
	}


	
	public boolean getByUser(String email) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
