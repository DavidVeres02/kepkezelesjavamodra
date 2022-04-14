import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
package .idea;

public class Main
{
    /* Amit javítottunk:
    -ImageExtensions (más kiterjesztések is jók)
    -újra futtatásnál felülírja a meglévő fájlokat
    -a startpage hivatkozás mostmár zárójelek alapján működik
    -mindensorban kell \n, hogy ha forráskódot megnézzük ne egy sor legyen
    -argumentum át van adva
    -lett hiba javítva a képlétrehozás utolsó előtti fájlírásába: hiányzott egy > karakter
    -CLASSOKRA SZÉT KELL SZEDNI
    -CSAK ANGOL VAGY CSAK MAGYAR KIFEJEZÉSEK
    -EZT A KOMMENTET EL KELL TÁVOLÍTANI
     */

    static List<String> ImageExtensions = List.of(".JPG", ".JPEG", ".GIF", ".PNG");

    public static void main(String[] args) throws IOException
    {
        if (args.length != 1)
        {
            System.out.println("Error: provide the path of a directory");
            System.exit(1);
        }
        else if (!new File(args[0]).isDirectory())
        {
            System.out.println("Error: provide the path of a directory");
            System.exit(1);
        }
        else
        {
            final String path =;
            String argumentum = args[0];

            bejaras(path, argumentum);

            System.out.println("Program vége");
        }
    }
}