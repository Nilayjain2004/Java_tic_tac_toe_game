
package demo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo extends JFrame implements ItemListener, ActionListener {

    int i, j, ii, jj, x, y, yesnull;
    int a[][] = {{10, 1, 2, 3, 11}, {10, 1, 4, 7, 11}, {10, 1, 5, 9, 11}, {10, 2, 5, 8, 11},
    {10, 3, 5, 7, 11}, {10, 3, 6, 9, 11}, {10, 4, 5, 6, 11},
    {10, 7, 8, 9, 11}, {10, 1, 2, 3, 11}};

    JButton b[] = new JButton[9];

    Demo() {
        super("Tic Tac Toe");
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            b[i] = new JButton("");
            b[i].addActionListener(this);
            add(b[i]);
        }
        reset();
    }

    void reset() {
        for (int i = 0; i < 9; i++) {
            a[i][0] = 10;
            b[i].setText("");
        }
    }

    boolean checkwinner() {
        for (int i = 0; i < 8; i++) {
            if (a[i][0] == a[i][1] && a[i][1] == a[i][2] && a[i][0] != 10) {
                return true;
            } else if (a[i][0] == a[i][3] && a[i][3] == a[i][6] && a[i][0] != 10) {
                return true;
            } else if (a[i][0] == a[i][4] && a[i][4] == a[i][8] && a[i][0] != 10) {
                return true;
            }
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == b[i]) {
                if (a[i][0] == 10) {
                    a[i][0] = 1;
                    b[i].setText("X");
                    if (checkwinner()) {
                        JOptionPane.showMessageDialog(this, "X Wins");
                        reset();
                    } else {
                        for (int j = 0; j < 9; j++) {
                            if (a[j][0] == 10) {
                                a[j][0] = 2;
                                b[j].setText("O");
                                if (checkwinner()) {
                                    JOptionPane.showMessageDialog(this, "O Wins");
                                    reset();
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void itemStateChanged(ItemEvent e) {
    }

    public static void main(String[] args) {
        Demo t = new Demo();
        t.setSize(300, 300);
        t.setVisible(true);
    }
}




