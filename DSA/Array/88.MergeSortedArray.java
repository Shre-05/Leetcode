/*
88. Merge Sorted Array
Easy
Topics
premium lock icon
Companies
Hint
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 */

import java.util.*;

class MergeSortedArray{
    public static void main(String[] args) {
        int arr1[]={1,2,3,6,9};
        int []arr2={2,5,6};
        MergeSortedArraySolution m=new MergeSortedArraySolution();
        m.usingExtraSpace(arr1, arr2, arr1.length, arr2.length);

        System.out.println("Solution using optmal 1:");
        m.usingOptimalSolution1(arr1, arr2, arr1.length, arr2.length);

        System.out.println("Using optimal2 solution\n");
        m.usingOptimalSolution2(arr1, arr2, arr1.length, arr2.length);

    }
}
class MergeSortedArraySolution{
    public void usingExtraSpace(int[]arr1,int []arr2,int n,int m){
        int x=n+m;
        int[] res=new int[n+m];

        int left=0;
        int right=0;
        int index=0;

        while(left<n && right<m){
            if(arr1[left]<arr2[right]){
                res[index]=arr1[left];
                index++;
                left++;
            }
            else{
                res[index]=arr2[right];
                right++;
                index++;
            }
        }

        while(left<n){
            res[index++]=arr1[left++];
        }
        while(right<m){
            res[index++]=arr2[right++];
        }

        for(int i=0;i<n+m;i++){
            if(i<n){
                arr1[i]=res[i];
            }
            else
                arr2[i-n]=res[i];
        }

        for(int num:res){
            System.out.print(num+" ");
        }
    }

    public void usingOptimalSolution1(int[]arr1,int []arr2,int n,int m){
        int left=n-1;
        int right=0;

        while(left>=0 && right<m){
            if(arr2[right]<arr1[left]){
                swap(arr1,arr2,right,left);

                left--;
                right++;
            }
            else{
                break;
            }
        }

        sort(arr1,0,arr1.length-1);
        sort(arr2,0,arr2.length-1);

        System.out.println("Array 1:");
        System.out.println(Arrays.toString(arr1));

        System.out.println("Array 2:");
        System.out.println(Arrays.toString(arr2));
    }

    private void swap(int []arr1,int[] arr2,int right,int left){
        int temp=arr1[left];
        arr1[left]=arr2[right];
        arr2[right]=temp;

    }

    private void sort(int arr[],int low,int high){
        if(low>=high){
            return;
        }
        int mid=low+(high-low)/2;

        sort(arr,low,mid);
        sort(arr,mid+1,high);

        mergeSort(arr,low,mid,high);
    }
    private void mergeSort(int[]arr,int low,int mid,int high){
        int left=low;
        int right=mid+1;
        ArrayList<Integer>temp=new ArrayList<>();
        
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
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

        for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }

    
    }

    public void usingOptimalSolution2(int []arr1,int arr2[],int n,int m){
        int len=n+m;
        int gap=(len/2)+(len%2);
        
        while(gap>0){
            int left=0;
            int right=left+gap;

            while(right<len){
                // left-arr2,right-arr2
                if(left<n && right>=n){
                    swapIfGreater(arr1,arr2,left,right-n);
                }
                // left-arr2,right-ar2
                else if(left>=n){
                    swapIfGreater(arr2,arr2,left-n,right-n);
                }
                else{
                    swapIfGreater(arr1,arr1,left,right);
                }
                
                left++;
                right++;
            }
            if(gap==1){
                break;
            }
            gap=(gap/2)+(gap%2);
        }
        for(int num:arr1){
        System.out.print(num+" ");
    }
    for(int num:arr2){
        System.out.print(num+" ");
    }
    }
    private void swapIfGreater(int[]arr1,int[]arr2,int i,int j){
        if(arr1[i]>arr2[j]){
            int temp=arr1[i];
            arr1[i]=arr2[j];
            arr2[j]=temp;
        }
    }

    

}
