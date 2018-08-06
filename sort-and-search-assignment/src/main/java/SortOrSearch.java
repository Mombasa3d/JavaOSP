import java.util.ArrayList;

public class SortOrSearch {
	
	public Double[] initialList;
	public Double[] sortedList;

	public void Sort1(Double[] d)
	{
		ArrayList<Double> tempList = null ;
		int i = 1;
		
		while(i  < d.length)
		{
			int x = i;
			while(x > 0 && d[x - 1] > d[x] )
			{
				double temp = d[x];
				d[x] = d[x-1];
				d[x-1] = temp;
			}
			i++;
		}
		sortedList = (Double[]) tempList.toArray();
		
	}
	
	public void Sort2(Double[] d)
	{
		
	}
	
	public double SearchLinear(Double[] d, double val)
	{
		int i = 0;
		while(i < d.length)
		{
			if(d[i] == val)
			{
				return d[i];
			}
			i++;
		}
		return 0;
	}
	
	public double SearchBinary(Double[] d)
	{
		
	}
}
