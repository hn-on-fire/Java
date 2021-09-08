
import java.util.ArrayList;

/**
 *
 * @author Harsh
 */
public class BrailleCell //extends BrailleCellSequence {
{

    /**
     *
     * @param cell1 Boolean 2-dimensional Array
     * @return uni-code char of the cell
     */
    private char getUni(boolean cell1[][]) {
        if (cell1[0][0] && cell1[1][0] && cell1[2][0] && cell1[0][1] && cell1[1][1] && cell1[2][1]) {
            return '\u283f';
        } else if (cell1[0][0] && cell1[1][0] && cell1[2][0] && cell1[0][1] && cell1[1][1]) {
            return '\u281f';
        } else if (cell1[0][0] && cell1[1][0] && cell1[2][0] && cell1[0][1] && cell1[2][1]) {
            return '\u282f';
        } else if (cell1[0][0] && cell1[1][0] && cell1[2][0] && cell1[1][1] && cell1[2][1]) {
            return '\u2837';
        } else if (cell1[0][0] && cell1[1][0] && cell1[0][1] && cell1[1][1] && cell1[2][1]) {
            return '\u283b';
        } else if (cell1[0][0] && cell1[2][0] && cell1[0][1] && cell1[1][1] && cell1[2][1]) {
            return '\u283d';
        } else if (cell1[1][0] && cell1[2][0] && cell1[0][1] && cell1[1][1] && cell1[2][1]) {
            return '\u283e';
        } else if (cell1[0][0] && cell1[1][0] && cell1[2][0] && cell1[0][1]) {
            return '\u280f';
        } else if (cell1[0][0] && cell1[1][0] && cell1[2][0] && cell1[1][1]) {
            return '\u2817';
        } else if (cell1[0][0] && cell1[1][0] && cell1[0][1] && cell1[1][1]) {
            return '\u281b';
        } else if (cell1[0][0] && cell1[2][0] && cell1[0][1] && cell1[1][1]) {
            return '\u281d';
        } else if (cell1[1][0] && cell1[2][0] && cell1[0][1] && cell1[1][1]) {
            return '\u281e';
        } else if (cell1[0][0] && cell1[1][0] && cell1[2][0] && cell1[2][1]) {
            return '\u2827';
        } else if (cell1[0][0] && cell1[1][0] && cell1[0][1] && cell1[2][1]) {
            return '\u282b';
        } else if (cell1[0][0] && cell1[2][0] && cell1[0][1] && cell1[2][1]) {
            return '\u282d';
        } else if (cell1[1][0] && cell1[2][0] && cell1[0][1] && cell1[2][1]) {
            return '\u282e';
        } else if (cell1[0][0] && cell1[1][0] && cell1[1][1] && cell1[2][1]) {
            return '\u2833';
        } else if (cell1[0][0] && cell1[2][0] && cell1[1][1] && cell1[2][1]) {
            return '\u2835';
        } else if (cell1[1][0] && cell1[2][0] && cell1[1][1] && cell1[2][1]) {
            return '\u2836';
        } else if (cell1[0][0] && cell1[0][1] && cell1[1][1] && cell1[2][1]) {
            return '\u2839';
        } else if (cell1[1][0] && cell1[0][1] && cell1[1][1] && cell1[2][1]) {
            return '\u283a';
        } else if (cell1[2][0] && cell1[0][1] && cell1[1][1] && cell1[2][1]) {
            return '\u283c';
        } else if (cell1[0][0] && cell1[1][0] && cell1[2][0]) {
            return '\u2807';
        } else if (cell1[0][0] && cell1[1][0] && cell1[0][1]) {
            return '\u280b';
        } else if (cell1[0][0] && cell1[2][0] && cell1[0][1]) {
            return '\u280d';
        } else if (cell1[1][0] && cell1[2][0] && cell1[0][1]) {
            return '\u280e';
        } else if (cell1[0][0] && cell1[1][0] && cell1[1][1]) {
            return '\u2813';
        } else if (cell1[0][0] && cell1[2][0] && cell1[1][1]) {
            return '\u2815';
        } else if (cell1[1][0] && cell1[2][0] && cell1[1][1]) {
            return '\u2816';
        } else if (cell1[0][0] && cell1[0][1] && cell1[1][1]) {
            return '\u2819';
        } else if (cell1[1][0] && cell1[0][1] && cell1[1][1]) {
            return '\u281a';
        } else if (cell1[2][0] && cell1[0][1] && cell1[1][1]) {
            return '\u281c';
        } else if (cell1[0][0] && cell1[1][0] && cell1[2][1]) {
            return '\u2823';
        } else if (cell1[0][0] && cell1[2][0] && cell1[2][1]) {
            return '\u2825';
        } else if (cell1[1][0] && cell1[2][0] && cell1[2][1]) {
            return '\u2826';
        } else if (cell1[0][0] && cell1[0][1] && cell1[2][1]) {
            return '\u2829';
        } else if (cell1[1][0] && cell1[0][1] && cell1[2][1]) {
            return '\u282a';
        } else if (cell1[2][0] && cell1[0][1] && cell1[2][1]) {
            return '\u282c';
        } else if (cell1[0][0] && cell1[1][1] && cell1[2][1]) {
            return '\u2831';
        } else if (cell1[1][0] && cell1[1][1] && cell1[2][1]) {
            return '\u2832';
        } else if (cell1[2][0] && cell1[1][1] && cell1[2][1]) {
            return '\u2834';
        } else if (cell1[0][1] && cell1[1][1] && cell1[2][1]) {
            return '\u2838';
        } else if (cell1[0][0] && cell1[1][0]) {
            return '\u2803';
        } else if (cell1[0][0] && cell1[2][0]) {
            return '\u2805';
        } else if (cell1[1][0] && cell1[2][0]) {
            return '\u2806';
        } else if (cell1[0][0] && cell1[0][1]) {
            return '\u2809';
        } else if (cell1[1][0] && cell1[0][1]) {
            return '\u280a';
        } else if (cell1[2][0] && cell1[0][1]) {
            return '\u280c';
        } else if (cell1[0][0] && cell1[1][1]) {
            return '\u2811';
        } else if (cell1[1][0] && cell1[1][1]) {
            return '\u2812';
        } else if (cell1[2][0] && cell1[1][1]) {
            return '\u2814';
        } else if (cell1[0][1] && cell1[1][1]) {
            return '\u2818';
        } else if (cell1[0][0] && cell1[2][1]) {
            return '\u2821';
        } else if (cell1[1][0] && cell1[2][1]) {
            return '\u2822';
        } else if (cell1[2][0] && cell1[2][1]) {
            return '\u2824';
        } else if (cell1[0][1] && cell1[2][1]) {
            return '\u2828';
        } else if (cell1[1][1] && cell1[2][1]) {
            return '\u2830';
        } else if (cell1[0][0]) {
            return '\u2801';
        } else if (cell1[1][0]) {
            return '\u2802';
        } else if (cell1[2][0]) {
            return '\u2804';
        } else if (cell1[0][1]) {
            return '\u2808';
        } else if (cell1[1][1]) {
            return '\u2810';
        } else if (cell1[2][1]) {
            return '\u2820';
        } else {
            return '\u2800';
        }

    }
    private static boolean isNumber, isLetter;
    private boolean cell1[][] = new boolean[3][2];
    private boolean cell2[][] = new boolean[3][2];
    private boolean cell3[][] = new boolean[3][2];
    private boolean cell4[][] = new boolean[3][2];
    private boolean cell5[][] = new boolean[3][2];
    private boolean cell6[][] = new boolean[3][2];
    private static boolean isSpace = false;
    private static int quotationMark = 0;
    BrailleCell tempCell;

