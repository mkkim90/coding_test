package basic;

import dfsBfs.Word;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 우선순위
 *
 * K개 만큼 많이 나오는 문자 추출
 * 많이 나오는 횟수가 많을 경우 알파벳 순으로 정렬
 */
public class TopKFrequentWordsTest {
    public class WordCnt implements Comparable<WordCnt> {
        String word;
        int cnt;
        public WordCnt(String word) {
            this.word = word;
            this.cnt = 1;
        }

        @Override
        public int compareTo(WordCnt o) {
            if (this.cnt > o.cnt) {
                    return 1;
            }

            if (this.cnt < o.cnt) {
                return -1;
            }

            return this.word.compareTo(o.word);
        }
    }
    @Test
    void solution() {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        topKFrequentWords(words, k);
    }

    private void topKFrequentWords(String[] words, int k) {
        Map<String, WordCnt> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).cnt++;
            } else {
                map.put(words[i], new WordCnt(words[i]));
            }
        }

        PriorityQueue<WordCnt> q = new PriorityQueue<>();
        for (WordCnt wordCnt : map.values()) {
            q.offer(wordCnt);
            if (q.size() > k) q.poll();
        }

        while (!q.isEmpty()) {
            System.out.println(q.poll().word);
        }
    }
}
