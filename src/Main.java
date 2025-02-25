import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        MapaMistnosti mapa = new MapaMistnosti("mapa.txt");
        new Hra(mapa).spustit();
    }
}