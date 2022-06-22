import domain.DiceHand;
import domain.YatzyScorer;
import org.junit.*;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void test_chance_shouldScoreTheSumOfAllDices() {
        assertEquals(15, YatzyScorer.chance(new DiceHand(2, 3, 4, 5, 1)));
        assertEquals(16, YatzyScorer.chance(new DiceHand(3, 3, 4, 5, 1)));
    }

    @Test
    public void test_yatzy_shouldScore50() {
        assertEquals(50, YatzyScorer.yatzy(new DiceHand(4, 4, 4, 4, 4)));
        assertEquals(50, YatzyScorer.yatzy(new DiceHand(6, 6, 6, 6, 6)));
        assertEquals(0, YatzyScorer.yatzy(new DiceHand(6, 6, 6, 6, 3)));
    }

    @Test
    public void test_ones_shouldSumAllDicesWithValueOne() {
        assertEquals(0, YatzyScorer.ones(new DiceHand(6, 2, 2, 4, 5)));
        assertEquals(1, YatzyScorer.ones(new DiceHand(1, 2, 3, 4, 5)));
        assertEquals(2, YatzyScorer.ones(new DiceHand(1, 2, 1, 4, 5)));
        assertEquals(4, YatzyScorer.ones(new DiceHand(1, 2, 1, 1, 1)));
    }

    @Test
    public void test_twos_shouldSumAllDicesWithValueTwo() {
        assertEquals(4, YatzyScorer.twos(new DiceHand(1, 2, 3, 2, 6)));
        assertEquals(10, YatzyScorer.twos(new DiceHand(2, 2, 2, 2, 2)));
    }

    @Test
    public void test_threes_shouldSumAllDicesWithValueThree() {
        assertEquals(6, YatzyScorer.threes(new DiceHand(1, 2, 3, 2, 3)));
        assertEquals(12, YatzyScorer.threes(new DiceHand(2, 3, 3, 3, 3)));
    }

    @Test
    public void test_fours_shouldSumAllDicesWithValueFour() {
        assertEquals(4, YatzyScorer.fours(new DiceHand(4, 5, 5, 5, 5)));
        assertEquals(8, YatzyScorer.fours(new DiceHand(4, 4, 5, 5, 5)));
        assertEquals(12, YatzyScorer.fours(new DiceHand(4, 4, 4, 5, 5)));
    }

    @Test
    public void test_fives_shouldSumAllDicesWithValueFive() {
        assertEquals(10, YatzyScorer.fives(new DiceHand(4, 4, 4, 5, 5)));
        assertEquals(15, YatzyScorer.fives(new DiceHand(4, 4, 5, 5, 5)));
        assertEquals(20, YatzyScorer.fives(new DiceHand(4, 5, 5, 5, 5)));
    }

    @Test
    public void test_sixes_shouldSumAllDicesWithValueSix() {
        assertEquals(0, YatzyScorer.sixes(new DiceHand(4, 4, 4, 5, 5)));
        assertEquals(6, YatzyScorer.sixes(new DiceHand(4, 4, 6, 5, 5)));
        assertEquals(18, YatzyScorer.sixes(new DiceHand(6, 5, 6, 6, 5)));
    }

    @Test
    public void test_onePair_shouldSumTheValueOfThePair() {
        assertEquals(6, YatzyScorer.onePair(new DiceHand(3, 4, 3, 5, 6)));
        assertEquals(10, YatzyScorer.onePair(new DiceHand(5, 3, 3, 3, 5)));
        assertEquals(12, YatzyScorer.onePair(new DiceHand(5, 3, 6, 6, 5)));
    }

    @Test
    public void test_twoPairs_shouldSumTheValueOfTheTwoPairs() {
        assertEquals(16, YatzyScorer.twoPairs(new DiceHand(3, 3, 5, 4, 5)));
        assertEquals(16, YatzyScorer.twoPairs(new DiceHand(3, 3, 5, 5, 5)));
        assertEquals(0, YatzyScorer.twoPairs(new DiceHand(3, 5, 5, 5, 5)));
    }

    @Test
    public void test_threeOfAKind_shouldSumAllValuesOfTheThreeOfAKind() {
        assertEquals(9, YatzyScorer.threeOfAKind(new DiceHand(3, 3, 3, 4, 5)));
        assertEquals(15, YatzyScorer.threeOfAKind(new DiceHand(5, 3, 5, 4, 5)));
        assertEquals(9, YatzyScorer.threeOfAKind(new DiceHand(3, 3, 3, 3, 5)));
    }

    @Test
    public void test_fourOfaAKind_shouldSumAllValuesOfTheFourOfAKind() {
        assertEquals(12, YatzyScorer.fourOfAKind(new DiceHand(3, 3, 3, 3, 5)));
        assertEquals(20, YatzyScorer.fourOfAKind(new DiceHand(5, 5, 5, 4, 5)));
        assertEquals(12, YatzyScorer.fourOfAKind(new DiceHand(3, 3, 3, 3, 3)));
    }

    @Test
    public void test_smallWtraight_shouldScoreFifteen() {
        assertEquals(15, YatzyScorer.smallStraight(new DiceHand(1, 2, 3, 4, 5)));
        assertEquals(15, YatzyScorer.smallStraight(new DiceHand(2, 3, 4, 5, 1)));
        assertEquals(0, YatzyScorer.smallStraight(new DiceHand(1, 2, 2, 4, 5)));
    }

    @Test
    public void test_largeStraight_shouldScoreTwenty() {
        assertEquals(20, YatzyScorer.largeStraight(new DiceHand(6, 2, 3, 4, 5)));
        assertEquals(20, YatzyScorer.largeStraight(new DiceHand(2, 3, 4, 5, 6)));
        assertEquals(0, YatzyScorer.largeStraight(new DiceHand(1, 2, 2, 4, 5)));
    }

    @Test
    public void test_fullHouse_ShouldScoreTheSumOfAllTheValues() {
        assertEquals(18, YatzyScorer.fullHouse(new DiceHand(6, 2, 2, 2, 6)));
        assertEquals(22, YatzyScorer.fullHouse(new DiceHand(6, 2, 2, 6, 6)));
        assertEquals(0, YatzyScorer.fullHouse(new DiceHand(2, 3, 4, 5, 6)));
    }
}
