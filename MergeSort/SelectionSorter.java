import java.util.Arrays;
public class SelectionSorter
{
    public static void sort( int[] a)
    {
        for( int i = 0 ; i < a.length - 1; i++)
        {
            int minPos = minimumPosition(a, i);
            ArrayUtil.swap( a, minPos, i);
        }
    }

    private static int minimumPosition( int[] a, int from)
    {
        int minPos = from;
        for( int i = from + 1; i < a.length; i++)
        {
            if (a[i] < a[minPos])
            {
                minPos = i;
            }
        }
        return minPos;
    }

    public static void main(String[] args)
    {
        String[] a = ArrayUtil.randomStringArray(20);
        System.out.println( Arrays.toString(a));

        //SelectionSorter.sort(a);
        System.out.println(Arrays.toString(a));

    }
}
