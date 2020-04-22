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
        while(money<sum) {
            System.out.println("금액 부족!");
            money=sc.nextInt(); //금액 부족하면 다시 입력받기
            if(money>sum){
                money=money-sum;//거스름돈 넣어줌
                break;
            }
        }



        int arr[]= {100,500,1000,5000,10000,50000};//지폐종류값 할당 배열 ex)1000원 50000원 등등등
        int name[]=new int[6];//"~~원은 ~~장이 필요합니다."-> 출력할때 ~~원 출력 담당 배열
        for(int i=0;i<6;i++){

            name[i]=arr[i];//출력할때 필요
        }

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
                System.out.println(arr[i]+"원은"+cnt+"장이 필요합니다");
            }//거스름돈이 화폐종류보다 작아진다면 갯수 출력
        }

    }
}