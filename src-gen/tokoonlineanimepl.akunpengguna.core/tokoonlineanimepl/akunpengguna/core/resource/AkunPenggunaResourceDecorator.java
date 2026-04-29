package tokoonlineanimepl.akunpengguna.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;

public abstract class AkunPenggunaResourceDecorator extends AkunPenggunaResourceComponent{
	protected AkunPenggunaResourceComponent record;

    public AkunPenggunaResourceDecorator(AkunPenggunaResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveAkunPengguna(VMJExchange vmjExchange){
		return record.saveAkunPengguna(vmjExchange);
	}

    public AkunPengguna createAkunPengguna(VMJExchange vmjExchange){
		return record.createAkunPengguna(vmjExchange);
	}
	
	public AkunPengguna createAkunPengguna(VMJExchange vmjExchange, int id){
		return record.createAkunPengguna(vmjExchange, id);
	}

    public HashMap<String, Object> updateAkunPengguna(VMJExchange vmjExchange){
		return record.updateAkunPengguna(vmjExchange);
	}

    public HashMap<String, Object> getAkunPengguna(VMJExchange vmjExchange){
		return record.getAkunPengguna(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllAkunPengguna(VMJExchange vmjExchange){
		return record.getAllAkunPengguna(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteAkunPengguna(VMJExchange vmjExchange){
		return record.deleteAkunPengguna(vmjExchange);
	}

}
