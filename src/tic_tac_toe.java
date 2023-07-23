import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tic_tac_toe implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons = new JButton[9];
    private boolean xTurn = true;
    private ImageIcon iconX = new ImageIcon("Icons/x.png");
    private ImageIcon iconO = new ImageIcon("Icons/o.png");


    public tic_tac_toe() {
        frame = new JFrame("TIC TAC TOE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }


        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        Icon x = new ImageIcon(iconX.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT));
        Icon o = new ImageIcon(iconO.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT));

        if (xTurn) {
            button.setText("X");
//            button.setIcon(x);
//            button.setDisabledIcon(x);
        } else {
            button.setText("O");
//            button.setIcon(o);
//            button.setDisabledIcon(o);
        }
        button.setEnabled(false);
        xTurn = !xTurn;

        checkForWinner();
    }


//    public void checkForWinner() {
//        //check rows
//        for (int i = 0; i < 9; i += 3) {
//            if ( buttons[i].getIcon().equals(buttons[i + 1].getIcon())
//                    && buttons[i].getIcon().equals(buttons[i + 2].getIcon())
//                    && !buttons[i].isEnabled()) {
//                JOptionPane.showMessageDialog(frame, buttons[i].getIcon() + "WINS");
//                resetGame();
//                return;
//            }
//        }
//
//
//            //check columns
//            for (int i = 0; i < 3; i++) {
//                if (buttons[i].getIcon().equals(buttons[i + 3].getIcon())
//                        && buttons[i].getIcon().equals(buttons[i + 6].getIcon())
//                        && !buttons[i].isEnabled()) {
//                    JOptionPane.showMessageDialog(frame, buttons[i].getIcon() + "WINS");
//                    resetGame();
//                    return;
//                }
//            }
//            //check diagonals
//            if (buttons[0].getIcon().equals(buttons[4].getIcon())
//                    && buttons[0].getIcon().equals(buttons[8].getIcon())
//                    && !buttons[0].isEnabled()) {
//                JOptionPane.showMessageDialog(frame, buttons[0].getIcon() + "WINS");
//                resetGame();
//                return;
//            }
//            if (buttons[2].getIcon().equals(buttons[4].getIcon())
//                    && buttons[2].getIcon().equals(buttons[6].getIcon())
//                    && !buttons[2].isEnabled()) {
//                JOptionPane.showMessageDialog(frame, buttons[2].getIcon() + "WINS");
//                resetGame();
//                return;
//            }
//            //check tie
//            boolean tie = true;
//            for (int i = 0; i < 9; i++) {
//                if (buttons[i].isEnabled()) {
//                    tie = false;
//                    break;
//                }
//            }
//            if (tie) {
//                JOptionPane.showMessageDialog(frame, "TIE!!!!");
//                resetGame();
//            }
//        }

    public void checkForWinner() {
        //check rows
        for (int i = 0; i < 9; i += 3) {
            if ( buttons[i].getText().equals(buttons[i + 1].getText())
                    && buttons[i].getText().equals(buttons[i + 2].getText())
                    && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getIcon() + "WINS");
                resetGame();
                return;
            }
        }


        //check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i + 3].getText())
                    && buttons[i].getText().equals(buttons[i + 6].getText())
                    && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getIcon() + "WINS");
                resetGame();
                return;
            }
        }
        //check diagonals
        if (buttons[0].getText().equals(buttons[4].getText())
                && buttons[0].getText().equals(buttons[8].getText())
                && !buttons[0].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[0].getIcon() + "WINS");
            resetGame();
            return;
        }
        if (buttons[2].getText().equals(buttons[4].getText())
                && buttons[2].getText().equals(buttons[6].getText())
                && !buttons[2].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[2].getIcon() + "WINS");
            resetGame();
            return;
        }
        //check tie
        boolean tie = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].isEnabled()) {
                tie = false;
                break;
            }
        }
        if (tie) {
            JOptionPane.showMessageDialog(frame, "TIE!!!!");
            resetGame();
        }
    }


    public void resetGame() {
        for (int i = 0; i < 9; i++) {
//            buttons[i].setIcon(null);
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        xTurn = true;
    }


    public static void main(String[] args) {
        new tic_tac_toe();
    }
}
