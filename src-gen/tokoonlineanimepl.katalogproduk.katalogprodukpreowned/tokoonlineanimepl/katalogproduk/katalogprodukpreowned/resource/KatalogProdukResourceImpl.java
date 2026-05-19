package tokoonlineanimepl.katalogproduk.katalogprodukpreowned.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import tokoonlineanimepl.katalogproduk.core.resource.KatalogProdukResourceDecorator;
import tokoonlineanimepl.katalogproduk.core.resource.KatalogProdukResourceComponent;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProdukImpl;
import tokoonlineanimepl.katalogproduk.core.service.KatalogProdukServiceComponent;
import tokoonlineanimepl.katalogproduk.katalogprodukpreowned.service.KatalogProdukServiceImpl;

public class KatalogProdukResourceImpl extends KatalogProdukResourceDecorator {
	private KatalogProdukServiceComponent katalogprodukkatalogprodukpreownedServiceImpl;

    public KatalogProdukResourceImpl (KatalogProdukResourceComponent record, KatalogProdukServiceComponent recordService) {
        super(record);
		this.katalogprodukkatalogprodukpreownedServiceImpl = new KatalogProdukServiceImpl(recordService);
    }

    
    @Route(url="call/katalogprodukpreowned/save")
    public List<HashMap<String,Object>> saveKatalogProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		KatalogProduk katalogprodukkatalogprodukpreowned = createKatalogProduk(vmjExchange);
		return getAllKatalogProduk(vmjExchange);
	}

    public KatalogProduk createKatalogProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			KatalogProduk result = katalogprodukkatalogprodukpreownedServiceImpl.createKatalogProduk(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public KatalogProduk createKatalogProduk(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			KatalogProduk result = katalogprodukkatalogprodukpreownedServiceImpl.createKatalogProduk(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/katalogprodukpreowned/update")
    public HashMap<String, Object> updateKatalogProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return katalogprodukkatalogprodukpreownedServiceImpl.updateKatalogProduk(requestBody);
	}

	
    @Route(url="call/katalogprodukpreowned/detail")
    public HashMap<String, Object> getKatalogProduk(VMJExchange vmjExchange){
		return record.getKatalogProduk(vmjExchange);
	}

	
    @Route(url="call/katalogprodukpreowned/list")
    public List<HashMap<String,Object>> getAllKatalogProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return katalogprodukkatalogprodukpreownedServiceImpl.getAllKatalogProduk();
	}

    public List<HashMap<String,Object>> transformKatalogProdukListToHashMap(List<KatalogProduk> KatalogProdukKatalogProdukPreOwnedList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < KatalogProdukKatalogProdukPreOwnedList.size(); i++) {
            resultList.add(KatalogProdukKatalogProdukPreOwnedList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/katalogprodukpreowned/delete")
    public List<HashMap<String,Object>> deleteKatalogProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return katalogprodukkatalogprodukpreownedServiceImpl.deleteKatalogProduk(requestBody);
	}

}
