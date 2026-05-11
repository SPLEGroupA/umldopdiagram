package tokoonlineanimepl.preorder.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.preorder.core.model.PreOrder;

public abstract class PreOrderServiceDecorator extends PreOrderServiceComponent{
	protected PreOrderServiceComponent record;

    public PreOrderServiceDecorator(PreOrderServiceComponent record) {
        this.record = record;
    }

	public PreOrder createPreOrder(Map<String, Object> requestBody){
		return record.createPreOrder(requestBody);
	}
	
    public PreOrder createPreOrder(Map<String, Object> requestBody, UUID id){
		return record.createPreOrder(requestBody, id);
	}

	public HashMap<String, Object> getPreOrder(String idStr){
		return record.getPreOrder(idStr);
	}

	public List<HashMap<String,Object>> getAllPreOrder(){
		return record.getAllPreOrder();
	}

    public HashMap<String, Object> updatePreOrder(Map<String, Object> requestBody){
		return record.updatePreOrder(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<PreOrder> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deletePreOrder(Map<String, Object> requestBody){
		return record.deletePreOrder(requestBody);
	}

	public HashMap<String, Object> getPreOrderById(UUID id){	
        return record.getPreOrderById(id);
    }

}
