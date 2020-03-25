package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

public class OutOfStockState implements ItemState {

	@Override
	public ItemResult deplete(Item item, int quantity) {
<<<<<<< HEAD
		ItemResult itemResult;
		itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
		item.setState(new ItemStateFactory().create(item.getAvailableQuantity()));
=======
		ItemResult itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
>>>>>>> finalCode
		item.notifyViewers();
		return itemResult;
	}

	@Override
	public ItemResult replenish(Item item, int quantity) {
<<<<<<< HEAD
		int availableQuantity = item.getAvailableQuantity();
		availableQuantity += quantity;
		item.setAvailableQuantity(availableQuantity);
		ItemResult itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);
		item.setState(new ItemStateFactory().create(availableQuantity));
=======
		int availableQuantity = item.getAvailableQuantity() + quantity;
		item.setAvailableQuantity(availableQuantity);
		ItemResult itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);
		item.setState(new ItemStateFactory().create(availableQuantity));
		item.notifyViewers();
>>>>>>> finalCode
		return itemResult;
	}

}