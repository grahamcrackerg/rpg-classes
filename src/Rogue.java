public class Rogue extends Combatant {
    private int stealth;
    public Rogue(String name, int hp, int stealth) {
        super(name,hp);
        this.stealth = stealth;
    }
    @Override
    public String attack() {
        return getName() + " ambushes the enemy.";
    }

}
