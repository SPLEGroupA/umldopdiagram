package tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.resource;
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
import tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.service.KatalogProdukServiceImpl;

public class KatalogProdukResourceImpl extends KatalogProdukResourceDecorator {
	private KatalogProdukServiceComponent katalogprodukkatalogprodukeksklusifServiceImpl;

    public KatalogProdukResourceImpl (KatalogProdukResourceComponent record, KatalogProdukServiceComponent recordService) {
        super(record);
		this.katalogprodukkatalogprodukeksklusifServiceImpl = new KatalogProdukServiceImpl(recordService);
    }

    
    @Route(url="call/katalogprodukeksklusif/save")
    public List<HashMap<String,Object>> saveKatalogProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		KatalogProduk katalogprodukkatalogprodukeksklusif = createKatalogProduk(vmjExchange);
		return getAllKatalogProduk(vmjExchange);
	}

    public KatalogProduk createKatalogProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			KatalogProduk result = katalogprodukkatalogprodukeksklusifServiceImpl.createKatalogProduk(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public KatalogProduk createKatalogProduk(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			KatalogProduk result = katalogprodukkatalogprodukeksklusifServiceImpl.createKatalogProduk(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/katalogprodukeksklusif/update")
    public HashMap<String, Object> updateKatalogProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return katalogprodukkatalogprodukeksklusifServiceImpl.updateKatalogProduk(requestBody);
	}

	
    @Route(url="call/katalogprodukeksklusif/detail")
    public HashMap<String, Object> getKatalogProduk(VMJExchange vmjExchange){
		return record.getKatalogProduk(vmjExchange);
	}

	
    @Route(url="call/katalogprodukeksklusif/list")
    public List<HashMap<String,Object>> getAllKatalogProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return katalogprodukkatalogprodukeksklusifServiceImpl.getAllKatalogProduk();
	}

    public List<HashMap<String,Object>> transformKatalogProdukListToHashMap(List<KatalogProduk> KatalogProdukKatalogProdukEksklusifList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < KatalogProdukKatalogProdukEksklusifList.size(); i++) {
            resultList.add(KatalogProdukKatalogProdukEksklusifList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/katalogprodukeksklusif/delete")
    public List<HashMap<String,Object>> deleteKatalogProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return katalogprodukkatalogprodukeksklusifServiceImpl.deleteKatalogProduk(requestBody);
	}

	protected boolean checkEksklusif(UUID id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
}
