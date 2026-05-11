package tokoonlineanimepl.manajemenpesanan.core.service;
import java.util.*;

import tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesanan;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ManajemenPesananService {
	ManajemenPesanan createManajemenPesanan(Map<String, Object> requestBody);
	HashMap<String, Object> getManajemenPesanan(String idStr);
    HashMap<String, Object> updateManajemenPesanan(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllManajemenPesanan();
    List<HashMap<String,Object>> deleteManajemenPesanan(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<ManajemenPesanan> List);
}
