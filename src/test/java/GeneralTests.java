import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;

public class GeneralTests {

    public class W implements Comparable<W> {
        String word;
        int index;

        W(String w, int i){
            word = w;
            index = i;
        }

        @Override
        public int compareTo(W that) {
            if (this.index > that.index){
                return 1;
            } else if (this.index < that.index){
                return -1;
            } else {
                return 0;
            }
        }
    }

    @Test
    public void stringImmutableTest(){
        String s = "Hello";
        assertEquals("Hello", s);
        s = "Change Hello";
        assertNotSame("Hello", s);
        assertEquals("Change Hello", s);
    }

    /** Document search. Design an algorithm that takes a sequence of
     n document words and a sequence of m query words and find the
     shortest interval in which the m query words appear in the document
     in the order given. The length of an interval is the number of words
     in that interval.
    @Test
    public void documentSearchTest(){
        String [] w = "Lorem et ut duo in".toLowerCase().split(" ");
        String [] d = ("Lorem ipsum dolor sit amet, usu ex legere timeam tritani, est mutat erant instructior ad. Nam no soluta cetero delicata, ad aliquam lobortis cum, nobis adversarium qui et. Dicit probatus et duo ea, atqui noluisse mediocrem eu quo. ut Sit latine dolorem ut id, no ludus tation veritus per." +
                "Insolens imperdiet persecuti sed te. Duo fierent mediocrem scripserit no, vix cibo assentior cu. Ea melius elaboraret sea. No nam unum mandamus, case insolens pro id. Est simul commune et." +
                "Eu vis probo zril essent, tation laboramus percipitur has no. Ex usu tempor pericula, iudico doming eirmod mea ne, ne movet latine prodesset qui. Sed debitis consulatu ex. An nominati reprimique scriptorem duo, lorem iusto eum et, enim lorem constituto pri eu. Vim adolescens sadipscing ad. Te et ut duo in vis atomorum gubergren assueverit, duo pri ex homero rationibus." +
                "Ad tritani epicuri comprehensam usu, in mea dicant duo indoctum delicatissimi, volumus elaboraret quo id. Docendi assentior id est, vim timeam oblique ut. Partem scripta et nec. Justo docendi posidonium ex est, vis et liber utinam mollis." +
                "Amet disputando his et, ut tempor invidunt has. Mea ut percipitur omittantur, paulo nominavi senserit ius eu, sea ne habeo definitiones. An ancillae appetere indoctum cum. Eu per fabellas platonem posidonium, putent appellantur disputationi no mel. Sit ad aliquam accumsan efficiantur, qui novum albucius id.").toLowerCase().split(" ");

        int m = w.length;
        int n = d.length;

        BinaryTree<W> [] trees = new BinaryTree[m];
        for(int i = 0; i < m; i++){
            trees[i] = new BinaryTree<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(d[i].equals(w[j])){
                    trees[j].insert(new W(d[i], i)); // hint: no need for trees since the indexes are already in order!!!
                }
            }
        }

        int minimum_distance = 0;
        ArrayList<BinaryTree<W>.Node> firstWordIndexes = trees[0].getInorderArray();
        for(BinaryTree<W>.Node node: firstWordIndexes){
            int distance_calculated = 0;
            int curr_point = node.data.index;
            boolean no_group_exists = false;
            //look for closest next word
            for(int k = 1; k < w.length; k++){
                int distance = 0;
                W temp = trees[k].ceil(new W("g",curr_point));
                if(temp != null) distance = temp.index;
                else no_group_exists = true;
                distance_calculated += distance - curr_point;
                curr_point = distance;
            }
            if(no_group_exists) continue;
            if(distance_calculated < minimum_distance || minimum_distance == 0) minimum_distance = distance_calculated;
        }

        assertEquals(12, minimum_distance);
        Integer in = 0;
        assertEquals(in, trees[0].minValue());

        //take to array by inorder traversal

    }*/

