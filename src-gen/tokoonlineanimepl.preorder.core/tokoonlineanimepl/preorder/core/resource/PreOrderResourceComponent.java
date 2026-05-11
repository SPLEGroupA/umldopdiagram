package tokoonlineanimepl.preorder.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.preorder.core.model.PreOrder;
//add other required packages

public abstract class PreOrderResourceComponent implements PreOrderResource{
	
	public PreOrderResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> savePreOrder(VMJExchange vmjExchange);
    public abstract PreOrder createPreOrder(VMJExchange vmjExchange);
	public abstract PreOrder createPreOrder(VMJExchange vmjExchange, UUID id);
	public abstract HashMap<String, Object> updatePreOrder(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getPreOrder(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllPreOrder(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deletePreOrder(VMJExchange vmjExchange);

}
