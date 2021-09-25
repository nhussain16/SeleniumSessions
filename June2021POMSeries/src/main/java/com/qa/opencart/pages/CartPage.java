package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {

	By cart = By.linkText("cart");
	
	public void addToCart() {
		System.out.println("add the product to the cart ");
	}
}
