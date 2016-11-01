/**
 * Created by tony on 1/11/2016.
 */
public class ShowVirtualKeyboard {

    private static String sysroot;
    private static Runtime rt;
    private static Process pros;

    public ShowVirtualKeyboard() {

        sysroot = System.getenv("SystemRoot");
        rt = Runtime.getRuntime();

        try {
            pros = rt.exec("cmd /c" + sysroot + "/system32/osk.exe");

        } catch(Exception ex){

            System.out.println("Umm, that's a little strange. Maybe you don't have an on screen keyboard");
        }

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