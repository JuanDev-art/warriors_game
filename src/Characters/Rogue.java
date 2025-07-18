package Characters;

import java.util.Random;

public class Rogue extends Character {

    //Constructor.
    public Rogue(String name, int health, int strength, int agility, int intellect, int defense, int speed) {

        //La fuerza y el intelecto las ponemos en 0 porque no la utiliza, el daño del mago depende de su intelecto.
        super(name, health, 0, agility, 0, defense, speed);

    }

    @Override
    public int Attack (Character enemy){

        Random random = new Random();

        //15% de probabilidad de fallar.
        int chanceFail = random.nextInt(100);

        if (chanceFail < 15) {

            System.out.println(this.getName() + " falló su ataque contra " + enemy.getName() + "!");

            return 0; //Fallo

        }

        //Daño basado en intelecto.
        int damage = this.getAgility() - enemy.getDefense() / 2; //Entre dos, si no sería muy poco daño.

        //Evitamos daño negativo.
        if (damage < 0) damage = 0;

        //20% de probabilidad de crítico.
        int chanceCrit = random.nextInt(100);

        if (chanceCrit < 20) {

            damage *= 2;

            System.out.println("¡Golpe crítico de " + this.getName() + "!");

        }

        int damageReceived = enemy.ReceiveDamage(damage);

        System.out.println(this.getName() + " ataca a " + enemy.getName() + " e inflige " + damageReceived + " de daño.");

        return damageReceived;
    }



    @Override
    public int ReceiveDamage(int amount) {

        //Creo la variable health para restar la vida al enemigo.
        int initialHealth = this.getHealth();
        int newHealth = initialHealth - amount;

        //Control de la vida para que no pueda ser negativa.
        if (newHealth < 0) {

            newHealth = 0;

        }

        //Actualizo la vida.
        setHealth(newHealth);

        //Devuelvo el daño real recibido.
        int damageReceived = initialHealth - newHealth;

        return damageReceived;
    }

}
