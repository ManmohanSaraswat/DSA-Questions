public class RearrangeArrayElementsbySign {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int pos = 0, neg = 0, flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (flag == 0) {
                while (nums[pos] < 0)
                    pos++;
                res[i] = nums[pos];
                flag = 1;   
                pos++;
            } else {
                while (nums[neg] > 0)
                    neg++;
                res[i] = nums[neg];
                flag = 0;
                neg++;
            }
        }
        return res;
    }
}