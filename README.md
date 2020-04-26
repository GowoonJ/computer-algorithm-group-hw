## 2020 1학기 컴퓨터알고리즘 조별과제1

### Java Swing 이용하여 자판기 GUI 구현

#### 프로그램 구현

   각 제품들에 대한 값들을 할당하고 **Greedy Algorithm**(탐욕 알고리즘) 이용하여 지불 금액에 대한 거스름돈 알고리즘 구현한 뒤, 지폐 분류를 거친 결과를 출력한다

- **GUI 형태는 피시방 음식 주문 서비스 참고**

- 1. JSpinner를 이용하여 원하는 음식의 수량 체크 후 보기 버튼 클릭
- 2. 책정된 음식의 총 금액을 보고 지불 금액 입력
- 3. 투입 버튼 클릭 시 총 거스름 돈과 화폐개수가 나옵니다.


   #### 코드 구현

  

   #### 1. **Greedy Algorithm** 
  ~~~~
     import java.util.*;
     
     public class GreedyAlgorithm {
     
         public static void main(String[] args) {
             moneychange a=new moneychange();
     
         }
     
     }
     
     
     class  moneychange{
         public moneychange() {
             Scanner sc=new Scanner(System.in);
             int Sand= 3000;
             int burgerset=5000;
             int Taco=2000;
             int price1,price2,price3;
     
             price1=Sand *sc.nextInt();
             price2=burgerset*sc.nextInt();
             price3=Taco*sc.nextInt();          /* 샌드위치 , 버거세트 ,타코 구입 총 가격 */
             int money;
             money=sc.nextInt(); //가지고 있는돈
             int sum=price1+price2+price3;// 총가격
             while(true) {
                 if(money<sum) {
                     System.out.println("금액 부족!");
                     money = sc.nextInt(); //금액 부족하면 다시 입력받기
                 }
                 else {
                     money=money-sum;//거스름돈 넣어줌
                     break;
                 }
             }
     
     
             if(money==0) System.out.println("거스름돈이 없습니다!");//지출액이 가진돈과 맞아떨어지면 출력
             int arr[]= {100,500,1000,5000,10000,50000};//지폐종류값 할당 배열 ex)1000원 50000원 등등등
     
     
     
             int cnt=0; //지폐,동전 개수 카운트 변수
     
             for(int i=5;i>=0;i--)//큰 화폐단위부터 봐줘야 하기 때문에 i를 n-1부터 줄어들게함
             {
                 cnt=0;//한바퀴 돌고 나면 카운트 0으로 초기화 그래야 다음 화폐종류의 개수가 나온다.
                 while(money-arr[i]>=0)
                 {
                     money=money-arr[i];
                     cnt++;
                 }//거스름돈 구분하고 개수 카운트
                 if(money-arr[i]<arr[i])
                 {
                    if(cnt>0) System.out.println(arr[i]+"원은"+cnt+"개가 필요합니다");
     
      
                }//거스름돈이 화폐종류보다 작아진다면 갯수 출력
             }
     
         }
     }
   ~~~~
  
      
   >위 코드는 탐욕 알고리즘을 이용해  받은 거스름돈을 지폐와 동전으로 변환해주는 코드를 구현하였는데, 
   만일 arr[] 의 값들을 할당할 때  오름차순으로 배열하지 않는다면 sort() 함수를 사용하여 오름차순으로 배열한뒤, 사용해야 한다.
       
  
  #### 2.  **Java Swing**
  
  > IntelliJ 에 내장된 GUI tool 을 이용하여 구현, GUI 는 form 으로 1차 구현 후, CalculatorApp class를 이용하여 입/출력 제어
 
  1) Calculator App.java
  
        ~~~~
        public class CalculatorApp extends JFrame{
            private void start(){
                JFrame frame = new JFrame("Calculator App");
                           frame.setContentPane(mainJPanel);
                           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                           frame.setResizable(true);
                           frame.pack();
                frame.setVisible(true);
            }
            
            public static void main(String[] args){
                CalculatorApp client = new CalculatorApp();
                client.start();
            }
        }
        ~~~~
      
      >JFrame 상속, 초기 설정
      >main 함수 내부에서 start() 호출하여 JFrame visible 로 실행
  
  2) spinner limited
        ~~~~
        private void setButtonLimit(){
            SpinnerModel spinnerModel1 = new SpinnerNumberModel(0, 0, 100, 1);
            SpinnerModel spinnerModel2 = new SpinnerNumberModel(0, 0, 100, 1);
            SpinnerModel spinnerModel3 = new SpinnerNumberModel(0, 0, 100, 1);
            spinner1.setModel(spinnerModel1);
            spinner2.setModel(spinnerModel2);
            spinner3.setModel(spinnerModel3);                                    
        }    
        ~~~~
      
      > SpinnerModel 을 이용하여 초기값, 최저, 최대, 클릭 시 증가값 설정 후 spinner에 적용
      > **(고려사항)** 모든 스피너에 같은 SpinnerNumberModel 을 적용할 경우, 모든 spinner의 값이 동시 증가할 수 있음
  
  3) 알고리즘 시행 전 GUI
  
  #### 3. Greedy + GUI
    
            private GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
            
            private void start(){
            ...
                inputButton.addActionListener(e->{
                        String money = textFieldInput.getText();
                        if (money.equals("")){
                            money = "0";
                        }
                        inputMoney = Integer.parseInt(money);
            
                        if (inputMoney != 0){
                            if ( greedyAlgorithm.getIsPay(inputMoney, costArray.get(3))){
                                
                                // greedyAlgorithm class 의 거스름돈 계산함수 호출
                                greedyAlgorithm.moneyChange();
                                setChangeArea(greedyAlgorithm.getChangeCost());
                            }else{
                                textFieldInput.setText("금액을 다시 입력해주세요");
                            }
                        }else {
                            textFieldInput.setText("금액을 입력해주세요");
                        }
            ...
            }

 
  > 금액 지불 버튼을 눌렀을 때 입력한 금액이 지불해야하는 금액보다 낮은지 계산 후,
  > if문을 통과한다면 greedyAlgorithm의 getChangeCost 함수 호출
  > 거스름돈 배열을 출력하는 setChangeArea() 함수에 ArrayList<String> 파라미터로 대입
    
   
  ~~~~
    public class GreedyAlgorithm {
        ...
    
        private ArrayList<String> changeArray = new ArrayList<>();
    
        void moneyChange() {
            
            //지폐종류값 할당 배열 ex)1000원 50000원 등등등
            int[] arr = {10, 50, 100, 500, 1000, 5000, 10000, 50000};
            int cnt; //지폐,동전 개수 카운트 변수
    
            // 입력 금액이 변동될 경우를 고려하여 함수 호출시마다 거스름돈 금액 저장할 ArrayList clear() 시킴
            changeArray.clear();
            
            //큰 화폐단위부터 봐줘야 하기 때문에 i를 n-1부터 줄어들게함
            for(int i=arr.length-1;i>=0;i--){
                cnt = 0;//한바퀴 돌고 나면 카운트 0으로 초기화 그래야 다음 화폐종류의 개수가 나온다.
                while(money-arr[i]>=0){
                    money=money-arr[i];
                    cnt++;
                }//거스름돈 구분하고 개수 카운트
                if(money-arr[i]<arr[i]){
                   if(cnt>0) {
                   
                       // 출력시 용이하게 하기 위해 ArrayList에 String 형태로 저장
                       changeArray.add(arr[i]+"원\t"+cnt+"개");
                   }
                }//거스름돈이 화폐종류보다 작아진다면 갯수 출력
            }
        }

  ~~~~
  
   앞서 언급하였던 Greedy class 를 수정하여 
   - Scanner.in
   - System.out.println 메소드 삭제
   - parameter와 ArrayList<String> 으로 입출력 값 설정
   
 
  ~~~~
    private void setChangeArea(ArrayList<String> arrayList){
          String changeOutput = "거스름 돈은\t 총 "+(inputMoney-sum)+ "원\n";
          
          // ArrayList에 있는 거스름돈 관련 String 을 하나의 문장으로 병합
          for(int i = 0 ; i<arrayList.size()-1; i++){
              changeOutput = changeOutput + arrayList.get(i) +"\n";
          }
          
          // 마지막 문장에는 \n 를 제거하며 나옵니다를 추가로 출력
          changeOutput = changeOutput + arrayList.get(arrayList.size()-1) +"가 나옵니다";
          
          // changeArea 에 Text 설정
          changeArea.setText(changeOutput);
    }
  ~~~~
  
  - 거스름돈 출력 함수를 이용하여 (JTextArea)ChangeArea 에 출력
  
  


 

