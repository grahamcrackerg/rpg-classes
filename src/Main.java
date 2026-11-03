import java.util.Scanner;
public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    Combatant dummy = new Dummy("DUMMY",1,0,0,0);
    ArrayList<Combatant> combatants = new ArrayList<>();
    System.out.println(System.getProperty("user.dir"));
    System.out.println("Welcome to the RPG!");

    if (Files.exists(Path.of("save.txt"))) {
        System.out.println("Save detected");
    }
    FileWriter writer = new FileWriter("save.txt");
    for (Combatant c : combatants) {
        writer.write(c.toCsv() + "\n");
    }
    writer.close();

}