    /**
     * Creates BrailleCell Object with suitable Grade-II Braille Contractions
     *
     * @param str Input String
     */
    protected BrailleCell(String str) {
        clearCell();
        isLetter = true;
        isNumber = false;
        switch (str) {

            case "and":
                cell1 = new BrailleCell('&').cell1;
                break;
            case "for":
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                cell1[2][0] = true;
                cell1[2][1] = true;
                break;
            case "of":
                cell1[0][0] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                cell1[2][0] = true;
                cell1[2][1] = true;
                break;
            case "the":
                cell1[0][1] = true;
                cell1[1][0] = true;
                cell1[2][0] = true;
                cell1[2][1] = true;
                break;
            case "with":
                cell1[0][1] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                cell1[2][0] = true;
                cell1[2][1] = true;
                break;
            case "child":
                cell1[0][0] = true;
                cell1[2][1] = true;
                break;
            case "shall":
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[2][1] = true;
                break;
            case "this":
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[1][1] = true;
                cell1[2][1] = true;
                break;
            case "which":
                cell1[0][0] = true;
                cell1[1][1] = true;
                cell1[2][1] = true;
                break;
            case "out":
                cell1[0][0] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                cell1[2][1] = true;
                break;
            case "still":
                cell1[0][1] = true;
                cell1[2][0] = true;
                break;
            case "but":
                cell1 = new BrailleCell('b').cell1;
                break;
            case "can":
                cell1 = new BrailleCell('c').cell1;
                break;

            case "do":
                cell1 = new BrailleCell('d').cell1;
                break;
            case "every":
                cell1 = new BrailleCell('e').cell1;
                break;
            case "from":
                cell1 = new BrailleCell('f').cell1;
                break;
            case "go":
                cell1 = new BrailleCell('g').cell1;
                break;
            case "have":
                cell1 = new BrailleCell('h').cell1;
                break;
            case "just":
                cell1 = new BrailleCell('j').cell1;
                break;
            case "knowledge":
                cell1 = new BrailleCell('k').cell1;
                break;
            case "like":
                cell1 = new BrailleCell('l').cell1;
                break;
            case "more":
                cell1 = new BrailleCell('m').cell1;
                break;
            case "not":
                cell1 = new BrailleCell('n').cell1;
                break;
            case "people":
                cell1 = new BrailleCell('p').cell1;
                break;
            case "rather":
                cell1 = new BrailleCell('r').cell1;
                break;
            case "so":
                cell1 = new BrailleCell('s').cell1;
                break;
            case "that":
                cell1 = new BrailleCell('t').cell1;
                break;
            case "us":
                cell1 = new BrailleCell('u').cell1;
                break;
            case "very":
                cell1 = new BrailleCell('v').cell1;
                break;
            case "will":
                cell1 = new BrailleCell('w').cell1;
                break;
            case "it":
                cell1 = new BrailleCell('x').cell1;
                break;
            case "you":
                cell1 = new BrailleCell('y').cell1;
                break;
            case "as":
                cell1 = new BrailleCell('z').cell1;
                break;
            case "can's":
                cell1 = new BrailleCell('c').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('s').cell1;
                break;
            case "can't":
                cell1 = new BrailleCell('c').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('t').cell1;
                break;
            case "people's":
                cell1 = new BrailleCell('p').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('s').cell1;
                break;
            case "so's":
                tempCell = new BrailleCell('s');
                cell1 = tempCell.cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = tempCell.cell1;
                break;
            case "that'd":
                cell1 = new BrailleCell('t').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('d').cell1;
                break;
            case "that'll":
                cell1 = new BrailleCell('t').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('l').cell1;
                cell4 = new BrailleCell('l').cell1;

                break;
            case "that's":
                cell1 = new BrailleCell('t').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('s').cell1;
                break;
            case "will's":
                cell1 = new BrailleCell('w').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('s').cell1;
                break;
            case "it'd":
                cell1 = new BrailleCell('x').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('d').cell1;
                break;
            case "it'll":
                tempCell = new BrailleCell('l');
                cell1 = new BrailleCell('x').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = tempCell.cell1;
                cell4 = tempCell.cell1;
                break;
            case "it's":
                cell1 = new BrailleCell('x').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('s').cell1;
                break;
            case "you'd":
                cell1 = new BrailleCell('y').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('d').cell1;
                break;
            case "you'll":
                tempCell = new BrailleCell('l');
                cell1 = new BrailleCell('y').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = tempCell.cell1;
                cell4 = tempCell.cell1;
                break;
            case "you're":
                cell1 = new BrailleCell('y').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('r').cell1;
                cell4 = new BrailleCell('e').cell1;
                break;
            case "you've":
                cell1 = new BrailleCell('y').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('v').cell1;
                cell4 = new BrailleCell('e').cell1;
                break;
            case "about":
                cell1 = new BrailleCell('a').cell1;
                cell2 = new BrailleCell('b').cell1;
                break;
            case "above":
                tempCell = new BrailleCell("about");
                cell1 = tempCell.cell1;
                cell2 = tempCell.cell2;
                cell3 = new BrailleCell('v').cell1;
                break;
            case "according":
                cell1 = new BrailleCell('a').cell1;
                cell2 = new BrailleCell('c').cell1;
                break;
            case "across":
                cell1 = new BrailleCell('a').cell1;
                cell2 = new BrailleCell('c').cell1;
                cell3 = new BrailleCell('r').cell1;
                break;
            case "afternoon":
                cell1 = new BrailleCell('a').cell1;
                cell2 = new BrailleCell('f').cell1;
                cell3 = new BrailleCell('n').cell1;
                break;
            case "afterward":
                tempCell = new BrailleCell("afternoon");
                cell1 = tempCell.cell1;
                cell2 = tempCell.cell2;
                cell3 = new BrailleCell('w').cell1;
                break;
            case "again":
                cell1 = new BrailleCell('a').cell1;
                cell2 = new BrailleCell('g').cell1;
                break;
            case "against":
                tempCell = new BrailleCell("again");
                cell1 = tempCell.cell1;
                cell2 = tempCell.cell2;
                cell3 = new BrailleCell('s').cell1;
                cell4 = new BrailleCell('t').cell1;
                break;
            case "ally":
                cell1 = new BrailleCell(',').cell1;
                cell2 = new BrailleCell('y').cell1;
                break;
            case "almost":
                cell1 = new BrailleCell('a').cell1;
                cell2 = new BrailleCell('l').cell1;
                cell3 = new BrailleCell('m').cell1;
                break;
            case "already":
                cell1 = new BrailleCell('a').cell1;
                cell2 = new BrailleCell('l').cell1;
                cell3 = new BrailleCell('r').cell1;
                break;
            case "also":
                cell1 = new BrailleCell('a').cell1;
                cell2 = new BrailleCell('l').cell1;
                break;
            case "although":
                cell1 = new BrailleCell('a').cell1;
                cell2 = new BrailleCell('l').cell1;
                cell3 = new BrailleCell('t').cell1;
                cell4 = new BrailleCell('h').cell1;
                break;
            case "altogether":
                cell1 = new BrailleCell('a').cell1;
                cell2 = new BrailleCell('l').cell1;
                cell3 = new BrailleCell('t').cell1;
                break;
            case "always":
                cell1 = new BrailleCell('a').cell1;
                cell2 = new BrailleCell('l').cell1;
                cell3 = new BrailleCell('w').cell1;
                break;
            case "ance":
                cell1 = new BrailleCell('.').cell1;
                cell2 = new BrailleCell('e').cell1;
                break;
            case "ar":
                cell1 = new BrailleCell('>').cell1;
                break;
            case "ation":
                cell1 = new BrailleCell(',').cell1;
                cell2 = new BrailleCell('n').cell1;
                break;
            case "bb":
                cell1 = new BrailleCell(2).cell1;
                break;
            case "be":
                cell1 = new BrailleCell(2).cell1;
                break;
            case "because":
                cell1 = new BrailleCell('b').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('c').cell1;
                break;
            case "before":
                cell1 = new BrailleCell('b').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('f').cell1;
                break;
            case "behind":
                cell1 = new BrailleCell('b').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('h').cell1;
                break;
            case "below":
                cell1 = new BrailleCell('b').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('l').cell1;
                break;
            case "beneath":
                cell1 = new BrailleCell('b').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('n').cell1;
                break;
            case "beside":
                cell1 = new BrailleCell('b').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('s').cell1;
                break;
            case "between":
                cell1 = new BrailleCell('b').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('t').cell1;
                break;
            case "beyond":
                cell1 = new BrailleCell('b').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('y').cell1;
                break;
            case "ble":
                cell1 = new BrailleCell('#').cell1;
                break;
            case "blind":
                cell1 = new BrailleCell('b').cell1;
                cell2 = new BrailleCell('l').cell1;
                break;
            case "braille":
                cell1 = new BrailleCell('b').cell1;
                cell2 = new BrailleCell('r').cell1;
                cell3 = new BrailleCell('l').cell1;
                break;
            case "by":
                cell1 = new BrailleCell(0).cell1;
                break;
            case "cannot":
                cell1 = new BrailleCell('_').cell1;
                cell2 = new BrailleCell('c').cell1;
                break;
            case "cc":
                cell1 = new BrailleCell(3).cell1;
                break;
            case "ch":
                cell1 = new BrailleCell('*').cell1;
                break;
            case "character":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('*').cell1;
                break;
            case "children":
                cell1 = new BrailleCell('c').cell1;
                cell2 = new BrailleCell('h').cell1;
                cell3 = new BrailleCell('n').cell1;
                break;
            case "com":
                cell1 = new BrailleCell('-').cell1;
                break;
            case "con":
                cell1 = new BrailleCell(3).cell1;
                break;
            case "conceive":
                cell1 = new BrailleCell('c').cell1;
                cell2 = new BrailleCell('o').cell1;
                cell3 = new BrailleCell('n').cell1;
                cell4 = new BrailleCell('c').cell1;
                cell5 = new BrailleCell('v').cell1;
                break;
            case "conceiving":
                cell1 = new BrailleCell('c').cell1;
                cell2 = new BrailleCell('o').cell1;
                cell3 = new BrailleCell('n').cell1;
                cell4 = new BrailleCell('c').cell1;
                cell5 = new BrailleCell('v').cell1;
                cell6 = new BrailleCell('g').cell1;
                break;
            case "could":
                cell1 = new BrailleCell('c').cell1;
                cell2 = new BrailleCell('d').cell1;
                break;
            case "day":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('d').cell1;
                break;
            case "dd":
                cell1 = new BrailleCell(4).cell1;
                break;
            case "deceive":
                cell1 = new BrailleCell('d').cell1;
                cell2 = new BrailleCell('c').cell1;
                cell3 = new BrailleCell('v').cell1;
                break;
            case "declare":
                cell1 = new BrailleCell('d').cell1;
                cell2 = new BrailleCell('c').cell1;
                cell3 = new BrailleCell('l').cell1;
                break;
            case "declaring":
                cell1 = new BrailleCell('d').cell1;
                cell2 = new BrailleCell('c').cell1;
                cell3 = new BrailleCell('l').cell1;
                cell4 = new BrailleCell('g').cell1;
                break;
            case "dis":
                cell1 = new BrailleCell(4).cell1;
                break;
            case "ea":
                cell1 = new BrailleCell(1).cell1;
                break;
            case "ed":
                cell1 = new BrailleCell('$').cell1;
                break;
            case "either":
                cell1 = new BrailleCell('e').cell1;
                cell2 = new BrailleCell('i').cell1;
                break;
            case "en":
                cell1 = new BrailleCell(5).cell1;
                break;
            case "ence":
                cell1 = new BrailleCell(';').cell1;
                cell2 = new BrailleCell('e').cell1;
                break;
            case "enough":
                cell1 = new BrailleCell(5).cell1;
                break;
            case "er":
                cell1 = new BrailleCell(']').cell1;
                break;
            case "ever":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('e').cell1;
                break;
            case "ff":
                cell1 = new BrailleCell(6).cell1;
                break;
            case "first":
                cell1 = new BrailleCell('f').cell1;
                cell2 = new BrailleCell('s').cell1;
                cell3 = new BrailleCell('t').cell1;
                break;
            case "friend":
                cell1 = new BrailleCell('f').cell1;
                cell2 = new BrailleCell('r').cell1;
                break;
            case "ful":
                cell1 = new BrailleCell(';').cell1;
                cell2 = new BrailleCell('l').cell1;
                break;
            case "gg":
                cell1 = new BrailleCell(7).cell1;
                break;
            case "gh":
                cell1 = new BrailleCell('<').cell1;
                break;
            case "good":
                cell1 = new BrailleCell('g').cell1;
                cell2 = new BrailleCell('d').cell1;
                break;
            case "great":
                cell1 = new BrailleCell('g').cell1;
                cell2 = new BrailleCell('r').cell1;
                cell3 = new BrailleCell('t').cell1;
                break;
            case "had":
                cell1 = new BrailleCell('_').cell1;
                cell2 = new BrailleCell('h').cell1;
                break;

            case "here":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('h').cell1;
                break;
            case "herself":
                cell1 = new BrailleCell('h').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('r').cell1;
                cell4 = new BrailleCell('f').cell1;
                break;
            case "him":
                cell1 = new BrailleCell('h').cell1;
                cell2 = new BrailleCell('m').cell1;
                break;
            case "himself":
                cell1 = new BrailleCell('h').cell1;
                cell2 = new BrailleCell('m').cell1;
                cell3 = new BrailleCell('f').cell1;
                break;
            case "his":
                cell1 = new BrailleCell(8).cell1;
                break;
            case "immediate":
                cell1 = new BrailleCell('i').cell1;
                cell2 = new BrailleCell('m').cell1;
                cell3 = new BrailleCell('m').cell1;
                break;
            case "in":
                cell1 = new BrailleCell(9).cell1;
                break;
            case "ing":
                cell1 = new BrailleCell('+').cell1;
                break;
            case "into":
                cell1 = new BrailleCell(9).cell1;
                cell2 = new BrailleCell(6).cell1;
                break;

            case "its":
                cell1 = new BrailleCell('x').cell1;
                cell2 = new BrailleCell('s').cell1;
                break;
            case "itself":
                cell1 = new BrailleCell('x').cell1;
                cell2 = new BrailleCell('f').cell1;
                break;
            case "ity":
                cell1 = new BrailleCell(';').cell1;
                cell2 = new BrailleCell('y').cell1;
                break;
            case "know":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('k').cell1;
                break;
            case "less":
                cell1 = new BrailleCell('.').cell1;
                cell2 = new BrailleCell('s').cell1;
                break;
            case "letter":
                cell1 = new BrailleCell('l').cell1;
                cell2 = new BrailleCell('r').cell1;
                break;
            case "little":
                cell1 = new BrailleCell('l').cell1;
                cell2 = new BrailleCell('l').cell1;
                break;
            case "lord":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('l').cell1;
                break;
            case "many":
                cell1 = new BrailleCell('_').cell1;
                cell2 = new BrailleCell('m').cell1;
                break;
            case "ment":
                cell1 = new BrailleCell(';').cell1;
                cell2 = new BrailleCell('t').cell1;
                break;
            case "mother":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('m').cell1;
                break;
            case "much":
                cell1 = new BrailleCell('m').cell1;
                cell2 = new BrailleCell('c').cell1;
                cell3 = new BrailleCell('h').cell1;
                break;
            case "must":
                cell1 = new BrailleCell('m').cell1;
                cell2 = new BrailleCell('s').cell1;
                cell3 = new BrailleCell('t').cell1;
                break;
            case "myself":
                cell1 = new BrailleCell('m').cell1;
                cell2 = new BrailleCell('y').cell1;
                cell3 = new BrailleCell('f').cell1;
                break;
            case "name":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('n').cell1;
                break;
            case "necessary":
                cell1 = new BrailleCell('n').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('c').cell1;
                break;
            case "neither":
                cell1 = new BrailleCell('n').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('i').cell1;
                break;
            case "ness":
                cell1 = new BrailleCell(';').cell1;
                cell2 = new BrailleCell('s').cell1;
                break;
            case "o'clock":
                cell1 = new BrailleCell('o').cell1;
                cell2 = new BrailleCell('\'').cell1;
                cell3 = new BrailleCell('c').cell1;
                break;

            case "one":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('o').cell1;
                break;
            case "oneself":
                cell1 = new BrailleCell('o').cell1;
                cell2 = new BrailleCell('n').cell1;
                cell3 = new BrailleCell('e').cell1;
                cell4 = new BrailleCell('f').cell1;
                break;
            case "ong":
                cell1 = new BrailleCell(';').cell1;
                cell2 = new BrailleCell('g').cell1;
                break;
            case "ou":
                cell1 = new BrailleCell('\\').cell1;
                break;
            case "ought":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('\\').cell1;
                break;
            case "ound":
                cell1 = new BrailleCell('.').cell1;
                cell2 = new BrailleCell('d').cell1;
                break;
            case "ourselves":
                cell1 = new BrailleCell('o').cell1;
                cell2 = new BrailleCell('u').cell1;
                cell3 = new BrailleCell('r').cell1;
                cell4 = new BrailleCell('v').cell1;
                cell5 = new BrailleCell('s').cell1;
                break;
            case "ount":
                cell1 = new BrailleCell('.').cell1;
                cell2 = new BrailleCell('t').cell1;
                break;

            case "ow":
                cell1 = new BrailleCell('[').cell1;
                break;
            case "paid":
                cell1 = new BrailleCell('p').cell1;
                cell2 = new BrailleCell('d').cell1;
                break;
            case "part":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('p').cell1;
                break;
            case "perceive":
                cell1 = new BrailleCell('p').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('r').cell1;
                cell4 = new BrailleCell('c').cell1;
                cell5 = new BrailleCell('v').cell1;
                break;
            case "perceiving":
                cell1 = new BrailleCell('p').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('r').cell1;
                cell4 = new BrailleCell('c').cell1;
                cell5 = new BrailleCell('v').cell1;
                cell6 = new BrailleCell('g').cell1;
                break;
            case "perhaps":
                cell1 = new BrailleCell('p').cell1;
                cell2 = new BrailleCell('e').cell1;
                cell3 = new BrailleCell('r').cell1;
                cell4 = new BrailleCell('h').cell1;
                break;
            case "question":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('q').cell1;
                break;
            case "quick":
                cell1 = new BrailleCell('q').cell1;
                cell2 = new BrailleCell('k').cell1;
                break;
            case "quite":
                cell1 = new BrailleCell('q').cell1;
                break;
            case "receive":
                cell1 = new BrailleCell('r').cell1;
                cell2 = new BrailleCell('c').cell1;
                cell3 = new BrailleCell('v').cell1;
                break;
            case "receiving":
                cell1 = new BrailleCell('r').cell1;
                cell2 = new BrailleCell('c').cell1;
                cell3 = new BrailleCell('v').cell1;
                cell4 = new BrailleCell('g').cell1;
                break;
            case "rejoice":
                cell1 = new BrailleCell('r').cell1;
                cell2 = new BrailleCell('j').cell1;
                cell3 = new BrailleCell('c').cell1;
                break;
            case "rejoicing":
                cell1 = new BrailleCell('r').cell1;
                cell2 = new BrailleCell('j').cell1;
                cell3 = new BrailleCell('c').cell1;
                cell4 = new BrailleCell('g').cell1;
                break;
            case "right":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('r').cell1;
                break;
            case "said":
                cell1 = new BrailleCell('s').cell1;
                cell2 = new BrailleCell('d').cell1;
                break;
            case "sh":
                cell1 = new BrailleCell('%').cell1;
                break;
            case "should":
                cell1 = new BrailleCell('s').cell1;
                cell2 = new BrailleCell('h').cell1;
                cell3 = new BrailleCell('d').cell1;
                break;
            case "sion":
                cell1 = new BrailleCell('.').cell1;
                cell2 = new BrailleCell('n').cell1;
                break;
            case "some":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('s').cell1;
                break;
            case "spirit":
                cell1 = new BrailleCell('_').cell1;
                cell2 = new BrailleCell('s').cell1;
                break;
            case "st":
                cell1 = new BrailleCell('/').cell1;
                break;
            case "such":
                cell1 = new BrailleCell('s').cell1;
                cell2 = new BrailleCell('c').cell1;
                cell3 = new BrailleCell('h').cell1;
                break;
            case "th":
                cell1 = new BrailleCell('?').cell1;
                break;
            case "their":
                cell1 = new BrailleCell('_').cell1;
                cell2 = new BrailleCell('!').cell1;
                break;
            case "themselves":
                cell1 = new BrailleCell('t').cell1;
                cell2 = new BrailleCell('h').cell1;
                cell3 = new BrailleCell('e').cell1;
                cell4 = new BrailleCell('m').cell1;
                cell5 = new BrailleCell('v').cell1;
                cell6 = new BrailleCell('s').cell1;
                break;
            case "there":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('!').cell1;
                break;
            case "these":
                cell1 = new BrailleCell('^').cell1;
                cell2 = new BrailleCell('!').cell1;
                break;
            case "those":
                cell1 = new BrailleCell('^').cell1;
                cell2 = new BrailleCell('?').cell1;
                break;
            case "through":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('?').cell1;
                break;
            case "thyself":
                cell1 = new BrailleCell('t').cell1;
                cell2 = new BrailleCell('h').cell1;
                cell3 = new BrailleCell('y').cell1;
                cell4 = new BrailleCell('f').cell1;
                break;
            case "time":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('t').cell1;
                break;
            case "tion":
                cell1 = new BrailleCell(';').cell1;
                cell2 = new BrailleCell('n').cell1;
                break;
            case "to":
                cell1 = new BrailleCell(6).cell1;
                break;
            case "today":
                cell1 = new BrailleCell('t').cell1;
                cell2 = new BrailleCell('d').cell1;
                break;
            case "together":
                cell1 = new BrailleCell('t').cell1;
                cell2 = new BrailleCell('g').cell1;
                cell3 = new BrailleCell('r').cell1;
                break;
            case "tomorrow":
                cell1 = new BrailleCell('t').cell1;
                cell2 = new BrailleCell('m').cell1;
                break;
            case "tonight":
                cell1 = new BrailleCell('t').cell1;
                cell2 = new BrailleCell('n').cell1;
                break;
            case "under":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('u').cell1;
                break;
            case "upon":
                cell1 = new BrailleCell('^').cell1;
                cell2 = new BrailleCell('u').cell1;
                break;
            case "was":
                cell1 = new BrailleCell(0).cell1;
                break;
            case "were":
                cell1 = new BrailleCell(7).cell1;
                break;
            case "wh":
                cell1 = new BrailleCell(':').cell1;
                break;
            case "where":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell(':').cell1;
                break;
            case "whose":
                cell1 = new BrailleCell('^').cell1;
                cell2 = new BrailleCell(':').cell1;
                break;
            case "word":
                cell1 = new BrailleCell('^').cell1;
                cell2 = new BrailleCell('w').cell1;
                break;
            case "work":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('w').cell1;
                break;
            case "world":
                cell1 = new BrailleCell('_').cell1;
                cell2 = new BrailleCell('w').cell1;
                break;
            case "would":
                cell1 = new BrailleCell('w').cell1;
                cell2 = new BrailleCell('d').cell1;
                break;
            case "young":
                cell1 = new BrailleCell('"').cell1;
                cell2 = new BrailleCell('y').cell1;
                break;
            case "your":
                cell1 = new BrailleCell('y').cell1;
                cell2 = new BrailleCell('r').cell1;
                break;
            case "yourself":
                cell1 = new BrailleCell('y').cell1;
                cell2 = new BrailleCell('r').cell1;
                cell3 = new BrailleCell('f').cell1;
                break;
            case "yourselves":
                cell1 = new BrailleCell('y').cell1;
                cell2 = new BrailleCell('r').cell1;
                cell3 = new BrailleCell('v').cell1;
                cell4 = new BrailleCell('s').cell1;
                break;

        }
    }

