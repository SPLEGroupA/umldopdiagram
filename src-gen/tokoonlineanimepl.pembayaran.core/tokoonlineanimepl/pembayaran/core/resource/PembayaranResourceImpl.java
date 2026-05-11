package tokoonlineanimepl.pembayaran.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.pembayaran.PembayaranFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import tokoonlineanimepl.pembayaran.core.model.Pembayaran;
import tokoonlineanimepl.pembayaran.core.service.PembayaranServiceImpl;
//add other required packages


public class PembayaranResourceImpl extends PembayaranResourceComponent{
	
	private PembayaranServiceImpl pembayaranServiceImpl = new PembayaranServiceImpl();

	
    @Route(url="call/pembayaran/save")
    public List<HashMap<String,Object>> savePembayaran(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Pembayaran pembayaran = createPembayaran(vmjExchange);
		return pembayaranServiceImpl.getAllPembayaran();
	}

    public Pembayaran createPembayaran(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Pembayaran result = pembayaranServiceImpl.createPembayaran(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
    public Pembayaran createPembayaran(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Pembayaran result = pembayaranServiceImpl.createPembayaran(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/pembayaran/update")
    public HashMap<String, Object> updatePembayaran(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return pembayaranServiceImpl.updatePembayaran(requestBody);
		
	}

	
    @Route(url="call/pembayaran/detail")
    public HashMap<String, Object> getPembayaran(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id_pembayaran");
		return pembayaranServiceImpl.getPembayaran(idStr);
	}

	
    @Route(url="call/pembayaran/list")
    public List<HashMap<String,Object>> getAllPembayaran(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return pembayaranServiceImpl.getAllPembayaran();
	}

	
    @Route(url="call/pembayaran/delete")
    public List<HashMap<String,Object>> deletePembayaran(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return pembayaranServiceImpl.deletePembayaran(requestBody);
	}


}
