import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorClient extends JFrame implements ActionListener, Runnable {

    JPanel costPanel = new JPanel(new GridLayout(2,0));
    JTextArea paymentArea = new JTextArea();
    JTextArea totalCostArea = new JTextArea();

    CalculatorApp calculatorApp = new CalculatorApp();
    JPanel mainPanel = calculatorApp.mainJPanel;


    // JFrame 이용

    public void start(){
        // x 클릭 시 프로그램도 종료, Frame의 Layout : BorderLayout


        JFrame frame = new JFrame("App");
        frame.setContentPane(new CalculatorApp().mainJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBackground(Color.LIGHT_GRAY);
//        mainPanel.setBackground(Color.LIGHT_GRAY);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }


    public static void main(String[] args){
        CalculatorClient client = new CalculatorClient();
        client.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }
}
