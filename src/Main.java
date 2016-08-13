import javax.swing.*;
import java.awt.event.*;

public class Main extends JDialog {
    private JPanel contentPane;
    private JButton trimLogsButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;

    public Main() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(trimLogsButton);

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

        trimLogsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent)  {
                Trim trim = new Trim(textArea1, textArea2, textArea3);
            }
        });
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Main dialog = new Main();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
