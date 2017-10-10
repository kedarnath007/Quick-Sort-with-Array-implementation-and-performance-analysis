/****************************************************/
// Filename: Qsort.java
// Change history:
// 04.10.2017 / Kedarnath Kurnool Gandla
/****************************************************/

/* This class is responsible for sorting the numbers using Quick sort algorithm.
/****************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Qsort 
{
	public static int partition(ArrayList<Float> a,int m, int n)
	{
		Float pivot;
		int i;
		pivot = a.get(n);
		i=m-1;
		for (int j=m;j<n;j++)
		{
			if(a.get(j)<pivot)
			{
				i++;
				swap(a,i,j);
			}
		}
		swap(a,i+1,n);
		return i+1;
	}
//Below function will call the quicksort recursively.
	public static void quicksort(ArrayList<Float> a,int p,int q)
	{
		if(p<q)
		{	
			int index;
			index = partition(a,p,q);
			quicksort(a,p,index-1);
			quicksort(a,index+1,q);
		}
	}
//Below fucntion will swap the elements for the given ArrayList.
	public static void swap(ArrayList<Float> a,int i, int j)
	{
		Float t;
		t=a.get(i);
		a.set(i,a.get(j));
		a.set(j,t);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		int len,s=0,t=0;
		String str,outputFile;
		long starttime,endtime;
		int[] size = new int[args.length];
		long[] time = new long[args.length];
		BufferedReader br = null;
		BufferedWriter bw = null;
		FileWriter fw = null;
		File inputfile = null;
		outputFile = "answers.txt";
		fw = new FileWriter(outputFile);
		bw = new BufferedWriter(fw);
		/*The main reason for using ArrayList to Array is because they are dynamic and if here are multiple lines in the Input file, 
		we cannot determine the exact length to create an array of definite size*/ 
		
		for(String name:args)
		{
			ArrayList<Float> a = new ArrayList<Float>();
			inputfile = new File(name);
			if (args.length<=0)
				return;
			br = new BufferedReader(new FileReader(inputfile));//directing to the input file for reading values
			while((str=br.readLine())!= null)
				{
					String[] ar = str.split(";"); //Extract all numbers separated by semi colon from inputfile as string
					for (int i=0 ;i<ar.length;i++)
					{
						if(ar[i].trim().length()>0) //Handle the white spaces between two semi-colons
						{
							a.add(Float.parseFloat(ar[i].trim())); //Converts the string into Integer and add it to ArrayList
						}
					}
				}
			len = a.size();//determining the size of ArrayList
			if (len>0)
			{
				starttime=System.currentTimeMillis();
				quicksort(a,0,len-1); //passing the reference of the ArrayList and length of the ArrayList
				endtime=System.currentTimeMillis();
			}
			else
				return;
			bw.write(name+": ");
			for(int i=0;i<a.size()-1;i++)
				bw.write(a.get(i).toString()+" ; ");//Inserts all sorted elements into the new output file
			bw.write(a.get(a.size()-1).toString()); //Insert the last element without semi colon at he end
			bw.newLine();
			bw.newLine();
			size[s]=len;
			time[t]=endtime-starttime;
			s++;
			t++;
		}
		bw.write("Performance Analysis:");
		bw.newLine();
		bw.write("InputFileName\tsize\tSorting Time(in milliseconds)");
		bw.newLine();
		for(int i=0;i<args.length;i++)
		{
			bw.write(args[i]+"\t"+size[i]+"\t"+time[i]);
			bw.newLine();
		}
		if(bw != null)
			bw.close();
		if(fw != null)
			fw.close();
	}
}
/* ReadMe Content:
 --------------------
Platform/Compiler
--------------------

jGrasp        (Platform)
javac           (compiler)

---------------------------------
Command Line Arguments
---------------------------------
	javac Qsort.java 					(Compiling)
	java  Qsort input1.txt input2.txt input3.txt 		(Running)

input1.txt, input2.txt, input3.txt - Input files with different numbers
Qsort.java - Source File

---------------------------------
Input/Output & Issues
---------------------------------

1. The Input file path has to be given in the Comand Line. If the input file name is not mentioned in the Command Line,
an empty output file (answers.txt) is created without any data.

2.  The Output file (answers.txt) is created with the sorted order of the numbers available in input file in the default folder where the source code is present.

3. Multiple file names can be provided as input at commandline while running.

4. File name and its sequence order will be displayed in the "answers.txt" file. 
Additionally, performance attributes like size and time taken for the algorithm to sort the given sequence will also be printed in the result file.

(Note: The time calculated for the Quick sort algorithm to run for small input values will be displayed as 0. 
Please provide larger input for time difference to be displayed.)
------------------
Program Design 
------------------

Main Function:

1. The input file path/paths is fetched from the comand line argument.

2. The file is being read using BufferedReader and the data (numbers) stored in a String array. 
    These numbers in String array are converted into Integer and added for the ArrayList.

3. The ArrayList reference and the length of the ArrayList is sent to the Insertion sort module.

4. Once the numbers in the ArrayList are sorted, these are inserted into the new file (answers.txt) and saved in the default file path where the source code is available.


quickSort(ArrayList a, int p, int q):

This module will recursively call itself and sort the elements according to Quick sort algorithm.

partition(ArrayList a, int p, int q):

This module will consider an element as pivot and divide all the elements less than this value towards left and others towards right.

swap(ArrayList<Float> a,int i, int j):

This method will swap the elements in the given array list at provided indices.

-------------------
Algorithm
-------------------

Step 1 - Choose the highest index value has pivot
Step 2 - Take two variables to point left and right of the list excluding pivot
Step 3 - left points to the low index
Step 4 - right points to the high
Step 5 - while value at left is less than pivot move right
Step 6 - while value at right is greater than pivot move left
Step 7 - if both step 5 and step 6 does not match swap left and right
Step 8 - if left = right, the point where they met is new pivot

-------------------
Pseudo Code	
-------------------

procedure quickSort(left, right)

   if right-left <= 0
      return
   else     
      pivot = A[right]
      partition = partitionFunc(left, right, pivot)
      quickSort(left,partition-1)
      quickSort(partition+1,right)    
   end if		
   
end procedure

function partitionFunc(left, right, pivot)
   leftPointer = left
   rightPointer = right - 1

   while True do
      while A[++leftPointer] < pivot do
         //do-nothing            
      end while
		
      while rightPointer > 0 && A[--rightPointer] > pivot do
         //do-nothing         
      end while
		
      if leftPointer >= rightPointer
         break
      else                
         swap leftPointer,rightPointer
      end if
		
   end while 
	
   swap leftPointer,right
   return leftPointer
	
end function

*/