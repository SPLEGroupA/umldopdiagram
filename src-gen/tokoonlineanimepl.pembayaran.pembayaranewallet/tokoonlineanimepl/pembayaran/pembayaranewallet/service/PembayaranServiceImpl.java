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
		String id_pembayaranStr = (String) requestBody.get("id_pembayaran");
		int id_pembayaran = Integer.parseInt(id_pembayaranStr);
		String metode = (String) requestBody.get("metode");
		String jumlahStr = (String) requestBody.get("jumlah");
		int jumlah = Integer.parseInt(jumlahStr);
		String status = (String) requestBody.get("status");
		String id_pesananStr = (String) requestBody.get("id_pesanan");
		int id_pesanan = Integer.parseInt(id_pesananStr);
		Pembayaran pembayaranpembayaranewallet = record.createPembayaran(requestBody);
		Pembayaran pembayaranpembayaranewalletdeco = PembayaranFactory.createPembayaran("tokoonlineanimepl.pembayaran.pembayaranewallet", pembayaranpembayaranewallet, id_pembayaran, metode, jumlah, status, id_pesanan, ewallet_provider);
		Repository.saveObject(pembayaranpembayaranewalletdeco);
		return pembayaranpembayaranewalletdeco;
	}

	public Pembayaran createPembayaran(Map<String, Object> requestBody, int id){
		Pembayaran savedPembayaran = Repository.getObject(id);
		String ewallet_provider = (String) requestBody.get("ewallet_provider");
		String id_pembayaranStr = (String) requestBody.get("id_pembayaran");
		int id_pembayaran = Integer.parseInt(id_pembayaranStr);
		String metode = (String) requestBody.get("metode");
		String jumlahStr = (String) requestBody.get("jumlah");
		int jumlah = Integer.parseInt(jumlahStr);
		String status = (String) requestBody.get("status");
		String id_pesananStr = (String) requestBody.get("id_pesanan");
		int id_pesanan = Integer.parseInt(id_pesananStr);
		UUID recordPembayaran = ((PembayaranDecorator) savedPembayaran).get();
		Pembayaran Pembayaran = record.createPembayaran(requestBody, recordPembayaran);
		Pembayaran pembayaranpembayaranewallet = PembayaranFactory.createPembayaran("tokoonlineanimepl.pembayaran.pembayaranewallet.model.PembayaranImpl", Pembayaran, id_pembayaran, metode, jumlah, status, id_pesanan, ewallet_provider);
		return pembayaranpembayaranewallet;
	}

    public HashMap<String, Object> updatePembayaran(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		
		Pembayaran pembayaranpembayaranewallet = Repository.getObject(id);
		pembayaranpembayaranewallet = createPembayaran(requestBody, id);
		
		Repository.updateObject(pembayaranpembayaranewallet);
		pembayaranpembayaranewallet = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return pembayaranpembayaranewallet.toHashMap();
	}

	public HashMap<String, Object> getPembayaran(String idStr){
		int id = Integer.parseInt(idStr);
		Pembayaran pembayaranpembayaranewallet = Repository.getObject(id);
		return pembayaranpembayaranewallet.toHashMap();
	}

	public HashMap<String, Object> getPembayaranById(int id){
		List<HashMap<String, Object>> pembayaranList = getAllPembayaran();
		for (HashMap<String, Object> pembayaran : pembayaranList){
			int pembayaran_id = ((Double) pembayaran.get("")).intValue();
			if (pembayaran_id == id){
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
		String idStr = ((String) requestBody.get(""));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllPembayaran();
	}

	
	protected boolean payWithEWallet(int amount) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
