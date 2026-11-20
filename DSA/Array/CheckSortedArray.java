package Array;

public class CheckSortedArray {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,1,6};
        int arr2[]={6,5,4,3,2,1};
        CheckSortedArray1 cs=new CheckSortedArray1();
        cs.checkAscending(arr);
        cs.checkDescending(arr2);

    }
}
class CheckSortedArray1{
    public void checkAscending(int arr[]){
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=arr[i-1]){
                continue;
            }
            else{
                System.out.println("Not Sorted");
                return;
            }
        }
        System.out.println("Sorted in asc");
        
    }
    public void checkDescending(int arr[]){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<=arr[i-1]){
                continue;
            }
            else{
                System.out.println("Not Sorted");
                return;
            }
        }
        System.out.println("Sorted in desc");
        
    }
}
