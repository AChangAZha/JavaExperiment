import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener, MouseListener {
    private int num1 = 0, n = 0;
    private double num2 = 0;
    private int flag = 0;
    JFrame frame;
    JPanel panel1, panel2, panel3;
    JTextField textField;
    JButton button[] = new JButton[16];
    String buttonText[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "+", "-", "*", "/" };

    public Calculator() {
        frame = new JFrame("计算器");
        textField = new JTextField(20);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        frame.setBounds(300, 300, 300, 300);
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.EAST);
        panel2.setLayout(new GridLayout(4, 3));
        panel3.setLayout(new GridLayout(4, 1));
        panel1.add(textField);
        for (int i = 0; i < 12; i++) {
            button[i] = new JButton(buttonText[i]);
            panel2.add(button[i]);
            button[i].addActionListener(this);
        }
        for (int i = 12; i < 16; i++) {
            button[i] = new JButton(buttonText[i]);
            panel3.add(button[i]);
            button[i].addActionListener(this);
        }
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String str = "";
        int i;
        for (i = 0; i <= 9; i++) {
            if (e.getSource() == button[i]) {
                if (i == 9) {
                    n = n * 10;
                } else {
                    n = n * 10 + i + 1;
                }
                str = String.valueOf(n);
                textField.setText(str);
            }
        }
        for (i = 12; i < 16; i++) {
            if (e.getSource() == button[i]) {
                num1 = Integer.parseInt(textField.getText());
                if (flag == 13) {
                    num2 = num1 + num2;
                } else if (flag == 14) {
                    num2 = num1 - num2;
                } else if (flag == 15) {
                    num2 = num1 * num2;
                } else if (flag == 16) {
                    num2 = num1 / num2;
                } else
                    num2 = num1;
                if (i == 12)
                    flag = 13;
                else if (i == 13)
                    flag = 14;
                else if (i == 14)
                    flag = 15;
                else
                    flag = 16;
                str = String.valueOf(buttonText[i]);
                textField.setText(str);
                n = 0;
                break;
            }
        }
        if (e.getSource() == button[10]) {
            num1 = Integer.parseInt(textField.getText());
            str = String.valueOf(num1 + buttonText[10]);
            textField.setText(str);
            int j = 0;
            for (i = 0; i <= 9; i++) {
                if (e.getSource() == button[i]) {
                    j++;
                    num2 = Math.pow(0.1, j) * Integer.parseInt(buttonText[i]);
                    str = String.valueOf(num1 + num2);
                    textField.setText(str);
                }
            }
        }
        if (e.getSource() == button[11]) {
            num1 = Integer.parseInt(textField.getText());
            if (flag == 13) {
                num2 = num2 + num1;
            } else if (flag == 14) {
                num2 = num2 - num1;
            } else if (flag == 15) {
                num2 = num2 * num1;
            } else if (flag == 16) {
                num2 = num2 / num1;
            } else
                num2 = num1;
            str = String.valueOf(num2);
            textField.setText(str);
            n = 0;
            flag = 0;
        }

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        new Calculator();
    }
}