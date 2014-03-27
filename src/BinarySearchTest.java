import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/** 
  * Java program to perform binary search in Java collection e.g List, Set
  * @author Javin Paul
  */
public class BinarySearchTest {

   
    public static void main(String args[]) {       
  
        //creating List
        List<Integer> numbers = new ArrayList<Integer>(1000000); //List of 1M records
       
        //initializing List
        for(int i =0; i<numbers.size(); i++){
            numbers.add(new Integer(i));
        }
      
        //performing contains search
        long startTime = System.nanoTime();
        boolean isExist = numbers.contains(new Integer(1000000));
        long totalTime = System.nanoTime() - startTime;


        System.out.println("Time to search 1Mth Record using contains() is {} nano seconds" + totalTime);
       
        //performing binary search
        startTime = System.nanoTime();
        Collections.sort(numbers);  // List needs to be sorted for Binary Search
        Integer number = Collections.binarySearch(numbers, new Integer(1000000));
        totalTime = System.nanoTime() - startTime;

        System.out.println("Time to search 1Mth Record using binary search is {} nano seconds" + totalTime);
    }
  
}

//Ouput:
//2013-06-04 23:23:17,834 0    [main] INFO  test.BinarySearchTest  - Time to search 1Mth Record using contains() is 51404 nano seconds
//2013-06-04 23:23:17,849 15   [main] INFO  test.BinarySearchTest  - Time to search 1Mth Record using binary search is 554261 nano seconds


//Read more: http://javarevisited.blogspot.com/2014/03/binary-search-vs-contains-performance.html#ixzz2xAyyyjsW