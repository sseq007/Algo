import java.util.*;

public class test {


    public static void main(String[] args) {


        recur(1);
    }

    private static void recur(int i) {

        if(i==11) return;
        System.out.println(i);
        recur(i+1);
    }
}
