package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

public class OutOfStockState implements ItemState {

	@Override
	public ItemResult deplete(Item item, int quantity) {
		ItemResult itemResult;
		itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
		item.setState(new ItemStateFactory().create(quantity));
		item.notifyViewers();
		return itemResult;
	}

	@Override
	public ItemResult replenish(Item item, int quantity) {
		int availableQuantity = item.getAvailableQuantity();
		availableQuantity += quantity;
		item.setAvailableQuantity(availableQuantity);
		ItemResult itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);
		item.setState(new ItemStateFactory().create(quantity));
		item.notifyViewers();
		return itemResult;
	}

}