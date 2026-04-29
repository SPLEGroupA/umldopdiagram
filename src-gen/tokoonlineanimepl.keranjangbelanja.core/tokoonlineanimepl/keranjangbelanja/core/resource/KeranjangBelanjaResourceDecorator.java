package tokoonlineanimepl.keranjangbelanja.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanja;

public abstract class KeranjangBelanjaResourceDecorator extends KeranjangBelanjaResourceComponent{
	protected KeranjangBelanjaResourceComponent record;

    public KeranjangBelanjaResourceDecorator(KeranjangBelanjaResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveKeranjangBelanja(VMJExchange vmjExchange){
		return record.saveKeranjangBelanja(vmjExchange);
	}

    public KeranjangBelanja createKeranjangBelanja(VMJExchange vmjExchange){
		return record.createKeranjangBelanja(vmjExchange);
	}
	
	public KeranjangBelanja createKeranjangBelanja(VMJExchange vmjExchange, int id){
		return record.createKeranjangBelanja(vmjExchange, id);
	}

    public HashMap<String, Object> updateKeranjangBelanja(VMJExchange vmjExchange){
		return record.updateKeranjangBelanja(vmjExchange);
	}

    public HashMap<String, Object> getKeranjangBelanja(VMJExchange vmjExchange){
		return record.getKeranjangBelanja(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllKeranjangBelanja(VMJExchange vmjExchange){
		return record.getAllKeranjangBelanja(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteKeranjangBelanja(VMJExchange vmjExchange){
		return record.deleteKeranjangBelanja(vmjExchange);
	}

	public KeranjangBelanjaImpl getByUser(String email) {
		return record.getByUser(email);
	}

	public boolean addItem(int id_cart_item) {
		return record.addItem(id_cart_item);
	}

	public OrderImpl checkout() {
		return record.checkout();
	}
}
