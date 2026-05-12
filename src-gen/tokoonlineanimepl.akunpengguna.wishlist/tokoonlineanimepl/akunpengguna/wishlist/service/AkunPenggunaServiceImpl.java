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
		String wishlist_items = (String) requestBody.get("wishlist_items");
		String email = (String) requestBody.get("email");
		String nama = (String) requestBody.get("nama");
		String alamat = (String) requestBody.get("alamat");
		String no_telepon = (String) requestBody.get("no_telepon");
		AkunPengguna akunpenggunawishlist = record.createAkunPengguna(requestBody);
		AkunPengguna akunpenggunawishlistdeco = AkunPenggunaFactory.createAkunPengguna("tokoonlineanimepl.akunpengguna.wishlist.model.AkunPenggunaImpl", akunpenggunawishlist, wishlist_items);
		Repository.saveObject(akunpenggunawishlistdeco);
		return akunpenggunawishlistdeco;
	}

    public AkunPengguna createAkunPengguna(Map<String, Object> requestBody, UUID id){	
		AkunPengguna savedAkunPengguna = Repository.getObject(id);
		String wishlist_items = (String) requestBody.get("wishlist_items");
		UUID recordAkunPenggunaId_akun = ((AkunPenggunaDecorator) savedAkunPengguna).getId_akun();
		AkunPengguna akunpengguna = record.createAkunPengguna(requestBody, recordAkunPenggunaId_akun);
		AkunPengguna akunpenggunawishlist = AkunPenggunaFactory.createAkunPengguna("tokoonlineanimepl.akunpengguna.wishlist.AkunPenggunaImpl", akunpengguna, wishlist_items);
		return akunpenggunawishlist;
	}

    public HashMap<String, Object> updateAkunPengguna(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_akun");
		UUID id = UUID.fromString(idStr);
		
		AkunPengguna akunpenggunawishlist = Repository.getObject(id);
		akunpenggunawishlist = createAkunPengguna(requestBody, id);
		
		Repository.updateObject(akunpenggunawishlist);
		akunpenggunawishlist = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return akunpenggunawishlist.toHashMap();
	}

	public HashMap<String, Object> getAkunPengguna(String idStr){
		UUID id = UUID.fromString(idStr);		
		AkunPengguna akunpenggunawishlist = Repository.getObject(id);
		return akunpenggunawishlist.toHashMap();
	}

	public HashMap<String, Object> getAkunPenggunaById(UUID id){
		List<HashMap<String, Object>> akunpenggunaList = getAllAkunPengguna();
		for (HashMap<String, Object> akunpengguna : akunpenggunaList){
			UUID akunpengguna_id = UUID.fromString((String) akunpengguna.get("id_akun"));
			if (akunpengguna_id.equals(id)){
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
		String idStr = ((String) requestBody.get("id_akun"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllAkunPengguna();
	}

	
	protected boolean addToWishlist(UUID id_akun, UUID id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	protected boolean removeFromWishlist(UUID id_akun, UUID id_produk) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
