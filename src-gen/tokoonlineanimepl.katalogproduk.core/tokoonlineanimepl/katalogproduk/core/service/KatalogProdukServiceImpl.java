package tokoonlineanimepl.katalogproduk.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.katalogproduk.KatalogProdukFactory;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class KatalogProdukServiceImpl extends KatalogProdukServiceComponent{

    public KatalogProduk createKatalogProduk(Map<String, Object> requestBody){
		String nama = (String) requestBody.get("nama");
		String hargaStr = (String) requestBody.get("harga");
		int harga = Integer.parseInt(hargaStr);
		String kategori = (String) requestBody.get("kategori");
		String deskripsi = (String) requestBody.get("deskripsi");
		String stokStr = (String) requestBody.get("stok");
		int stok = Integer.parseInt(stokStr);
		String gambar_url = (String) requestBody.get("gambar_url");
		
		//to do: fix association attributes
		
		KatalogProduk katalogproduk = KatalogProdukFactory.createKatalogProduk("tokoonlineanimepl.katalogproduk.core.model.KatalogProdukImpl", nama, harga, kategori, deskripsi, stok, gambar_url);
		Repository.saveObject(katalogproduk);
		return katalogproduk;
	}

    public KatalogProduk createKatalogProduk(Map<String, Object> requestBody, UUID id){	
		UUID id_produk = id;
		String nama = (String) requestBody.get("nama");
		String hargaStr = (String) requestBody.get("harga");
		int harga = Integer.parseInt(hargaStr);
		String kategori = (String) requestBody.get("kategori");
		String deskripsi = (String) requestBody.get("deskripsi");
		String stokStr = (String) requestBody.get("stok");
		int stok = Integer.parseInt(stokStr);
		String gambar_url = (String) requestBody.get("gambar_url");
		
		//to do: fix association attributes
		KatalogProduk katalogproduk = KatalogProdukFactory.createKatalogProduk("tokoonlineanimepl.katalogproduk.core.model.KatalogProdukImpl",id_produk, nama, harga, kategori, deskripsi, stok, gambar_url);
		Repository.saveObject(katalogproduk);
		return katalogproduk;
	}

    public HashMap<String, Object> updateKatalogProduk(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_produk");
		UUID id = UUID.fromString(idStr);		
		KatalogProduk katalogproduk = Repository.getObject(id);
		
		katalogproduk.setNama((String) requestBody.get("nama"));
		String hargaStr = (String) requestBody.get("harga");
		katalogproduk.setHarga(Integer.parseInt(hargaStr));
		
		katalogproduk.setKategori((String) requestBody.get("kategori"));
		katalogproduk.setDeskripsi((String) requestBody.get("deskripsi"));
		String stokStr = (String) requestBody.get("stok");
		katalogproduk.setStok(Integer.parseInt(stokStr));
		
		katalogproduk.setGambar_url((String) requestBody.get("gambar_url"));
		
		Repository.updateObject(katalogproduk);
		
		//to do: fix association attributes
		
		return katalogproduk.toHashMap();
		
	}

    public HashMap<String, Object> getKatalogProduk(String idStr){
		UUID id = UUID.fromString(idStr);		
		KatalogProduk katalogproduk = Repository.getObject(id);
		return katalogproduk.toHashMap();
	}

	public HashMap<String, Object> getKatalogProdukById(UUID id){
		List<HashMap<String, Object>> katalogprodukList = getAllKatalogProduk();
		for (HashMap<String, Object> katalogproduk : katalogprodukList){
			UUID record_id = UUID.fromString((String) katalogproduk.get("id_produk"));
			if (record_id.equals(id)){
				return katalogproduk;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllKatalogProduk(){
		List<KatalogProduk> List = Repository.getAllObject("katalogproduk_impl");
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

}
