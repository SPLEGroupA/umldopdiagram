package tokoonlineanimepl.katalogproduk.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.katalogproduk.KatalogProdukFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;
import tokoonlineanimepl.katalogproduk.core.service.KatalogProdukServiceImpl;
//add other required packages


public class KatalogProdukResourceImpl extends KatalogProdukResourceComponent{
	
	private KatalogProdukServiceImpl katalogprodukServiceImpl = new KatalogProdukServiceImpl();

	
    @Route(url="call/katalogproduk/save")
    public List<HashMap<String,Object>> saveKatalogProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		KatalogProduk katalogproduk = createKatalogProduk(vmjExchange);
		return katalogprodukServiceImpl.getAllKatalogProduk();
	}

    public KatalogProduk createKatalogProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			KatalogProduk result = katalogprodukServiceImpl.createKatalogProduk(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
    public KatalogProduk createKatalogProduk(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			KatalogProduk result = katalogprodukServiceImpl.createKatalogProduk(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/katalogproduk/update")
    public HashMap<String, Object> updateKatalogProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return katalogprodukServiceImpl.updateKatalogProduk(requestBody);
		
	}

	
    @Route(url="call/katalogproduk/detail")
    public HashMap<String, Object> getKatalogProduk(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id_produk");
		return katalogprodukServiceImpl.getKatalogProduk(idStr);
	}

	
    @Route(url="call/katalogproduk/list")
    public List<HashMap<String,Object>> getAllKatalogProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return katalogprodukServiceImpl.getAllKatalogProduk();
	}

	
    @Route(url="call/katalogproduk/delete")
    public List<HashMap<String,Object>> deleteKatalogProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return katalogprodukServiceImpl.deleteKatalogProduk(requestBody);
	}


}
