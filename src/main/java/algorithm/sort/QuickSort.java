package algorithm.sort;


public class QuickSort {

    /**
     * 快排
     * @param nums
     * @param left
     * @param right
     */
    public void quickSort(int[] nums, int left, int right){
        // 结束
        if(left >=  right){
            return;
        }

        int l = left;
        int r = right;
        int key = nums[l];
        while(l < r){
            while(nums[r] >= key && l < r){
                r --;
            }

            while(nums[l] <= key && l < r){
                l ++;
            }

            if(l < r){
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        nums[left] = nums[l];
        nums[l] = key;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }

    public void printArr(int[] nums){
        for(int i = 0; i < nums.length; i ++){
            System.out.println(nums[i]);
        }
    }

    //  我是王八蛋



    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] nums = new int[]{1, 3, 2, 4, 6, 5};
        s.quickSort(nums, 0, 5);
        s.printArr(nums);
    }
}
