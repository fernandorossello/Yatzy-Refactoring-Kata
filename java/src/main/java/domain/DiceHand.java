package domain;

import java.util.Arrays;

public class DiceHand {
    private final int[] rolledDices;

    public DiceHand(int d1, int d2, int d3, int d4, int d5) {
        this.rolledDices = new int[]{d1, d2, d3, d4, d5};
    }

    public int sumDicesOfValue(int value) {
        int sum = 0;
        for (int dice : this.rolledDices) {
            if (dice == value) {
                sum += value;
            }
        }

        return sum;
    }

    public int getScoreForNOfAKind(int expectedOccurrences) {
        return getDieWithNOccurrences(expectedOccurrences) * expectedOccurrences;
    }

    public boolean hasAllNumbersBetween(int from, int to) {
        int[] tallies = countOccurrencesOfRolledDices();
        for (int i = from; i <= to; i++) {
            if (tallies[i] != 1) return false;
        }

        return true;
    }

    // TODO: Make this private if possible
    public int[] countOccurrencesOfRolledDices() {
        int[] counts = new int[7];
        for (int dice : this.rolledDices)
            counts[dice]++;
        return counts;
    }

    public boolean allDiceAreEqual() {
        for (int occurrences : countOccurrencesOfRolledDices()) {
            if (occurrences == 5) {
                return true;
            }
        }

        return false;
    }

    public int sumOfAllDice() {
        return Arrays.stream(rolledDices).sum();
    }

    private int getDieWithNOccurrences(int expectedOccurrences){
        int[] countOfOccurrences = this.countOccurrencesOfRolledDices();
        for (int i = 6; i > 0; i--) {
            if (countOfOccurrences[i] >= expectedOccurrences) {
                return i;
            }
        }

        return 0;
    }
}
