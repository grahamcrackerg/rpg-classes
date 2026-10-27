public static void main(String[] args) {
    Combatant dummy = new Dummy("DUMMY",1,0,0,0);
    ArrayList<Combatant> combatants = new ArrayList<>();
    combatants.add(new Rogue("OLLIE", 15, 3,7,5));
    combatants.add(new Necromancer("BODHI", 12, 1,2,18));
    combatants.add(new Battlemage("JOSHY", 22, 8,6,14,50));
    //dummy.takeDamage(10,dummy);
    for (Combatant c: combatants) {
        if (c instanceof SpecialMove) {
            ((SpecialMove) c).UseSpecialMove();
        }
        c.attack(dummy);
    }
    for (Combatant c: combatants) {
        c.attack(dummy);
    }
    for (Combatant c: combatants) {
        c.attack(dummy);
    }
    for (Combatant c: combatants) {
        c.attack(dummy);
    }
}