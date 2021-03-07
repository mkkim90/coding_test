package dfsBfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * begin	target	words	return
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
 */
public class ConvertWordsTest {
    @Test
    void solution() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        assertThat(convertWords(begin, target, words)).isEqualTo(4);
    }

    private int convertWords(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = {false, false, false, false, false, false};
        q.offer(new Word(begin));
        int answer = 0;
        while (!q.isEmpty()) {
            Word u = q.poll();
            if ( u.isSameWord(target)) {
                answer = u.getCnt();
                break;
            }

            for (int i = 0; i < words.length; i ++){
                if (visited[i] == false) {
                    String str = words[i];
                    if (isContainsOneChar(u.getWord(), str)) {
                        q.offer(new Word(str, u.getCnt() + 1));
                        visited[i] = true;
                    }
                }
            }
        }

        return answer;
    }

    private boolean isContainsOneChar(String u, String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (cnt > 1) {
                return false;
            }

            if (!u.contains(String.valueOf(str.charAt(i)))) {
                cnt++;
            }
        }

        return cnt == 1;
    }

/*
    public void dfs(String presentWord, String target, int count,String[] words) {
        if(presentWord.equals(target)) {
            answer = (answer > count) ? count : answer;
            return;
        }

        for(int i = 0; i < words.length; i++) {                        //탐색한 글자중 하나만 차이나고 탐색되지 않은 글자이 있다면. dfs 수행
            if(!used[i] && check(presentWord, words[i])) {
                used[i] = true;
                dfs(words[i],target,count+1, words);
                used[i] = false;
            }
        }
    }*/
}
