import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorApp extends JFrame{
    public JPanel mainJPanel;
    private JSpinner spinner1, spinner2, spinner3;
    private JTextArea costArea;
    private JTextArea changeArea;
    private JButton buttonStart;
    private JLabel count2Label, count3Label, count1Label;
    private JPanel item1Panel, item3Panel, item2Panel;
    private JPanel calculateJPanel, titleJPanel;
    private JLabel totalLabel, costLabel, titleLabel;
    private JLabel imageLabel1, imageLabel3, imageLabel2;
    private JTextField textFieldInput;
    private JButton inputButton;
    private JTextArea textArea;

    private int num1, num2, num3, inputMoney, sum;

    private ArrayList<Integer> costArray = new ArrayList<>(3);
    private GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();

    // JFrame 이용
    private void start(){
        JFrame frame = new JFrame("Calculator App");
        frame.setContentPane(mainJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.pack();

        setButtonLimit();
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

        inputButton.addActionListener(e->{
            if(costArray.isEmpty()||costArray.get(3)==0){
                textFieldInput.setText("주문할 음식을 골라주세요");
            }else {
                String money = textFieldInput.getText();
                if (money.equals("")){
                    money = "0";
                }

                try{
                    inputMoney = Integer.parseInt(money);
                    if (inputMoney != 0) {
                        if (greedyAlgorithm.getIsPay(inputMoney, costArray.get(3))) {
                            greedyAlgorithm.moneyChange();
                            setChangeArea(greedyAlgorithm.getChangeCost());
                        } else {
                            textFieldInput.setText("금액을 다시 입력해주세요");
                        }
                    } else {
                        textFieldInput.setText("금액을 입력해주세요");
                    }

                }catch(NumberFormatException exception){
                    textFieldInput.setText("금액을 다시 입력해주세요");
                    inputMoney = 0;
                }
            }
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

        if (!costArray.isEmpty()){
            costArray.clear();
        }

        costArray.add(0,sandwich*itemSandwich);
        costArray.add(1,taco*itemTaco);
        costArray.add(2,burgerSet*itemBurger);

        sum = 0;
        for (int i = 0 ; i<3 ; i++){
            sum = sum + costArray.get(i);
        }
        costArray.add(3,sum);
    }

    private void setChangeArea(ArrayList<String> arrayList){
        String changeOutput = "거스름 돈은\t 총 "+(inputMoney-sum)+ "원\n";
        for(int i = 0 ; i<arrayList.size()-1; i++){
            changeOutput = changeOutput + arrayList.get(i) +"\n";
        }
        changeOutput = changeOutput + arrayList.get(arrayList.size()-1) +"가 나옵니다";
        changeArea.setText(changeOutput);
    }
}


