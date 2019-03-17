package ro.iim.recursion;

public class HanoiTowers {

    public static void doTowers(int noTowers, String from, String inter, String to) {
        if (noTowers == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(noTowers - 1, from, to, inter);

            System.out.println("Disk " + noTowers + " from " + from + " to " + to);

            doTowers(noTowers - 1, inter, from, to);
        }
    }

    public static void main(String[] args) {
        doTowers(3, "A", "B", "C");
    }
}
