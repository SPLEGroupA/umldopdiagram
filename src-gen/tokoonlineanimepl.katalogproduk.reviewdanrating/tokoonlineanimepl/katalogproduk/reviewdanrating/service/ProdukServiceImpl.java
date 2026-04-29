package tokoonlineanimepl.katalogproduk.reviewdanrating.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import tokoonlineanimepl.katalogproduk.core.service.ProdukServiceDecorator;
import tokoonlineanimepl.katalogproduk.core.model.ProdukImpl;
import tokoonlineanimepl.katalogproduk.core.service.ProdukServiceComponent;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;
import tokoonlineanimepl.katalogproduk.core.model.ProdukDecorator;
import tokoonlineanimepl.katalogproduk.ProdukFactory;

public class ProdukServiceImpl extends ProdukServiceDecorator {
    public ProdukServiceImpl (ProdukServiceComponent record) {
        super(record);
    }

 	public Produk createProduk(Map<String, Object> requestBody){
		String average_ratingStr = (String) requestBody.get("average_rating");
		int average_rating = Integer.parseInt(average_ratingStr);
		String id_produkStr = (String) requestBody.get("id_produk");
		int id_produk = Integer.parseInt(id_produkStr);
		String nama = (String) requestBody.get("nama");
		String hargaStr = (String) requestBody.get("harga");
		int harga = Integer.parseInt(hargaStr);
		String kategori = (String) requestBody.get("kategori");
		String deskripsi = (String) requestBody.get("deskripsi");
		String stokStr = (String) requestBody.get("stok");
		int stok = Integer.parseInt(stokStr);
		String gambar_url = (String) requestBody.get("gambar_url");
		Produk katalogprodukreviewdanrating = record.createProduk(requestBody);
		Produk katalogprodukreviewdanratingdeco = ProdukFactory.createProduk("tokoonlineanimepl.katalogproduk.reviewdanrating", katalogprodukreviewdanrating, id_produk, nama, harga, kategori, deskripsi, stok, gambar_url, average_rating);
		Repository.saveObject(katalogprodukreviewdanratingdeco);
		return katalogprodukreviewdanratingdeco;
	}

	public Produk createProduk(Map<String, Object> requestBody, int id){
		Produk savedProduk = Repository.getObject(id);
		String average_ratingStr = (String) requestBody.get("average_rating");
		int average_rating = Integer.parseInt(average_ratingStr);
		String id_produkStr = (String) requestBody.get("id_produk");
		int id_produk = Integer.parseInt(id_produkStr);
		String nama = (String) requestBody.get("nama");
		String hargaStr = (String) requestBody.get("harga");
		int harga = Integer.parseInt(hargaStr);
		String kategori = (String) requestBody.get("kategori");
		String deskripsi = (String) requestBody.get("deskripsi");
		String stokStr = (String) requestBody.get("stok");
		int stok = Integer.parseInt(stokStr);
		String gambar_url = (String) requestBody.get("gambar_url");
		UUID recordProduk = ((ProdukDecorator) savedProduk).get();
		Produk Produk = record.createProduk(requestBody, recordProduk);
		Produk katalogprodukreviewdanrating = ProdukFactory.createProduk("tokoonlineanimepl.katalogproduk.reviewdanrating.model.ProdukImpl", Produk, id_produk, nama, harga, kategori, deskripsi, stok, gambar_url, average_rating);
		return katalogprodukreviewdanrating;
	}

    public HashMap<String, Object> updateProduk(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		
		Produk katalogprodukreviewdanrating = Repository.getObject(id);
		katalogprodukreviewdanrating = createProduk(requestBody, id);
		
		Repository.updateObject(katalogprodukreviewdanrating);
		katalogprodukreviewdanrating = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return katalogprodukreviewdanrating.toHashMap();
	}

	public HashMap<String, Object> getProduk(String idStr){
		int id = Integer.parseInt(idStr);
		Produk katalogprodukreviewdanrating = Repository.getObject(id);
		return katalogprodukreviewdanrating.toHashMap();
	}

	public HashMap<String, Object> getProdukById(int id){
		List<HashMap<String, Object>> produkList = getAllProduk();
		for (HashMap<String, Object> produk : produkList){
			int produk_id = ((Double) produk.get("")).intValue();
			if (produk_id == id){
				return produk;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllProduk(){
		List<Produk> List = Repository.getAllObject("katalogproduk_reviewdanrating");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Produk> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteProduk(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get(""));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllProduk();
	}

	
	protected boolean addReview(int rating) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
