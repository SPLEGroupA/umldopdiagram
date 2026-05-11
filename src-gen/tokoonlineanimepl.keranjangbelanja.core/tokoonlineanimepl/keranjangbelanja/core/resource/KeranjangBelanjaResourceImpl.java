package tokoonlineanimepl.keranjangbelanja.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.keranjangbelanja.KeranjangBelanjaFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanja;
import tokoonlineanimepl.keranjangbelanja.core.service.KeranjangBelanjaServiceImpl;
//add other required packages


public class KeranjangBelanjaResourceImpl extends KeranjangBelanjaResourceComponent{
	
	private KeranjangBelanjaServiceImpl keranjangbelanjaServiceImpl = new KeranjangBelanjaServiceImpl();

	
    @Route(url="call/keranjangbelanja/save")
    public List<HashMap<String,Object>> saveKeranjangBelanja(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		KeranjangBelanja keranjangbelanja = createKeranjangBelanja(vmjExchange);
		return keranjangbelanjaServiceImpl.getAllKeranjangBelanja();
	}

    public KeranjangBelanja createKeranjangBelanja(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			KeranjangBelanja result = keranjangbelanjaServiceImpl.createKeranjangBelanja(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
    public KeranjangBelanja createKeranjangBelanja(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			KeranjangBelanja result = keranjangbelanjaServiceImpl.createKeranjangBelanja(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/keranjangbelanja/update")
    public HashMap<String, Object> updateKeranjangBelanja(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return keranjangbelanjaServiceImpl.updateKeranjangBelanja(requestBody);
		
	}

	
    @Route(url="call/keranjangbelanja/detail")
    public HashMap<String, Object> getKeranjangBelanja(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id_keranjang");
		return keranjangbelanjaServiceImpl.getKeranjangBelanja(idStr);
	}

	
    @Route(url="call/keranjangbelanja/list")
    public List<HashMap<String,Object>> getAllKeranjangBelanja(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return keranjangbelanjaServiceImpl.getAllKeranjangBelanja();
	}

	
    @Route(url="call/keranjangbelanja/delete")
    public List<HashMap<String,Object>> deleteKeranjangBelanja(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return keranjangbelanjaServiceImpl.deleteKeranjangBelanja(requestBody);
	}


	
	public boolean getByUser(String email) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	
	public boolean addItem(UUID id_cart_item) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	
	public boolean checkout() {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
