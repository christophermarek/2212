package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class SupplierProxy extends Proxy {
    protected Proxy next = new LowQuantityProxy();

    @Override
    public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
	next.placeOrder(orderDetails, buyer);

    }

    @Override
    public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
	Facade facade = Facade.getInstance();
	facade.restock(restockDetails, supplier);
    }

}
