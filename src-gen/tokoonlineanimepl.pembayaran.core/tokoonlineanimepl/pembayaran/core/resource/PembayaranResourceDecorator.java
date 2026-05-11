package tokoonlineanimepl.pembayaran.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.pembayaran.core.model.Pembayaran;

public abstract class PembayaranResourceDecorator extends PembayaranResourceComponent{
	protected PembayaranResourceComponent record;

    public PembayaranResourceDecorator(PembayaranResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> savePembayaran(VMJExchange vmjExchange){
		return record.savePembayaran(vmjExchange);
	}

    public Pembayaran createPembayaran(VMJExchange vmjExchange){
		return record.createPembayaran(vmjExchange);
	}
	
	public Pembayaran createPembayaran(VMJExchange vmjExchange, UUID id){
		return record.createPembayaran(vmjExchange, id);
	}

    public HashMap<String, Object> updatePembayaran(VMJExchange vmjExchange){
		return record.updatePembayaran(vmjExchange);
	}

    public HashMap<String, Object> getPembayaran(VMJExchange vmjExchange){
		return record.getPembayaran(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllPembayaran(VMJExchange vmjExchange){
		return record.getAllPembayaran(vmjExchange);
	}

    public List<HashMap<String,Object>> deletePembayaran(VMJExchange vmjExchange){
		return record.deletePembayaran(vmjExchange);
	}

}
