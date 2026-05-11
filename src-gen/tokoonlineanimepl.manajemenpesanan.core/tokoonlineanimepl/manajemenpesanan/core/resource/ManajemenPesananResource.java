package tokoonlineanimepl.manajemenpesanan.core.resource;
import java.util.*;

import tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesanan;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ManajemenPesananResource {
    List<HashMap<String,Object>> saveManajemenPesanan(VMJExchange vmjExchange);
    HashMap<String, Object> updateManajemenPesanan(VMJExchange vmjExchange);
    HashMap<String, Object> getManajemenPesanan(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllManajemenPesanan(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteManajemenPesanan(VMJExchange vmjExchange);
}
