package tokoonlineanimepl.keranjangbelanja.core.service;
import java.util.*;

import tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanja;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface KeranjangBelanjaService {
	KeranjangBelanja createKeranjangBelanja(Map<String, Object> requestBody);
	HashMap<String, Object> getKeranjangBelanja(String idStr);
    HashMap<String, Object> updateKeranjangBelanja(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllKeranjangBelanja();
    List<HashMap<String,Object>> deleteKeranjangBelanja(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<KeranjangBelanja> List);
}
