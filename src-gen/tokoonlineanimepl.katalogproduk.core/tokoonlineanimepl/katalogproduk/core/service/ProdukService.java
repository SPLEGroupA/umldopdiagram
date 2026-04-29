package tokoonlineanimepl.katalogproduk.core.service;
import java.util.*;

import tokoonlineanimepl.katalogproduk.core.model.Produk;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ProdukService {
	Produk createProduk(Map<String, Object> requestBody);
	HashMap<String, Object> getProduk(String idStr);
    HashMap<String, Object> updateProduk(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllProduk();
    List<HashMap<String,Object>> deleteProduk(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Produk> List);
}
