## 2020 1학기 컴퓨터알고리즘 조별과제1

#### Java Swing 이용하여 자판기 구현

- ### 프로그램 구현

   각 제품들에 대한 값들을 할당하고 **Greedy Algorithm**(탐욕 알고리즘) 이용하여 지불 금액에 대한 거스름돈 알고리즘 구현한 뒤, 지폐 분류를 거친 결과를 출력한다

- **GUI 형태는 피시방 음식 주문 서비스 참고**



- ### 코드 구현

  

  1. **Greedy Algorithm** 

     ```java
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
     ```



위 코드는 탐욕 알고리즘을 이용해  받은 거스름돈을 지폐와 동전으로 변환해주는 코드를 구현하였는데, 만일 arr배열의 값들을 할당할 때  오름차순으로 배열하지 않는다면 sort함수를 사용하여 오름차순으로 배열한뒤, 사용해야 한다.



**여기서부터는 고운누나가 마무뤼해주세여어어옹ㅇ(별로 한건 없지만)**

 

