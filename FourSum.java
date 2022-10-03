import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
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
    private int binarySearch(Pair []arr, int start, int end, long target){
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
    public List<List<Integer>> twoSum(Pair[] arr, long target, int x) {
        List<List<Integer>> res = new ArrayList<>();
        int index = -1;
        for(int i = x; i < arr.length; i++){
            if(i != x && arr[i].a == arr[i-1].a) continue;
            if((index = binarySearch(arr, i+1, arr.length-1, target - arr[i].a)) != -1) {
                List<Integer> ans = new ArrayList<>();
                ans.add(arr[i].a);
                ans.add(arr[index].a);
                res.add(ans);
                index = -1;
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(Pair[] arr, long target, int x){
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        for(int i = x; i < n; i++){
            if(i != x && arr[i].a == arr[i-1].a) continue;
            List<List<Integer>> ans = twoSum(arr, target - arr[i].a, i+1);
            for(List<Integer> l : ans){
                l.add(arr[i].a);
                res.add(l);
            }
        }
        return res;
    }
    public List<List<Integer>> fourSum(int[] nums, int t) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++)
            arr[i] = new Pair(nums[i], i);
        Arrays.sort(arr);
        long target = t;
        for(int i = 0; i < n; i++){
            if(i != 0 && arr[i].a == arr[i-1].a) continue;
            List<List<Integer>> ans = threeSum(arr, target - arr[i].a, i+1);
            for(List<Integer> l : ans){
                l.add(arr[i].a);
                res.add(l);
            }
        }
        return res;
    }
}