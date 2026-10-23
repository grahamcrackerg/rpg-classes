public class Battlemage extends Combatant {
    private int mana;
    private int strength;
    public Battlemage(String name, int hp, int defense, int strength, int intel, int mana) {
        super(name,hp,defense,strength,intel);
        this.mana = mana;
        this.strength = strength;
    }
    @Override
    public void attack(Combatant target) {

    }
}
