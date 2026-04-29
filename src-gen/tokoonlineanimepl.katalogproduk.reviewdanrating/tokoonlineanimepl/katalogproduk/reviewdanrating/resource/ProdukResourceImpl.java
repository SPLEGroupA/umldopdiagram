package tokoonlineanimepl.katalogproduk.reviewdanrating.resource;
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
import tokoonlineanimepl.katalogproduk.reviewdanrating.service.ProdukServiceImpl;

public class ProdukResourceImpl extends ProdukResourceDecorator {
	protected ProdukServiceComponent recordComponent;
	private ProdukServiceImpl katalogprodukreviewdanratingServiceImpl = new ProdukServiceImpl(recordComponent);

    public ProdukResourceImpl (ProdukResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/reviewdanrating/save")
    public List<HashMap<String,Object>> saveProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Produk katalogprodukreviewdanrating = createProduk(vmjExchange);
		return getAllProduk(vmjExchange);
	}

    public KatalogProduk createProduk(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Produk result = katalogprodukreviewdanratingServiceImpl.createProduk(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public KatalogProduk createProduk(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Produk result = katalogprodukreviewdanratingServiceImpl.createProduk(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/reviewdanrating/update")
    public HashMap<String, Object> updateProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return katalogprodukreviewdanratingServiceImpl.updateProduk(requestBody);
	}

	
    @Route(url="call/reviewdanrating/detail")
    public HashMap<String, Object> getProduk(VMJExchange vmjExchange){
		return record.getProduk(vmjExchange);
	}

	
    @Route(url="call/reviewdanrating/list")
    public List<HashMap<String,Object>> getAllProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return katalogprodukreviewdanratingServiceImpl.getAllProduk();
	}

    public List<HashMap<String,Object>> transformProdukListToHashMap(List<Produk> KatalogProdukReviewDanRatingList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < KatalogProdukReviewDanRatingList.size(); i++) {
            resultList.add(KatalogProdukReviewDanRatingList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/reviewdanrating/delete")
    public List<HashMap<String,Object>> deleteProduk(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return katalogprodukreviewdanratingServiceImpl.deleteProduk(requestBody);
	}

	protected boolean addReview(int rating) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
}
