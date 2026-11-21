
import java.util.*;

class Intersection{
    public static void main(String[] args) {
        int[] arr1={1,1,2,3,4,4,4,5,6};
        int[] arr2={1,2,3,4,4,5,6,7};

        BruteIntersection b=new BruteIntersection();
        b.Intersection(arr1, arr2);

        System.out.println();
        optimalIntersection o=new optimalIntersection();
        o.Intersection(arr1, arr2);
    }
}
class BruteIntersection{
    public void Intersection(int []arr1,int[]arr2){
        ArrayList<Integer>ans=new ArrayList<>();
        int[]visited=new int[arr2.length];
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){

                if(visited[j]==1) continue ;

                if(arr1[i]==arr2[j]){
                    ans.add(arr1[i]);
                    visited[j]=1;
                    break;
                }
                if(arr2[j]>arr1[i]){
                    break;
                }
            }
        }
        for(int nums:ans){
            System.out.print(nums+" ");
        }
    }
    public void printArray(int[]arr){
        for(int num:arr){
            System.out.print(num+" ");
        }   
    }
}
// tc-O(n1+n2)
// sc-O(1)
class optimalIntersection{
    public void Intersection(int arr1[],int arr2[]){
        int i=0;
        int j=0;
        ArrayList<Integer> ans=new ArrayList<>();
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                i++;
            }
            if(arr1[i]>arr2[j]){
                j++;
            }
            else{
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        for(int num:ans){
            System.out.print(num+" ");
        }
    }
}