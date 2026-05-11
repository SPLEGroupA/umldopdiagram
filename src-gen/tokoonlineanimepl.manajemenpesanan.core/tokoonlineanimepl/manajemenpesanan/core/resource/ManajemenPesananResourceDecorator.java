package tokoonlineanimepl.manajemenpesanan.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesanan;

public abstract class ManajemenPesananResourceDecorator extends ManajemenPesananResourceComponent{
	protected ManajemenPesananResourceComponent record;

    public ManajemenPesananResourceDecorator(ManajemenPesananResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveManajemenPesanan(VMJExchange vmjExchange){
		return record.saveManajemenPesanan(vmjExchange);
	}

    public ManajemenPesanan createManajemenPesanan(VMJExchange vmjExchange){
		return record.createManajemenPesanan(vmjExchange);
	}
	
	public ManajemenPesanan createManajemenPesanan(VMJExchange vmjExchange, UUID id){
		return record.createManajemenPesanan(vmjExchange, id);
	}

    public HashMap<String, Object> updateManajemenPesanan(VMJExchange vmjExchange){
		return record.updateManajemenPesanan(vmjExchange);
	}

    public HashMap<String, Object> getManajemenPesanan(VMJExchange vmjExchange){
		return record.getManajemenPesanan(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllManajemenPesanan(VMJExchange vmjExchange){
		return record.getAllManajemenPesanan(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteManajemenPesanan(VMJExchange vmjExchange){
		return record.deleteManajemenPesanan(vmjExchange);
	}

	public boolean getByUser(String email) {
		return record.getByUser(email);
	}
}
