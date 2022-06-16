import java.util.Arrays;

public class Yatzy {

    protected int[] rolledDices;

    public Yatzy(int... dices) {
        if (dices.length > 5) {
            throw new IllegalArgumentException("More dices than allowed");
        }
        this.rolledDices = dices;
    }

    public int chance() {
        return Arrays.stream(rolledDices).sum();
    }

    public int ones() {
        return sumDicesWithValue(1, this.rolledDices);
    }

    public int twos() {
        return sumDicesWithValue(2, this.rolledDices);
    }

    public int threes() {
        return sumDicesWithValue(3, this.rolledDices);
    }

    public int fours() {
        return sumDicesWithValue(4, this.rolledDices);
    }

    public int fives() {
        return sumDicesWithValue(5, this.rolledDices);
    }

    public int sixes() {
        return sumDicesWithValue(6, this.rolledDices);
    }

    public static int onePair(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = countOccurrencesOfDices(d1, d2, d3, d4, d5);
        for (int at = 0; at != 6; at++)
            if (counts[6 - at - 1] >= 2)
                return (6 - at) * 2;
        return 0;
    }

    public static int twoPairs(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = countOccurrencesOfDices(d1, d2, d3, d4, d5);
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = countOccurrencesOfDices(d1, d2, d3, d4, d5);
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] t = countOccurrencesOfDices(d1, d2, d3, d4, d5);
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = countOccurrencesOfDices(d1, d2, d3, d4, d5);
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = countOccurrencesOfDices(d1, d2, d3, d4, d5);
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = countOccurrencesOfDices(d1, d2, d3, d4, d5);;
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

    public static int yatzy(int... dice) {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die - 1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    private int sumDicesWithValue(int value, int... dices) {
        int sum = 0;
        for (int dice : dices) {
            if (dice == value) {
                sum += value;
            }
        }

        return sum;
    }

    private static int[] countOccurrencesOfDices(int... dices) {
        int[] counts = new int[6];
        for (int dice : dices)
            counts[dice-1]++;
        return counts;
    }


}



