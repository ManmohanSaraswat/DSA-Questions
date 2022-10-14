import java.util.Arrays;

public class LargestPerimeterTriangle {

    // calculating using formula
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for(int i = n-1; i >= 2; i--){
            double a = nums[i], b = nums[i-1], c = nums[i-2]; 
            double s = (a + b + c)/2.0;
            int res = (int)Math.ceil(Math.sqrt(s*(s-a)*(s-b)*(s-c)));
            if(res > 0)
                ans = Math.max(ans, nums[i] + nums[i-1] + nums[i-2]);
        }
        return ans;
    }

    // if a >= b >= c, to make a non-zero area triangle, a < b + c 
    public int largestPerimeterSimplerMethod(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length-1; i >= 2; i--){
            if(nums[i] < nums[i-1] + nums[i-2])
                return nums[i] + nums[i-1] + nums[i-2];
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println((int)Math.sqrt(-1));
        new LargestPerimeterTriangle().largestPerimeter(new int[]{1, 2, 3, 4, 5});
    }
}
