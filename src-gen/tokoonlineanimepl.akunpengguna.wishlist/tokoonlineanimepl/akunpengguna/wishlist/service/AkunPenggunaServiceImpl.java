package tokoonlineanimepl.akunpengguna.wishlist.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import tokoonlineanimepl.akunpengguna.core.service.AkunPenggunaServiceDecorator;
import tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaImpl;
import tokoonlineanimepl.akunpengguna.core.service.AkunPenggunaServiceComponent;
import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;
import tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaDecorator;
import tokoonlineanimepl.akunpengguna.AkunPenggunaFactory;

public class AkunPenggunaServiceImpl extends AkunPenggunaServiceDecorator {
    public AkunPenggunaServiceImpl (AkunPenggunaServiceComponent record) {
        super(record);
    }

 	public AkunPengguna createAkunPengguna(Map<String, Object> requestBody){
		String id_akunStr = (String) requestBody.get("id_akun");
		int id_akun = Integer.parseInt(id_akunStr);
		String email = (String) requestBody.get("email");
		String nama = (String) requestBody.get("nama");
		String alamat = (String) requestBody.get("alamat");
		String no_telepon = (String) requestBody.get("no_telepon");
		AkunPengguna akunpenggunawishlist = record.createAkunPengguna(requestBody);
		AkunPengguna akunpenggunawishlistdeco = AkunPenggunaFactory.createAkunPengguna("tokoonlineanimepl.akunpengguna.wishlist", akunpenggunawishlist, id_akun, email, nama, alamat, no_telepon);
		Repository.saveObject(akunpenggunawishlistdeco);
		return akunpenggunawishlistdeco;
	}

	public AkunPengguna createAkunPengguna(Map<String, Object> requestBody, int id){
		AkunPengguna savedAkunPengguna = Repository.getObject(id);
		String id_akunStr = (String) requestBody.get("id_akun");
		int id_akun = Integer.parseInt(id_akunStr);
		String email = (String) requestBody.get("email");
		String nama = (String) requestBody.get("nama");
		String alamat = (String) requestBody.get("alamat");
		String no_telepon = (String) requestBody.get("no_telepon");
		UUID recordAkunPengguna = ((AkunPenggunaDecorator) savedAkunPengguna).get();
		AkunPengguna AkunPengguna = record.createAkunPengguna(requestBody, recordAkunPengguna);
		AkunPengguna akunpenggunawishlist = AkunPenggunaFactory.createAkunPengguna("tokoonlineanimepl.akunpengguna.wishlist.model.AkunPenggunaImpl", AkunPengguna, id_akun, email, nama, alamat, no_telepon);
		return akunpenggunawishlist;
	}

    public HashMap<String, Object> updateAkunPengguna(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		
		AkunPengguna akunpenggunawishlist = Repository.getObject(id);
		akunpenggunawishlist = createAkunPengguna(requestBody, id);
		
		Repository.updateObject(akunpenggunawishlist);
		akunpenggunawishlist = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return akunpenggunawishlist.toHashMap();
	}

	public HashMap<String, Object> getAkunPengguna(String idStr){
		int id = Integer.parseInt(idStr);
		AkunPengguna akunpenggunawishlist = Repository.getObject(id);
		return akunpenggunawishlist.toHashMap();
	}

	public HashMap<String, Object> getAkunPenggunaById(int id){
		List<HashMap<String, Object>> akunpenggunaList = getAllAkunPengguna();
		for (HashMap<String, Object> akunpengguna : akunpenggunaList){
			int akunpengguna_id = ((Double) akunpengguna.get("")).intValue();
			if (akunpengguna_id == id){
				return akunpengguna;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllAkunPengguna(){
		List<AkunPengguna> List = Repository.getAllObject("akunpengguna_wishlist");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<AkunPengguna> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteAkunPengguna(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get(""));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllAkunPengguna();
	}

	
	protected boolean addToWishlist(int id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	protected boolean removeFromWishlist(int id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
