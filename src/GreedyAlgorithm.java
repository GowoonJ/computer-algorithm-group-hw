import java.util.ArrayList;

public class GreedyAlgorithm {
    private int money; // useful money input value

    private ArrayList<String> changeArray = new ArrayList<>();

    void moneyChange() {
        int[] arr = {10, 50, 100, 500, 1000, 5000, 10000, 50000};//지폐종류값 할당 배열 ex)1000원 50000원 등등등

        int cnt; //지폐,동전 개수 카운트 변수

        changeArray.clear();
        for(int i=arr.length-1;i>=0;i--){//큰 화폐단위부터 봐줘야 하기 때문에 i를 n-1부터 줄어들게함
            cnt=0;//한바퀴 돌고 나면 카운트 0으로 초기화 그래야 다음 화폐종류의 개수가 나온다.
            while(money-arr[i]>=0){
                money=money-arr[i];
                cnt++;
            }//거스름돈 구분하고 개수 카운트
            if(money-arr[i]<arr[i]) {
               if(cnt>0) {
                   changeArray.add(arr[i]+"원\t"+cnt+"개");
               }

            }//거스름돈이 화폐종류보다 작아진다면 갯수 출력
        }
    }
    Boolean getIsPay(int money, int sum){
        boolean isPay = false;
        if(money>sum) {
            isPay = true;
            this.money = money-sum;
        }
        return isPay;
    }

    ArrayList<String> getChangeCost(){
        return changeArray;
    }
}