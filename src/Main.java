public static void main(String[] args) {
    ArrayList<Combatant> combatants = new ArrayList<>();
    combatants.add(new Rogue("Bodhi", 15, 100));
    combatants.add(new Necromancer("Ollie", 10, 3));
    combatants.add(new Battlemage("Joshy", 25, 10,100));
    for (Combatant c: combatants) {
        System.out.println(c.attack());
    }
}