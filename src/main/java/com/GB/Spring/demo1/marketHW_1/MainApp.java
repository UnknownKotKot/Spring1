package com.GB.Spring.demo1.marketHW_1;

import com.GB.Spring.demo1.marketHW_1.impl.Cart;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Configuration
@ComponentScan("com.GB.Spring.demo1.marketHW_1")
public class MainApp {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr;
        String commandStr;
        String idStr;

        String addStr = "add";
        String delStr = "del";
        String showStr = "show";
        String exitStr = "q";

        System.out.println("type \"add [id]\" - to add prods to cart");
        System.out.println("type \"del [id]\" - to remove prods from cart");
        System.out.println("type \"show\" - to show prods in cart");
        System.out.println(" \"q\" - is for exit");

        Cart cartConsole = context.getBean(Cart.class);
        do {
            inputStr = br.readLine();
            if (inputStr.length() > 3) {
                commandStr = inputStr.substring(0, 4).trim();
                idStr = inputStr.substring(4);
                if (commandStr.equalsIgnoreCase(addStr)) {
                    cartConsole.addProduct(Long.parseLong(idStr));
                } else if (commandStr.equalsIgnoreCase(delStr)) {
                    cartConsole.removeProduct(Long.parseLong(idStr));
                } else if (commandStr.equalsIgnoreCase(showStr)) {
                    cartConsole.showCart();
                } else {
                    System.out.println("Try again");
                }
            } else if (!inputStr.equalsIgnoreCase(exitStr)) {
                System.out.println("Try again");
            }
        } while (!inputStr.equalsIgnoreCase(exitStr));
    }
}
