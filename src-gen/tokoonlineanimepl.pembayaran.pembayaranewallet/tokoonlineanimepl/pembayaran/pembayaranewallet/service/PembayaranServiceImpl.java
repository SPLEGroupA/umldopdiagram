package tokoonlineanimepl.pembayaran.pembayaranewallet.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import tokoonlineanimepl.pembayaran.core.service.PembayaranServiceDecorator;
import tokoonlineanimepl.pembayaran.core.model.PembayaranImpl;
import tokoonlineanimepl.pembayaran.core.service.PembayaranServiceComponent;
import tokoonlineanimepl.pembayaran.core.model.Pembayaran;
import tokoonlineanimepl.pembayaran.core.model.PembayaranDecorator;
import tokoonlineanimepl.pembayaran.PembayaranFactory;

public class PembayaranServiceImpl extends PembayaranServiceDecorator {
    public PembayaranServiceImpl (PembayaranServiceComponent record) {
        super(record);
    }

 	public Pembayaran createPembayaran(Map<String, Object> requestBody){
		String ewallet_provider = (String) requestBody.get("ewallet_provider");
		String metode = (String) requestBody.get("metode");
		String jumlahStr = (String) requestBody.get("jumlah");
		int jumlah = Integer.parseInt(jumlahStr);
		String status = (String) requestBody.get("status");
		String id_pesananStr = (String) requestBody.get("id_pesanan");
		int id_pesanan = Integer.parseInt(id_pesananStr);
		Pembayaran pembayaranpembayaranewallet = record.createPembayaran(requestBody);
		Pembayaran pembayaranpembayaranewalletdeco = PembayaranFactory.createPembayaran("tokoonlineanimepl.pembayaran.pembayaranewallet.model.PembayaranImpl", pembayaranpembayaranewallet, ewallet_provider);
		Repository.saveObject(pembayaranpembayaranewalletdeco);
		return pembayaranpembayaranewalletdeco;
	}

    public Pembayaran createPembayaran(Map<String, Object> requestBody, UUID id){	
		Pembayaran savedPembayaran = Repository.getObject(id);
		String ewallet_provider = (String) requestBody.get("ewallet_provider");
		UUID recordPembayaranId_pembayaran = ((PembayaranDecorator) savedPembayaran).getId_pembayaran();
		Pembayaran pembayaran = record.createPembayaran(requestBody, recordPembayaranId_pembayaran);
		Pembayaran pembayaranpembayaranewallet = PembayaranFactory.createPembayaran("tokoonlineanimepl.pembayaran.pembayaranewallet.PembayaranImpl", pembayaran, ewallet_provider);
		return pembayaranpembayaranewallet;
	}

    public HashMap<String, Object> updatePembayaran(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_pembayaran");
		UUID id = UUID.fromString(idStr);
		
		Pembayaran pembayaranpembayaranewallet = Repository.getObject(id);
		pembayaranpembayaranewallet = createPembayaran(requestBody, id);
		
		Repository.updateObject(pembayaranpembayaranewallet);
		pembayaranpembayaranewallet = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return pembayaranpembayaranewallet.toHashMap();
	}

	public HashMap<String, Object> getPembayaran(String idStr){
		UUID id = UUID.fromString(idStr);		
		Pembayaran pembayaranpembayaranewallet = Repository.getObject(id);
		return pembayaranpembayaranewallet.toHashMap();
	}

	public HashMap<String, Object> getPembayaranById(UUID id){
		List<HashMap<String, Object>> pembayaranList = getAllPembayaran();
		for (HashMap<String, Object> pembayaran : pembayaranList){
			UUID pembayaran_id = UUID.fromString((String) pembayaran.get("id_pembayaran"));
			if (pembayaran_id.equals(id)){
				return pembayaran;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllPembayaran(){
		List<Pembayaran> List = Repository.getAllObject("pembayaran_pembayaranewallet");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Pembayaran> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deletePembayaran(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id_pembayaran"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllPembayaran();
	}

	
	protected boolean payWithEWallet(UUID id_pembayaran, int amount) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
