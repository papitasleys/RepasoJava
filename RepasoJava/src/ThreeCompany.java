import java.util.*;

public class ThreeCompany {
    public static void main(String[] args) {
        System.out.println("hey yo, una cadena pls: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        System.out.println(three(input));
    }

    private static String three(String input) {
        System.out.println("la cadena original es: " + input);
        String output = "";

        int longitud = input.length();

        for (int i =0; i < longitud; i++){
            char letra = input.charAt(i);
            output += new String(new char[3]).replace('\0', letra);
        }
        return output;
    }
}
