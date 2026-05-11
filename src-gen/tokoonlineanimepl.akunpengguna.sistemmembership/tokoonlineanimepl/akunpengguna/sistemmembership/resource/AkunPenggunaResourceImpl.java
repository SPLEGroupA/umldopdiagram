package tokoonlineanimepl.akunpengguna.sistemmembership.resource;
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
import tokoonlineanimepl.akunpengguna.sistemmembership.service.AkunPenggunaServiceImpl;

public class AkunPenggunaResourceImpl extends AkunPenggunaResourceDecorator {
	private AkunPenggunaServiceComponent akunpenggunasistemmembershipServiceImpl;

    public AkunPenggunaResourceImpl (AkunPenggunaResourceComponent record, AkunPenggunaServiceComponent recordService) {
        super(record);
		this.akunpenggunasistemmembershipServiceImpl = new AkunPenggunaServiceImpl(recordService);
    }

    
    @Route(url="call/sistemmembership/save")
    public List<HashMap<String,Object>> saveAkunPengguna(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		AkunPengguna akunpenggunasistemmembership = createAkunPengguna(vmjExchange);
		return getAllAkunPengguna(vmjExchange);
	}

    public AkunPengguna createAkunPengguna(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AkunPengguna result = akunpenggunasistemmembershipServiceImpl.createAkunPengguna(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public AkunPengguna createAkunPengguna(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AkunPengguna result = akunpenggunasistemmembershipServiceImpl.createAkunPengguna(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/sistemmembership/update")
    public HashMap<String, Object> updateAkunPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return akunpenggunasistemmembershipServiceImpl.updateAkunPengguna(requestBody);
	}

	
    @Route(url="call/sistemmembership/detail")
    public HashMap<String, Object> getAkunPengguna(VMJExchange vmjExchange){
		return record.getAkunPengguna(vmjExchange);
	}

	
    @Route(url="call/sistemmembership/list")
    public List<HashMap<String,Object>> getAllAkunPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return akunpenggunasistemmembershipServiceImpl.getAllAkunPengguna();
	}

    public List<HashMap<String,Object>> transformAkunPenggunaListToHashMap(List<AkunPengguna> AkunPenggunaSistemMembershipList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < AkunPenggunaSistemMembershipList.size(); i++) {
            resultList.add(AkunPenggunaSistemMembershipList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/sistemmembership/delete")
    public List<HashMap<String,Object>> deleteAkunPengguna(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return akunpenggunasistemmembershipServiceImpl.deleteAkunPengguna(requestBody);
	}

	protected String checkMembership(UUID id_akun) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
}
