public class MinimumAdditionstoMakeValidString {
    public int addMinimum(String word) {
        char[] arr = word.toCharArray();
        int count = arr[0] - 'a';
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == 'a') {
                if (arr[i] == 'a') {
                    count += 2;
                } else if (arr[i] == 'b') {

                } else {
                    count += 1;
                }
            } else if (arr[i - 1] == 'b') {
                if (arr[i] == 'a') {
                    count += 1;
                } else if (arr[i] == 'b') {
                    count += 2;
                } else {

                }
            } else {
                if (arr[i] == 'a') {

                } else if (arr[i] == 'b') {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        if (arr[arr.length - 1] == 'a')
            count += 2;
        else if (arr[arr.length - 1] == 'b')
            count++;
        return count;
    }
}
