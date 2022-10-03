import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    private class Pair implements Comparable<Pair>{
        int a, b;
        public int compareTo(Pair p){
            return this.a - p.a;
        }
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    private int binarySearch(Pair []arr, int start, int end, int target){
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid].a == target) return mid;
            if(arr[mid].a < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
    public List<List<Integer>> twoSum(Pair[] arr, int target, int x) {
        List<List<Integer>> res = new ArrayList<>();
        int index = -1;
        for(int i = x; i < arr.length; i++){
            if(i != x && arr[i].a == arr[i-1].a) continue;
            if((index = binarySearch(arr, i+1, arr.length-1, -1 * (target + arr[i].a))) != -1) {
                List<Integer> ans = new ArrayList<>();
                ans.add(arr[i].a);
                ans.add(arr[index].a);
                res.add(ans);
                index = -1;
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(int []nums){
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Pair[] arr = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = new Pair(nums[i], i);
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            if(i != 0 && arr[i].a == arr[i-1].a) continue;
            int target = arr[i].a;
            List<List<Integer>> ans = twoSum(arr, target, i+1);
            for(List<Integer> l : ans){
                l.add(arr[i].a);
                res.add(l);
            }
        }
        return res;
    }
    // public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
//         Set<String> set = new HashSet<>();
//         List<List<Integer>> ans = new ArrayList<>();
//         for(int i = 0; i < nums.length; i++){
//             for(int j = i + 1; j < nums.length; j++){
//                 int target = nums[i] + nums[j];
//                 if(target <= 0)
//                     target = Math.abs(target);
//                 else
//                     target = target * -1;
//                 int index = Arrays.binarySearch(nums, j + 1, nums.length, target);
//                 if(index >= j+1){
//                     String s = nums[i] + " " + nums[j] + " " + nums[index];
//                     set.add(s);
//                 }
//             }
//         }
        
//         for(String s : set){
//             String brr[] = s.split(" ");
//             List<Integer> ls = new ArrayList<>();
//             ls.add(Integer.parseInt(brr[0]));
//             ls.add(Integer.parseInt(brr[1]));
//             ls.add(Integer.parseInt(brr[2]));
//             ans.add(ls);
//         }
//         return ans;
//     }
}