//Time - O(n*log(n))
//Space - O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] array = new int[nums.length];
        int len = 1;
        array[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] > array[len-1]){
                array[len] = nums[i];
                len++;
            } else {
                int index = binarySearch(array, 0, len-1, nums[i]);
                array[index] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int[] arr,int low,int high,int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] < target)
                low = mid+1;
            else
                high=mid-1;
        }
        return low;
    }
}
