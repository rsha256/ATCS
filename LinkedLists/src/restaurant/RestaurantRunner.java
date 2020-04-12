package restaurant;

import java.util.*;
import static java.lang.System.*;

public class RestaurantRunner {
	public static void main(String[] args) {
		ListNode z = new ListNode("cheese",
				new ListNode("pepperoni", new ListNode("onions", new ListNode("peppers", new ListNode("bacon",
						new ListNode("pineapple", new ListNode("sausage", new ListNode("garlic", null))))))));

		out.println("Worksheet LL#2 Runner\n\n");

		out.println("Original list values\n");
		Restaurant.print(z);
		out.println("\n");

		out.println("num nodes = " + Restaurant.nodeCount(z));

		out.println("\nList values after calling nodeCount\n");
		Restaurant.print(z);
		out.println();

		Restaurant.doubleFirst(z);
		out.println("\nList values after calling doubleFirst\n");
		Restaurant.print(z);
		out.println();

		Restaurant.doubleLast(z);
		out.println("\nList values after calling doubleLast\n");
		Restaurant.print(z);
		out.println();

		
		
		Restaurant.removeXthNode(z, 2);
		out.println("\nList values after calling removeXthNode(2)\n");
		Restaurant.print(z);
		out.println();
		
		Restaurant.setXthNode(z, 2, "PIZZA!");
		out.println("\nList values after calling setXthNode(2,PIZZA!)\n");
		Restaurant.print(z);
		out.println();
		
		Restaurant.skipEveryOther(z);
		Restaurant.print(z);
		out.println();

	}
}
