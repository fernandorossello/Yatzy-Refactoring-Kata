import org.junit.*;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void test_chance_shouldScoreTheSumOfAllDices() {
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).chance());
        assertEquals(16, new Yatzy(3, 3, 4, 5, 1).chance());
    }

    @Test
    public void test_yatzy_shouldScore50() {
        assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4));
        assertEquals(50, Yatzy.yatzy(6, 6, 6, 6, 6));
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
    }

    @Test
    public void test_ones_shouldSumAllDicesWithValueOne() {
        assertEquals(0, new Yatzy(6, 2, 2, 4, 5).ones());
        assertEquals(1, new Yatzy(1, 2, 3, 4, 5).ones());
        assertEquals(2, new Yatzy(1, 2, 1, 4, 5).ones());
        assertEquals(4, new Yatzy(1, 2, 1, 1, 1).ones());
    }

    @Test
    public void test_twos_shouldSumAllDicesWithValueTwo() {
        assertEquals(4, new Yatzy(1, 2, 3, 2, 6).twos());
        assertEquals(10, new Yatzy(2, 2, 2, 2, 2).twos());
    }

    @Test
    public void test_threes_shouldSumAllDicesWithValueThree() {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }

    @Test
    public void test_fours_shouldSumAllDicesWithValueFour() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
    }

    @Test
    public void test_fives_shouldSumAllDicesWithValueFive() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
    }

    @Test
    public void test_sixes_shouldSumAllDicesWithValueSix() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void test_onePair_shouldSumTheValueOfThePair() {
        assertEquals(6, Yatzy.onePair(3, 4, 3, 5, 6));
        assertEquals(10, Yatzy.onePair(5, 3, 3, 3, 5));
        assertEquals(12, Yatzy.onePair(5, 3, 6, 6, 5));
    }

    @Test
    public void test_twoPairs_shouldSumTheValueOfTheTwoPairs() {
        assertEquals(16, Yatzy.twoPairs(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.twoPairs(3, 3, 5, 5, 5));
    }

    @Test
    public void test_threeOfAKind_shouldSumAllValuesOfTheThreeOfAKind() {
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 4, 5));
        assertEquals(15, Yatzy.threeOfAKind(5, 3, 5, 4, 5));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 5));
    }

    @Test
    public void test_fourOfaAKind_shouldSumAllValuesOfTheFourOfAKind() {
        assertEquals(12, Yatzy.fourOfAKind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.fourOfAKind(5, 5, 5, 4, 5));
        assertEquals(12, Yatzy.fourOfAKind(3, 3, 3, 3, 3));
    }

    @Test
    public void test_smallWtraight_shouldScoreFifteen() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void test_largeStraight_shouldScoreTwenty() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void test_fullHouse_ShouldScoreTheSumOfAllTheValues() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(22, Yatzy.fullHouse(6, 2, 2, 6, 6));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}
