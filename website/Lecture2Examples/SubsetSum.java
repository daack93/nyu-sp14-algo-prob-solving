import java.io.*;
import java.util.*;

public class SubsetSum
{
    static class LexicoComp implements Comparator<ArrayList<Integer>>
    {
	public int compare(ArrayList<Integer> a, ArrayList<Integer> b)
	{
	    int m = Math.min(a.size(),b.size());
	    for (int i = 0; i < m; ++i)
	    {
		int av = a.get(i), bv = b.get(i);
		if (av != bv) return av < bv ? -1 : 1;
	    }
	    if (a.size() != b.size()) 
		return a.size() < b.size() ? -1 : 1;
	    return 0;
	}
    }

    public static void main(String[] args) throws Exception
    {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String line = in.readLine();
	String[] toks = line.split("\\s+");
	int[] arr = new int[toks.length];
	for (int i = 0; i < toks.length; ++i) 
	    arr[i] = Integer.parseInt(toks[i]);
	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	for (int mask = 1; mask < (1<<arr.length); ++mask)
	{
	    ArrayList<Integer> curr = new ArrayList<Integer>();
	    int sum = 0;
	    for (int i = 0; i < arr.length; ++i)
	    {
		int currBit = 1<<i;
		if ( (mask & currBit) != 0 )
		{
		    sum += arr[i];
		    curr.add(arr[i]);
		}    
	    }
	    if (sum == 0) list.add(curr);
	}
	Collections.sort(list, new LexicoComp());
	for (ArrayList<Integer> al : list)
	{
	    for (int i = 0; i < al.size(); ++i)
	    {
		if (i > 0) System.out.print(" ");
		System.out.print(al.get(i));
	    }
	    System.out.println();
	}
    }
}
