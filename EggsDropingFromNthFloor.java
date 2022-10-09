public class EggsDropingFromNthFloor {
    static int dp1D[];
    static int dp2D[][];
    public static int findUsing2D(int num, int eggs){
        if(num <= 1 || eggs == 1) return num;
        if(dp2D[num][eggs] != -1) return dp2D[num][eggs];
        int minDrops = Integer.MAX_VALUE;
        for(int i = 1; i <= num; i++){
            int temp = 1 + Math.max(findUsing2D(i-1, eggs-1), findUsing2D(num-i, eggs));
            minDrops = Math.min(minDrops, temp);
        }
        return dp2D[num][eggs] = minDrops;
    }
    public static int findUsing1D(int num){
        if(num <= 1) return num;
        if(dp1D[num] != -1) return dp1D[num];
        int minDrops = Integer.MAX_VALUE;
        for(int i = 1; i <= num; i++){
            int temp = 1 + Math.max(i-1, findUsing1D(num-i));
            minDrops = Math.min(minDrops, temp);
        }
        return dp1D[num] = minDrops;
    }
    public static int twoEggsDropMemoization(int num){
        dp1D = new int[num+1];
        dp2D = new int[num+1][3];
        for(int i = 0; i <= num; i++){
            dp1D[i] = -1;
            dp2D[i][1] = dp2D[i][2] = -1;
        }
        return findUsing1D(num);
        // return findUsing2D(num, 2);
    }
    public static int twoEggsDropTabular(int num){
        int []tabular = new int[num+1];
        tabular[1] = 1;
        for(int i = 2; i <= num; i++){
            int minDrops = Integer.MAX_VALUE;
            for(int j = 1; j <= i; j++){
                int temp = 1 + Math.max(j-1, tabular[i-j]);
                minDrops = Math.min(minDrops, temp);
            }
            tabular[i] = minDrops;
        }
        return tabular[num];
    }
    public static void main(String[] args) {
        System.out.println(twoEggsDropMemoization(1000));
        System.out.println(twoEggsDropTabular(10000));
    }
}
