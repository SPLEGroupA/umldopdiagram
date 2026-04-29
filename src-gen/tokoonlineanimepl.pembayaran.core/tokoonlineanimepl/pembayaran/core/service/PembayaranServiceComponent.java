package tokoonlineanimepl.pembayaran.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.pembayaran.core.model.Pembayaran;
//add other required packages

public abstract class PembayaranServiceComponent implements PembayaranService{
	protected RepositoryUtil<Pembayaran> Repository;

    public PembayaranServiceComponent(){
        this.Repository = new RepositoryUtil<Pembayaran>(tokoonlineanimepl.pembayaran.core.model.PembayaranComponent.class);
    }	

    public abstract Pembayaran createPembayaran(Map<String, Object> requestBody);
	public abstract Pembayaran createPembayaran(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updatePembayaran(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getPembayaran(String idStr);
    public abstract List<HashMap<String,Object>> getAllPembayaran();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Pembayaran> List);
    public abstract List<HashMap<String,Object>> deletePembayaran(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getPembayaranById(int id);

}
