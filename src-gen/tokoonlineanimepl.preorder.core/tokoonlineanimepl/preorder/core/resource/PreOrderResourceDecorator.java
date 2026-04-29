package tokoonlineanimepl.preorder.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.preorder.core.model.PreOrder;

public abstract class PreOrderResourceDecorator extends PreOrderResourceComponent{
	protected PreOrderResourceComponent record;

    public PreOrderResourceDecorator(PreOrderResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> savePreOrder(VMJExchange vmjExchange){
		return record.savePreOrder(vmjExchange);
	}

    public PreOrder createPreOrder(VMJExchange vmjExchange){
		return record.createPreOrder(vmjExchange);
	}
	
	public PreOrder createPreOrder(VMJExchange vmjExchange, int id){
		return record.createPreOrder(vmjExchange, id);
	}

    public HashMap<String, Object> updatePreOrder(VMJExchange vmjExchange){
		return record.updatePreOrder(vmjExchange);
	}

    public HashMap<String, Object> getPreOrder(VMJExchange vmjExchange){
		return record.getPreOrder(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllPreOrder(VMJExchange vmjExchange){
		return record.getAllPreOrder(vmjExchange);
	}

    public List<HashMap<String,Object>> deletePreOrder(VMJExchange vmjExchange){
		return record.deletePreOrder(vmjExchange);
	}

}
