package printnumbers;

public class AscendingOrder {

	public static void main(String[] args) {
		
		 int[] a=new int[]{34,56,78,99,38};
		 int temp=0;
		 // Display elements of original array
		 System.out.println("Elements of Array:");
		for(int i=0;i<a.length;i++)
			
		{	
	   System.out.println(a[i]+"");
	  } 
		//Sort array in ascending order
		for(int i=0;i<a.length;i++)
		{  for(int j=i+1;j<a.length;j++)
		{  if(a[i]>a[j])
		{
			temp=a[i];
		    a[i]=a[j];
		    a[j]=temp;
		}
		}
		}
		// Display elements of array after sorting
		System.out.println("Elements of array sorted in ascending order");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]+"");
		}
}

}	

