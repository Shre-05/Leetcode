package Array;
import java.util.*;
public class Basic {

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        // create an array
        int[]arr=new int[4];
        
        int x=101;
        for(int i=0;i<arr.length;i++){
            arr[i]=x;
            x++;
        }

        // print an array
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        /* 
        // take inupu from user
        int size=sc.nextInt();
        int arr2[]=new int[size];

        for(int i=0;i<arr2.length;i++){
            arr2[i]=sc.nextInt();
        }

        for(int y:arr2){
            System.out.print(y+" ");
        }
        */

        // print a predefined array
        int[] arr3={1,2,3,4,5};
        for(int z:arr3){
            System.out.print(z+" ");
        }
        System.out.println();

        // 2D array
        int[][] arr4=new int[3][3];
        int y=1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr4[i][j]=y;
                y++;
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(arr4[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        // 3D array
        int[][][]arr5=new int[3][3][3];
        int z=1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    arr5[i][j][k]=z;
                    z++;
                }
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    System.out.print(arr5[i][j][k]+" ");
                }System.out.println();
            }
        }
        System.out.println();


    }
}
