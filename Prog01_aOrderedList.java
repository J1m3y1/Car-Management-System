package Project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
* Represents a program to manage an ordered list of cars.
*
* CSC 1351 Programming Project No 1
* Section 002
*
* @author Jimmy Rubio Gonzalez
* @since 03/17/24
*
*/
public class Prog01_aOrderedList {
	/**
	 * Main method to manage an ordered list of cars based on user input.
	 * 
	 * CSC 1351 Programming Project No 1
	 * Section 002
	 *
	 * @author Jimmy Rubio Gonzalez
	 * @since 03/17/24
	 */
    public static void main(String[] args) {
        aOrderedList orderedList = new aOrderedList();

        try {
            Scanner scanner = GetInputFile("Enter input filename: ");
            PrintWriter writer = GetOutputFile("Enter output filename: ");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String input = parts[0];
                if (input.equals("A")) {
                    String make = parts[1];
                    int year = Integer.parseInt(parts[2]);
                    int price = Integer.parseInt(parts[3]);
                    car newCar = new car(make, year, price);
                    orderedList.add(newCar);
                } else if (input.equals("D")) {
                    if(parts.length == 3) {
                    	String make = parts[1];
                        int year = Integer.parseInt(parts[2]);
                        orderedList.remove(make, year);
                    }
                    else if(parts.length == 2) {
                    	orderedList.remove(Integer.parseInt(parts[1]));
                    }
                }
            }

            scanner.close();

            outputList(writer, orderedList);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    

    /**
    * Gets the input file based on the user prompt.
    * 
    * CSC 1351 Programming Project No 1
    * Section 002
    *
    * @author Jimmy Rubio Gonzalez
    * @since 03/17/24
    */
    public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String filename;
        do {
            System.out.print(UserPrompt);
            filename = scanner.nextLine();
            File file = new File(filename);
            if (file.exists()) {
                return new Scanner(file);
            } else {
                System.out.println("File specified <" + filename + "> does not exist. Would you like to continue? <Y/N>");
                String done = scanner.nextLine();
                if (done.equals("N") || done.equals("n")) {
                    scanner.close();
                	throw new FileNotFoundException();
                }
            }
        } while (true);
    }

    /**
    * Gets the output file based on the user prompt.
    *
    * CSC 1351 Programming Project No 1
    * Section 002
    *
    * @author Jimmy Rubio Gonzalez
    * @since 03/17/24
    */
    public static PrintWriter GetOutputFile(String UserPrompt) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String filename;
        do {
            System.out.print(UserPrompt);
            filename = scanner.nextLine();
            File file = new File(filename);
            if (file.exists()) {
                 return new PrintWriter(file);
            } else {
                System.out.println("Folder is write-protected. Would you like to continue? <Y/N>");
                String done = scanner.nextLine();
                if (done.equals("N") || done.equals("n")) {
                   scanner.close();
                	throw new FileNotFoundException();
                }
            }
        } while (true);
    }

    /**
    * Outputs the list of cars to the specified writer.
    *
    * CSC 1351 Programming Project No 1
    * Section 002
    *
    * @author Jimmy Rubio Gonzalez
    * @since 03/17/24
    */
    public static void outputList(PrintWriter writer, aOrderedList orderedList) {
        writer.println("Number of cars: " + orderedList.size());

        orderedList.reset();
        while (orderedList.hasNext()) {
            car car = (car) orderedList.next();
            writer.println("\nMake: \t" + car.getMake());
            writer.println("Year: \t" + car.getYear());
            writer.println("Price: $" + car.getPrice());
        }
    }
}


	