package tokoonlineanimepl.akunpengguna.sistempoinloyalitas.resource;
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
import tokoonlineanimepl.akunpengguna.sistempoinloyalitas.service.AkunPenggunaServiceImpl;

public class AkunPenggunaResourceImpl extends AkunPenggunaResourceDecorator {
	protected AkunPenggunaServiceComponent recordComponent;
	private AkunPenggunaServiceImpl akunpenggunasistempoinloyalitasServiceImpl = new AkunPenggunaServiceImpl(recordComponent);

    public AkunPenggunaResourceImpl (AkunPenggunaResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/sistempoinloyalitas/save")
    public List<HashMap<String,Object>> saveAkunPengguna(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		AkunPengguna akunpenggunasistempoinloyalitas = createAkunPengguna(vmjExchange);
		return getAllAkunPengguna(vmjExchange);
	}

    public AkunPengguna createAkunPengguna(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AkunPengguna result = akunpenggunasistempoinloyalitasServiceImpl.createAkunPengguna(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public AkunPengguna createAkunPengguna(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AkunPengguna result = akunpenggunasistempoinloyalitasServiceImpl.createAkunPengguna(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/sistempoinloyalitas/update")
    public HashMap<String, Object> updateAkunPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return akunpenggunasistempoinloyalitasServiceImpl.updateAkunPengguna(requestBody);
	}

	
    @Route(url="call/sistempoinloyalitas/detail")
    public HashMap<String, Object> getAkunPengguna(VMJExchange vmjExchange){
		return record.getAkunPengguna(vmjExchange);
	}

	
    @Route(url="call/sistempoinloyalitas/list")
    public List<HashMap<String,Object>> getAllAkunPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return akunpenggunasistempoinloyalitasServiceImpl.getAllAkunPengguna();
	}

    public List<HashMap<String,Object>> transformAkunPenggunaListToHashMap(List<AkunPengguna> AkunPenggunaSistemPoinLoyalitasList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < AkunPenggunaSistemPoinLoyalitasList.size(); i++) {
            resultList.add(AkunPenggunaSistemPoinLoyalitasList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/sistempoinloyalitas/delete")
    public List<HashMap<String,Object>> deleteAkunPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return akunpenggunasistempoinloyalitasServiceImpl.deleteAkunPengguna(requestBody);
	}

	protected boolean redeemPoin(int jumlah_poin) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
}
