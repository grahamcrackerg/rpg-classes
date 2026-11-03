import java.util.Random;
public class Gunslinger extends Combatant implements SpecialMove {
    Random random = new Random();
    public Gunslinger(String name, int hp, int defense, int strength, int intel) {
        super(name,hp,defense,strength,intel);
    }
    @Override public void attack(Combatant target) {
        target.takeDamage(strength,this);
        System.out.println(name + " pistol whips " + target.name + "!");
    }

    @Override public void UseSpecialMove(Combatant target) {
        System.out.println(name + " rains fire on " + target.name + "!");
        for (int i=0; i<3+random.nextInt(4); i++) {
            target.takeDamage(strength,this);
            System.out.println(target.name + "is hit for 4 damage!");
        }
    }
}
