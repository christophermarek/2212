package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

public class LowStockState implements ItemState{

	@Override
	public ItemResult deplete(Item item, int quantity) {
		ItemResult itemResult;
		int availableQuantity = item.getAvailableQuantity();
<<<<<<< HEAD
		if (availableQuantity < quantity) {
		    itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
		} else {
=======
		if (availableQuantity < quantity)
		    itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
		else {
>>>>>>> finalCode
		    availableQuantity -= quantity;
		    itemResult = new ItemResult("AVAILABLE", ResponseCode.Completed);
		}
		
		item.setAvailableQuantity(availableQuantity);
<<<<<<< HEAD
		item.setState(new ItemStateFactory().create(availableQuantity)); // made in i2 will go out of stock if = 0, low stock if < 10, stay in stock if > 10
		item.notifyViewers(); // made in i3
=======
		item.setState(new ItemStateFactory().create(availableQuantity));
		item.notifyViewers();
>>>>>>> finalCode
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