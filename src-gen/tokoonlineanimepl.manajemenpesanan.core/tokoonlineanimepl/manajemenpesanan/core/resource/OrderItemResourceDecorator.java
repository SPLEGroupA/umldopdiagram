package tokoonlineanimepl.manajemenpesanan.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.manajemenpesanan.core.model.OrderItem;

public abstract class OrderItemResourceDecorator extends OrderItemResourceComponent{
	protected OrderItemResourceComponent record;

    public OrderItemResourceDecorator(OrderItemResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveOrderItem(VMJExchange vmjExchange){
		return record.saveOrderItem(vmjExchange);
	}

    public OrderItem createOrderItem(VMJExchange vmjExchange){
		return record.createOrderItem(vmjExchange);
	}
	
	public OrderItem createOrderItem(VMJExchange vmjExchange, int id){
		return record.createOrderItem(vmjExchange, id);
	}

    public HashMap<String, Object> updateOrderItem(VMJExchange vmjExchange){
		return record.updateOrderItem(vmjExchange);
	}

    public HashMap<String, Object> getOrderItem(VMJExchange vmjExchange){
		return record.getOrderItem(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllOrderItem(VMJExchange vmjExchange){
		return record.getAllOrderItem(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteOrderItem(VMJExchange vmjExchange){
		return record.deleteOrderItem(vmjExchange);
	}

	public OrderItemImpl getByPesanan(int id_pesanan) {
		return record.getByPesanan(id_pesanan);
	}
}
