# Quick-Sort-with-Array-implementation-and-performance-analysis
Implemented in Java.

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

