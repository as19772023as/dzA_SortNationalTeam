import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]

    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {
        int i = 1;
        int[] team = Arrays.copyOf(teams[0], teams[0].length);

        while (i <= teams.length - 1) {
            team = merge(team, teams[i]);
            i += 1;
        }

        return team;
    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {

        int[] teamC = new int[teamA.length];
        int iA = 0, iB = 0, iC = 0;

        while (iC < teamA.length) {
            if (teamA[iA] > teamB[iB]) {
                teamC[iC] = teamA[iA];
                iA += 1;
            } else {
                teamC[iC] = teamB[iB];
                iB += 1;
            }

            iC += 1;
        }

        return teamC;
    }
}