package tokoonlineanimepl.pembayaran.pembayaranewallet.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import tokoonlineanimepl.pembayaran.core.resource.PembayaranResourceDecorator;
import tokoonlineanimepl.pembayaran.core.resource.PembayaranResourceComponent;
import tokoonlineanimepl.pembayaran.core.model.Pembayaran;
import tokoonlineanimepl.pembayaran.core.model.PembayaranImpl;
import tokoonlineanimepl.pembayaran.core.service.PembayaranServiceComponent;
import tokoonlineanimepl.pembayaran.pembayaranewallet.service.PembayaranServiceImpl;

public class PembayaranResourceImpl extends PembayaranResourceDecorator {
	protected PembayaranServiceComponent recordComponent;
	private PembayaranServiceImpl pembayaranpembayaranewalletServiceImpl = new PembayaranServiceImpl(recordComponent);

    public PembayaranResourceImpl (PembayaranResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/pembayaranewallet/save")
    public List<HashMap<String,Object>> savePembayaran(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Pembayaran pembayaranpembayaranewallet = createPembayaran(vmjExchange);
		return getAllPembayaran(vmjExchange);
	}

    public Pembayaran createPembayaran(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Pembayaran result = pembayaranpembayaranewalletServiceImpl.createPembayaran(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Pembayaran createPembayaran(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Pembayaran result = pembayaranpembayaranewalletServiceImpl.createPembayaran(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/pembayaranewallet/update")
    public HashMap<String, Object> updatePembayaran(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return pembayaranpembayaranewalletServiceImpl.updatePembayaran(requestBody);
	}

	
    @Route(url="call/pembayaranewallet/detail")
    public HashMap<String, Object> getPembayaran(VMJExchange vmjExchange){
		return record.getPembayaran(vmjExchange);
	}

	
    @Route(url="call/pembayaranewallet/list")
    public List<HashMap<String,Object>> getAllPembayaran(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return pembayaranpembayaranewalletServiceImpl.getAllPembayaran();
	}

    public List<HashMap<String,Object>> transformPembayaranListToHashMap(List<Pembayaran> PembayaranPembayaranEWalletList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < PembayaranPembayaranEWalletList.size(); i++) {
            resultList.add(PembayaranPembayaranEWalletList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/pembayaranewallet/delete")
    public List<HashMap<String,Object>> deletePembayaran(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return pembayaranpembayaranewalletServiceImpl.deletePembayaran(requestBody);
	}

	protected boolean payWithEWallet(int amount) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
}
