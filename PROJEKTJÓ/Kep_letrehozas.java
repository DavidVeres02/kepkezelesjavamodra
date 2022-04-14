import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class Kep_letrehozas 
{
    private static void kep_letrehozas(String path, List<File> picture_files, String argumentum) throws IOException
    {
        for (int i = 0; i < picture_files.size(); i++)
        {
            File picture = picture_files.get(i);
            String picture_name = picture.getName().substring(0, picture.getName().lastIndexOf('.')); //jpg nélkül
            File html_file = new File(path + "\\" + picture_name + ".html");
            BufferedWriter picturewriter = new BufferedWriter(new FileWriter(html_file));

            String gyoker_utvonal = startPage_path(path, argumentum);
            picturewriter.write("<h2><a href=\"" + gyoker_utvonal + "\">" + "Start Page</h2></a>\n");

            picturewriter.write("<hr>\n");
            picturewriter.write("<a href=\"index.html\">Vissza</a>\n");
            picturewriter.write("<br><br>\n");

            String elozo_html = "";
            String kovetkezo_html = "";

            if (i - 1 < 0) //ha az első képpel dolgozik
            {
                elozo_html = picture_name + ".html";
                kovetkezo_html = picture_files.get(i + 1).getName().substring(0, picture_files.get(i + 1).getName().lastIndexOf('.')) + ".html";
            }
            else if (i + 1 >= picture_files.size()) //ha az utolsó képpel dolgozik
            {
                elozo_html = picture_files.get(i - 1).getName().substring(0, picture_files.get(i - 1).getName().lastIndexOf('.')) + ".html";
                kovetkezo_html = picture_name + ".html";
            }
            else { //ha bármelyik másikkal
                elozo_html = picture_files.get(i - 1).getName().substring(0, picture_files.get(i - 1).getName().lastIndexOf('.')) + ".html";
                kovetkezo_html = picture_files.get(i + 1).getName().substring(0, picture_files.get(i + 1).getName().lastIndexOf('.')) + ".html";
            }

            picturewriter.write("<a href=\"" + elozo_html + "\"> << </a>  " + picture.getName() + "  <a href=\"" + kovetkezo_html + "\"> >> </a>\n");
            picturewriter.write("<br><rb>\n");
            picturewriter.write("<a href=\"" + kovetkezo_html + "\"><img src=\"" + picture.getName() + "\"" + "height=\"30%\" width=\"30%\"></a>\n");
            picturewriter.write("<br><br>\n");

            picturewriter.close();
        }
    }
}
