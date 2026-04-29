package tokoonlineanimepl.akunpengguna.core.service;
import java.util.*;

import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface AkunPenggunaService {
	AkunPengguna createAkunPengguna(Map<String, Object> requestBody);
	HashMap<String, Object> getAkunPengguna(String idStr);
    HashMap<String, Object> updateAkunPengguna(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllAkunPengguna();
    List<HashMap<String,Object>> deleteAkunPengguna(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<AkunPengguna> List);
}
