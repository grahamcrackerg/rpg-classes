public class Battlemage extends Combatant {
    private int mana;
    private int strength;
    public Battlemage(String name, int hp, int mana, int strength) {
        super(name,hp);
        this.mana = mana;
        this.strength = strength;
    }
    @Override
    public String attack() {
        return getName() + " slashes enemies with magic attacks.";
    }
}