    @Test
    public void countPairs() {
        int [] deliciousness = new int[]{1,3,1,1,874,1174,1192,856,29,3,57,7,151,1897,14243,18525,2993,13391,1,1,344,168,
                154,102,2,2,25,7,1,0,9,7,839,15545,2,62,3,61,6,2,0,1,12614,20154,97,31,725,299,1,0,5191,
                11193,0,1,2513,13871,1,15,396,628,1472,576,1,1,63,1,7,9,1,1,1,3,1157,15227,5,11,4,60,18195,
                14573,3,5,19763,13005,4819,11565,37,27,0,128,355,157,33,31,2179,1917,5733,27035,14,2,3,1,1,0,2,0,3,1,0,2,1,3,
                110,18,1,0,56,200,0,1,9,7,241,15,3536,560,0,4,0,4,3272,13112,10489,5895,14,2,66,190,1,1,2,14,7548,644,
                744,3352,4,0,11,5,0,4,1,0,1651,14733,7,25,21477,11291,4,12,2660,1436,9914,22854,39,25,12,20,597,427,1289,759,48,16,7576,616,1,3,4,12,1649,399,2,6,1,0,0,1,198,826,511,15873,765,259,16339,45,1,0,339,1709,890,134,1,3,10791,5593,6,2,4,0,0,2,6150,2042,5220,2972,20,12,144,368,256,256,4,0,10734,5650,29,35,96,32,4,0,2,2,1,3,218,38,965,59,9999,22769,1881,2215,308,204,4750,3442,0,1,1,1,1,15,1,0,27,5,2,0,199,57,1,0,4,0,29,3,104,24,171,341,18,46,257,3839,0,2,16,112,6033,2159,7,1,13,19,1162,886,1,1,0,4,5,3,4125,4067,4109,4083,534,490,24685,8083,107,405,8,120,3167,5025,18,46,0,1,395,629,8185,7,15,1,6,10,1195,853,1,3,224,32,656,1392,0,1,15,17,414,98,128,128,2,0,0,4,12269,4115,51,13,0,1,93,163,73,183,7982,24786,3246,13138,86,426,456,568,63,1,2,6,15978,406,13860,18908,1,0,21380,11388,23,9,108,20,0,16,23,41,42,22,2,6,25908,6860,8,24,17,47,16665,16103,75,53,2,0,6,2,31,481,1,15,797,3299,4,124,2,2,1,1,874,15510,25,7,12473,3911,1387,14997,3,13,6778,9606,102,26,23511,9257,341,171,8142,50,197,1851,1088,31680,14061,2323,4,4,1573,14811,6282,1910,4,12,0,2,409,103,5697,2495,8,8,7,1,0,1,19,13,0,2,2,0,4,0,9,23,103,921,1322,726,8,0,1723,325,765,1283,1534,2562,965,1083,1,1,3,13,0,8,29289,3479,213,43,7054,1138,406,1642,7367,25401,0,2,0,2,1,0,7,1,0,4,16,16,29,3,1859,6333,1448,31320,2,2,164,92,11279,21489,1199,849,8,120,111,17,225,7967,169,1879,1648,400,1248,800,669,355,57,7,2165,6027,1555,493,1,0,0,4,1017,7,107,149,2712,1384,113,143,44,84,356,1692,0,4,7650,542,45,19,62,450,209,47,963,1085,48,16,4089,28679,1,3,1,1,1,1,1,0,64,64,268,7924,464,48,0,1,406,1642,1956,14428,16198,186,3705,391,50,14,1,15,1,3,9190,7194,2,0,8154,38,23,41,1,1,5887,26881,234,22,246,10,15094,1290,7630,8754,283,229,175,337,350,162,189,8003,1,1,1357,691,249,775,4514,11870,23,233,30160,2608,3,253,6,122,112,144,6,2,1,0,173,8019,1,0,1,0,17,47,13564,19204,4,12,5481,2711,115,13,216,40,2,0,158,354,14,2,35,221,1093,3003,3584,4608,1,1,22897,9871,31,1,49,15,185,71,32,32,1,0,735,289,1,7,4070,12314,2,14,3,1,1,63,632,32136,82,46,211,301,69,59,42,22,2179,1917,4,0,3,5,1945,6247,127,1,0,1,24,232,13811,2573,1899,149,8,24,1478,6714,2,6,2,0,687,337,4,0,16,0,9909,6475,3485,611,102,26,2299,1797,12,244,0,2,7,1,1613,2483,12,4,1999,2097,1,0,12,4,712,1336,2,2,628,396,1282,766,0,4};
        int n = deliciousness.length*(deliciousness.length-1) / 2;
        int[] totals = new int[n];
        int meals = 0;

        int z = 0;
        for(int i = 0; i < deliciousness.length; i++)
            for(int j = i + 1; j < deliciousness.length; j++)
                totals[z++] = deliciousness[i] + deliciousness[j];

        for(int i = 0; i < n; i++){
            for(int k = 0; k < 21; k++){
                if(totals[i] == Math.pow(2,k)) meals++;
            }
        }
        System.out.println(meals);
    }

}