    /**
     * Creates BrailleCell Object for the given character
     *
     * @param ch Input Character
     */
    protected BrailleCell(char ch) {
        clearCell();
        if (ch != '.' || ch != ',') {
            isLetter = true;
            isNumber = false;
        }
        switch (ch) {
            case ' ':
                isSpace = true;
                break;
            case 'a':
                cell1[0][0] = true;
                break;
            case 'b':
                cell1[0][0] = true;
                cell1[1][0] = true;
                break;
            case 'c':
                cell1[0][0] = true;
                cell1[0][1] = true;
                break;
            case 'd':
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[1][1] = true;
                break;
            case 'e':
                cell1[0][0] = true;
                cell1[1][1] = true;
                break;
            case 'f':
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[1][0] = true;
                break;
            case 'g':
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                break;
            case 'h':
                cell1[0][0] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                break;
            case 'i':
                cell1[0][1] = true;
                cell1[1][0] = true;
                break;
            case 'j':
                cell1[0][1] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                break;
            case 'k':
                cell1[0][0] = true;
                cell1[2][0] = true;
                break;
            case 'l':
                cell1[0][0] = true;
                cell1[1][0] = true;
                cell1[2][0] = true;
                break;
            case 'm':
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[2][0] = true;
                break;
            case 'n':
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[1][1] = true;
                cell1[2][0] = true;
                break;
            case 'o':
                cell1[0][0] = true;
                cell1[1][1] = true;
                cell1[2][0] = true;
                break;
            case 'p':
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[1][0] = true;
                cell1[2][0] = true;
                break;
            case 'q':
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                cell1[2][0] = true;
                break;
            case 'r':
                cell1[0][0] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                cell1[2][0] = true;
                break;
            case 's':
                cell1[0][1] = true;
                cell1[1][0] = true;
                cell1[2][0] = true;
                break;
            case 't':
                cell1[0][1] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                cell1[2][0] = true;
                break;
            case 'u':
                cell1[0][0] = true;
                cell1[2][0] = true;
                cell1[2][1] = true;
                break;
            case 'v':
                cell1[0][0] = true;
                cell1[1][0] = true;
                cell1[2][0] = true;
                cell1[2][1] = true;
                break;
            case 'w':
                cell1[0][1] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                cell1[2][1] = true;
                break;
            case 'x':
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[2][0] = true;
                cell1[2][1] = true;
                break;
            case 'y':
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[1][1] = true;
                cell1[2][0] = true;
                cell1[2][1] = true;
                break;
            case 'z':
                cell1[0][0] = true;
                cell1[1][1] = true;
                cell1[2][0] = true;
                cell1[2][1] = true;
                break;
            
        }
    }

