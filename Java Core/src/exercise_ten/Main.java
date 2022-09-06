package exercise_ten;

public class Main {
    public static void main(String[] args) {
        String str = "fdoiashfldksanf kdsalrjfdskl;af  foApsdajkk f;las fopdsajf slkadpe'sjf sdaklfmdsa fpd as rhjfw30qpo";
        VanBan vanBan = new VanBan(str);

        System.out.println("# of words: " + vanBan.getWords());

        System.out.println("# of 'a' : " + vanBan.countA());

    }
}
