package Project1;

import java.util.Arrays;

/**
 * Represents an ordered list of cars.
 * 
 * CSC 1351 Programming Project No 1
 * Section 002
 *
 * @author Jimmy Rubio Gonzalez
 * @since 03/17/24
 */
public class aOrderedList {
	final int SIZEINCREMENTS = 20; // Size increments for resizing the list
    private Comparable[] oList; // Array to store objects
    private int listSize; // Total size of the list
    private int numObjects; // Number of objects currently in the list
    private int curr; // Current position pointer in the list

/**
* Initializes a new instance of the aOrderedList class.
* 
* CSC 1351 Programming Project No 1
* Section 002
*
* @author Jimmy Rubio Gonzalez
* @since 03/17/24
*/
public aOrderedList() {
    this.numObjects = 0;
    this.listSize = this.SIZEINCREMENTS;
    this.oList = new Comparable[this.SIZEINCREMENTS];
    this.curr = -1;
}

/**
* Adds a new car to the ordered list.
*
* CSC 1351 Programming Project No 1
* Section 002
*
* @author Jimmy Rubio Gonzalez
* @since 03/17/24
*/
public void add(Comparable newObject) {
	//Checks to see if theres capacity for the new object, if not it increases SIZEINCREMENTS by 1.
    if (this.numObjects == this.listSize) {
    	this.listSize += this.SIZEINCREMENTS;
    	oList = Arrays.copyOf(oList, this.listSize);
    }
    //Finds insertion index
    int insertIndex = 0;
    while (insertIndex < this.numObjects && this.oList[insertIndex].compareTo(newObject) < 0) {
        insertIndex++;
    }
    //Shifts the elements to the right to make room for new object
    System.arraycopy(this.oList, insertIndex, this.oList, insertIndex + 1, this.numObjects - insertIndex);
    //Inserts new object
    this.oList[insertIndex] = newObject;
    //Updates number of objects
    this.numObjects++;
}

/**
* Gets the car at the specified index.
*
* CSC 1351 Programming Project No 1
* Section 002
*
* @author Jimmy Rubio Gonzalez
* @since 03/17/24
*/
public Comparable get(int index) {
    return this.oList[index];
}

/**
* Gets the next car in the ordered list.
*
* CSC 1351 Programming Project No 1
* Section 002
*
* @author Jimmy Rubio Gonzalez
* @since 03/17/24
*/
public Comparable next() {
    if (hasNext()) {
    	//Provides next element
        return this.oList[++curr];
    } else {
        return null;
    }
}

/**
* Checks if there is a next car in the ordered list.
*
* CSC 1351 Programming Project No 1
* Section 002
*
* @author Jimmy Rubio Gonzalez
* @since 03/17/24
*/
public boolean hasNext() {
	if (this.curr < this.numObjects) {
		return true;
	}
	else {
		return false;
	}
	}

/**
* Resets the current position in the ordered list.
* 
* CSC 1351 Programming Project No 1
* Section 002
*
* @author Jimmy Rubio Gonzalez
* @since 03/17/24
*/
public void reset() {
	this.curr = -1;
}

/**
* Gets the number of cars in the ordered list.
*
* CSC 1351 Programming Project No 1
* Section 002
*
* @author Jimmy Rubio Gonzalez
* @since 03/17/24
*/
public int size() {
    return this.numObjects;
}

/**
* Checks if the ordered list is empty.
*
* CSC 1351 Programming Project No 1
* Section 002
*
* @author Jimmy Rubio Gonzalez
* @since 03/17/24
*/
public boolean isEmpty() {
	if (this.numObjects == 0) {
		return true;
	}
	else {
		return false;
	}
}

/**
 * Removes a car from the ordered list.
 *
 * CSC 1351 Programming Project No 1
 * Section 002
 *
 * @author Jimmy Rubio Gonzalez
 * @since 03/17/24
 */
 public void remove(String make, int year) {   
	 for (int i = 0; i < this.numObjects; i++) {
	        car car = (car) this.oList[i]; 
	        if (car.getMake().equals(make) && car.getYear() == year) {
	        	//Removes car object from list and shifts all elements one postion to the left 
	            System.arraycopy(this.oList, i + 1, this.oList, i, this.numObjects - i - 1);
	            this.numObjects--;
	          
	        }
	    }
	   
	}
/**
* Removes a car from the ordered list at a specified index.
*
* CSC 1351 Programming Project No 1
* Section 002
*
* @author Jimmy Rubio Gonzalez
* @since 03/17/24
*/
 
 public void remove(int index) {
	// Check if index is out of bounds  
	 if (index < 0 || index >= this.numObjects) {
	        throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
	    }
	 else {
		for(int i = index; i < this.numObjects - 1; i++) {
			oList[i] = oList[i + 1];
		}
	    //If index is in bounds it removes the object and shifts all elements on postion to the left
	    System.arraycopy(this.oList, index + 1, this.oList, index, this.numObjects - index - 1);
	    this.numObjects--;
	}
 }

/**
* Returns a string representation of the ordered list.
*
* CSC 1351 Programming Project No 1
* Section 002
*
* @author Jimmy Rubio Gonzalez
* @since 03/17/24
*/
public String toString() {
    StringBuilder carInfo = new StringBuilder("[");
    for (int i = 0; i < this.numObjects; i++) {
        carInfo.append(this.oList[i].toString());
        if (i < this.numObjects - 1) {
        	carInfo.append(", ");
        }
    }
    carInfo.append("]");
    return carInfo.toString();
}
}
