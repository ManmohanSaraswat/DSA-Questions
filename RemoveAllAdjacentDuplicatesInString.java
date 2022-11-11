public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (res.length() == 0)
                res.append(arr[i]);
            else if (res.charAt(res.length() - 1) == arr[i])
                res.deleteCharAt(res.length() - 1);
            else
                res.append(arr[i]);
        }
        return res.toString();
    }
}
