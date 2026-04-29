package tokoonlineanimepl.akunpengguna.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;
//add other required packages

public abstract class AkunPenggunaResourceComponent implements AkunPenggunaResource{
	
	public AkunPenggunaResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveAkunPengguna(VMJExchange vmjExchange);
    public abstract AkunPengguna createAkunPengguna(VMJExchange vmjExchange);
	public abstract AkunPengguna createAkunPengguna(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateAkunPengguna(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getAkunPengguna(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllAkunPengguna(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteAkunPengguna(VMJExchange vmjExchange);

}
