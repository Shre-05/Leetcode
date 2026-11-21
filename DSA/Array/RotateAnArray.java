public class RotateAnArray {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        RotateAnArraybyK r =new RotateAnArraybyK();
        r.RotateAnArrayby1(arr);
        r.RotateAnArraybyDBrute(arr, arr.length, 3);
        int arr2[]={1,2,3,4,5,6,7};
        r.RotateAnArraybyDOptimal(arr2, arr2.length, 3);

    }   
}
class RotateAnArraybyK{
    // rotate an array by 1
    public void RotateAnArrayby1(int []arr){
        int temp=arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=temp;

        printArray(arr);
    }
    // print an array
    public void printArray(int[]arr){
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }
    // rotate an array by k
    // time complexity-O(d)+O(n-d)+O(d)=O(n+d)
    // sc-O(d)-extra space for storing the temp
    public void RotateAnArraybyDBrute(int []arr,int n,int d){
        // create a temp
        int temp[]=new int[d];
        for(int i=0;i<d;i++){
            temp[i]=arr[i];        
        }

        // shifting
        for(int i=d;i<n;i++){
            arr[i-d]=arr[i];
        }

        // pushback
        for(int i=n-d;i<n;i++){
            arr[i]=temp[i-(n-d)];
        }

        // print an array
        printArray(arr);
    }

    // Function to reverse an array
    public void reverseArray(int arr[],int left,int right){
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

            left++;
            right--;
        }
        
    }

    // optimal way to rotate an array by d
    public void RotateAnArraybyDOptimal(int arr[],int n,int d){
        d=d%n;
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
        reverseArray(arr, 0, n-1);

        printArray(arr);
    }


}
