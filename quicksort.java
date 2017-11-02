import java.util.Random;

class QuickSort{
	
	//Swaps two numbers
	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	//Calls quicksort recursively 
	public static void quicksort(int[] array, int left, int right){
	
		if(left < right) {
			int q = partition(array, left, right);
			quicksort(array, left,  q-1);
			quicksort(array, q+1, right);
		}
	}
	
	//Partitions the array in which elements less than the pivot element are at  its left and greater at its right 
	public static int partition(int[] array, int start, int end){
		
		Random rand = new Random();
		int randomNumber = rand.nextInt(end) + start;
		
		//Swapping pivot element with random element
		swap(array, end, randomNumber);
		int x = array[end];
		
		int i = start - 1;
		for(int j = start; j <= end-1; j++){
			if(array[j] <= x){
				i++;
			swap(array, i, j);
			}	
		}
		
		swap(array, end, i+1);
		return i+1;
	}
	
	public static void main(String[] args){
		
		int[] array = {2, 8, 7, 1, 3, 5, 6, 4};
		
		System.out.println("Unsorted array");
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		
		quicksort(array, 0, array.length - 1);
	
		System.out.println("Sorted array");
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
}