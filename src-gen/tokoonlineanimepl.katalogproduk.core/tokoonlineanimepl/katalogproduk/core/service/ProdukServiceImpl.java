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
import tokoonlineanimepl.katalogproduk.ProdukFactory;
import tokoonlineanimepl.katalogproduk.core.model.Produk;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class ProdukServiceImpl extends ProdukServiceComponent{

    public Produk createProduk(Map<String, Object> requestBody){
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
		
		//to do: fix association attributes
		
		Produk produk = ProdukFactory.createProduk("tokoonlineanimepl.katalogproduk.core.model.ProdukImpl", id_produk, nama, harga, kategori, deskripsi, stok, gambar_url);
		Repository.saveObject(produk);
		return produk;
	}

	public Produk createProduk(Map<String, Object> requestBody, int id){
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
		
		//to do: fix association attributes
		Produk produk = ProdukFactory.createProduk("tokoonlineanimepl.katalogproduk.core.model.ProdukImpl",id_produk, nama, harga, kategori, deskripsi, stok, gambar_url);
		Repository.saveObject(produk);
		return produk;
	}

    public HashMap<String, Object> updateProduk(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		Produk produk = Repository.getObject(id);
		
		String id_produkStr = (String) requestBody.get("id_produk");
		produk.setId_produk(Integer.parseInt(id_produkStr));
		
		produk.setNama((String) requestBody.get("nama"));
		String hargaStr = (String) requestBody.get("harga");
		produk.setHarga(Integer.parseInt(hargaStr));
		
		produk.setKategori((String) requestBody.get("kategori"));
		produk.setDeskripsi((String) requestBody.get("deskripsi"));
		String stokStr = (String) requestBody.get("stok");
		produk.setStok(Integer.parseInt(stokStr));
		
		produk.setGambar_url((String) requestBody.get("gambar_url"));
		
		Repository.updateObject(produk);
		
		//to do: fix association attributes
		
		return produk.toHashMap();
		
	}

    public HashMap<String, Object> getProduk(String idStr){
		int id = Integer.parseInt(idStr);
		Produk produk = Repository.getObject(id);
		return produk.toHashMap();
	}

	public HashMap<String, Object> getProdukById(int id){
		List<HashMap<String, Object>> produkList = getAllProduk();
		for (HashMap<String, Object> produk : produkList){
			int record_id = ((Double) produk.get("")).intValue();
			if (record_id == id){
				return produk;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllProduk(){
		List<Produk> List = Repository.getAllObject("produk_impl");
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

}
