package tokoonlineanimepl.preorder.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.preorder.core.model.PreOrder;
//add other required packages

public abstract class PreOrderServiceComponent implements PreOrderService{
	protected RepositoryUtil<PreOrder> Repository;

    public PreOrderServiceComponent(){
        this.Repository = new RepositoryUtil<PreOrder>(tokoonlineanimepl.preorder.core.model.PreOrderComponent.class);
    }	

    public abstract PreOrder createPreOrder(Map<String, Object> requestBody);
	public abstract PreOrder createPreOrder(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updatePreOrder(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getPreOrder(String idStr);
    public abstract List<HashMap<String,Object>> getAllPreOrder();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<PreOrder> List);
    public abstract List<HashMap<String,Object>> deletePreOrder(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getPreOrderById(int id);

}
