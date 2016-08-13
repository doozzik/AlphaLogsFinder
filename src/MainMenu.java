import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JDialog {
    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    private JButton trimLogsButton;
    private JTextField textField3;
    private JButton buttonOK;
    private JButton buttonCancel;

    public MainMenu() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        trimLogsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onTrim();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onTrim() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        MainMenu dialog = new MainMenu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
