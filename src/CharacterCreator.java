import javax.swing.*;
import java.awt.*;

public class CharacterCreator extends JFrame {

    public CharacterCreator() {

        setTitle("Character Creator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Character Name:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField nameField = new JTextField(15);
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameField.setMaximumSize(
                new Dimension(400, 30)
        );

        JLabel classLabel = new JLabel("Character Class:");
        classLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] classes = {
                "Rogue",
                "Battlemage",
                "Necromancer",
                "Gunslinger",
                "Chef"
        };

        JComboBox<String> classBox =
                new JComboBox<>(classes);
        classBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        classBox.setMaximumSize(
                new Dimension(400, 30)
        );
        JButton contButton =
                new JButton("Continue");
        add(panel);
        contButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contButton.setMaximumSize(
                new Dimension(200, 30)
        );

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(classLabel);
        panel.add(classBox);
        panel.add(new JLabel(" "));
        panel.add(contButton);
        setVisible(true);
    }
}