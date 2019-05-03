package Driver;

import Business.WordData;
import Tree.AVLTree;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Driver {

    public static void main(String[] args) {
        File file = new File("GulliversTravelsExcerpt.txt");

        try {
            AVLTree tree = ReadFile(file);
            Iterator<WordData> it = tree.getInorderIterator();
            while (it.hasNext()) {
                WordData wd = it.next();
                StringBuilder string = new StringBuilder(wd.getWord());
                TreeSet<Integer> lines = wd.getLines();
                Iterator<Integer> itr = lines.iterator();
                while (itr.hasNext()) {
                    string.append(" " + itr.next().toString());
                } // inner
                System.out.println(string);
            } // outer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static AVLTree ReadFile(File file) throws IOException {
        AVLTree<WordData> tree = new AVLTree<>();
        Scanner scan = new Scanner(file);
        BufferedReader br = new BufferedReader(new FileReader(file));

        List l = readFileInList(file.getName());
        Iterator<String> itr = l.iterator();
        int index = 1;
        while (itr.hasNext()) {
            String[] strings = itr.next().replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
            for (String string : strings) {
                WordData word = new WordData(string.trim());

                if (tree.isEmpty())
                    tree.add(word);
                else if (tree.contains(word)) {
                    WordData append = tree.getEntry(word);
                    //tree.remove(word);
                    if (!append.getLines().contains(index))
                        tree.getEntry(word).addLine(index);
                }
                else
                    tree.add(word);
            }
            index++;
        } // end of outer while
        return tree;
    }



        //System.out.println(scan.next());

/*        while (true) {
            //System.out.println(st);
            String st = br.readLine();
            System.out.println(st);
        }*/


    private static List<String> readFileInList(String fileName)
    {

        List<String> lines = Collections.emptyList();
        try
        {
            lines =
                    Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }

        catch (IOException e)
        {

            // do something
            e.printStackTrace();
        }
        return lines;
    }
}
