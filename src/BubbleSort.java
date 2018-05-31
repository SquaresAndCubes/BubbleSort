/* Brent Vaalburg CSCI312
 * Davenport University
 * Week 3 Sorting Assignment
 * Dependencies: 
 * Java8 Standard Library
 */
import java.util.Random;
import java.util.stream.IntStream;

// Java program for implementation of Bubble Sort
class BubbleSort
{
    int sort(int array[])
    {
    	//set time counting variables to 0
    	long start = System.currentTimeMillis();
    	long end = 0;
    	long total = 0;
    	
    	//creates new int n to store the length of the array
        int n = array.length;
        
        //bubblesort algorithm
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
        
        //calculate time of sorting and store to toal variable
        end = System.currentTimeMillis();
        total = end - start;
        
        //return the total time
        return (int) total;
    }
    
    int[] randomInts(int count) {
    	
    	//use java8 stream api to generate array of random integers.
        int[] array = IntStream.generate(() -> new Random().nextInt(100)).limit(count).toArray();
        
        //return the array of random ints to pass to the sort method
        return array;
    }
 


    public static void main(String args[])
    {
    	//int array of sizes from the assignment instructions
    	int[] numElements = {100, 1000, 10000, 25000, 50000, 100000, 250000, 500000, 750000, 1000000};
    	
    	//Print console output header
    	System.out.println("Array Size | Sort Duration");
    	
    	//get size of numElements array for iteration
    	int n = numElements.length;
    	
    	//for loop to iterate through different sizes of arrays to make
    	for (int i = 0; i < n; i++) {
    		
    		//for each array size to make create a BubbleSort object
            BubbleSort object = new BubbleSort();
            
            //get which numElements item to print to console
            int a = numElements[i]; 
            
            //call the randomInts method on BubbleSort object to generate array based on size from numElements
            //then call the sort method on the random array built
            int b = object.sort(object.randomInts(numElements[i]));
            
            //print to console the size of the array and the time to sort in ms
            System.out.println(a + " items" + " | " + b + " ms");
    	}
        
    }
}
