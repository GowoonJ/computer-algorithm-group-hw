import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {
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
    private JTextField textFieldInput;
    private JButton 투입Button;

    int num1, num2, num3;

    public GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();

    // JFrame 이용

    private void start(){
        // x 클릭 시 프로그램도 종료, Frame의 Layout : BorderLayout
        JFrame frame = new JFrame("Calculator App");
        frame.setContentPane(mainJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        setButtonLimit();

        buttonStart.addActionListener(e ->{
            num1 = (int) spinner1.getValue();
            num2 = (int) spinner2.getValue();
            num3 = (int) spinner3.getValue();



        });

        frame.setVisible(true);
    }

    private void setButtonLimit(){
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        spinner1.setModel(spinnerModel);
        spinner2.setModel(spinnerModel);
        spinner3.setModel(spinnerModel);
    }

    public static void main(String[] args){
        CalculatorApp client = new CalculatorApp();
        client.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


