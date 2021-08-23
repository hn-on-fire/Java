package brailleprinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Harsh
 */
public class BrailleCellSequence extends BraillePrinter {

    final class MyEntry<K, V> implements Map.Entry<K, V> {

        private final K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }

    private ArrayList<boolean[][]> PRINT = new ArrayList<>();
    private boolean langIsSpanish;
    private final static String[] MAJOR_CONTRACTIONS = {"ed", "ff", "wh", "in", "dd", "st", "cc", "bb", "ar", "go", "be", "th", "as", "it", "ch", "sh", "en", "by", "do", "ou", "er", "ea", "to", "ow", "of", "gh", "gg", "us", "so", "con", "had", "and", "ity", "dis", "not", "the", "but", "you", "day", "him", "ble", "ful", "was", "can", "its", "one", "for", "out", "ing", "ong", "com", "his", "know", "ence", "ever", "tion", "some", "name", "ance", "must", "upon", "very", "it's", "work", "time", "like", "more", "it'd", "here", "lord", "ount", "ally", "into", "that", "less", "much", "said", "many", "ound", "this", "from", "were", "have", "so's", "such", "will", "ness", "your", "ment", "sion", "paid", "word", "just", "good", "also", "part", "with", "those", "can's", "child", "can't", "quick", "world", "first", "there", "every", "again", "under", "ation", "their", "ought", "young", "these", "great", "below", "where", "right", "it'll", "about", "today", "above", "would", "still", "quite", "shall", "whose", "you'd", "which", "could", "blind", "that'd", "beside", "before", "that's", "people", "rather", "enough", "you've", "mother", "friend", "beyond", "almost", "myself", "will's", "little", "itself", "should", "behind", "spirit", "letter", "cannot", "you're", "across", "always", "either", "you'll", "already", "oneself", "because", "o'clock", "rejoice", "thyself", "perhaps", "declare", "herself", "beneath", "deceive", "receive", "braille", "against", "neither", "through", "that'll", "himself", "between", "tonight", "children", "tomorrow", "question", "yourself", "people's", "although", "perceive", "together", "conceive", "according", "receiving", "ourselves", "necessary", "rejoicing", "character", "afternoon", "knowledge", "declaring", "immediate", "afterward", "conceiving", "yourselves", "perceiving", "themselves", "altogether"};
    private static String voldermort_with_a_nose = "";
    private static BrailleCell hariputtar;

