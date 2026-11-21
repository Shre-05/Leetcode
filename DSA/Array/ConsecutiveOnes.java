public class ConsecutiveOnes {
    public static void main(String[] args) {
        ConsecutiveOnesSolution c=new ConsecutiveOnesSolution();
        int[]arr={1,1,2,3,3,4,4};
        c.brute(arr);
    }
}
class ConsecutiveOnesSolution{
    public void brute(int []arr){
        
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            int count=0;

            for(int j=0;j<arr.length;j++){
                if(arr[j]==num){
                    count++;
                }
            }
            if(count==1){
                System.out.println(num);
                break;
            }
        }
    }
}
