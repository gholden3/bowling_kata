package main.java.src;

public class Bowling {
  private int n = 0;
  private int[] r = new int[21];

  public void roll(int p) {
    r[n] = p;
    n++;
  }

  public int getScore() {
    int s = 0;
    int i = 0;
    while (i < n ) {
      int tempScore = 0;
      boolean strike = (r[i] == 10);
      boolean spare = (r[i] + r[i + 1] == 10);

      if (str) {
        tempScore = r[i] + r[i + 1] + r[i + 2];
        i++;
      } else if (sp) {
        tempScore = r[i] + r[i + 1] + r[i + 2];
        i += 2;
      } else {
        tempScore = r[i] + r[i + 1];
        i += 2;
      }
      s += tempScore;
      if (str && (i == n - 2) ||  (sp && (i == n - 1))) {
        break;
      }
    }
    return s;
  }
}
