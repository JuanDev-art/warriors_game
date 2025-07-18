//Esta clase gestiona el combate entre dos personajes. Turnos, daño, resultado...

import Characters.Character;

public class Battle {

    private Character player1;
    private Character player2;

    public Battle (Character player1, Character player2) {

        this.player1 = player1;
        this.player2 = player2;

    }

    public void Start() {

        System.out.println("¡Comienza el combate entre " + player1.getName() + " y " + player2.getName() + "!");

        //Determinar quien empieza por velocidad.
        Character attacker, defender;

        if (player1.getSpeed() >= player2.getSpeed()) {

            attacker = player1;
            defender = player2;

        } else {

            attacker = player2;
            defender = player1;

        }

        while (player1.getHealth() > 0 && player2.getHealth() > 0) {

            // \n --> Inserta un salto de línea antes del mensaje. Es decir, deja una línea en blanco antes de imprimir.
            System.out.println("\nTurno de " + attacker.getName());

            attacker.Attack(defender);

            //Mostrar la vida restante de ambos personajes.
            System.out.println(attacker.getName() + " tiene " + attacker.getHealth() + " de vida.");
            System.out.println(attacker.getName() + " tiene " + defender.getHealth() + " de vida.");

            //Comprobar si el defensor a muerto.
            if (defender.getHealth() <= 0) {

                System.out.println(defender.getName() + " ha sido derrotado.");
                System.out.println(attacker.getName() + " ha ganado el combate");

                break;

            }

            //Intercambiar roles.
            Character temp = attacker;
            attacker = defender;
            defender = temp;

        }

    }

}
