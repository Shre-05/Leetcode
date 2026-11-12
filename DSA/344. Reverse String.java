class n{
    public static void main(String[]args){
    int nums[] = {2,7,11,15};
    int target=9;
    int arr[]=new int[2];

    for(int i=0;i<nums.length;i++){
        for(int j=0;j<nums.length;j++){
            if(nums[i]+nums[j]==target){
                arr[0]=i;
                arr[1]=j;
            }
        }
    }
    for(int k=0;k<arr.length;k++){
        System.out.println(arr[k]);
    }}

}



