package screen.mainMenuApplication;
import screen.sortingApplication.*;
import screen.sortingApplication.color.ColorManager;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainMenu extends JFrame {
    private JPanel mainPanel, container;
    private JLabel titleLabel;
    private JButton helpMenuButton, quitButton, sortButton;
    private static final int WIDTH = 1024, HEIGHT = 768;

    public MainMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(WIDTH, HEIGHT));
        setLocationRelativeTo(null);
        setBackground(ColorManager.BACKGROUND);
        setTitle("TEAM 19's Sorting Visualizer");
        initialize();
        setVisible(true);
    }

    private void initialize() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(ColorManager.BACKGROUND);

        // add title label
        titleLabel = new JLabel("Sorting Visualizer");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 50f));
        titleLabel.setForeground(ColorManager.TEXT);
        int topPadding = 10;
        int leftPadding = 0;
        int bottomPadding = 10;
        int rightPadding = 0;
        titleLabel.setBorder(new EmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding));

        //add sort button
        sortButton = new JButton("Sort");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame().setVisible(true);
                dispose();
            }
        });

        // add help button
        helpMenuButton = new JButton("Help");
        helpMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHelpDialog();
            }
        });

        // add quit button
        quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //set font, size for button
        Font buttonFont = sortButton.getFont().deriveFont(Font.PLAIN, 30f);
        Dimension buttonSize = new Dimension(150, 70);
        sortButton.setFont(buttonFont);
        helpMenuButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);
        sortButton.setPreferredSize(buttonSize);
        helpMenuButton.setPreferredSize(buttonSize);
        quitButton.setPreferredSize(buttonSize);

        //add title
        container.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Điều chỉnh khoảng cách giữa các nút

        buttonPanel.add(sortButton, gbc);

        gbc.gridy++;
        buttonPanel.add(helpMenuButton, gbc);

        gbc.gridy++;
        buttonPanel.add(quitButton, gbc);
        buttonPanel.setBackground(ColorManager.BACKGROUND);

        // Thêm JPanel vào khu vực Center của Container
        container.add(buttonPanel, BorderLayout.CENTER);


    }

    private static void showHelpDialog() {
        String helpMessage = "Welcome to the application!\n\n" +
                "Instructions:\n" +
                "1. Do something...\n" +
                "2. Do something else...\n" +
                "3. Enjoy using the application!";

        JOptionPane.showMessageDialog(null, helpMessage, "Help", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
