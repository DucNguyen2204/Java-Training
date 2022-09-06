package exercise_ten;

import java.util.StringTokenizer;

public class VanBan {
    private String str;

    private StringTokenizer tokens;

    private int count;

    public VanBan(){

    }

    public VanBan(String str) {
        this.str = str;
        tokens = new StringTokenizer(this.str);

    }

    public int getWords(){
        return this.tokens.countTokens();
    }

    public int countA(){
        this.count = 0;
        this.reFormat();
        long c = this.str.chars().filter(ch -> ch == 'a' || ch == 'A').count();
        this.count = Math.toIntExact(c);
        return this.count;
    }

    public void reFormat(){
        this.str = this.str.trim().replaceAll("\\s+", " ");
    }
}
