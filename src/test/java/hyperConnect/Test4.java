package hyperConnect;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Test4 {
    @Test
    void create() {
        Platformer platformer = new Platformer(6,3);
        assertThat(platformer.position()).isEqualTo(3); // should print 3
        platformer.jumpLeft();
        System.out.println(platformer.position()); // should print 1

        platformer.jumpRight();
        System.out.println(platformer.position()); // should print 4
    }
}

class Platformer {
    private List<Integer> tiles = new LinkedList<>();
    private int position;
    public Platformer(int n, int position) {
        for (int i = 0; i < n; i++) {
            tiles.add(i);
        }
        this.position = position;
    }

    public void jumpLeft() {
        int leftIndex = position - 2;
        tiles.remove(position);
        position = leftIndex;
    }

    public void jumpRight() {
        int rightIndex = position + 1;
        tiles.remove(position);
        position = rightIndex;
    }

    public int position() {
        return tiles.get(this.position);
    }

    public static void main(String[] args) {
        Platformer platformer = new Platformer(6, 3);
        System.out.println(platformer.position()); // should print 3

        platformer.jumpLeft();
        System.out.println(platformer.position()); // should print 1

        platformer.jumpRight();
        System.out.println(platformer.position()); // should print 4
    }
}
