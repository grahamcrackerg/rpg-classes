public class Chef extends Combatant implements SpecialMove{
    public Chef(String name, int hp, int defense, int strength, int intel) {
        super(name,hp,defense,strength,intel);
    }
    @Override public void attack(Combatant target) {
        target.takeDamage(strength + 2,this);
        System.out.println(name + " hits " + target.name + " with a frying pan!");
    }

    @Override public void UseSpecialMove(Combatant target) {
        System.out.println(name + " makes a meal for " + target.name + "!");
        target.takeDamage(-(6 + (intel / 3)),this);
        System.out.println(target.name + " heals " + 6+ (intel/3) + " HP!");
    }
}
