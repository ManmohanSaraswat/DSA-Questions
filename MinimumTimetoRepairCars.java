public class MinimumTimetoRepairCars {
    private boolean solve(int[] ranks, long cars, long time) {
        for (int i = 0; i < ranks.length; i++) {
            long maxCars = (int) Math.sqrt(time / ranks[i]);
            cars -= maxCars;
        }
        return cars <= 0;
    }

    public long repairCars(int[] ranks, int cars) {
        long start = 1, end = 100000000000005L;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (solve(ranks, cars, mid))
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}
