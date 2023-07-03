package com.jspiders.carddekho_case_study.main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.jspiders.carddekho_case_study.entity.Car;
import com.jspiders.carddekho_case_study.operation.Operation;

public class CarDekhoMenu 
{
	 
   
   public static void displayMenu() {
	   
	   Operation operation=new Operation();
          
	   Scanner sc = new Scanner(System.in);
       int choice=0;

       do{
           System.out.println("Menu:");
           System.out.println("1. Add Car");
           System.out.println("2. Update Car");
           System.out.println("3. Search Car");
           System.out.println("4. Delete Car");
           System.out.println("5. Exit");
           System.out.print("Enter your choice: ");
           choice = sc.nextInt();

           switch (choice) {
               case 1:
                   // Add Car Logic
                   System.out.println("Adding car...");
                   operation.addCar();
                   break;

               case 2:
                   // Update Car Logic
                   System.out.println("Updating car...");
                   System.out.println("Enter car ID which want to update");
                   int carid = sc.nextInt();
                   operation.updateCar(carid);
                   break;

               case 3:
                   int searchChoice = 0;

                  do{
                       System.out.println("Search Car:");
                       System.out.println("1. By Name");
                       System.out.println("2. By Brand");
                       System.out.println("3. By Fuel Type");
                       System.out.println("4. Go back to the main menu");
                       System.out.print("Enter your choice: ");
                       searchChoice = sc.nextInt();

                       switch (searchChoice) {
                           case 1:
                               // Search by Name Logic
                               System.out.println("Searching car by name...");
                               operation.searchByName();

                               break;

                           case 2:
                               // Search by Brand Logic
                               System.out.println("Searching car by brand...");
                               operation.searchByBrand() ;
                               break;

                           case 3:
                               // Search by Fuel Type Logic
                               System.out.println("Searching car by fuel type...");
                               operation.searchCarByFuelType();
                               break;

                           case 4:
                               System.out.println("Going back to the main menu...");
                               break;

                           default:
                               System.out.println("Invalid choice!");
                               break;
                       }
                   
                   } while (searchChoice != 4);

                   break;

               case 4:
                   // Delete Car Logic
            	   operation.displayAllCarDetails();
                   System.out.println("Deleting car...");
                   System.out.println("Enter car ID which want to delete");
                   int cid = sc.nextInt();
                   operation.deleteCar(cid);
                   break;

               case 5:
                   System.out.println("Exiting...");
                   break;

               default:
                   System.out.println("Invalid choice!");
                   break;
           }
       }while(choice!=5);
   }
       

   }
	
	


