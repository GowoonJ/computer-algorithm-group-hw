import java.util.*;

public class GreedyAlgorithm {
    private int item1;
    private int item2;
    private int item3;
    private int money; // useful money input value


    private boolean isPay = false;


    public void setData(int itemSandwich, int itemBurger, int itemTaco){
        this.item1 = itemSandwich;
        this.item2 = itemBurger;
        this.item3 = itemTaco;
    }

    public void moneyChange() {
        Scanner sc = new Scanner(System.in);
        int sandwich = 7000;
        int burgerSet = 15000;
        int taco = 12000;
        int price1,price2,price3;

        price1 = sandwich*item1;
        price2 = burgerSet*item2;
        price3 = taco*item3;
        /* 샌드위치 , 버거세트 ,타코 구입 총 가격 */
        int sum = price1+price2+price3;
        int money;
        money=sc.nextInt(); //가지고 있는돈

        while(true) {
            if(money<sum) {
                System.out.println("금액 부족!");
                money = sc.nextInt(); //금액 부족하면 다시 입력받기
            }
            else{
                money = money-sum;//거스름돈 넣어줌
                break;
            }
        }


        if(money==0) System.out.println("거스름돈이 없습니다!");

        int arr[]= {100,500,1000,5000,10000,50000};//지폐종류값 할당 배열 ex)1000원 50000원 등등등

        int cnt=0; //지폐,동전 개수 카운트 변수
        for(int i=arr.length-1;i>=0;i--){//큰 화폐단위부터 봐줘야 하기 때문에 i를 n-1부터 줄어들게함
            cnt=0;//한바퀴 돌고 나면 카운트 0으로 초기화 그래야 다음 화폐종류의 개수가 나온다.
            while(money-arr[i]>=0){
                money=money-arr[i];
                cnt++;
            }//거스름돈 구분하고 개수 카운트
            if(money-arr[i]<arr[i]) {
               if(cnt>0) System.out.println(arr[i]+"원은"+cnt+"개가 필요합니다");

            }//거스름돈이 화폐종류보다 작아진다면 갯수 출력
        }
    }

    public Boolean getIsPay(){
        return isPay;
    }
}