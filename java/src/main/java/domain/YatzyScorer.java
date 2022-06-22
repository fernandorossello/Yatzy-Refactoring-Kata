package domain;

public class YatzyScorer {
    public static int chance(DiceHand diceHand) {
        return diceHand.sumOfAllDice();
    }

    public static int ones(DiceHand diceHand) {
        return diceHand.sumDicesOfValue(1);
    }

    public static int twos(DiceHand diceHand) {
        return diceHand.sumDicesOfValue(2);
    }

    public static int threes(DiceHand diceHand) {
        return diceHand.sumDicesOfValue(3);
    }

    public static int fours(DiceHand diceHand) {
        return diceHand.sumDicesOfValue(4);
    }

    public static int fives(DiceHand diceHand) {
        return diceHand.sumDicesOfValue(5);
    }

    public static int sixes(DiceHand diceHand) {
        return diceHand.sumDicesOfValue(6);
    }

    public static int onePair(DiceHand diceHand) {
        return diceHand.getScoreForNOfAKind(2);
    }

    public static int threeOfAKind(DiceHand diceHand) {
        return diceHand.getScoreForNOfAKind(3);
    }

    public static int fourOfAKind(DiceHand diceHand) {
        return diceHand.getScoreForNOfAKind(4);
    }

    public static int smallStraight(DiceHand diceHand) {
        return diceHand.hasAllNumbersBetween(1, 5) ? 15 : 0;
    }

    public static int largeStraight(DiceHand diceHand) {
        return diceHand.hasAllNumbersBetween(2, 6) ? 20 : 0;
    }

    public static int yatzy(DiceHand diceHand) {
        return diceHand.allDiceAreEqual() ? 50 : 0;
    }

    public static int twoPairs(DiceHand diceHand) {
        int[] counts = diceHand.countOccurrencesOfRolledDices();
        int n = 0;
        int score = 0;

        for (int i = 1; i <= 6; i++) {
            if (counts[i] >= 2) {
                n++;
                score += i;
            }
        }

        if (n == 2) {
            return score * 2;
        } else {
            return 0;
        }
    }

    public static int fullHouse(DiceHand diceHand) {
        int[] count = diceHand.countOccurrencesOfRolledDices();
        int _2_at = 0;
        int _3_at = 0;
        boolean threeOf = false;
        boolean twoOf = false;

        for (int i = 1; i <= 6; i++) {
            if (count[i] == 2) {
                twoOf = true;
                _2_at = i;
            }

            if (count[i] == 3) {
                threeOf = true;
                _3_at = i;
            }
        }

        return twoOf && threeOf ? _2_at * 2 + _3_at * 3 : 0;

    }

}



