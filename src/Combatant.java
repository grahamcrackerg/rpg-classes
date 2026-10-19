public abstract class Combatant {
    private String name;
    private int hp;

    public Combatant(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
    public String getName() { return name; }
    public abstract String attack();
}