    /*private boolean isMajorWordContraction(String str) {
        return Arrays.binarySearch(MAJOR_CONTRACTIONS, str) != -1;
    }*/
    private BrailleCellSequence(String text) {
        text = text.toLowerCase();
        langIsSpanish = text.indexOf('¿') != -1 || text.indexOf('á') != -1 || text.indexOf('é') != -1 || text.indexOf('í') != -1 || text.indexOf('ó') != -1 || text.indexOf('ú') != -1 || text.indexOf('ü') != -1 || text.indexOf('ñ') != -1;
        if (langIsSpanish) {
            for (int i = 0; i < text.length(); i++) {
                hariputtar = (new BrailleCell((Character.isDigit(text.charAt(i))) ? Integer.parseInt(String.valueOf(text.charAt(i))) : text.charAt(i)));
                voldermort_with_a_nose += (String) hariputtar.getCellSequence().get(1);
                for (boolean[][] cell : (ArrayList<boolean[][]>) hariputtar.getCellSequence().get(0)) {
                    PRINT.add(cell);

                }
            }
        } else {
            String str = text;
            HashMap<String, Boolean> temp = new HashMap<>();
            String endsWith = "";
            int count = 0;
            ArrayList<Integer> spc = new ArrayList();
            me:
            for (int i = MAJOR_CONTRACTIONS.length - 1; i >= 0; i--) {

                if (text.startsWith(MAJOR_CONTRACTIONS[i])) {

                    temp.put(MAJOR_CONTRACTIONS[i], false);

                    text = text.substring(MAJOR_CONTRACTIONS[i].length());
                }
                if (text.endsWith(MAJOR_CONTRACTIONS[i])) {
                    endsWith = MAJOR_CONTRACTIONS[i];
                    text = text.substring(0, (text.length() - MAJOR_CONTRACTIONS[i].length()));
                }
                if ((!("").equals(endsWith)) && (temp.size() == 1)) {
                    break;
                }
            }
            temp.put(text, true);
            for (int i = MAJOR_CONTRACTIONS.length - 1; i >= 0 && (!("".equals(text))) && (text != null); i--) {

                List<Map.Entry<String, Boolean>> list
                        = new LinkedList<>(temp.entrySet());

                for (Map.Entry<String, Boolean> aa : list) {
                    if (aa.getValue()) {
                        if (aa.getKey().toLowerCase().contains(MAJOR_CONTRACTIONS[i])) {

                            temp.put(text.substring(0, aa.getKey().indexOf(MAJOR_CONTRACTIONS[i])) + '\u283f' + text.substring(aa.getKey().indexOf(MAJOR_CONTRACTIONS[i]) + MAJOR_CONTRACTIONS[i].length()), true);
                            count++;
                            temp.remove(text, true);
                            text = text.substring(0, aa.getKey().indexOf(MAJOR_CONTRACTIONS[i])) + '\u283f' + text.substring(aa.getKey().indexOf(MAJOR_CONTRACTIONS[i]) + MAJOR_CONTRACTIONS[i].length());
                            temp.put(MAJOR_CONTRACTIONS[i], false);
                        }
                    }
                }
            }
            String[] vals = new String[temp.size() + count];
            List<Map.Entry<String, Boolean>> list
                    = new LinkedList<>(temp.entrySet());
            int i = 0;
            for (Map.Entry<String, Boolean> aa : list) {
                for (String string : aa.getKey().split("" + '\u283f')) {
                    vals[i] = string;
                    i++;
                }
            }

            Arrays.sort(vals, (y, x) -> Integer.compare(x.length(), y.length()));
            HashMap<String, Integer> order = new HashMap<>();
            for (String trs : vals) {
                if (" ".equals(trs)) {
                    spc.add(str.indexOf(trs));
                } else {
                    order.put(trs, str.indexOf(trs));
                }
                int dupp = trs.length();
                String rand = "";
                for (int j = 0; j < dupp; j++) {
                    rand += '\u283f';
                }
                str = str.replaceFirst(trs, rand);
            }
            List<Map.Entry<String, Integer>> Finale1
                    = new LinkedList<>(order.entrySet());
            List<Map.Entry<String, Integer>> Finale = new LinkedList();
            Finale1.forEach((jj) -> {
                Finale.add(new MyEntry<>(jj.getKey(), jj.getValue()));
            });
            spc.forEach((index) -> {
                Finale.add(new MyEntry<>(" ", index));
            });
            // Sort the list 
            Collections.sort(Finale, (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> (o1.getValue()).compareTo(o2.getValue()));
            // put data from sorted list to hashmap  
            ArrayList<String> DONE = new ArrayList<>();
            Finale.forEach((aa) -> {
                DONE.add(aa.getKey());
            });
            DONE.add(endsWith);
            DONE.forEach((String DONE1) -> {

                // System.out.println(DONE1);
                //String DONE2 = DONE1;
                //DONE1 = DONE1.trim();
                // System.out.println(DONE1 + "  " + Arrays.deepToString(MAJOR_CONTRACTIONS));
                //System.out.println(Arrays.deepToString(MAJOR_CONTRACTIONS).contains("[" + DONE1 ) || Arrays.deepToString(MAJOR_CONTRACTIONS).contains(", " + DONE1 + ", ") || Arrays.deepToString(MAJOR_CONTRACTIONS).contains(", " + DONE1 + "]"));
                if ((Arrays.deepToString(MAJOR_CONTRACTIONS).contains(DONE1) || Arrays.deepToString(MAJOR_CONTRACTIONS).contains(DONE1) || Arrays.deepToString(MAJOR_CONTRACTIONS).contains(DONE1)) && (!(" ".equals(DONE1)))) {

                    hariputtar = (BrailleCell) (new BrailleCell(DONE1));
                    voldermort_with_a_nose += (String) hariputtar.getCellSequence().get(1);

                    for (boolean[][] cell : (ArrayList<boolean[][]>) hariputtar.getCellSequence().get(0)) {
                        PRINT.add(cell);
                    }

                } else {
                    for (int p = 0; p < DONE1.length(); p++) {
                        hariputtar = (BrailleCell) ((Character.isDigit(DONE1.charAt(p))) ? (new BrailleCell(Integer.parseInt(String.valueOf(DONE1.charAt(p))))) : (new BrailleCell(DONE1.charAt(p))));
                        voldermort_with_a_nose += (String) hariputtar.getCellSequence().get(1);

                        for (boolean[][] cell : (ArrayList<boolean[][]>) hariputtar.getCellSequence().get(0)) {
                            PRINT.add(cell);
                        }
                    }

                }

            });
        }
    }

    public static ArrayList<Object> getBrailleCellSequence(String txt) {
        ArrayList<Object> ret = new ArrayList();
        ArrayList<boolean[][]> bhej = new BrailleCellSequence(txt).PRINT;
        ret.add(bhej);
        ret.add(voldermort_with_a_nose);
        return ret;
    }

}
