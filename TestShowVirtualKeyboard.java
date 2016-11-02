/**
 * Created by tony on 1/11/2016.
 */
public class TestShowVirtualKeyboard{

    public static void main(String[] args) {

        ShowVirtualKeyboard keyboard = new ShowVirtualKeyboard();

        //keyboard.setVisible(true);

        try {
            Thread.sleep(5000);

        } catch (Exception ex) {

            System.out.println("Couldn't sleep hey?");
        }
        ShowVirtualKeyboard.removeKeyboard();
        //keyboard.setVisible(false);
    }
}