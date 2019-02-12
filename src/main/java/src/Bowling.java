package main.java.src;

public class Bowling {
  private int numberOfRolls = 0;
  private int[] rolls = new int[21];

  public void roll(int pins) {
    rolls[numberOfRolls] = pins;
    numberOfRolls++;
  }

  public int getScore() {
    int score = 0;
    int i = 0;
    while (i < numberOfRolls ) {
      int frameScore = 0;
      boolean strike = (rolls[i] == 10);
      boolean spare = (getFrameScore(i) == 10);

      if (strike) {
        frameScore = getStrikeOrSpareFrameScore(i);
        i++;
      } else if (spare) {
        frameScore = getStrikeOrSpareFrameScore(i);
        i += 2;
      } else {
        frameScore = getFrameScore(i);
        i += 2;
      }
      score += frameScore;
      if (shouldStopScoring(i, strike, spare)) {
        break;
      }
    }
    return score;
  }

  private boolean shouldStopScoring(int i, boolean strike, boolean spare) {
    if (strike && (i == numberOfRolls - 2))
      return true;
    if (spare && (i == numberOfRolls - 1))
      return true;
    return false;
  }

  private int getFrameScore(int i) {
    return rolls[i] + rolls[i + 1];
  }

  private int getStrikeOrSpareFrameScore(int i) {
    return rolls[i] + rolls[i + 1] + rolls[i + 2];
  }
}
