public class Skeleton extends Combatant {
    public Skeleton(String name, int hp, int defense, int strength, int intel) {
        super(name,hp,defense,strength,intel);
    }
    @Override public void attack(Combatant target) {
        target.takeDamage(strength,this);
        System.out.println(name + " lunges at " + target.name + "!");
    }
}
