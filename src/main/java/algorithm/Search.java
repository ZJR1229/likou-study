package algorithm;

public class Search {
    // 折半查找
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Search s = new Search();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(s.search(nums, 6));
    }
}
