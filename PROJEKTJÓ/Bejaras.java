import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
package .idea;

public class Bejaras 
{
    private static void bejaras(String path, String argumentum) throws IOException
    {
        File root = new File(path);
        File[] files = root.listFiles();

        List<File> picture_files = new ArrayList<>();
        List<File> directory_files = new ArrayList<>();

        for (File file : files) // kiszűri a jpg-ket és a mappákat
        {
            if (file.isDirectory())
            {
                directory_files.add(file);
            }
            else
            {
                String kiterjesztes = file.getName().substring(file.getName().lastIndexOf('.')).toUpperCase();
                if (ImageExtensions.contains(kiterjesztes))
                {
                    picture_files.add(file);
                }
            }
        }
        
        Index_letrehoz(path, directory_files, picture_files, argumentum);
        Kep_letrehozas(path, picture_files, argumentum);

        if (!directory_files.isEmpty())
        {
            for (int index = 0; index < directory_files.size(); index++)
            {
                File directory = directory_files.get(index);
                path = directory.getPath();

                bejaras(path, argumentum);
            }
        }    
}