    /**
     * Creates BrailleCell Object for the given Integer
     *
     * @param in Input Integer
     */
    protected BrailleCell(int in) {
        clearCell();
        isLetter = false;
        isNumber = true;
        switch (in) {
            case 1:
                cell1[0][0] = true;
                break;
            case 2:
                cell1[0][0] = true;
                cell1[1][0] = true;
                break;
            case 3:
                cell1[0][0] = true;
                cell1[0][1] = true;
                break;
            case 4:
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[1][1] = true;
                break;
            case 5:
                cell1[0][0] = true;
                cell1[1][1] = true;
                break;
            case 6:
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[1][0] = true;
                break;
            case 7:
                cell1[0][0] = true;
                cell1[0][1] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                break;
            case 8:
                cell1[0][0] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                break;
            case 9:
                cell1[0][1] = true;
                cell1[1][0] = true;
                break;
            case 0:
                cell1[0][1] = true;
                cell1[1][0] = true;
                cell1[1][1] = true;
                break;
        }

    }

    /**
     * Checks if Cell is Empty
     *
     * @param cell Input Boolean cell
     * @return Boolean value to check is cell is Empty
     */
    private boolean isNull(boolean cell[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (cell[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean wasLetter = true, wasNumber;

    /**
     * Combine 6 cells
     *
     * @return Object ArrrayList with an ArrayList of Boolean cells and the
     * String equivalent
     */
    public ArrayList<Object> getCellSequence() {
        ArrayList<boolean[][]> ret = new ArrayList<>();
        String uni = "";
        if (wasLetter && isNumber) {
            boolean[][] temp = new boolean[3][2];
            temp[0][1] = true;
            temp[1][1] = true;
            temp[2][0] = true;
            temp[2][1] = true;
            ret.add(temp);
            wasLetter = false;
            wasNumber = true;
            uni += getUni(temp);
        } else if (isLetter) {
            wasNumber = false;
            wasLetter = true;
        }
        if (isSpace) {
            ret.add(cell1);
            uni += getUni(cell1);
            isSpace = false;
        } else if (!isNull(cell6)) {
            ret.add(cell1);
            ret.add(cell2);
            ret.add(cell3);
            ret.add(cell4);
            ret.add(cell5);
            ret.add(cell6);
            uni += getUni(cell1);
            uni += getUni(cell2);
            uni += getUni(cell3);
            uni += getUni(cell4);
            uni += getUni(cell5);
            uni += getUni(cell6);
        } else if (!isNull(cell5)) {
            ret.add(cell1);
            ret.add(cell2);
            ret.add(cell3);
            ret.add(cell4);
            ret.add(cell5);
            uni += getUni(cell1);
            uni += getUni(cell2);
            uni += getUni(cell3);
            uni += getUni(cell4);
            uni += getUni(cell5);
        } else if (!isNull(cell4)) {
            ret.add(cell1);
            ret.add(cell2);
            ret.add(cell3);
            ret.add(cell4);
            uni += getUni(cell1);
            uni += getUni(cell2);
            uni += getUni(cell3);
            uni += getUni(cell4);
        } else if (!isNull(cell3)) {
            ret.add(cell1);
            ret.add(cell2);
            ret.add(cell3);
            uni += getUni(cell1);
            uni += getUni(cell2);
            uni += getUni(cell3);
        } else if (!isNull(cell2)) {
            ret.add(cell1);
            ret.add(cell2);
            uni += getUni(cell1);
            uni += getUni(cell2);
        } else if (!isNull(cell1)) {
            ret.add(cell1);
            uni += getUni(cell1);
        }
        ArrayList<Object> objj = new ArrayList<>();
        objj.add(ret);
        objj.add(uni);
        return objj;

    }

    /**
     * Clears Braille Cell
     */
    final void clearCell() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                cell1[i][j] = false;
                cell2[i][j] = false;
                cell3[i][j] = false;
                cell4[i][j] = false;
                cell5[i][j] = false;
                cell6[i][j] = false;
            }
        }
    }
}
