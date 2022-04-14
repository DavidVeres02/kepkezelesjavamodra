public class StartPage 
{
    private static String startPage_path(String path, String argumentum)
    {
        int argumentumPerJelekSzama = 0;
        int pathPerJelekSzama = 0;

        char[] argumentumCharArray = argumentum.toCharArray();
        for (char c : argumentumCharArray)
        {
            if (c == '\\')
            {
                argumentumPerJelekSzama++;
            }
        }

        char[] pathCharArray = path.toCharArray();
        for (char c : pathCharArray)
        {
            if (c == '\\')
            {
                pathPerJelekSzama++;
            }
        }

        int szulomappa = pathPerJelekSzama - argumentumPerJelekSzama;
        String gyoker_utvonal = "index.html";

        for (int hanyadik_mappa = 0; hanyadik_mappa < szulomappa; hanyadik_mappa++)
        {
            gyoker_utvonal = "../" + gyoker_utvonal;
        }

        return gyoker_utvonal;
    }   
}
