package ca.uwo.proxies;

import java.util.Map;
import java.util.Scanner;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class HighQuantityProxy extends Proxy {

    public void authenticate(Buyer buyer) {
	boolean auth = false;
	Scanner input = new Scanner(System.in);
	while (!auth) {
	    System.out.println("**********Authenticator**********");
	    System.out.print("Enter Username:");
	    String usr = input.next();
	    if (usr.equals(buyer.getUserName())) {
		System.out.print("Enter password:");
		String pwd = input.next();
		if (pwd.equals(buyer.getPassword())) {
		    System.out.println("-> Authenticaton Successful");
		    auth = true;
		} else
		    System.out.println("-> Authenticaton failed");
	    } else
		System.out.println("-> Authenticaton failed");
	}
    }

    @Override
    public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
	Facade facade = new Facade();
	authenticate(buyer);
	facade.placeOrder(orderDetails, buyer);
    }

    @Override
    public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
    }

}
