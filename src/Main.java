import java.util.Scanner;
public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    Combatant dummy = new Dummy("DUMMY",1,0,0,0);
    ArrayList<Combatant> combatants = new ArrayList<>();
    System.out.println(System.getProperty("user.dir"));
    System.out.println("Welcome to the RPG!");

    if (Files.exists(Path.of("save.txt"))) {
        System.out.println("Save detected!");
        System.out.println("Would you like to load your save file?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        int choice = 0;
        while(choice < 1 || choice > 2) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
            } else {
                input.next();
            }

            if (choice < 1 || choice > 2) {
                System.out.print("Type a number 1 or 2");
            }
        }
        if (choice == 1) {
            try {
                Scanner fileScanner = new Scanner(new File("save.txt"));
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length != 6) {
                        System.out.println("Skipping malformed line: " + line);
                        continue;
                    }

                    String type = parts[0];
                    String name = parts[1];
                    int hp = Integer.parseInt(parts[2]);
                    int defense = Integer.parseInt(parts[3]);
                    int strength = Integer.parseInt(parts[4]);
                    int intel = Integer.parseInt(parts[5]);
                    if (type.equals("Rogue")) {
                        combatants.add(new Rogue(name,hp,defense,strength,intel));
                    }
                    if (type.equals("Battlemage")) {
                        combatants.add(new Battlemage(name,hp,defense,strength,intel));
                    }
                    if (type.equals("Necromancer")) {
                        combatants.add(new Necromancer(name,hp,defense,strength,intel));
                    }
                    if (type.equals("Gunslinger")) {
                        combatants.add(new Gunslinger(name,hp,defense,strength,intel));
                    }
                    if (type.equals("Chef")) {
                        combatants.add(new Chef(name,hp,defense,strength,intel));
                    }
                    System.out.println(name + " added");
                }
                fileScanner.close();
                System.out.println("Save loaded successfully!");
            } catch (FileNotFoundException e) {
                System.out.println("Save file not detected.");
            }


        }
        if (choice == 2) {
            System.out.println("Save not loaded");
        }
    }
    boolean quit = false;
    while (!quit) {
        System.out.println("Would you like to create a character or save your characters?");
        System.out.println("1) Create Characters");
        System.out.println("2) Show Characters");
        System.out.println("3) Save");
        int choice = 0;
        while(choice < 1 || choice > 3) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
            } else {
                input.next();
            }

            if (choice < 1 || choice > 3) {
                System.out.print("Type a number 1-3");
            }
        }
        if (choice == 1) {
            String name = "";
            System.out.print("Please type your character's name");
            for(name = input.nextLine(); name.isBlank(); name = input.nextLine()) {
                System.out.print("Your name can't be blank");
            }
            int classchoice = 0;
            System.out.println("What class is your character?");
            System.out.println("1) Rogue");
            System.out.println("2) Battlemage");
            System.out.println("3) Necromancer");
            System.out.println("4) Gunslinger");
            System.out.println("5) Chef");
            while(classchoice < 1 || classchoice > 5) {
                if (input.hasNextInt()) {
                    classchoice = input.nextInt();
                    input.nextLine();
                } else {
                    input.next();
                }

                if (classchoice < 1 || classchoice > 5) {
                    System.out.print("Type a number 1-5");
                }
            }
            System.out.println("What is your character's HP?");
            int hp = -1;
            while (hp<1) {
                if (!input.hasNextInt()) {
                    input.next();
                    System.out.println("Please input a number greater than 0");
                }
                if (input.hasNextInt()) {
                    hp = input.nextInt();
                    if (hp < 1) {
                        System.out.println("Please input a number greater than 0");
                    }
                }
            }
            System.out.println("What is your character's defense?");
            int defense = -1;
            while (defense <0) {
                if (!input.hasNextInt()) {
                    input.next();
                    System.out.println("Please input a number greater than 0");
                }
                if (input.hasNextInt()) {
                    defense = input.nextInt();
                    if (defense < 0) {
                        System.out.println("Please input a number greater than 0");
                    }
                }
            }
            System.out.println("What is your character's strength?");
            int strength = -1;
            while (strength <0) {
                if (!input.hasNextInt()) {
                    input.next();
                    System.out.println("Please input a number greater than 0");
                }
                if (input.hasNextInt()) {
                    strength = input.nextInt();
                    if (strength < 0) {
                        System.out.println("Please input a number greater than 0");
                    }
                }
            }
            System.out.println("What is your character's intel?");
            int intel = -1;
            while (intel <0) {
                if (!input.hasNextInt()) {
                    input.next();
                    System.out.println("Please input a number greater than 0");
                }
                if (input.hasNextInt()) {
                    intel = input.nextInt();
                    if (intel < 0) {
                        System.out.println("Please input a number greater than 0");
                    }
                }
            }
            switch (classchoice) {
                case 1:
                    combatants.add(new Rogue(name,hp,defense,strength,intel));
                case 2:
                    combatants.add(new Battlemage(name,hp,defense,strength,intel));
                case 3:
                    combatants.add(new Necromancer(name,hp,defense,strength,intel));
                case 4:
                    combatants.add(new Gunslinger(name,hp,defense,strength,intel));
                case 5:
                    combatants.add(new Chef(name,hp,defense,strength,intel));
            }
        }
        if (choice == 2) {
            if (combatants.size() > 0) {
                for (Combatant c: combatants) {
                    System.out.println(c.toCsv());
                }
            } else {
                System.out.println("You have no characters...");
            }
        }
        if (choice == 3) {
            FileWriter writer = new FileWriter("save.txt");
            for (Combatant c : combatants) {
                writer.write(c.toCsv() + "\n");
            }
            writer.close();
            System.out.println("Saved successfully!");
        }
    }


}