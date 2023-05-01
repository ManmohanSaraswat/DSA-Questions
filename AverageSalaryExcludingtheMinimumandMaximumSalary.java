public class AverageSalaryExcludingtheMinimumandMaximumSalary {
    public double average(int[] salary) {
        int min = salary[0], max = salary[0], tot = 0;
        for (int sal : salary) {
            min = Math.min(min, sal);
            max = Math.max(max, sal);
            tot += sal;
        }
        tot -= (min + max);
        return (tot * 1.0) / (salary.length - 2);
    }
}
