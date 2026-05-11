package tokoonlineanimepl.keranjangbelanja.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanja;
//add other required packages

public abstract class KeranjangBelanjaServiceComponent implements KeranjangBelanjaService{
	protected RepositoryUtil<KeranjangBelanja> Repository;

    public KeranjangBelanjaServiceComponent(){
        this.Repository = new RepositoryUtil<KeranjangBelanja>(tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanjaComponent.class);
    }	

    public abstract KeranjangBelanja createKeranjangBelanja(Map<String, Object> requestBody);
	public abstract KeranjangBelanja createKeranjangBelanja(Map<String, Object> requestBody, UUID id);
	public abstract HashMap<String, Object> updateKeranjangBelanja(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getKeranjangBelanja(String idStr);
    public abstract List<HashMap<String,Object>> getAllKeranjangBelanja();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<KeranjangBelanja> List);
    public abstract List<HashMap<String,Object>> deleteKeranjangBelanja(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getKeranjangBelanjaById(UUID id);	

	public abstract boolean getByUser(String email);

	public abstract boolean addItem(UUID id_cart_item);

	public abstract boolean checkout();
}
