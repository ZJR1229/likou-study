package GaoPin;

public class K {

    private int res;
    private int n;
    private int k;

    public int findKth(int[] a, int n, int K) {
        this.n = n;
        this.k = K;
        quickSort(a, 0, n - 1);
        return res;
    }

    public void quickSort(int[] nums, int left, int right){
        if(left > right){
            return;
        }

        if(left == right){
            if(left == (this.n - this.k)){
                this.res = nums[left];
                return;
            }
        }

        int l = left;
        int r = right;
        int key = nums[left];
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
        if(l == (this.n - this.k)){
            this.res = key;
            return;
        } else{
            quickSort(nums, left, l - 1);
            quickSort(nums, l + 1, right);
        }

    }

    public void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }


    public static void main(String[] args) {
        K k = new K();
        int[] arr =  new int[]{10,10,9,9,8,7,5,6,4,3,4,2};
        int res = k.findKth(arr, 12, 3);
        System.out.println(res);



    }
}
