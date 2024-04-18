import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        
        Menu menu = new Menu();
        ArrayList<Item> items = menu.getMenu();
        Scanner scnr = new Scanner(System.in);


        boolean run = true;

        while(run){
            System.out.println("Welcome to Hot Chicken Shop!");
            System.out.println("Would you like to: ");
            System.out.println("\t1. Order Take-away");
            System.out.println("\t2. Order Delivery");
            int choice = 0;
            
            while (true) {
                try {                
                    choice = scnr.nextInt();
                    break;
                } catch (InputMismatchException ime) {
                    System.out.println("Enter a valid number.");
                    scnr.nextLine();
                }
            }
            switch(choice){
                case 1:
                    ArrayList<Receipt> receiptList = new ArrayList<>();
                    System.out.println(menu);
                    boolean ordering = true;
                    while (ordering) {
                        while(true){
                            try{
                                System.out.println("Please enter the ID of the food you want (or enter 0 to stop):");
                                int choiceID = scnr.nextInt();
                                if (choiceID == 0) {
                                    ordering = false;
                                    break;
                                }

                                System.out.println("Please enter the quantity of food you want:");
                                int quantity = scnr.nextInt();

                                Item newItem = null;
                                for (Item item : menu.getMenu()) {
                                    if (item.getId() == choiceID) {
                                        newItem = item;
                                        break;
                                    }
                                }

                                if (newItem != null) {
                                    Receipt receipt = new Receipt(newItem, quantity);
                                    receiptList.add(receipt);
                                } else {
                                    System.out.println("Invalid item ID.");
                                }

                                scnr.nextLine();

                                System.out.println("Are you done ordering? Y/N");
                                String continueOrder = scnr.nextLine().toUpperCase();
                                while (true) {
                                    if (continueOrder.equals("Y") || continueOrder.equals("N")) {
                                         break; // Break the loop if the input is either Y or N
                                    } else {
                                        System.out.println("Please enter either 'Y' or 'N'.");
                                        continueOrder = scnr.nextLine().toUpperCase();
                                    }
                                }

                                if (continueOrder.equals("Y")) {
                                    ordering = false;
                                    break;
                                }

                            }catch(InputMismatchException ime){
                                System.out.println("Please enter valid input");
                                scnr.nextLine();
                            }

                        }
                    }
                    
                    double total = 0;

                    System.out.println("Receipt:");
                    for (Receipt receipt : receiptList) {
                        System.out.println(receipt);
                        total += receipt.getPrice();
                    }
                    
                    System.out.printf("Total: $%.2f\n", total);

                    boolean validInput = true;

                    while(validInput){
                        try{

                            System.out.println("Please enter you name for the order: ");
                            String name = scnr.nextLine();
                            System.out.println("Please enter your method of payment, Card/Cash: ");
                            String paymentType = scnr.nextLine();
                            System.out.println("Please enter the time you want the order to be ready(Enter time as decimal, Ex. 12.30): ");
                            Double expectedTime = scnr.nextDouble();
                            Order order = new Order(name,paymentType,expectedTime);

                            PrintWriter pw = new PrintWriter(new FileWriter("receipt.txt"));
                            pw.println(order);
                            pw.println(receiptList);
                            pw.println("Total: $%.2f\n" + total);
                    
                            pw.close();
                            System.out.println("Thank you for you order, you will get your receipt shortly...(Check File)");
                            validInput = false;
                        }catch(InputMismatchException ime){
                            System.out.println("Please enter a valid imput");
                            scnr.nextLine();
                        }catch (IOException e) {
                        e.printStackTrace();
                        }
                    }
                    
                    run = false;
                    break;
                
                case 2:
                    ArrayList<Receipt> receiptListDelivery = new ArrayList<>();
                    boolean orderingDelivery = true;
                    System.out.println(menu);
                    while (orderingDelivery) {
                        while(true){
                            try{
                                System.out.println("Please enter the ID of the food you want (or enter 0 to stop):");
                                int choiceID = scnr.nextInt();
                                if (choiceID == 0) {
                                    orderingDelivery = false;
                                    break;
                                }

                                System.out.println("Please enter the quantity of food you want:");
                                int quantity = scnr.nextInt();

                                Item newItem = null;
                                for (Item item : menu.getMenu()) {
                                    if (item.getId() == choiceID) {
                                        newItem = item;
                                        break;
                                    }
                                }

                                if (newItem != null) {
                                    Receipt receipt = new Receipt(newItem, quantity);
                                    receiptListDelivery.add(receipt);
                                } else {
                                    System.out.println("Invalid item ID.");
                                }

                                scnr.nextLine();

                                System.out.println("Are you done ordering? Y/N");
                                String continueOrder = scnr.nextLine().toUpperCase();
                                while (true) {
                                    if (continueOrder.equals("Y") || continueOrder.equals("N")) {
                                         break; // Break the loop if the input is either Y or N
                                    } else {
                                        System.out.println("Please enter either 'Y' or 'N'.");
                                        continueOrder = scnr.nextLine().toUpperCase();
                                    }
                                }

                                if (continueOrder.equals("Y")) {
                                    orderingDelivery = false;
                                    break;
                                }

                            }catch(InputMismatchException ime){
                                System.out.println("Please enter valid input");
                                scnr.nextLine();
                            }

                        }
                    }
                    
                    double totalDelivery = 0;

                    System.out.println("Receipt:");
                    for (Receipt receipt : receiptListDelivery) {
                        System.out.println(receipt);
                        totalDelivery += receipt.getPrice();
                    }
                    
                    System.out.println("Total: $%.2f\n" + totalDelivery);

                    boolean validInputDelivery = true;

                    while(validInputDelivery){
                        try{

                            System.out.println("Please enter your name for the order: ");
                            String name = scnr.nextLine();

                            System.out.println("Please enter your method of payment, Card/Cash: ");
                            String paymentType = scnr.nextLine();

                            System.out.println("Please enter the time you want the order to be delivered(Enter time as decimal, Ex. 12.30): ");
                            double expectedTime = scnr.nextDouble();

                            System.out.println("Please enter your delivery address: ");
                            scnr.nextLine();
                            String address = scnr.nextLine();

                            Delivery orderDelivery = new Delivery(name, paymentType, expectedTime, address);

                            PrintWriter pw = new PrintWriter(new FileWriter("receipt.txt"));
                            pw.println(orderDelivery);
                            for (Receipt receipt : receiptListDelivery) {
                                pw.println(receipt);
                            }
                            pw.println("Total: $%.2f\n" + totalDelivery);
                    
                            pw.close();
                            System.out.println("Thank you for your order, you will get your receipt shortly...(Check File)");
                            validInputDelivery = false;
                        }catch(InputMismatchException ime){
                            System.out.println("Please enter a valid input");
                            scnr.nextLine();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    
                    run = false;
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }            

        }


    }
}