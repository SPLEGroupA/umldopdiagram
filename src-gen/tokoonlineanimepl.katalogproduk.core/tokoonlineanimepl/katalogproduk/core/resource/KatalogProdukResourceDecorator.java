package tokoonlineanimepl.katalogproduk.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;

public abstract class KatalogProdukResourceDecorator extends KatalogProdukResourceComponent{
	protected KatalogProdukResourceComponent record;

    public KatalogProdukResourceDecorator(KatalogProdukResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveKatalogProduk(VMJExchange vmjExchange){
		return record.saveKatalogProduk(vmjExchange);
	}

    public KatalogProduk createKatalogProduk(VMJExchange vmjExchange){
		return record.createKatalogProduk(vmjExchange);
	}
	
	public KatalogProduk createKatalogProduk(VMJExchange vmjExchange, UUID id){
		return record.createKatalogProduk(vmjExchange, id);
	}

    public HashMap<String, Object> updateKatalogProduk(VMJExchange vmjExchange){
		return record.updateKatalogProduk(vmjExchange);
	}

    public HashMap<String, Object> getKatalogProduk(VMJExchange vmjExchange){
		return record.getKatalogProduk(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllKatalogProduk(VMJExchange vmjExchange){
		return record.getAllKatalogProduk(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteKatalogProduk(VMJExchange vmjExchange){
		return record.deleteKatalogProduk(vmjExchange);
	}

}
