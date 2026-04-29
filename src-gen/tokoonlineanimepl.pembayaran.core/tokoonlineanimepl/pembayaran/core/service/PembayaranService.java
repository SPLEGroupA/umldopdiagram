package tokoonlineanimepl.pembayaran.core.service;
import java.util.*;

import tokoonlineanimepl.pembayaran.core.model.Pembayaran;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface PembayaranService {
	Pembayaran createPembayaran(Map<String, Object> requestBody);
	HashMap<String, Object> getPembayaran(String idStr);
    HashMap<String, Object> updatePembayaran(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllPembayaran();
    List<HashMap<String,Object>> deletePembayaran(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Pembayaran> List);
}
