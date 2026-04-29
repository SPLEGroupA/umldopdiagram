package tokoonlineanimepl.keranjangbelanja.core.resource;
import java.util.*;

import tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanja;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface KeranjangBelanjaResource {
    List<HashMap<String,Object>> saveKeranjangBelanja(VMJExchange vmjExchange);
    HashMap<String, Object> updateKeranjangBelanja(VMJExchange vmjExchange);
    HashMap<String, Object> getKeranjangBelanja(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllKeranjangBelanja(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteKeranjangBelanja(VMJExchange vmjExchange);
}
