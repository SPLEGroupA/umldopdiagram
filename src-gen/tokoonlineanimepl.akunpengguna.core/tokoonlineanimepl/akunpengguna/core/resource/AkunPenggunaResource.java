package tokoonlineanimepl.akunpengguna.core.resource;
import java.util.*;

import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface AkunPenggunaResource {
    List<HashMap<String,Object>> saveAkunPengguna(VMJExchange vmjExchange);
    HashMap<String, Object> updateAkunPengguna(VMJExchange vmjExchange);
    HashMap<String, Object> getAkunPengguna(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllAkunPengguna(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteAkunPengguna(VMJExchange vmjExchange);
}
