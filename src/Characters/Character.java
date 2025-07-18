package Characters;

import java.util.Random;

public abstract class Character {

    //Atributos.
    private String name;
    private int health;
    private int strength;
    private int agility;
    private int intellect;
    private int defense;
    private int speed;

    //Constructor
    public Character(String name, int health, int strength, int agility, int intellect, int defense, int speed) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.defense = defense;
        this.speed = speed;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    //Constructor default.
    public Character() {
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    //Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //Método atacar.

    //La mecánica básica de ataque (incluyendo azar, críticos fallos) va a ser igual para cada clase, luego sobreescribiré
    //en cada clase lo que quiera personalizar pero esta será la base.
    public int Attack(Character enemy) {

        //Crea un generador de números aleatorios.
        Random random = new Random();

        //15% de probabilidad de fallar.
        int chanceFail = random.nextInt(100);//Devuelve un número aleatorio de 0 a 99.

        //Si el número aleatorio devuelto por random.nextInt() es entre 0 y 14 entonces fallará.
        if (chanceFail < 15){

            //Devolverá 0 de daño.
            return 0;

        }

        //Calcular el daño base.
        int damage = this.getStrength() - enemy.getDefense() / 2; //Entre dos porque si no casi no entraría daño.

        //Comprobación para que damage nunca sea negativo.
        if (damage < 0) {

            damage = 0;

        }
        //Comprobar golpe crítico.
        int chanceCrit = random.nextInt(100);

        if (chanceCrit < 20) {

            damage *= 2;
        }

        //Aplicamos el daño.
        int receivedDamage = enemy.ReceiveDamage(damage);

        return receivedDamage;

    }

    //Sabes si el personaje sigue vivo.
    public boolean isAlive() {

        return this.health > 0;

    }

    public String toString() {

        return name + " [❤️: " + health + ", 💪: " + strength + ", 🐒:" + agility + ", 🧠:" + intellect + ", 🛡️: " + defense + ", ⚡: " + speed + "]";

    }

    //Método para recibir daño.
    public abstract int ReceiveDamage(int amount);
}
