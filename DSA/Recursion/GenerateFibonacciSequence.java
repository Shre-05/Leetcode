/*
2648. Generate Fibonacci Sequence
Easy
premium lock icon
Companies
Hint
Write a generator function that returns a generator object which yields the fibonacci sequence.

The fibonacci sequence is defined by the relation Xn = Xn-1 + Xn-2.

The first few numbers of the series are 0, 1, 1, 2, 3, 5, 8, 13. */

class GenerateFibonacciSequence{
    public static void main(String[] args) {
        long[] seq=fibSequence(5);
        for(int i=0;i<seq.length;i++){
            System.out.print(seq[i]+" ");
        }
    }
    public static  long[] fibSequence(int n){
        long[] ans=new long[n];
        long a=0;
        long b=1;
        long c=0;

        for(int i=0;i<n;i++){
            ans[i]=a;
            long temp=a+b;
            a=b;
            b=temp;

        }
        return ans;
    }
} 
