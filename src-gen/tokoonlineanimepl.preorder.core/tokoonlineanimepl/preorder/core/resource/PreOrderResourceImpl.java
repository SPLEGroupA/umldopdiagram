package tokoonlineanimepl.preorder.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.preorder.PreOrderFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import tokoonlineanimepl.preorder.core.model.PreOrder;
import tokoonlineanimepl.preorder.core.service.PreOrderServiceImpl;
//add other required packages


public class PreOrderResourceImpl extends PreOrderResourceComponent{
	
	private PreOrderServiceImpl preorderServiceImpl = new PreOrderServiceImpl();

	
    @Route(url="call/preorder/save")
    public List<HashMap<String,Object>> savePreOrder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PreOrder preorder = createPreOrder(vmjExchange);
		return preorderServiceImpl.getAllPreOrder();
	}

    public PreOrder createPreOrder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			PreOrder result = preorderServiceImpl.createPreOrder(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public PreOrder createPreOrder(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			PreOrder result = preorderServiceImpl.createPreOrder(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/preorder/update")
    public HashMap<String, Object> updatePreOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return preorderServiceImpl.updatePreOrder(requestBody);
		
	}

	
    @Route(url="call/preorder/detail")
    public HashMap<String, Object> getPreOrder(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("");
		return preorderServiceImpl.getPreOrder(idStr);
	}

	
    @Route(url="call/preorder/list")
    public List<HashMap<String,Object>> getAllPreOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return preorderServiceImpl.getAllPreOrder();
	}

	
    @Route(url="call/preorder/delete")
    public List<HashMap<String,Object>> deletePreOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return preorderServiceImpl.deletePreOrder(requestBody);
	}


}
