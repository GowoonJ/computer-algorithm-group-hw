import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorClient extends JFrame implements ActionListener, Runnable {

    JPanel costPanel = new JPanel(new GridLayout(2,0));
    JTextArea paymentArea = new JTextArea();
    JTextArea totalCostArea = new JTextArea();


    // JFrame 이용

    public void start(){
        // x 클릭 시 프로그램도 종료, Frame의 Layout : BorderLayout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel itemPanel = new JPanel(new GridLayout(2,3));
        itemPanel.setBackground(Color.LIGHT_GRAY);
        this.add(itemPanel,BorderLayout.CENTER);

        costPanel.setBackground(Color.WHITE);
        this.add(itemPanel,BorderLayout.SOUTH);

        this.setSize(800, 600);
        this.setVisible(true);
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
