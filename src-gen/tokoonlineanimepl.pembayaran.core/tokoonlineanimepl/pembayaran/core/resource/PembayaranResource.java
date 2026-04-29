package tokoonlineanimepl.pembayaran.core.resource;
import java.util.*;

import tokoonlineanimepl.pembayaran.core.model.Pembayaran;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface PembayaranResource {
    List<HashMap<String,Object>> savePembayaran(VMJExchange vmjExchange);
    HashMap<String, Object> updatePembayaran(VMJExchange vmjExchange);
    HashMap<String, Object> getPembayaran(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPembayaran(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePembayaran(VMJExchange vmjExchange);
}
