public class Battlemage extends Combatant implements SpecialMove{
    private int mana;
    private int imbue = 0;
    public Battlemage(String name, int hp, int defense, int strength, int intel, int mana) {
        super(name,hp,defense,strength,intel);
        this.mana = mana;
    }
    @Override
    public void attack(Combatant target) {
        mana += 5;
        if (imbue == 0) {
            target.takeDamage(strength,this);
            System.out.println(name + " strikes " + target.name + "!");
        } else {
            int dmginc = (int) Math.ceil(((double) imbue)*((double) 3/5));
            imbue -= dmginc;
            target.takeDamage(strength + (imbue) + 1,this);
            System.out.println(name + " strikes " + target.name + " with elemental power!");
        }
    }

    @Override public void UseSpecialMove() {
        if (mana >= 25) {
            imbue = (int) (imbue + intel * 1.5);
            System.out.println(name+" imbues their weapon with elemental magic.");
            mana -= 25;
        } else {
            System.out.println("Not enough mana.");
        }

    }
}
