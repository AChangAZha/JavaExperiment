import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lottery {
    private Set<Integer> winningNumbers = new HashSet<Integer>();

    public Lottery() {
        Random rand = new Random();
        while (winningNumbers.size() < 7) {
            winningNumbers.add(rand.nextInt(30) + 1);
        }
    }

    public void Draw(Set<Integer> num) {
        int count = 0;
        for (int i : num) {
            if (winningNumbers.add(i)) {
                winningNumbers.remove(i);
                count++;
            }
        }
        System.out.println("");
        System.out.println("中奖号码：");
        for (int i : winningNumbers) {
            System.out.print(i + " ");
        }
        System.out.println("");
        if (count == 0) {
            System.out.println("您中了一等奖！");
        } else if (count == 1) {
            System.out.println("您中了二等奖！");
        } else if (count == 2) {
            System.out.println("您中了三等奖！");
        } else {
            System.out.println("很遗憾，您未中奖！");
        }
    }

}