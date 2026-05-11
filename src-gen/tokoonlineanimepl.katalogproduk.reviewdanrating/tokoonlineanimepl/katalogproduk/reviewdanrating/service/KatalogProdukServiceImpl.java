package tokoonlineanimepl.katalogproduk.reviewdanrating.service;

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
		String average_ratingStr = (String) requestBody.get("average_rating");
		int average_rating = Integer.parseInt(average_ratingStr);
		String nama = (String) requestBody.get("nama");
		String hargaStr = (String) requestBody.get("harga");
		int harga = Integer.parseInt(hargaStr);
		String kategori = (String) requestBody.get("kategori");
		String deskripsi = (String) requestBody.get("deskripsi");
		String stokStr = (String) requestBody.get("stok");
		int stok = Integer.parseInt(stokStr);
		String gambar_url = (String) requestBody.get("gambar_url");
		KatalogProduk katalogprodukreviewdanrating = record.createKatalogProduk(requestBody);
		KatalogProduk katalogprodukreviewdanratingdeco = KatalogProdukFactory.createKatalogProduk("tokoonlineanimepl.katalogproduk.reviewdanrating.model.KatalogProdukImpl", katalogprodukreviewdanrating, average_rating);
		Repository.saveObject(katalogprodukreviewdanratingdeco);
		return katalogprodukreviewdanratingdeco;
	}

    public KatalogProduk createKatalogProduk(Map<String, Object> requestBody, UUID id){	
		KatalogProduk savedKatalogProduk = Repository.getObject(id);
		String average_ratingStr = (String) requestBody.get("average_rating");
		int average_rating = Integer.parseInt(average_ratingStr);
		UUID recordKatalogProdukId_produk = ((KatalogProdukDecorator) savedKatalogProduk).getId_produk();
		KatalogProduk katalogproduk = record.createKatalogProduk(requestBody, recordKatalogProdukId_produk);
		KatalogProduk katalogprodukreviewdanrating = KatalogProdukFactory.createKatalogProduk("tokoonlineanimepl.katalogproduk.reviewdanrating.KatalogProdukImpl", katalogproduk, average_rating);
		return katalogprodukreviewdanrating;
	}

    public HashMap<String, Object> updateKatalogProduk(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_produk");
		UUID id = UUID.fromString(idStr);
		
		KatalogProduk katalogprodukreviewdanrating = Repository.getObject(id);
		katalogprodukreviewdanrating = createKatalogProduk(requestBody, id);
		
		Repository.updateObject(katalogprodukreviewdanrating);
		katalogprodukreviewdanrating = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return katalogprodukreviewdanrating.toHashMap();
	}

	public HashMap<String, Object> getKatalogProduk(String idStr){
		UUID id = UUID.fromString(idStr);		
		KatalogProduk katalogprodukreviewdanrating = Repository.getObject(id);
		return katalogprodukreviewdanrating.toHashMap();
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
		List<KatalogProduk> List = Repository.getAllObject("katalogproduk_reviewdanrating");
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

	
	protected boolean addReview(UUID id_produk, int rating) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
