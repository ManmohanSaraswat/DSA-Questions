import java.util.Arrays;

public class DividePlayersIntoTeamsofEqualSkill {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        long sum = 0, res = 0;
        for(int s: skill) sum += s;
        if(sum % (n / 2) != 0) return -1;
        sum = sum / (n / 2);
        Arrays.sort(skill);
        for(int i = 0; i < n / 2; i++){
            if(skill[i] + skill[n - i - 1] != sum) return -1;
            res += skill[i] * skill[n - i - 1];
        }
        return res;
    }
}
