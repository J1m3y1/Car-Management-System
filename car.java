package Project1;

/**
 * Represents a car object.
 * 
 * CSC 1351 Programming Project No 1
 * Section 002
 *
 * @author Jimmy Rubio Gonzalez
 * @since 03/17/24
 */

public class car implements Comparable<car> {
	private String make; // Represents the make of the car
    private int year; // Represents the year the car was manufactured
    private int price; // Represents the price of the car
    
    /**
    * Initializes a new instance of the car class.
    *
    * CSC 1351 Programming Project No 1
    * Section 002
    *
    * @author Jimmy Rubio Gonzalez
    * @since 03/17/24
    */
    public car(String make, int year, int price) {
        this.make = make;
        this.year = year;
        this.price = price;
    }

    /**
    * Gets the make of the car.
    *
    * CSC 1351 Programming Project No 1
    * Section 002
    *
    * @author Jimmy Rubio Gonzalez
    * @since 03/17/24
    */
    public String getMake() {
        return make;
    }

    /**
    * Gets the year of the car.
    *
    * CSC 1351 Programming Project No 1
    * Section 002
    *
    * @author Jimmy Rubio Gonzalez
    * @since 03/17/24
    */
    public int getYear() {
        return year;
    }

    /**
    * Gets the price of the car.
    *
    *CSC 1351 Programming Project No 1
    * Section 002
    *
    * @author Jimmy Rubio Gonzalez
    * @since 03/17/24
    */
    public int getPrice() {
        return price;
    }

    /**
    * Compares two cars for order based on make then year.
    *
    * CSC 1351 Programming Project No 1
    * Section 002
    *
    * @author Jimmy Rubio Gonzalez
    * @since 03/17/24
    */
    public int compareTo(car other) {
        if (make.compareTo(other.make) != 0) {
            return make.compareTo(other.make);
        } else {
            return Integer.compare(year, other.year);
        }
    }

    /**
    * Returns a string representation of the car.
    *
    * CSC 1351 Programming Project No 1
    * Section 002
    *
    * @author Jimmy Rubio Gonzalez
    * @since 03/17/24
    */
    public String toString() {
        return "Make: " + make + ", Year: " + year + ", Price: $" + price + ";";
    }
}