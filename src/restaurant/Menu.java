package restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {
    static ArrayList<MenuItem> mainList = new ArrayList<MenuItem>();
    static ArrayList<MenuItem> removeList = new ArrayList<MenuItem>();
    static Iterator<MenuItem> mainIter = mainList.iterator();
    static Scanner keyboard = new Scanner(System.in);

    public static void addItem(String menuCategory, String menuDescription, Double menuPrice)
    {
        MenuItem newItem = new MenuItem(menuCategory, menuDescription,menuPrice);
        mainList.add(newItem);
    }//end of addItem method

    public static void removeItem(String itemDescription)
    {//java.lang.IllegalStateException you must call next method of iterator
        for(MenuItem menu : mainList)
        {
            if(menu.getDescription().equals(itemDescription))
            {
                removeList.add(menu);
            }
        }
        mainList.removeAll(removeList);
    }//end of removeItem method

    public static void listMenuItem(String itemDescription)
    {
        for(MenuItem menu : mainList)
        {
            if(menu.getDescription().equals(itemDescription))
            {
                System.out.println(menu.toString());
            }
        }

    }//end of listMenuItem method

    public static void listMenu()
    {
        for(MenuItem menu : mainList)
        {
            if(menu instanceof MenuItem)
            {
                System.out.println(menu.toString());
            }
        }//end of for loop

    }//end of listMenu method

    public static void listDuplicateItems()
    {
        int cnt = 0;
        for(MenuItem menu : mainList)
        {
            if(menu instanceof MenuItem)
            {
                //System.out.println("1"+menu.toString());
                for(MenuItem menu1 : mainList) {
                    if(menu1 instanceof MenuItem) {
                        if((menu.toString()).equals(menu1.toString())) {
                            cnt = cnt + 1;
                        }
                    }
                }

            }
        }//end of for loop
        if(cnt > 1)
            System.out.println("Duplicate Item exists");
    }

    public static void showMenu() {
        System.out.println("1. Add Item to Menu ");
        System.out.println("2. Remove Item from Menu");
        System.out.println("3. List all Items on Menu");
        System.out.println("4. List specific Item on Menu");
        System.out.println("5. Check for duplicate Menu Items");
        //System.out.println("6. Quit");
        int action = 0;
        int action1 = 0;
        action1 = keyboard.nextInt();

        Scanner parameter1 = new Scanner(System.in);
        Scanner parameter2 = new Scanner(System.in);
        Scanner parameter3 = new Scanner(System.in);
        //System.out.println(action1);
        action = action1;
        while(action != 0) {
            action = action1;
            //System.out.println(action);
            switch (action) {
                case 6:

                    break;
                case 1:
                    System.out.println("Type in the category of the item you want to add.");
                    String category = parameter1.next();
                    System.out.println("Type in the description of the item you want to add.");
                    String description = parameter2.next();
                    System.out.println("Type in the price of the item you want to add.");
                    Double price = parameter3.nextDouble();
                    addItem(category, description, price);
                    listMenu();
                    showMenu();

                    break;
                case 2:
                    System.out.println("Type in the description of the item you want to remove.");
                    String description1 = parameter2.next();
                    removeItem(description1);
                    listMenu();
                    showMenu();

                    break;
                case 3:
                    listMenu();
                    showMenu();

                    break;
                case 4:
                    System.out.println("Type in the description of the item you want to remove.");
                    String description2 = parameter3.next();
                    listMenuItem(description2);
                    showMenu();

                    break;
                case 5:
                    listDuplicateItems();
                    showMenu();

                    break;
            }
        }
    }
    public static void main(String[] args){
        showMenu();
    }
}
