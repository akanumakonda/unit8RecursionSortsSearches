import java.util.Scanner;

/**
   This class processes baby name records.
*/
public class RecordReader
{
   private double total;
   private double limit;
   private double numberOfNames;
   /**
      Constructs a RecordReader with a zero total.
   */
   public RecordReader(double aLimit, int numberNames)
   {
      total = 0;
      limit = aLimit;
      numberOfNames = numberNames;
   }

   /**
      Reads an input record and prints the name if the current total is less 
      than the limit.
      @param in the input stream
   */
   public void process(Scanner s)
   {
      String name = s.next();
      String count = s.next();
                       while ( count.indexOf( "," , 0) != -1)
                 {
                     String first = count.substring( 0, count.indexOf(",", 0));
                     String last = count.substring( count.indexOf(",", 0) + 1, count.length()-1);
                     count = first + last;
                 }
      double percent = (double) Integer.parseInt(count)/ numberOfNames;
      
      if (total < limit) { System.out.print(name + " "); }
      total = total + percent;
   }

   /**
      Checks whether there are more inputs to process
      @return true if the limit has not yet been reached
   */
   public boolean hasMore()
   {
      return total < limit;
   }
}
