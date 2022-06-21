import java.util.Arrays;

public class Yatzy {

    protected int[] rolledDices;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        this.rolledDices = new int[]{d1, d2, d3, d4, d5};
    }

    public int chance() {
        return Arrays.stream(rolledDices).sum();
    }

    public int ones() {
        return sumDicesofValue(1, this.rolledDices);
    }

    public int twos() {
        return sumDicesofValue(2, this.rolledDices);
    }

    public int threes() {
        return sumDicesofValue(3, this.rolledDices);
    }

    public int fours() {
        return sumDicesofValue(4, this.rolledDices);
    }

    public int fives() {
        return sumDicesofValue(5, this.rolledDices);
    }

    public int sixes() {
        return sumDicesofValue(6, this.rolledDices);
    }

    public int onePair() {
        return getScoreForNOfAKind(2);
    }

    public int threeOfAKind() {
        return getScoreForNOfAKind(3);
    }

    public int fourOfAKind() {
        return getScoreForNOfAKind(4);
    }

    public int smallStraight() {
        return hasAllNumbersBetween(1,5) ? 15 : 0;
    }

    public int largeStraight() {
        return hasAllNumbersBetween(2,6) ? 20 : 0;
    }

    public int yatzy() {
        int[] counts = countOccurrencesOfRolledDices();
        return Arrays.stream(counts).anyMatch(occurrences -> occurrences == 5) ? 50 : 0;
    }

    public int twoPairs() {
        int [] counts = countOccurrencesOfRolledDices();
        int n = 0;
        int score = 0;
        for (int i = 6; i > 0; i--)
            if (counts[i] >= 2) {
                n++;
                score += i;
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = countOccurrencesOfDicesStatic(d1, d2, d3, d4, d5);
        ;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }

    private int sumDicesofValue(int value, int... dices) {
        int sum = 0;
        for (int dice : dices) {
            if (dice == value) {
                sum += value;
            }
        }

        return sum;
    }

    private boolean hasAllNumbersBetween(int from, int to) {
        int[] tallies = countOccurrencesOfRolledDices();
        for (int i = from; i <= to; i++) {
            if (tallies[i] != 1) return false;
        }

        return true;
    }

    private static int[] countOccurrencesOfDicesStatic(int... dices) {
        int[] counts = new int[6];
        for (int dice : dices)
            counts[dice - 1]++;
        return counts;
    }

    private int[] countOccurrencesOfRolledDices() {
        int[] counts = new int[7];
        for (int dice : this.rolledDices)
            counts[dice]++;
        return counts;
    }

    private int getScoreForNOfAKind(int expectedOccurrences) {
        int[] countOfOccurrences = this.countOccurrencesOfRolledDices();
        for (int i = 6; i > 0; i--) {
            if (countOfOccurrences[i] >= expectedOccurrences) {
                return i * expectedOccurrences;
            }
        }
        return 0;
    }
}



