import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignMemoryAllocator {
    private int[] arr;
    Map<Integer, List<int[]>> map;

    public DesignMemoryAllocator(int n) {
        arr = new int[n];
        map = new HashMap<>();
    }

    public int allocate(int size, int mID) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == 0) {
                int mem = i + 1;
                while (mem < arr.length && arr[mem] == 0)
                    mem++;
                if (mem == arr.length || arr[mem] != 0)
                    mem--;
                mem = mem - i + 1;
                if (mem >= size) {
                    List<int[]> vals = map.getOrDefault(mID, new ArrayList<>());
                    vals.add(new int[] { i, i + size - 1 });
                    map.put(mID, vals);
                    mem = 0;
                    while (mem < size) {
                        arr[i + mem] = mID;
                        mem++;
                    }
                    return i;
                }
                i = i + mem + 1;
            } else
                i++;
        }
        return -1;
    }

    public int free(int mID) {
        int count = 0;
        List<int[]> vals = map.getOrDefault(mID, new ArrayList<>());
        for (int[] val : vals) {
            int start = val[0], end = val[1];
            for (; start <= end; start++) {
                arr[start] = 0;
                count++;
            }
        }
        map.remove(mID);
        return count;
    }
}
