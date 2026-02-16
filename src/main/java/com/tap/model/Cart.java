package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
private static Map<Integer,CartItem> items;
private static CartItem item;
   public Cart() {
	this.items = new HashMap<>();
     }
   public Map<Integer, CartItem> addItem(CartItem item) {
	   int itemid=item.getItemId();
	   if(items.containsKey(itemid)) {
		   CartItem existingitem=items.get(itemid);
		   existingitem.setQuantity(existingitem.getQuantity()+item.getQuantity());
		   existingitem.setPrice(existingitem.getQuantity()*item.getPrice());
	   }
	   else {
		  
		   items.put(itemid,item);
		   CartItem existingitem=items.get(itemid);
		   existingitem.setPrice(existingitem.getQuantity()*item.getPrice());
		 }
	   return items;
	  
   }
   
   public Map<Integer, CartItem> updateItem(CartItem updatedItem, int itemId, int quantity) {
	 
	    CartItem existingItem = items.get(itemId);

	    if (existingItem != null) {
	        System.out.println("Existing Item Found");

	        if (quantity <= 0) {
	            // Remove the item if the quantity is 0 or negative
	            items.remove(itemId);
	            System.out.println("Item removed from cart.");
	        } else {
	            // Update the quantity and price for the existing item
	            existingItem.setQuantity(quantity);  // Update the quantity
	            existingItem.setPrice(existingItem.getPrice() * quantity);  // Recalculate the price
	            System.out.println("Item updated: " + existingItem.getName() + " Quantity: " + existingItem.getQuantity() + " Price: " + existingItem.getPrice());
	        }
	    } else {
	        // If the item doesn't exist, add it to the cart
	        System.out.println("Item with ID " + itemId + " not found in the cart.");
	        if (quantity > 0) {
	            // Add the new item to the cart
	            updatedItem.setQuantity(quantity); // Set the quantity
	            updatedItem.setPrice(updatedItem.getPrice() * quantity); // Set the price based on quantity
	            items.put(itemId, updatedItem);  // Add the updated item to the cart
	            System.out.println("New item added: " + updatedItem.getName() + " Quantity: " + updatedItem.getQuantity() + " Price: " + updatedItem.getPrice());
	        }
	    }

	    return items;  // Return the updated cart
	}
   public static Map<Integer, CartItem> deleteItem(CartItem updatedItem, int itemId) {
	    // Check if the item exists in the cart
	   // Check if the item exists in the cart
	   items.put(itemId, updatedItem);
	   for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
           item = entry.getValue();
          System.out.println("Item ID: " + item.getItemId() + ", Quantity: " + item.getQuantity() + ", Price: " + item.getPrice());
      }
	    CartItem existingItem = items.get(itemId);

	    if (existingItem != null) {
	        System.out.println("Existing Item Found");

	       
	           
	            items.remove(itemId);
	            System.out.println("Item removed from cart.");
	    }
	      else {
	           
	        System.out.println("existing item is null");
	        }
	    
	    

	    return items;  // Return the updated cart
	}


   public Map<Integer, CartItem> getItems() {
		return items;
	}
}
