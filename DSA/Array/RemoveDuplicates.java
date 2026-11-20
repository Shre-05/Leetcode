package Array;
import java.util.HashSet;
public class RemoveDuplicates {
    public static void main(String[] args) {
        int []arr={1,1,2,2,2,3,3,3};
        Remove r=new Remove();
        int n=r.remove(arr);
        System.out.println();
        
        int[] arr2={1,1,2,2,3,3,3,4};
        OptimalRemove o=new OptimalRemove();
        int y=o.Remove(arr2);
        for(int i=0;i<y;i++){
            System.out.print(arr2[i]);
        }

        
    }
}
// Brute force approach- use Hashset to store unique elements and remove the duplicates
// tc-O(n)-Iteration+HashSet
// sc-O(n)- Hashset storage
class Remove{
    public int remove(int []arr){
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                continue;
            }
            else{
                set.add(arr[i]);
            }
            
        }
        for(int x : set){
            System.out.print(x+" ");
        }

        return set.size();
        
    }
}

// tc-O(n)- two pointers among which one is transversing an entinre n
// sc-O(1)- only two points declared no any ds needed
class OptimalRemove{
    public int Remove(int arr[]){
        int i=0;
        int j=0;
        while(j<arr.length){
            if(arr[i]==arr[j]){
                j++;
            }
            else{
                arr[i+1]=arr[j];
                i++;
                j++;
            }
        }
        return i+1;
    }
}