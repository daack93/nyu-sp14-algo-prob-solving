import java.io.*;
import java.util.*;

public class Sorting
{
    public static void main(String[] args) throws Exception
    {	
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String line;
	ArrayList<Integer> al = new ArrayList<Integer>(1100000);
	while ((line = in.readLine()) != null)
	{
	    al.clear();
	    StringTokenizer st = new StringTokenizer(line);
	    while (st.hasMoreTokens()) 
		al.add(Integer.parseInt(st.nextToken()));
	    Collections.sort(al);
	    boolean found = false;
	    for (int i = 0; i < al.size() && !found; ++i)
	    {
		if (al.get(i) != i+1)
		{
		    System.out.println(i+1);
		    found = true;
		}
	    }
	    if (!found) System.out.println(al.size()+1);
	}
    }
}
