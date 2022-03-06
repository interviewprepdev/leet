import java.io.*;
import java.util.*;

public class MyClass {
    
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public static  String alienOrder(String[] words) {
        Map<Character, List<Character>> fromKeyMap = new HashMap<>();
        Map<Character, Integer>  indegreeMap = new HashMap<Character, Integer>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++)
        {
            for (int j = 0; j < words[i].length(); j++)
            {
                fromKeyMap.put(words[i].charAt(j), new LinkedList<Character>());
                indegreeMap.put(words[i].charAt(j), 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++)
        {
            char[] ca1 = words[i].toCharArray();
            char[] ca2 = words[i +1].toCharArray();
            for (int j = 0; j < Math.min(ca1.length, ca2.length); j++)
            {
                if (ca1[j] != ca2[j])
                {
                    fromKeyMap.get(ca1[j]).add(ca2[j]);
                    int count = (int)(indegreeMap.get(ca2[j]) + 1);
                    indegreeMap.put(ca2[j], count);
                    break;
                }                
            }
        }

        boolean flag = false;
        while (!indegreeMap.isEmpty())
        {
           flag = false;
           Iterator it = indegreeMap.entrySet().iterator();
           while (it.hasNext())
           {
               Map.Entry<Character, Integer> es =  (Map.Entry<Character, Integer>) it.next();
               if ((int)es.getValue() == 0)
               {
                   Character c = (Character) es.getKey();
                   flag = true;
                   it.remove();
                   sb.append(c);
                   List<Character> cl = fromKeyMap.get(c);
                   for (Character cur : cl)
                   {
                       int count = (int)((indegreeMap.get(cur)) - 1);
                       indegreeMap.put(cur, count);
                   }          
               }
           }

           if (!flag)
            return "empty";
        }
        
        return sb.toString();

    }
    public static void main(String args[]) {
      String[] input1 = new String[] {"wrt", "wrf", "er", "ett", "rftt", "swft", "swtf"};
      // String[] input2 = new String[] {"z", "x"};
      // String[] input3 = new String[] {"z", "x", "z"};
      System.out.println(MyClass.alienOrder(input1));
    }
}
