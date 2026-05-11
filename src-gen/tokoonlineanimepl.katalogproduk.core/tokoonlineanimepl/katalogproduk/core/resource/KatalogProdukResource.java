package tokoonlineanimepl.katalogproduk.core.resource;
import java.util.*;

import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface KatalogProdukResource {
    List<HashMap<String,Object>> saveKatalogProduk(VMJExchange vmjExchange);
    HashMap<String, Object> updateKatalogProduk(VMJExchange vmjExchange);
    HashMap<String, Object> getKatalogProduk(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllKatalogProduk(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteKatalogProduk(VMJExchange vmjExchange);
}
