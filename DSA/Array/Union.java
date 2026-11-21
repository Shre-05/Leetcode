import java.util.*;

public class Union {
    public static void main(String[] args) {
        int[] arr1={1,1,2,3,5,5,6};
        int[] arr2={1,2,3,4,5,6};

        unionBrute u=new unionBrute();
        u.union(arr1, arr2);

        System.out.println();

        optimalUnion o=new optimalUnion();
        o.union(arr1, arr2);
    }
}
class unionBrute{
    public void union(int []arr1,int []arr2){
        HashSet<Integer>set=new HashSet<>();
        for(int num:arr1){
            if(set.contains(num)){
                continue;
            }
            else{
                set.add(num);
            }
        }
        for(int num:arr2){
            if(set.contains(num)){
                continue;
            }
            else{
                set.add(num);
            }
        }

        for(int num:set){
            System.out.print(num+" ");
        }

    }
}
class optimalUnion{
    public void union(int[]arr1,int arr2[]){
        int i=0;
        int j=0;

        ArrayList<Integer>ans=new ArrayList<>();

        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                if(ans.isEmpty()|| ans.get(ans.size()-1)!=arr1[i]){
                    ans.add(arr1[i]);
                }
            }
            i++;
        }
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]>arr2[j]){
                if(ans.isEmpty()|| ans.get(ans.size()-1)!=arr2[j]){
                    ans.add(arr2[j]);
                }
            }
            j++;
        }
        while(i<arr1.length){
            if(arr1[i]<arr2[j]){
                if(ans.isEmpty()|| ans.get(ans.size()-1)!=arr1[i]){
                    ans.add(arr1[i]);
                }
            }
            i++;
        }
        while(j<arr2.length){
            if(arr1[i]>arr2[j]){
                if(ans.isEmpty()|| ans.get(ans.size()-1)!=arr2[j]){
                    ans.add(arr2[j]);
                }
            }
            j++;
        }

        for(int num:ans){
            System.out.print(num+" ");
        }


    }
}
