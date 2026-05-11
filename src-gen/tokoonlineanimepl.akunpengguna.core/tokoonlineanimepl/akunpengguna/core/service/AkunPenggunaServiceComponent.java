package tokoonlineanimepl.akunpengguna.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;
//add other required packages

public abstract class AkunPenggunaServiceComponent implements AkunPenggunaService{
	protected RepositoryUtil<AkunPengguna> Repository;

    public AkunPenggunaServiceComponent(){
        this.Repository = new RepositoryUtil<AkunPengguna>(tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaComponent.class);
    }	

    public abstract AkunPengguna createAkunPengguna(Map<String, Object> requestBody);
	public abstract AkunPengguna createAkunPengguna(Map<String, Object> requestBody, UUID id);
	public abstract HashMap<String, Object> updateAkunPengguna(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getAkunPengguna(String idStr);
    public abstract List<HashMap<String,Object>> getAllAkunPengguna();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<AkunPengguna> List);
    public abstract List<HashMap<String,Object>> deleteAkunPengguna(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getAkunPenggunaById(UUID id);	

}
