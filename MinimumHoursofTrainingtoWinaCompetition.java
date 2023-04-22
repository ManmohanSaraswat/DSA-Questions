public class MinimumHoursofTrainingtoWinaCompetition {
    public int minNumberOfHours(int en, int er, int[] energy, int[] experience) {
        int res = 0, e = 0, r = er;
        for (int i = 0; i < energy.length; i++) {
            if (en <= energy[i]) {
                res += energy[i] - en + 1;
                en += energy[i] - en + 1;
            }
            en -= energy[i];
            if (er <= experience[i]) {
                res += experience[i] - er + 1;
                er += experience[i] - er + 1;
            }
            er += experience[i];
        }
        return res;
    }
}
