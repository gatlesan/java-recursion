package striver_sheet.arrays;

public class XPowerN {



    //*** Ask if n is -ve or only +ve, n * -1 to make it positive
    //if -ve ans = 1/ans after converting it to positive
    //*** O(n) where 2^10 can be found running loop from 0...n-1
    //*** optimal if dividing the root by half O(log(n))
    // 2^10 --> 2*2^ n=n/2
    // 2^3 ---> 2*2^ n=n-1


    public static void main(String[] args) {
        int x = 2;
        int n = -2;
        //**Double you never know the size required based on n
        double a = 1;
        //**In case of negative take n as long to avoid overflow
        long nn = n;
        if(n<0)
            nn = -1*n;

        while(nn>1) {

            if(nn%2 == 0) {
                a =a * x * x;
                nn = nn/2;
            } else {
                a =a * x * x;
                nn = nn-1;
            }

        }

        if(n<0) {
            a = 1.0/a;
        }
        System.out.println(a);


    }


}
