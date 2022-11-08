public class Maximum69Number {
    public int maximum69NumberMyApproach(int num) {
        String n = String.valueOf(num);
        int max = num;
        String temp = "";
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '9')
                temp = n.substring(0, i) + '6' + n.substring(i + 1);
            else
                temp = n.substring(0, i) + '9' + n.substring(i + 1);
            max = Math.max(max, Integer.parseInt(temp));
        }
        return max;
    }

    public int maximum69NumberEfficient(int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }
}
