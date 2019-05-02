package Business;

import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class WordData implements Comparable<WordData> {

    private String word;
    private TreeSet<Integer> lines;

    public WordData() {
        word = "";
        lines = new TreeSet<>();
    }

    public WordData(String word) {
        this.word = word;
        lines = new TreeSet<>();
    }

    public WordData(WordData data) {
        word = data.word;
        lines = new TreeSet<>();
        Iterator<Integer> it = data.getLines().iterator();
        while (it.hasNext()) {
            lines.add(it.next());
        }
    }

    public String getWord() {
        return word;
    }

    public void addLine(int line) {
        lines.add(line);
    }

    public TreeSet<Integer> getLines() {
        return lines;
    }

    @Override
    public int compareTo(WordData w) {
        return this.word.compareTo(w.word);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.word);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WordData other = (WordData) obj;
        if (!Objects.equals(this.word, other.word)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String result = word + ": ";

        Iterator<Integer> it = lines.iterator();
        if (it.hasNext())
            result += it.next();

        while (it.hasNext()) {
            result += ", " + it.next();
        }

        return result;
    }
}
