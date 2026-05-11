package tokoonlineanimepl.katalogproduk.reviewdanrating.resource;
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
import tokoonlineanimepl.katalogproduk.reviewdanrating.service.KatalogProdukServiceImpl;

public class KatalogProdukResourceImpl extends KatalogProdukResourceDecorator {
	private KatalogProdukServiceComponent katalogprodukreviewdanratingServiceImpl;

    public KatalogProdukResourceImpl (KatalogProdukResourceComponent record, KatalogProdukServiceComponent recordService) {
        super(record);
		this.katalogprodukreviewdanratingServiceImpl = new KatalogProdukServiceImpl(recordService);
    }

    
    @Route(url="call/reviewdanrating/save")
    public List<HashMap<String,Object>> saveKatalogProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		KatalogProduk katalogprodukreviewdanrating = createKatalogProduk(vmjExchange);
		return getAllKatalogProduk(vmjExchange);
	}

    public KatalogProduk createKatalogProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			KatalogProduk result = katalogprodukreviewdanratingServiceImpl.createKatalogProduk(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public KatalogProduk createKatalogProduk(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			KatalogProduk result = katalogprodukreviewdanratingServiceImpl.createKatalogProduk(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/reviewdanrating/update")
    public HashMap<String, Object> updateKatalogProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return katalogprodukreviewdanratingServiceImpl.updateKatalogProduk(requestBody);
	}

	
    @Route(url="call/reviewdanrating/detail")
    public HashMap<String, Object> getKatalogProduk(VMJExchange vmjExchange){
		return record.getKatalogProduk(vmjExchange);
	}

	
    @Route(url="call/reviewdanrating/list")
    public List<HashMap<String,Object>> getAllKatalogProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return katalogprodukreviewdanratingServiceImpl.getAllKatalogProduk();
	}

    public List<HashMap<String,Object>> transformKatalogProdukListToHashMap(List<KatalogProduk> KatalogProdukReviewDanRatingList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < KatalogProdukReviewDanRatingList.size(); i++) {
            resultList.add(KatalogProdukReviewDanRatingList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/reviewdanrating/delete")
    public List<HashMap<String,Object>> deleteKatalogProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return katalogprodukreviewdanratingServiceImpl.deleteKatalogProduk(requestBody);
	}

	protected boolean addReview(UUID id_produk, int rating) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
}
