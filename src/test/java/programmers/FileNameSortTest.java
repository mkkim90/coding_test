package programmers;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
 * ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
 */
public class FileNameSortTest {
    static class File implements Comparable<File>{
        private String fullName;
        private String HEAD;
        private int NUMBER;
        private String TAIL;

        File(String fullName) {
            this.fullName = fullName;
            split(fullName.toLowerCase().toCharArray());
        }

        private void split(char[] fullNames) {
            StringBuffer head = new StringBuffer();
            int numberIndex = 0;
            for (int i = 0; i < fullNames.length; i++) {
                if (Character.isDigit(fullNames[i])) {
                    numberIndex = i;
                    break;
                }
                head.append(fullNames[i]);
            }
            this.HEAD = head.toString();
            StringBuffer num = new StringBuffer();
            int tailIndex = 0;
            for (int i = numberIndex; i < fullNames.length; i++) {
                if (num.length() >= 5 || !Character.isDigit(fullNames[i])) {
                    tailIndex = i;
                    break;
                }
                num.append(fullNames[i]);
            }
            this.NUMBER = Integer.parseInt(num.toString());
            StringBuffer tail = new StringBuffer();
            for (int i = tailIndex; i < fullNames.length; i++) {
                tail.append(fullNames[i]);
            }
            this.TAIL = tail.toString();
        }

        @Override
        public int compareTo(File o) {

            int headValue = HEAD.compareTo(o.HEAD);

            if(headValue == 0) {


                return NUMBER - o.NUMBER;
            } else {
                return headValue;
            }

        }
    }
    @Test
    void solution() {
        //String[] inputs = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] inputs = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        PriorityQueue<File> q = new PriorityQueue<>();
        for (String input : inputs) {
            q.offer(new File(input));
        }
        String[] answer = new String[inputs.length];
        int i = 0;
        while (!q.isEmpty()) {
            answer[i++] = q.poll().fullName;
        }
    }
}
