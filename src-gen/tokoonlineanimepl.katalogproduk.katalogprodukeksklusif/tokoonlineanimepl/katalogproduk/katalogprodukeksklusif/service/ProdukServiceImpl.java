package tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.service;

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
		boolean is_eksklusif = (boolean) requestBody.get("is_eksklusif");
		String nama = (String) requestBody.get("nama");
		String hargaStr = (String) requestBody.get("harga");
		int harga = Integer.parseInt(hargaStr);
		String kategori = (String) requestBody.get("kategori");
		String deskripsi = (String) requestBody.get("deskripsi");
		String stokStr = (String) requestBody.get("stok");
		int stok = Integer.parseInt(stokStr);
		String gambar_url = (String) requestBody.get("gambar_url");
		Produk katalogprodukkatalogprodukeksklusif = record.createProduk(requestBody);
		Produk katalogprodukkatalogprodukeksklusifdeco = ProdukFactory.createProduk("tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.model.ProdukImpl", katalogprodukkatalogprodukeksklusif, is_eksklusif);
		Repository.saveObject(katalogprodukkatalogprodukeksklusifdeco);
		return katalogprodukkatalogprodukeksklusifdeco;
	}

    public Produk createProduk(Map<String, Object> requestBody, UUID id){	
		Produk savedProduk = Repository.getObject(id);
		boolean is_eksklusif = (boolean) requestBody.get("is_eksklusif");
		UUID recordProdukId_produk = ((ProdukDecorator) savedProduk).getId_produk();
		Produk produk = record.createProduk(requestBody, recordProdukId_produk);
		Produk katalogprodukkatalogprodukeksklusif = ProdukFactory.createProduk("tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.ProdukImpl", produk, is_eksklusif);
		return katalogprodukkatalogprodukeksklusif;
	}

    public HashMap<String, Object> updateProduk(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_produk");
		UUID id = UUID.fromString(idStr);
		
		Produk katalogprodukkatalogprodukeksklusif = Repository.getObject(id);
		katalogprodukkatalogprodukeksklusif = createProduk(requestBody, id);
		
		Repository.updateObject(katalogprodukkatalogprodukeksklusif);
		katalogprodukkatalogprodukeksklusif = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return katalogprodukkatalogprodukeksklusif.toHashMap();
	}

	public HashMap<String, Object> getProduk(String idStr){
		UUID id = UUID.fromString(idStr);		
		Produk katalogprodukkatalogprodukeksklusif = Repository.getObject(id);
		return katalogprodukkatalogprodukeksklusif.toHashMap();
	}

	public HashMap<String, Object> getProdukById(UUID id){
		List<HashMap<String, Object>> produkList = getAllProduk();
		for (HashMap<String, Object> produk : produkList){
			UUID produk_id = UUID.fromString((String) produk.get("id_produk"));
			if (produk_id.equals(id)){
				return produk;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllProduk(){
		List<Produk> List = Repository.getAllObject("katalogproduk_katalogprodukeksklusif");
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
		String idStr = ((String) requestBody.get("id_produk"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllProduk();
	}

	
	protected boolean checkEksklusif(UUID id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
