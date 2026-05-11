package tokoonlineanimepl.akunpengguna.wishlist.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import tokoonlineanimepl.akunpengguna.core.resource.AkunPenggunaResourceDecorator;
import tokoonlineanimepl.akunpengguna.core.resource.AkunPenggunaResourceComponent;
import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;
import tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaImpl;
import tokoonlineanimepl.akunpengguna.core.service.AkunPenggunaServiceComponent;
import tokoonlineanimepl.akunpengguna.wishlist.service.AkunPenggunaServiceImpl;

public class AkunPenggunaResourceImpl extends AkunPenggunaResourceDecorator {
	private AkunPenggunaServiceComponent akunpenggunawishlistServiceImpl;

    public AkunPenggunaResourceImpl (AkunPenggunaResourceComponent record, AkunPenggunaServiceComponent recordService) {
        super(record);
		this.akunpenggunawishlistServiceImpl = new AkunPenggunaServiceImpl(recordService);
    }

    
    @Route(url="call/wishlist/save")
    public List<HashMap<String,Object>> saveAkunPengguna(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		AkunPengguna akunpenggunawishlist = createAkunPengguna(vmjExchange);
		return getAllAkunPengguna(vmjExchange);
	}

    public AkunPengguna createAkunPengguna(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AkunPengguna result = akunpenggunawishlistServiceImpl.createAkunPengguna(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public AkunPengguna createAkunPengguna(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AkunPengguna result = akunpenggunawishlistServiceImpl.createAkunPengguna(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/wishlist/update")
    public HashMap<String, Object> updateAkunPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return akunpenggunawishlistServiceImpl.updateAkunPengguna(requestBody);
	}

	
    @Route(url="call/wishlist/detail")
    public HashMap<String, Object> getAkunPengguna(VMJExchange vmjExchange){
		return record.getAkunPengguna(vmjExchange);
	}

	
    @Route(url="call/wishlist/list")
    public List<HashMap<String,Object>> getAllAkunPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return akunpenggunawishlistServiceImpl.getAllAkunPengguna();
	}

    public List<HashMap<String,Object>> transformAkunPenggunaListToHashMap(List<AkunPengguna> AkunPenggunaWishlistList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < AkunPenggunaWishlistList.size(); i++) {
            resultList.add(AkunPenggunaWishlistList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/wishlist/delete")
    public List<HashMap<String,Object>> deleteAkunPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return akunpenggunawishlistServiceImpl.deleteAkunPengguna(requestBody);
	}

	protected boolean addToWishlist(UUID id_akun, UUID id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	protected boolean removeFromWishlist(UUID id_akun, UUID id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
}
