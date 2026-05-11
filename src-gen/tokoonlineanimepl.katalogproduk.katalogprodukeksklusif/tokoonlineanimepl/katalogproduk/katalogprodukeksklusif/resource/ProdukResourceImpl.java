package tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import tokoonlineanimepl.katalogproduk.core.resource.ProdukResourceDecorator;
import tokoonlineanimepl.katalogproduk.core.resource.ProdukResourceComponent;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;
import tokoonlineanimepl.katalogproduk.core.model.ProdukImpl;
import tokoonlineanimepl.katalogproduk.core.service.ProdukServiceComponent;
import tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.service.ProdukServiceImpl;

public class ProdukResourceImpl extends ProdukResourceDecorator {
	private ProdukServiceComponent katalogprodukkatalogprodukeksklusifServiceImpl;

    public ProdukResourceImpl (ProdukResourceComponent record, ProdukServiceComponent recordService) {
        super(record);
		this.katalogprodukkatalogprodukeksklusifServiceImpl = new ProdukServiceImpl(recordService);
    }

    
    @Route(url="call/katalogprodukeksklusif/save")
    public List<HashMap<String,Object>> saveProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Produk katalogprodukkatalogprodukeksklusif = createProduk(vmjExchange);
		return getAllProduk(vmjExchange);
	}

    public KatalogProduk createProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Produk result = katalogprodukkatalogprodukeksklusifServiceImpl.createProduk(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public KatalogProduk createProduk(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Produk result = katalogprodukkatalogprodukeksklusifServiceImpl.createProduk(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/katalogprodukeksklusif/update")
    public HashMap<String, Object> updateProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return katalogprodukkatalogprodukeksklusifServiceImpl.updateProduk(requestBody);
	}

	
    @Route(url="call/katalogprodukeksklusif/detail")
    public HashMap<String, Object> getProduk(VMJExchange vmjExchange){
		return record.getProduk(vmjExchange);
	}

	
    @Route(url="call/katalogprodukeksklusif/list")
    public List<HashMap<String,Object>> getAllProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return katalogprodukkatalogprodukeksklusifServiceImpl.getAllProduk();
	}

    public List<HashMap<String,Object>> transformProdukListToHashMap(List<Produk> KatalogProdukKatalogProdukEksklusifList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < KatalogProdukKatalogProdukEksklusifList.size(); i++) {
            resultList.add(KatalogProdukKatalogProdukEksklusifList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/katalogprodukeksklusif/delete")
    public List<HashMap<String,Object>> deleteProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return katalogprodukkatalogprodukeksklusifServiceImpl.deleteProduk(requestBody);
	}

	protected boolean checkEksklusif(UUID id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
}
