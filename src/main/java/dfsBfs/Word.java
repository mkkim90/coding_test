package dfsBfs;

public class Word {
    private String word;
    private int cnt = 0;

    public Word(String word) {
        this.word = word;
    }

    public Word(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }

    public void increaseCnt() {
        cnt++;
    }

    public int getCnt() {
        return cnt;
    }

    public boolean isSameWord(String target) {
        return this.word.equals(target);
    }

    public String getWord() {
        return this.word;
    }
}
