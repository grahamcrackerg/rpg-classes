public class Necromancer extends Combatant implements SpecialMove{
    private int souls = 0;
    public Necromancer(String name, int hp, int defense, int strength, int intel) {
        super(name,hp,defense,strength,intel);
    }
    @Override public void attack(Combatant target) {
        target.takeDamage(strength,this);
        System.out.println(name + " slaps " + target.name + "!");
        souls++;
        System.out.println("Absorbed part of "+target.name+"'s soul! Total: "+souls);
    }

    @Override public void UseSpecialMove() {
        if (souls >= 1) {
            new Skeleton("SKELLY", 5+souls,2+souls,souls*4,souls);
            System.out.println(name + " summons a skeleton from the ground!");
            souls = 0;
        } else {
            System.out.println(name + " is out of souls.");
        }
    }
}
