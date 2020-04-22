import java.util.*;

public class Change {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);


        int change=sc.nextInt();//거스름돈
        int arr[]= {100,500,1000,5000,10000,50000};//지폐종류값 할당 배열 ex)1000원 50000원 등등등
        int name[]=new int[6];//"~~원은 ~~장이 필요합니다."-> 출력할때 ~~원 출력 담당 배열
        for(int i=0;i<6;i++){

            name[i]=arr[i];//출력할때 필요
        }

        int cnt=0; //지폐,동전 개수 카운트 변수
        for(int i=5;i>=0;i--)//큰 화폐단위부터 봐줘야 하기 때문에 i를 n-1부터 줄어들게함
        {
            cnt=0;//한바퀴 돌고 나면 카운트 0으로 초기화 그래야 다음 화폐종류의 개수가 나온다.
            while(change-arr[i]>=0)
            {
                change=change-arr[i];
                cnt++;
            }//거스름돈 구분하고 개수 카운트
            if(change-arr[i]<arr[i])
            {
                System.out.println(arr[i]+"원은"+cnt+"개가 필요합니다");
            }//거스름돈이 화폐종류보다 작아진다면 갯수 출력
        }

    }


}
