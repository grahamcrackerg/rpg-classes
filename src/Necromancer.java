public class Necromancer extends Combatant {
    private int mana;
    public Necromancer(String name, int hp, int defense, int strength, int intel, int mana) {
        super(name,hp,defense,strength,intel);
        this.mana = mana;
    }
    @Override
    public void attack(Combatant target) {

    }
}
