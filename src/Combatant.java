public abstract class Combatant {
    protected String name;
    protected int hp;
    protected int defense;
    protected int strength;
    protected int intel;

    public Combatant(String name, int hp, int defense, int strength, int intel) {
        this.name = name;
        this.hp = hp;
        this.defense = defense;
        this.strength = strength;
        this.intel = intel;
    }
    public String getName() { return name; }
    public double resist() {return (1-((0.5*Math.sqrt(defense*150))*0.01));}
    public abstract void attack(Combatant target);
    public void takeDamage(int damage, Combatant attacker) {
        hp = (int) (hp - (damage * resist()));
        System.out.println(name + " took "+(int) (damage*resist())+" damage from "+attacker.name);
    }
}
