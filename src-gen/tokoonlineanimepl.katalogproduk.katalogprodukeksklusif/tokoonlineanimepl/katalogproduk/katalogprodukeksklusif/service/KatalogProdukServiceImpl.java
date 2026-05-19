package tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import tokoonlineanimepl.katalogproduk.core.service.KatalogProdukServiceDecorator;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProdukImpl;
import tokoonlineanimepl.katalogproduk.core.service.KatalogProdukServiceComponent;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProdukDecorator;
import tokoonlineanimepl.katalogproduk.KatalogProdukFactory;

public class KatalogProdukServiceImpl extends KatalogProdukServiceDecorator {
    public KatalogProdukServiceImpl (KatalogProdukServiceComponent record) {
        super(record);
    }

 	public KatalogProduk createKatalogProduk(Map<String, Object> requestBody){
		String label_eksklusif = (String) requestBody.get("label_eksklusif");
		String nama = (String) requestBody.get("nama");
		String hargaStr = (String) requestBody.get("harga");
		int harga = Integer.parseInt(hargaStr);
		String kategori = (String) requestBody.get("kategori");
		String deskripsi = (String) requestBody.get("deskripsi");
		String stokStr = (String) requestBody.get("stok");
		int stok = Integer.parseInt(stokStr);
		String gambar_url = (String) requestBody.get("gambar_url");
		KatalogProduk katalogprodukkatalogprodukeksklusif = record.createKatalogProduk(requestBody);
		KatalogProduk katalogprodukkatalogprodukeksklusifdeco = KatalogProdukFactory.createKatalogProduk("tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.model.KatalogProdukImpl", katalogprodukkatalogprodukeksklusif, label_eksklusif);
		Repository.saveObject(katalogprodukkatalogprodukeksklusifdeco);
		return katalogprodukkatalogprodukeksklusifdeco;
	}

    public KatalogProduk createKatalogProduk(Map<String, Object> requestBody, UUID id){	
		KatalogProduk savedKatalogProduk = Repository.getObject(id);
		String label_eksklusif = (String) requestBody.get("label_eksklusif");
		UUID recordKatalogProdukId_produk = ((KatalogProdukDecorator) savedKatalogProduk).getId_produk();
		KatalogProduk katalogproduk = record.createKatalogProduk(requestBody, recordKatalogProdukId_produk);
		KatalogProduk katalogprodukkatalogprodukeksklusif = KatalogProdukFactory.createKatalogProduk("tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.KatalogProdukImpl", katalogproduk, label_eksklusif);
		return katalogprodukkatalogprodukeksklusif;
	}

    public HashMap<String, Object> updateKatalogProduk(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_produk");
		UUID id = UUID.fromString(idStr);
		
		KatalogProduk katalogprodukkatalogprodukeksklusif = Repository.getObject(id);
		katalogprodukkatalogprodukeksklusif = createKatalogProduk(requestBody, id);
		
		Repository.updateObject(katalogprodukkatalogprodukeksklusif);
		katalogprodukkatalogprodukeksklusif = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return katalogprodukkatalogprodukeksklusif.toHashMap();
	}

	public HashMap<String, Object> getKatalogProduk(String idStr){
		UUID id = UUID.fromString(idStr);		
		KatalogProduk katalogprodukkatalogprodukeksklusif = Repository.getObject(id);
		return katalogprodukkatalogprodukeksklusif.toHashMap();
	}

	public HashMap<String, Object> getKatalogProdukById(UUID id){
		List<HashMap<String, Object>> katalogprodukList = getAllKatalogProduk();
		for (HashMap<String, Object> katalogproduk : katalogprodukList){
			UUID katalogproduk_id = UUID.fromString((String) katalogproduk.get("id_produk"));
			if (katalogproduk_id.equals(id)){
				return katalogproduk;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllKatalogProduk(){
		List<KatalogProduk> List = Repository.getAllObject("katalogproduk_katalogprodukeksklusif");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<KatalogProduk> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteKatalogProduk(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id_produk"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllKatalogProduk();
	}

	
	protected boolean checkEksklusif(UUID id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
