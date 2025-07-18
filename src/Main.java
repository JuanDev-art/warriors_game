import Characters.Character;
import Characters.Mage;
import Characters.Rogue;
import gui.BattleWindow;

public class Main {
    public static void main(String[] args) {

        //Lanzar ventana gráfica.
        new BattleWindow();

        //Crear personajes
        Mage gandalf = new Mage("Gandalf", 100, 10, 5, 40, 10, 20);
        Rogue valeera = new Rogue("Valeera", 100, 30, 45, 10, 15, 25);

        //Iniciar batalla.
        Battle battle = new Battle(gandalf, valeera);

        battle.Start();
    }
}
