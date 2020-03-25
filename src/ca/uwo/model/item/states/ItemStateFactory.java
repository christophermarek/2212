package ca.uwo.model.item.states;

public class ItemStateFactory {
    
    public ItemState create(int q) {
	if (q == 0)
	    return new OutOfStockState();
	else if (q > 0 && q < 10)
	    return new LowStockState();
	return new InStockState();
    }
}
