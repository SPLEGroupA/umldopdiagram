package tokoonlineanimepl.katalogproduk.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.katalogproduk.ProdukFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import tokoonlineanimepl.katalogproduk.core.model.Produk;
import tokoonlineanimepl.katalogproduk.core.service.ProdukServiceImpl;
//add other required packages


public class ProdukResourceImpl extends ProdukResourceComponent{
	
	private ProdukServiceImpl produkServiceImpl = new ProdukServiceImpl();

	
    @Route(url="call/katalogproduk/save")
    public List<HashMap<String,Object>> saveProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Produk produk = createProduk(vmjExchange);
		return produkServiceImpl.getAllProduk();
	}

    public Produk createProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Produk result = produkServiceImpl.createProduk(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Produk createProduk(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Produk result = produkServiceImpl.createProduk(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/katalogproduk/update")
    public HashMap<String, Object> updateProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return produkServiceImpl.updateProduk(requestBody);
		
	}

	
    @Route(url="call/katalogproduk/detail")
    public HashMap<String, Object> getProduk(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("");
		return produkServiceImpl.getProduk(idStr);
	}

	
    @Route(url="call/katalogproduk/list")
    public List<HashMap<String,Object>> getAllProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return produkServiceImpl.getAllProduk();
	}

	
    @Route(url="call/katalogproduk/delete")
    public List<HashMap<String,Object>> deleteProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return produkServiceImpl.deleteProduk(requestBody);
	}


}
