public abstract class Character {

    private String name;
    private int health;
    private int strength;
    private int defense;
    private int speed;

    //Constructor
    public Character(String name, int health, int strength, int defense, int speed) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.speed = speed;
    }


    //Constructor default.
    public Character() {
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
    public abstract int Attack(Character enemy);


    //Método para recibir daño.
    public abstract int receiveDamage(int amount);
}
