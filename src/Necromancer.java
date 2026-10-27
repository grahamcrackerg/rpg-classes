public class Necromancer extends Combatant {
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
}
