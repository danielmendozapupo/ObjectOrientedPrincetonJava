public class Reverse{

    public static String reverse(String s){
       String temp = new String("");
       int n = s.length();
        for(int i = s.length()-1; i >=0 ; i--)
           temp = temp + s.charAt(i);
       return temp;
    }

    public static void main(String[] args){
        String s = new String("Hello");
        String temp = reverse(s);

        StdOut.println(temp);
    }
}