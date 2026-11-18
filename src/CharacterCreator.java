import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;

public class CharacterCreator extends JFrame {
    private CardLayout cl;
    private String charname;
    private String charclass;
    private int charhp;
    private int chardef;
    private int charstren;
    private int charint;
    private JPanel mainPanel;
    private JLabel infolabel;
    public CharacterCreator() {

        setTitle("Character Creator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel cc1 = createcc1();
        JPanel cc2 = createcc2();

        cl = new CardLayout();
        mainPanel = new JPanel(cl);

        mainPanel.add(cc1,"Character Creator 1");
        mainPanel.add(cc2,"Character Creator 2");
        add(mainPanel);
        setVisible(true);

    }
    private JPanel createcc1() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Character Name:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField nameField = new JTextField(15);
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameField.setMaximumSize(new Dimension(400, 30));

        JLabel classLabel = new JLabel("Character Class:");
        classLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] classes = {
                "Rogue",
                "Battlemage",
                "Necromancer",
                "Gunslinger",
                "Chef"
        };

        JComboBox<String> classBox = new JComboBox<>(classes);
        classBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        classBox.setMaximumSize(new Dimension(400, 30));

        JButton contButton = new JButton("Continue");
        contButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        contButton.addActionListener(e -> {

            charname = nameField.getText();
            charclass = (String) classBox.getSelectedItem();
            infolabel.setText("Name: " + charname + "    Class: " + charclass);
            cl.show(mainPanel, "Character Creator 2");
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(classLabel);
        panel.add(classBox);
        panel.add(new JLabel(" "));
        panel.add(contButton);

        return panel;
    }
    private JPanel createcc2() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        System.out.println(charname);
        infolabel = new JLabel();
        infolabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel hplabel = new JLabel("HP:");
        hplabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField hpfield = new JTextField(15);
        hpfield.setMaximumSize(new Dimension(400, 30));
        hpfield.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel defenselabel = new JLabel("Defense:");
        defenselabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField defensefield = new JTextField(15);
        defensefield.setMaximumSize(new Dimension(400, 30));
        defensefield.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel strengthlabel = new JLabel("Strength:");
        strengthlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField strengthfield = new JTextField(15);
        strengthfield.setMaximumSize(new Dimension(400, 30));
        strengthfield.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel intellabel = new JLabel("Intel:");
        intellabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField intelfield = new JTextField(15);
        intelfield.setMaximumSize(new Dimension(400, 30));
        intelfield.setAlignmentX(Component.CENTER_ALIGNMENT);

        ((AbstractDocument) hpfield.getDocument())
                .setDocumentFilter(new NumericFilter());
        ((AbstractDocument) defensefield.getDocument())
                .setDocumentFilter(new NumericFilter());
        ((AbstractDocument) strengthfield.getDocument())
                .setDocumentFilter(new NumericFilter());
        ((AbstractDocument) intelfield.getDocument())
                .setDocumentFilter(new NumericFilter());
        JLabel total = new JLabel("Total stats must be 20 or less");
        total.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton createButton = new JButton("Create");
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        createButton.addActionListener(e -> {
            try {
                charhp = Integer.parseInt(hpfield.getText());
                chardef = Integer.parseInt(defensefield.getText());
                charstren = Integer.parseInt(strengthfield.getText());
                charint = Integer.parseInt(intelfield.getText());
            } catch (NumberFormatException e2) {
                return;
            }

            if (charhp < 1) {
                total.setText("HP must be 1 or higher");
                return;
            }
            if (chardef < 1) {
                total.setText("Defense must be 1 or higher");
                return;
            }
            if (charstren < 1) {
                total.setText("Strength must be 1 or higher");
                return;
            }
            if (charint < 1) {
                total.setText("Intel must be 1 or higher");
                return;
            }
            if (charhp + chardef + charint + charstren > 20) {
                total.setText("Total stats must be 20 or less (Current: " + (charhp + chardef + charint + charstren) + ")");
                return;
            }

        });
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        backButton.addActionListener(e -> {
            cl.show(mainPanel, "Character Creator 1");
        });
        panel.add(infolabel);
        panel.add(hplabel);
        panel.add(hpfield);
        panel.add(defenselabel);
        panel.add(defensefield);
        panel.add(strengthlabel);
        panel.add(strengthfield);
        panel.add(intellabel);
        panel.add(intelfield);
        panel.add(total);
        panel.add(createButton);
        panel.add(backButton);
        return panel;
    }
}