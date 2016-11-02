/**
 * Created by tony on 2/11/2016.
 */
public class TestPickupsInARow {

    public static void main(String[] args) {

        Player player1 = new Player("Bill");
        Player player2 = new Player("Jill");
        Player player3 = new Player("Phil");

        player2.setPickupsInARow(player2.getPickupsInARow() + 1);
        System.out.println(player1.getPickupsInARow() + " " + player2.getPickupsInARow() + " " + player3.getPickupsInARow());
    }
}
