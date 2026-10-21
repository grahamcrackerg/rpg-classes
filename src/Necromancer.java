public class Necromancer extends Combatant {
    private int spirits;
    public Necromancer(String name, int hp, int spirits) {
        super(name,hp);
        this.spirits = spirits;
    }
    @Override
    public String attack() {
        return getName() + " summons skeletons to tear apart the enemy.";
    }
}
