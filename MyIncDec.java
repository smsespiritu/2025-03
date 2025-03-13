
public class MyIncDec {
    
    private static int x;
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        long startTime = System.nanoTime();
        increment();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Timing for increment is " + duration + "milliseconds");
        
        startTime = System.nanoTime();
        decrement();
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        System.out.println("Timing for decrement is " + duration + "milliseconds");
        
    }
    
    public static void increment() {
        x++;
    }
    
    public static void decrement() {
        x--;
    }
    
}
