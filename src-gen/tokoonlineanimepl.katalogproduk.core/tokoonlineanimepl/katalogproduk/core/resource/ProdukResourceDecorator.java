package tokoonlineanimepl.katalogproduk.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.katalogproduk.core.model.Produk;

public abstract class ProdukResourceDecorator extends ProdukResourceComponent{
	protected ProdukResourceComponent record;

    public ProdukResourceDecorator(ProdukResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveProduk(VMJExchange vmjExchange){
		return record.saveProduk(vmjExchange);
	}

    public Produk createProduk(VMJExchange vmjExchange){
		return record.createProduk(vmjExchange);
	}
	
	public Produk createProduk(VMJExchange vmjExchange, UUID id){
		return record.createProduk(vmjExchange, id);
	}

    public HashMap<String, Object> updateProduk(VMJExchange vmjExchange){
		return record.updateProduk(vmjExchange);
	}

    public HashMap<String, Object> getProduk(VMJExchange vmjExchange){
		return record.getProduk(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllProduk(VMJExchange vmjExchange){
		return record.getAllProduk(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteProduk(VMJExchange vmjExchange){
		return record.deleteProduk(vmjExchange);
	}

}
