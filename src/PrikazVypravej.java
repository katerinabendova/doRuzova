import java.io.BufferedReader;
import java.io.FileReader;

public class PrikazVypravej {

    public static String nactiSoubor(){
        try (BufferedReader rd = new BufferedReader(new FileReader("vypraveni.txt"))){
            String radek;
            while ((radek = rd.readLine()) != null){
                return radek;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;

    }
}
