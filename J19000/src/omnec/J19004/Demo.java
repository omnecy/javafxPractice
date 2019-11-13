package omnec.J19004;

import java.io.Console;

public class Demo {

    public static void main(String[] args) {

        int num = 5;
        //Console console = System.console();
        //num = Integer.valueOf(console.readLine());
        J19004 j19004 = new J19004(num);
        j19004.run();
    }
}
