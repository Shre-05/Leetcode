package Array;

public class SecondLargetElement {
    public static void main(String[] args) {

        // Brute force approach
            // -Sort an array
            // -find n-1 element
            // tc-O(nLogN+ n)
            // sc-O(n)
        Sort s=new Sort();
        int []arr={3,2,7,8,7,5,8};
        s.Divide(arr,0,arr.length-1);
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println();

        // n-1 as max
        int max=arr[arr.length-1];
        int Slargest=max;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]!=max){
                Slargest=arr[i];
                break;
            }

        }
        System.out.println("Second Larget element using brute force is: "+Slargest);


        // Second optimal solution
        int[] arr2={3,2,7,8,7,5,8};
        SecondOptimal so=new SecondOptimal();
        so.findSecondLargetElement(arr2);

        // optimal solution
        Optimal o=new Optimal();
        o.findSecondLargetElement(arr2);
        o.findSecondSmallestElement(arr2);

    }
}
// Time complexity-O(n)+O(n)=O(2n)
// space complexity-O(1)
class SecondOptimal{
    public void findSecondLargetElement(int []arr){
        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int SLarget=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<max && arr[i]>SLarget){
                SLarget=arr[i];
            }
        }

        System.out.println("Second largest element using Second Optimal solution is: "+SLarget);
    }
}

// Tc=O(n)
// Sc-O(1);
class Optimal{
    public void findSecondLargetElement(int arr[]){
        int Largest=arr[0];
        int SLargest=-1;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>Largest){
                SLargest=Largest;
                Largest=arr[i];
            }
            else if(arr[i]<Largest && arr[i]>SLargest){
                SLargest=arr[i];
            }
        }
        System.out.println("Second largest element using Optimal solution is:" +SLargest);
    }

    public void findSecondSmallestElement(int arr[]){
        int smallest=arr[0];
        int secsmallest=Integer.MAX_VALUE;

        for(int i=1;i<arr.length;i++){
            if(arr[i]<smallest){
                secsmallest=smallest;
                smallest=arr[i];
            }
            else if(arr[i]>smallest && arr[i]<secsmallest){
                secsmallest=arr[i];
            }
        }
        System.out.println("Second Smallest element using Optimal solution is: "+secsmallest);
    }
}
