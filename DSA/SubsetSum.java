import java.util.*;
public class SubsetSum {
    public static void main(String[] args) {
        int []arr={3,1,2};
        ArrayList<Integer> Result=subsetSum(arr,0,new ArrayList<>(),0);
        Collections.sort(Result);
        System.out.println(Result);
    }
    public static ArrayList<Integer> subsetSum(int arr[],int i,ArrayList<Integer>Curr,int sum){
        // base case
        if(i==arr.length){
            Curr.add(sum);
            return Curr;
        }

        // pick
        subsetSum(arr, i+1, Curr, sum+arr[i]);
        // no pick
        subsetSum(arr, i+1, Curr, sum);

        
        return Curr;
        
    }  
     
}
