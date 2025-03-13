package projTest;

import java.util.ArrayList;
import java.lang.Math;

public class ShoppingCart {

	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initialize items
		ShoppingCart sc = new ShoppingCart();
		
		Item unliOneGB = sc.createItem("ult_small", "Unlimited 1GB", 24.90);
		Item unliTwoGB = sc.createItem("ult_medium", "Unlimited 2GB", 29.90);
		Item unliFiveGB = sc.createItem("ult_large", "Unlimited 5GB", 44.90);
		Item oneGBData = sc.createItem("1gb", "1 GB Data-pack", 9.90);
		
		ArrayList<Item> itemsCart = new ArrayList<Item>();
		
		//first scenario
		
		itemsCart.add(unliOneGB);
		itemsCart.add(unliOneGB);
		itemsCart.add(unliOneGB);
		itemsCart.add(unliOneGB);
		itemsCart.add(unliOneGB);
		itemsCart.add(unliOneGB);
		itemsCart.add(unliFiveGB);
		
		//second scenario
		/*
		itemsCart.add(unliOneGB);
		itemsCart.add(unliOneGB);
		itemsCart.add(unliFiveGB);
		itemsCart.add(unliFiveGB);
		itemsCart.add(unliFiveGB);
		itemsCart.add(unliFiveGB);
		*/
		
		//Third scenario
		/*
		itemsCart.add(unliOneGB);
		itemsCart.add(unliTwoGB);
		itemsCart.add(unliTwoGB);
		*/
		
		//count Unlimited 1GB
		int unliOneGBCount = 0;
		int unliTwoGBCount = 0;
		int unliFiveGBCount = 0;
		double totalPrice = 0.00;
		for (Item i : itemsCart) {
			if (i.productCode == "ult_small") {
				totalPrice = totalPrice + unliOneGB.getPrice();
				unliOneGBCount++;
			} else if (i.productCode == "ult_medium") {
				totalPrice = totalPrice + unliTwoGB.getPrice();
				unliTwoGBCount++;
			} else if (i.productCode == "ult_large") {
				unliFiveGBCount++;
			}
		}
		
		System.out.println("Cart shows small has " + unliOneGBCount + 
				", medium has " + unliTwoGBCount + ", large has " + unliFiveGBCount);
		
		if (unliOneGBCount >= 3) {
			int num = (int) Math.floor(unliOneGBCount / 3);
			System.out.println("Num is = " + num);
			for (int a = 0; a < num; a++) {
				totalPrice = totalPrice - unliOneGB.getPrice();
			}	
		}
		
		//Pricing for Unli Five GB
		//If order is more than 3, discount price applies
		//else if less than or equal to 3, normal rate is applied
		
		if (unliFiveGBCount <= 3) {
			for (int j = 0; j < unliFiveGBCount; j++) {
				totalPrice = totalPrice + unliFiveGB.getPrice(); //Discounted price for bulk orders
			}
		}
		
		if (unliFiveGBCount > 3) {
			for (int k = 0; k < unliFiveGBCount; k++) {
				totalPrice = totalPrice + 39.90; //Discounted price for bulk orders
			}	
		} 
		
		if (unliTwoGBCount > 0) {
			for (int x = 0; x < unliTwoGBCount; x++) {
				itemsCart.add(oneGBData);
			}
		}
		
		System.out.println("");
		System.out.println("Cart Contents:");
		for (Item it : itemsCart) {
			System.out.println ("Item name: " + it.getName());
		}
		
		System.out.println("");
		System.out.println("Total Price = " + totalPrice);

	}
	
	public Item createItem(String productCode, String name, double price) {
		Item i = new Item(productCode, name, price);
		return i;
	}
	
	public class Item {
		
		public String productCode;
		public String name;
		public double price; 
		
		public Item(String productCode, String name, double price) {
			this.productCode = productCode;
			this.name = name;
			this.price = price;
		}
		
		public String getProductCode() {
			return productCode;
		}

		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
	}

}
