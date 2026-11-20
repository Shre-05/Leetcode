package Array;
import java.util.*;
import java.util.stream.Gatherer.Integrator;
public class LargestElement {
    public static void main(String[] args) {
        int[] arr={3,2,1,5,2};
        Sort s=new Sort();
        s.Divide(arr, 0, arr.length-1);
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println();

        // larget element
        // Brute force approach:
            // Here sorting will take O(nlogn) and accessing last element will take O(1)
            // Space comp- O(n)
        System.out.println("largest element: "+arr[arr.length-1]);


        // Optimal Approach
        int[] arr2={3,2,1,7,2};
        OptimalSolution o=new OptimalSolution();
        o.findLargetElement(arr2);
    }
}
class Sort{
    public void Divide(int []arr,int low,int high){
        if(low>=high){
            return;
        }
        
            int mid=(low+high)/2;
            Divide(arr,low,mid);
            Divide(arr,mid+1,high);
            Merge(arr,low,mid,high);
        
    }
    public void Merge(int arr[],int low,int mid,int high){
        ArrayList<Integer>temp=new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=0; i<temp.size(); i++){
            arr[low+i] = temp.get(i);
        }

    }
}

// Tc-O(n)-no any sorting required
// sc-O(1)
class OptimalSolution{
    public void findLargetElement(int []arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("Largest element found using Optimal solution is: "+max);
    }
}