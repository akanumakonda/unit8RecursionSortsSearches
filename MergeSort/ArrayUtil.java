import java.util.Random;

/**
   This class contains utility methods for array manipulation.
*/  
public class ArrayUtil
{ 
   private static Random generator = new Random();

   /**
      Creates an array filled with random values.
      @param length the length of the array
      @param n the number of possible random values
      @return an array filled with length numbers between
      0 and n - 1
   */
   public static String[] randomStringArray(int length)
   {  
      String[] a = new String[length];      
      for (int i = 0; i < a.length; i++)
      {
         a[i] = randomString(10);
         }
      return a;
   }
   
   private static String randomString(int numChars)
   {
       String random = "";
       for (int i = 0; i <= numChars; i++)
       {
           int randNum = (int) (Math.random()*26);
           char c = (char) ('a' + randNum);
           random += c;
        }
       return random;
    }

   /**
      Swaps two entries of an array.
      @param a the array
      @param i the first position to swap
      @param j the second position to swap
   */
   public static void swap(int[] a, int i, int j)
   {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
}
      
