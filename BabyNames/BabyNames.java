import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNames
{
    public static final double LIMIT = .50;

    public static void main(String[] args) throws FileNotFoundException
    {  
        Scanner in = new Scanner(System.in);
        System.out.println("Enter File name");
        String fileName = in.next();
        try
        {
            File file = new File(fileName);
            Scanner s = new Scanner(file);
            System.out.println("Enter the number of girl names");
            int gnum = in.nextInt();
            System.out.println("Enter the number of boy names");
            int bnum = in.nextInt();
            RecordReader boys = new RecordReader(LIMIT, bnum);
            RecordReader girls = new RecordReader(LIMIT, gnum);

            while (boys.hasMore() || girls.hasMore())
            {
                String rank = s.next();
//                 while ( rank.indexOf( "," , 0) != -1)
//                 {
//                     String first = rank.substring( 0, rank.indexOf(",", 0));
//                     String last = rank.substring( rank.indexOf(",", 0) + 1, rank.length()-1);
//                     rank = first + last;
//                 }
                System.out.print(rank + " ");
                boys.process(s);
                girls.process(s);
                System.out.println();

               
            }
            s.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("File not found");
        }
    }
}   
