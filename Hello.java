import java.lang.Math;
public class Hello {
    public static void main(String[] args) {
        int argLength = args.length;
        int sum = 0;
        int[] intArray = new int[argLength];

        for(int i = 0; i < argLength; i++) {            // Read in Ints
            intArray[i] = Integer.parseInt(args[i]);
        }

        for(int i = 0; i < intArray.length; i++) {      // Sum Array values
            sum =+ intArray[i];
            //System.out.println(intArray[i]);
        }
        
        for(int i = 0; i < intArray.length; i++) {
    
            if(intArray[i] % 2 == 0) {
               Systems.out.println(intArray[i])
            }
        }

        System.out.println(sum);

        System.out.println("Hello, World!");
    }
}


