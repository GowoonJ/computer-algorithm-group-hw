import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorApp extends JFrame{
    public JPanel mainJPanel;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JTextArea costArea;
    private JTextArea changeArea;
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
    private JButton inputButton;
    private JTextArea 저희업소는모든제품을TextArea;

    private int num1, num2, num3;

    ArrayList<Integer> costArray = new ArrayList<>(3);

    public GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();

    // JFrame 이용

    private void start(){
        // x 클릭 시 프로그램도 종료, Frame의 Layout : BorderLayout
        JFrame frame = new JFrame("Calculator App");
        frame.setContentPane(mainJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        setButtonLimit();

        calculateTotalCost(0,0,0);

        buttonStart.addActionListener(e ->{
            num1 = (int) spinner1.getValue();
            num2 = (int) spinner2.getValue();
            num3 = (int) spinner3.getValue();

            calculateTotalCost(num1, num2, num3);

            costArea.setText( "샌드위치\t" + num1 +"개\t" + costArray.get(0) + "원\n"
                    + "타코\t"+ num2 +"개\t" + costArray.get(1) + "원\n"
                    + "햄버거세트\t" + num3 +"개\t" +costArray.get(2) + "원\n"
                    + "총 금액 : \t" + costArray.get(3) +"원"
            );
        });



        frame.setVisible(true);
    }

    private void setButtonLimit(){
        SpinnerModel spinnerModel1 = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerModel spinnerModel2 = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerModel spinnerModel3 = new SpinnerNumberModel(0, 0, 100, 1);
        spinner1.setModel(spinnerModel1);
        spinner2.setModel(spinnerModel2);
        spinner3.setModel(spinnerModel3);
    }

    public static void main(String[] args){
        CalculatorApp client = new CalculatorApp();
        client.start();
    }


    private void calculateTotalCost(int itemSandwich, int itemTaco, int itemBurger){
        int sandwich = 7000;
        int burgerSet = 15000;
        int taco = 12000;

        if (costArray.isEmpty()){
            initSet();
        }

        costArray.set(0,sandwich*itemSandwich);
        costArray.set(1,taco*itemTaco);
        costArray.set(2,burgerSet*itemBurger);

        int sum= 0;
        for (int i = 0 ; i<3 ; i++){
            sum = sum + costArray.get(i);
        }
        costArray.set(3,sum);
    }

    private void initSet(){
        costArray.add(0,0);
        costArray.add(1,0);
        costArray.add(2,0);
        costArray.add(3,0);
    }
}


