package tokoonlineanimepl.katalogproduk.core.service;
import java.util.*;

import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface KatalogProdukService {
	KatalogProduk createKatalogProduk(Map<String, Object> requestBody);
	HashMap<String, Object> getKatalogProduk(String idStr);
    HashMap<String, Object> updateKatalogProduk(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllKatalogProduk();
    List<HashMap<String,Object>> deleteKatalogProduk(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<KatalogProduk> List);
}
