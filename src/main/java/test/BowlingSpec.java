package main.java.test;

import main.java.src.Bowling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BowlingSpec {

      /*
    10 frames, 2 rolls each. perfect score == 300.

    spare: 10 points + number of pins in next roll. [4, 6, 7, 3, 6, 1 ]
  frame 1: 17
  frame 2: 10

        strike: 10 points + number of pins in next 2 rolls.
        [10, 6, 7, 3, 7]
  frame 1:  23
  frame 2:  13
  frame 3: 10

        otherwise sum of both rolls.  [2, 3, 2, 1]
        frame 1: 5, frame 2: 3

    10th frame: if strike, 2 more rolls. if spare, you get one more
    score = sum all 10 frames

    [2, 2, 2, ...5, 5, 2]
    frame 10: 12

    [2, 2, 2, ...10, 2, 2]
    frame 10: 14
     */

    /*
    implementation assumptions
    - assume people roll the correct number of rolls
    - assume you only call score after you've finished rolling all the rolls for the game
     */

  Bowling bowling = new Bowling();

  @Test
  public void all_gutter_balls_then_score_is_zero() {
    rollSameNumberTimes(0,20);
    assertEquals(0, bowling.getScore());
  }

  @Test
  public void noStrikes_noSpares() {
    rollSameNumberTimes(2,20);
    assertEquals(40, bowling.getScore());
  }

  @Test
  public void nineSpares() {
    rollSameNumberTimes(5,18);
    rollSameNumberTimes(2,2);
    assertEquals(136, bowling.getScore());
  }

  @Test
  public void oneStrikes() {
    // [10, 2, 2,2, 2, ]
    rollSameNumberTimes(10,1);
    rollSameNumberTimes(2,18);
    assertEquals(50, bowling.getScore());
  }

  @Test
  public void lastOneStrikes() {
    // [ 2, 2, 2, 2, 2,....10, 2, 2 ]
    rollSameNumberTimes(2,18);
    rollSameNumberTimes(10,1);
    rollSameNumberTimes(2,2);
    assertEquals(50, bowling.getScore());
  }

  @Test
  public void lastOneStrikesWithBonusAsStrike() {
    // [ 2, 2, 2, 2, 2,....10, 10, 10 ]
    rollSameNumberTimes(2,18);
    rollSameNumberTimes(10,3);
    assertEquals(66, bowling.getScore());
  }

  @Test
  public void perfectScore() {
    // [ 10......10, 10, 10 ]
    rollSameNumberTimes(10,12);
    assertEquals(300, bowling.getScore());
  }

  @Test
  public void lastOneSpare() {
    // [ 2, 2, 2, 2, 2,....5, 5, 2 ]
    rollSameNumberTimes(2,18);
    rollSameNumberTimes(5,2);
    rollSameNumberTimes(2,1);
    assertEquals(48, bowling.getScore());
  }

  private void rollSameNumberTimes(int pins, int times) {
    for (int i = 0; i < times; i++) {
      bowling.roll(pins);
    }
  }
}
