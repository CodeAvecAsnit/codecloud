package com.asn.practise.security;

public class BitOperations {
    public static void PrintBits(int bits){
        for(int i = 31;i>=0;--i){
            int x =(bits>>i)&1;
            System.out.print(x);
        }

    }

    public static boolean checkEven(int num){
        return (num&1)==1;
    }

    public static int MultiplyAvecDeuxPowerN(int num,int n){
        return num<<n;
    }

    public static int DivideAvecDeuxPowerN(int num,int n){
        return num>>n;
    }


    public static void main(String[] args) {
        int num = 32;
        PrintBits(num);
        System.out.println();
        if(checkEven(num)){
            System.out.println("De numero sont odd");
        }else System.out.println("De numero sont even");
        System.out.println(MultiplyAvecDeuxPowerN(num,3));
        System.out.println(DivideAvecDeuxPowerN(num,5));
        System.out.println(CheckNums(num,num));
        System.out.println(CheckNums(num,MultiplyAvecDeuxPowerN(num,1)));
        int x = 9;
        PrintBits(x);
        System.out.println();
        PrintBits(ReverseBits(x));
        int [] arr = countBits(2);
        for(int k : arr){
            System.out.println(k);
        }
    }

    public static boolean CheckNums(int a,int b){
        return (a^b)==0;
    }

    public static int ReverseBits(int num){
        int rev =0;
        for(int i = 0;i<32;++i){
            int x = num & 1;
            rev = (rev <<1)|x;
            num>>=1;
        }
        return rev;
    }


        public static int[] countBits(int num) {
            int[] arr = new int[num+1];
            for(int j = 0;j<=num;++j){
                arr[j]=countOnes(j);
            }
            return arr;
    }

    public static int countOnes(int n){
        int count = 0;
        for(int i = 0;i<32;++i){
            if((n&1)==1){
                ++count;
            }
            n>>=1;
        }
        return count;
    }

    public int singleNumber(int[] nums) {
        int rev = 0;
        for(int x : nums){
            rev ^=x;
        }
        return rev;
    }


    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        long arraySum = 0;
        long arraySquareSum = 0;
        for (int num : nums) {
            arraySum += num;
            arraySquareSum += (long) num * num;
        }
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2 * n + 1) / 6;
        long xMinusY = arraySum - expectedSum;
        long xPlusY = (arraySquareSum - expectedSquareSum) / xMinusY;
        int x = (int) ((xMinusY + xPlusY) / 2);
        int y = (int) (x - xMinusY);
        return new int[]{x, y};
    }
}
