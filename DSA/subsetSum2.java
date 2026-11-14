import java.util.*;
public class subsetSum2 {
    public static void main(String[] args) {
        List<List<Integer>> ans=new ArrayList<>();
        int arr[]={1,2,2,2,3,3};
        Arrays.sort(arr);
        subSum(arr,0,new ArrayList(),ans);
        System.out.println(ans);
    }
    public static void subSum(int []arr,int index,ArrayList<Integer>Curr,List<List<Integer>>ans){
        ans.add(new ArrayList<>(Curr));
        for(int i=index;i<arr.length;i++){
            if(i!=index && arr[i]==arr[i-1]) continue;
            Curr.add(arr[i]);
            subSum(arr, i+1, Curr, ans);
            Curr.remove(Curr.size()-1);

        }
    }
}
