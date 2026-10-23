public class Dummy extends Combatant {
    public Dummy(String name, int hp, int defense, int strength, int intel) {
        super(name,hp,defense,strength,intel);
    }
    @Override
    public void attack(Combatant target) {

    }
    @Override
    public void takeDamage(int damage, Combatant attacker) {
        System.out.println(name + " took "+(int) (damage*resist())+" damage from "+attacker.name);
    }
}
