import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class Index_letrehoz 
{
    private static void index_letrehozas(String path, List<File> directory_files, List<File> picture_files, String argumentum) throws IOException
    {
        File index_file = new File(path + "/index.html");
        BufferedWriter indexwriter = new BufferedWriter(new FileWriter(index_file));

        String gyoker_utvonal = startPage_path(path, argumentum);
        indexwriter.write("<h2><a href=\"" + gyoker_utvonal + "\">" + "Start Page</h2></a>\n");
        indexwriter.write("<hr>\n");

        indexwriter.write("<h2>Directories:</h2>\n");
        indexwriter.write("<ul>\n");

        if (!path.equals(argumentum))
        {
            indexwriter.write("<li><a href=\"../index.html\"</a><<</li>\n"); // előző mappa hivatkozása, ha van
        }

        for (File directory : directory_files) //felsorolja a mappákat és hivatkozik rájuk
        {
            indexwriter.write("<li><a href=\"" + directory.getName() + "/index.html\">" + directory.getName() + "</a></li>\n");
        }

        indexwriter.write("</ul>\n");
        indexwriter.write("<hr>\n");

        indexwriter.write("<h2>Images:</h2>\n");
        indexwriter.write("<ul>\n");
        for (File picture : picture_files) //felsorolja a képeket és hivatkozik rájuk
        {
            String picture_name = picture.getName().substring(0, picture.getName().lastIndexOf('.')); //jpg nélkül
            indexwriter.write("<li><a href=\"" + picture_name + ".html" + "\">" + picture.getName() + "</a></li>\n");
        }
        indexwriter.write("</ul>\n");
        indexwriter.close();
    }    
}
