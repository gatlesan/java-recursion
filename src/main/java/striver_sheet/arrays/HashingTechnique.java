package striver_sheet.arrays;

public class HashingTechnique {

    public static void main(String[] args) {


        //Problem Statement: Given an array you are asked multiple times to find an element each time TC O(n)
        //Hashing --> pre storing and fetching
        //Number hashing --> using frequency array
        //character hashing --> using a array of size 26 //assumption is string has all lower chars without symbols
        //*** formula for index a(97) z(122) 'char'-a will give index to store, do not need to remember a-97 ...
        //*** use hashmap
        //*** Hashing methods --> Division method a[i]%10 always gives res from 0 to 9
        //*** fetching t%10 --> index and count of occurrence
        //** chaining(LinkedList) --> collision

        //For capitals and smalls take an array of len 255
        //System.out.println(Character.codePointAt("A",0));
        //System.out.println(Character.codePointAt("Z",0));

        char c = 'a';
        System.out.println("index for b "+('b'-c));
        System.out.println("index for f "+('f'-c));
        System.out.println("index for z "+('z'-c));

        char C = 'A';
        System.out.println("index for B "+('B'-C));
        System.out.println("index for F "+('F'-C));


    }
}
