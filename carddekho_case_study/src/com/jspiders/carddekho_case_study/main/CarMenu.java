package com.jspiders.carddekho_case_study.main;

import java.util.Scanner;

public class CarMenu {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            displayMenu();
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Clear the newline character

	            switch (choice) {
	                case 1:
	                    addCar();
	                    break;
	                case 2:
	                    updateCar();
	                    break;
	                case 3:
	                    searchCar();
	                    break;
	                case 4:
	                    deleteCar();
	                    break;
	                case 5:
	                    System.out.println("Exiting the program...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        } while (choice != 5);
	    }

	    private static void displayMenu() {
	        System.out.println("Menu:");
	        System.out.println("1. Add Car");
	        System.out.println("2. Update Car");
	        System.out.println("3. Search Car");
	        System.out.println("4. Delete Car");
	        System.out.println("5. Exit");
	        System.out.print("Enter your choice: ");
	    }

	    private static void addCar() {
	        System.out.println("Add Car functionality");
	        // Add your logic for adding a car here
	    }

	    private static void updateCar() {
	        System.out.println("Update Car functionality");
	        // Add your logic for updating a car here
	    }

	    private static void searchCar() {
	        System.out.println("Search Car functionality");
	        // Add your logic for searching a car here
	    }

	    private static void deleteCar() {
	        System.out.println("Delete Car functionality");
	        // Add your logic for deleting a car here
	    }

}
