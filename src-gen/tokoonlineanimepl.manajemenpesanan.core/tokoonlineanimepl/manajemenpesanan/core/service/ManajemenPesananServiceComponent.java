package tokoonlineanimepl.manajemenpesanan.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesanan;
//add other required packages

public abstract class ManajemenPesananServiceComponent implements ManajemenPesananService{
	protected RepositoryUtil<ManajemenPesanan> Repository;

    public ManajemenPesananServiceComponent(){
        this.Repository = new RepositoryUtil<ManajemenPesanan>(tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesananComponent.class);
    }	

    public abstract ManajemenPesanan createManajemenPesanan(Map<String, Object> requestBody);
	public abstract ManajemenPesanan createManajemenPesanan(Map<String, Object> requestBody, UUID id);
	public abstract HashMap<String, Object> updateManajemenPesanan(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getManajemenPesanan(String idStr);
    public abstract List<HashMap<String,Object>> getAllManajemenPesanan();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<ManajemenPesanan> List);
    public abstract List<HashMap<String,Object>> deleteManajemenPesanan(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getManajemenPesananById(UUID id);	

	public abstract boolean getByUser(String email);
}
