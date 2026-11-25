public class Move0toEnd {
    public static void main(String[] args) {
       int []arr={1,0,2,3,2,0,0,4,5,1};
        Move0toEnd1 m=new Move0toEnd1();
        m.Move0toEndBrute(arr);

        System.out.println();
        int []arr2={1,0,2,3,2,0,0,4,5,1};
        m.Move0toEndOptimal(arr2);
     
        
    }
    
}
class Move0toEnd1 {

    // tc-O(n)+O(x)+O(n)=O(n)
    public void Move0toEndBrute(int arr[]){
        // create temp
            int temp[]=new int[arr.length];
            int j=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]!=0){
                    temp[j]=arr[i];
                    j++;
                }
            } 
        
        // add os
        for(int i=j;i<arr.length;i++){
            temp[i]=0;
        }

        // copy back to array
        for(int i=0;i<arr.length;i++){
            arr[i]=temp[i];
        }
        printArray(arr);

        
    }
    void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    // optimal approach
    public void Move0toEndOptimal(int arr[]){
        int j=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if (j==-1) return;
        for(int i=j+1;i<arr.length;i++){
            if(arr[i]!=0){
                swap(arr,i,j);
                j++;
            }
        }

        printArray(arr);
    }
}
