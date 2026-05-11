package tokoonlineanimepl.manajemenpesanan.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesanan;
//add other required packages

public abstract class ManajemenPesananResourceComponent implements ManajemenPesananResource{
	
	public ManajemenPesananResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveManajemenPesanan(VMJExchange vmjExchange);
    public abstract ManajemenPesanan createManajemenPesanan(VMJExchange vmjExchange);
	public abstract ManajemenPesanan createManajemenPesanan(VMJExchange vmjExchange, UUID id);
	public abstract HashMap<String, Object> updateManajemenPesanan(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getManajemenPesanan(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllManajemenPesanan(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteManajemenPesanan(VMJExchange vmjExchange);

	public abstract boolean getByUser(String email);
}
