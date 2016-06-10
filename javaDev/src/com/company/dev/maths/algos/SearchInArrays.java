package com.company.dev.maths.algos;

/**
 * Abstract Data Structure - Stack and Queue.
 * 1. Queue - implemented for int. 
 * 2. GenericQueue - Generic Queue for any data type.
 * 3. Stack - integer stack implemented with two int Queue.
 * 4. GenericStack - implemented using two GenericStacks.
 * 2.
 * 3.
 * 4.
 * 5.
 * 6.
 * 7.
 * 
 * @author Pankaj Mondal
 *
 */
public class SearchInArrays {
	/**
	 * 1. Integer Queue.
	 * FIFO Data Structure.
	 * @author pkmon
	 *
	 */
	class Queue{
		int []q;
		int head=0,tail=0;
		public Queue(){
			this(100);
		}
		public Queue(int initSize){
			q=new int[initSize];
		}
		int size(){
			return tail-head;
		}
		
		Queue enque(int elem){
			q[tail++]=elem;
			return this;
		}
		int deque(){
			if(tail==0) throw new IllegalArgumentException("No element in the Queue to deque.");
			int telem=q[head];
			q[head]=0;
			head++;
			return telem;
		}
		void print(){
			System.out.println();
			for(int i=head;i<tail;i++)
				System.out.print(q[i]+" ");
		}
	}
	
	/**
	 * FIFO Data Structure.
	 * @author pkmon
	 *
	 */
	class GenericQueue<T>{
		T[] q;
		T telem;
		int head=0,tail=0;
		public GenericQueue(){
			this(100);
		}
		@SuppressWarnings("unchecked")
		public GenericQueue(int initSize){
			q=(T[])new Object[initSize];
		}
		int size(){
			return tail-head;
		}
		
		GenericQueue<T> enque(T elem){
			q[tail++]=elem;
			return this;
		}
		T deque(){
			if(tail==0) throw new IllegalArgumentException("No element in the Queue to deque.");
			telem=q[head];
			q[head]=null;
			head++;
			return telem;
		}
		void print(){
			System.out.println();
			for(int i=head;i<tail;i++)
				System.out.print(q[i]+" ");
		}
	}
	
	/**
	 * FILO Structure.
	 * @author pkmon
	 */
	class Stack{
		Queue pushq;
		Queue popq;
		int tos=0;
		public Stack(){
			pushq=new Queue();
			popq=new Queue();
		}
		void push(int elem){// put it at the TOP OF STACK. out it into - pushq
			while(popq.size()>0){
				pushq.enque(popq.deque());
			}
			pushq.enque(elem);
		}
		
		int pop(){// pop the element from the TOP OF STACK.
			while(pushq.size()>1){
				popq.enque(pushq.deque());
			}
			return pushq.deque();
		}
		void print(){
			pushq.print();
		}
	}
	class GenericlStack<T>{
		GenericQueue<T> pushq;
		GenericQueue<T> popq;
		int tos=0;
		public GenericlStack(){
			pushq=new GenericQueue<T>();
			popq=new GenericQueue<T>();
		}
		void push(T elem){// put it at the TOP OF STACK. out it into - pushq
			while(popq.size()>0){
				pushq.enque(popq.deque());
			}
			pushq.enque(elem);
		}
		
		T pop(){// pop the element from the TOP OF STACK.
			while(pushq.size()>1){
				popq.enque(pushq.deque());
			}
			return pushq.deque();
		}
		void print(){
			pushq.print();
		}
	}
	void stackQueue(){
		Stack s1=new Stack();
		s1.push(1);
		s1.push(2);
		s1.push(4);
		s1.print();
		int pop = s1.pop();
		System.out.println("pop: "+pop);
		s1.print();
		s1.push(8);
		s1.print();
		s1.push(16);
		s1.print();
		// Generic Stack implemented.
		GenericlStack<Integer> istack = new GenericlStack<Integer>();
		istack.push(1);
		istack.push(2);
		istack.push(4);
		istack.push(8);
		istack.print();
		istack.pop();
		istack.pop();
		istack.print();
		
		// Generic Stack implemented.
		GenericlStack<String> sstack = new GenericlStack<String>();
		sstack.push("Tom");
		sstack.push("Dick");
		sstack.push("Harry");
		sstack.push("Dutch");
		sstack.print();
		sstack.pop();
		sstack.pop();
		sstack.push("Hub");
		sstack.print();
	}
	
