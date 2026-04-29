package tokoonlineanimepl.katalogproduk.core.resource;
import java.util.*;

import tokoonlineanimepl.katalogproduk.core.model.Produk;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ProdukResource {
    List<HashMap<String,Object>> saveProduk(VMJExchange vmjExchange);
    HashMap<String, Object> updateProduk(VMJExchange vmjExchange);
    HashMap<String, Object> getProduk(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllProduk(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteProduk(VMJExchange vmjExchange);
}
