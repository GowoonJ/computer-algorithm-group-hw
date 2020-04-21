import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener, Runnable {
    public JPanel mainJPanel;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JTextArea costArea;
    private JTextArea totalCostArea;
    private JButton buttonStart;
    private JButton buttonBuy;
    private JLabel count2Label;
    private JLabel count3Label;
    private JPanel item1Panel;
    private JPanel item3Panel;
    private JPanel item2Panel;
    private JLabel count1Label;
    private JPanel calculateJPanel;
    private JLabel totalLabel;
    private JLabel costLabel;
    private JLabel titleLabel;
    private JPanel titleJPanel;
    private JSpinner spinner1;
    private JLabel imageLabel1;
    private JLabel imageLabel3;
    private JLabel imageLabel2;

    // JFrame 이용

    private void start(){
        // x 클릭 시 프로그램도 종료, Frame의 Layout : BorderLayout
        JFrame frame = new JFrame("Calculator App");
        frame.setContentPane(new CalculatorApp().mainJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        CalculatorApp client = new CalculatorApp();
        client.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }
}


