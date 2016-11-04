import javax.swing.*;
import java.awt.*;

/**
 * Created by tony on 1/11/2016.
 */
public class ShowVirtualKeyboard extends JPanel {

    static String sysroot;
    static Runtime rt;
    static Process pros;
    static int key;

    public ShowVirtualKeyboard() {

        Dimension dim = new Dimension(100, 100);

        setSize(dim);

        sysroot = System.getenv("SystemRoot");
        rt = Runtime.getRuntime();

        try {
            pros = rt.exec("cmd /c" + sysroot + "/system32/osk.exe");

        } catch(Exception ex){

            System.out.println("Umm, that's a little strange. Maybe you don't have an on screen keyboard");
        }

    }
    public static int getKey(){

        key = 1234;
        return key;
    }
    public static void removeKeyboard(){

        System.out.println("here " + pros);

        try {

            System.out.println("and here " + pros);

        } catch(Exception ex){

            System.out.println("Oops, didn't like that..");
        }
    }
}