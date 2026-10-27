public class Rogue extends Combatant implements SpecialMove {
    private Boolean stealth = false;
    public Rogue(String name, int hp, int defense, int strength, int intel) {
        super(name,hp,defense,strength,intel);
    }
    @Override public void attack(Combatant target) {
        if (stealth) {
            stealth = false;
            target.takeDamage(strength*2,this);
            System.out.println(name + " sneak attacks " + target.name + "!");
        } else {
            target.takeDamage(strength,this);
            System.out.println(name + " stabs " + target.name + "!");
        }
    }

    @Override public void UseSpecialMove() {
        if (!stealth) {
           stealth = true;
           System.out.println(name + " becomes cloaked in shadow.");
        } else {
            stealth = false;
            System.out.println(name + " uncloaks.");
        }
    }
}
