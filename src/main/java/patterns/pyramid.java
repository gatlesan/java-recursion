package patterns;

public class pyramid {

    public static void main(String[] args) {

        int c =9;
        int r =4;
        for(int i=0;i<5;i++) {
            for(int j=0;j<=9;j++) {
                if(r == j) {
                    int k = (i*2)+1;
                    while(k>0) {
                        System.out.print("*");
                        k--;
                    }
                    j = j+(i*2);
                    r--;
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
