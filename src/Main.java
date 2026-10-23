public static void main(String[] args) {
    Combatant dummy = new Dummy("DUMMY",1,0,0,0);
    ArrayList<Combatant> combatants = new ArrayList<>();
    combatants.add(new Rogue("BODHI", 15, 3,20,5));
    combatants.add(new Necromancer("OLLIE", 12, 1,5,18,100));
    combatants.add(new Battlemage("JOSHY", 22, 8,15,14,50));
    dummy.takeDamage(10,dummy);
    combatants.get(2).takeDamage(10,dummy);
}