import hra.Konzole;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            Konzole k = new Konzole();
            k.spustit();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}