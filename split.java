	class split{
		private static int count = 0;
	
	public static void merge(int [] a, int [] b, int [] result){
		
		int index1 = 0, index2 = 0;
		
		int mid = (a.length + b.length)/2;
		

		for(int k = 0 ; k < result.length; k++){
			if(index1 == a.length){
				result[k] = b[index2];
				index2++;
				
			}else if(index2 == b.length){
				result[k] = a[index1];
				index1++;
				
			}else if(a[index1]<b[index2]){
				result[k] = a[index1];
				
			
				index1++;
			}else if(b[index2]<a[index1]){
				result[k] = b[index2];
					count += mid - index1;
				index2++;
			}
		}
	}
	
	public static void sort(int [] nums){
		
		int mid = nums.length/2;
		
		if (nums.length == 1)
			return;
		int[] d1 = new int[mid];
		int[] d2 = new int[nums.length - mid];
		for(int i = 0; i< nums.length; i++){
			if(i < mid)
				d1[i] = nums[i];
			else
				d2[i - mid] = nums[i];
		}
	
		//sort first half
		sort(d1);
		
		//sort second half
		sort(d2);
		
		//merge the two halves
		merge(d1, d2, nums);
	}
	
	public static void main(String[] args){
		int[] nums = {6, 5, 4, 3, 2, 1};
		sort(nums);
		System.out.println("Split inversion count is " + count);   // Output will be 15 
	}
}