	public static void main(String[] args) {
		int[][]arr = {{1,2},{2,3},{3,4},{4,5},{3,2},{4,1} };
		SearchInArrays arrays=new SearchInArrays();
		int[][]resp = arrays.getIndexes(arr, 5);
		printIntArray(resp);
		
		int[] arri={1,2,3,4,5,-1,-2,3,-4,-5,6,7,8,9,9,9,10,1,1,-6,-7,-8,-9,-10};
		//arrays.getIndexes(arri,0);
		arrays.findRepeatedElement(arri);
		int[]sortedRepeatedIntArray = {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5};
		int repNo=5;
		int repeatedLower = arrays.binarySearch(sortedRepeatedIntArray, repNo, true);
		int repeatedHigher = arrays.binarySearch(sortedRepeatedIntArray, repNo, false);
		System.out.println(repNo +" is repeated: "+ (repeatedHigher-repeatedLower + 1)+" times.");
		arrays.stackQueue();
	}
	int binarySearch(int[]arr,int srchVal,boolean searchFirst){
		int low = 0, high = arr.length-1, result = -1;
		while(low <= high) {
			int mid=(low+high)/2;
			if(arr[mid] == srchVal){
				result=mid;
				if(searchFirst){
					high = mid - 1; // Go on searching towards left(lower indices).
				} else {
					low = mid + 1; // Go on searching towards right(higher indices).
				}
			} else if(srchVal < arr[mid]){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}
	void findDuplicates(int[]arr){
		
	}
	/**
	 * Find repeated element in an array..
	 * @param array
	 */
	void findRepeatedElement(int[]array){
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if (array[i]==array[j]){
					System.out.println(array[i]+"@ ("+i+","+j+")");
				}
			}
		}
	}
	
	/*
	 * Find the SUB ARRAY indexes having the sum as <number>
	 */
	int [][] getIndexes(int[]array, int number){
		if(array==null)return null;
		int[][]sorted=new int[array.length][2];
		int count=0;
		printIntArray(array);
		array=bubbleSort(array);
		printIntArray(array);
		int sum=sumOfArray(array);
		if(number==sum)return new int[][]{array};
		if(sum>=number){ // more possibilities.
			
			
		}
		return sorted;
	}
	int sumOfArray(int []array){
		if(array==null)return 0;
		int sum=0;
		for(int i:array) sum+=i;
		return sum;
	}
	int[] bubbleSort(int[]tobedorted){
		if(tobedorted==null)return null;
		if(tobedorted.length<2)return tobedorted;
		for(int i=0;i<tobedorted.length;i++){
			for(int j=i+1;j<tobedorted.length;j++){
				if(tobedorted[i]>tobedorted[j]){
					int temp=tobedorted[i];
					tobedorted[i]=tobedorted[j];
					tobedorted[j]=temp;
				}
			}
		}
		return tobedorted;
	}
	
	/*
	 * Find the SUB ARRAYS having the sum as <number>
	 */
	int [][] getIndexes(int[][]array, int number){
		if(array==null)return null;
		int[][]sorted=new int[array.length][2];
		int count=0;
		for(int i=0;i<array.length;i++){
			
			if( (array[i][0]+array[i][1]) == number){
				sorted[count]=array[i];
				count++;
				System.out.println("-- {"+array[i][0]+","+array[i][1]+"}");
			}
		}
		return sorted;
	}
	
	static void printIntArray(int[][]array){
		for(int i=0;i<array.length;i++){
			System.out.println();
			for (int j=0;j<array[i].length;j++){
				System.out.print(array[i][j]+ " ");
			}
		}
	}
	static void printIntArray(int[]array){
		System.out.println();
		for (int j : array) {
			System.out.print(j + " ");
		}
	}

}
