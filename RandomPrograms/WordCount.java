import java.util.Scanner;
import java.io.File;
import java.lang.Exception;
import java.lang.Throwable;
import java.io.FileNotFoundException;
/**
 * Write a description of class WordCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordCount
{
    /** description of instance variable x (add comment for each instance variable) */
// 
//     public static void main(String[] args)
//     {
//         File inputFile = new File(wordFile);
//     }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter File name");
        String fileName = in.next();
        try
        {
            File file = new File(fileName);
            Scanner s = new Scanner(file);
            int count = 0;
            while (s.hasNext())
            {
                s.next();
                count++;
            }
            System.out.println(count);
            s.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("File not found");
        }
    }

}
