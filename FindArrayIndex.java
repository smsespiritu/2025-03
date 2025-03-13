import java.io.*;
import java.util.*;

public class FindArrayIndex {
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        Integer[] array = {4,9,3,7,8};
        Integer[] subarray = {3,7};
        
        int indexFound = findArray(array, subarray);
        System.out.println("SubArray Index Found in " + indexFound);
        
    }
    
    public static int findArray(Integer[] array, Integer[] subArray)
    {
        return Collections.indexOfSubList(Arrays.asList(array), Arrays.asList(subArray));
    }
    
}