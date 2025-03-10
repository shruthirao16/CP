package PreFS;

import java.util.*;

/*Text-Bob kevin
Docs-John kate
Text-Kenny seb
Run-Kenny seb
Docs-Bob kevin

output:
Bob kevin-2
Kenny seb-2
John kate-1

 */
public class StringsCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();         //*************************************
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextLine();
        }
        //HashMap<String, Integer> hm = new HashMap<>();
        Map<String, Integer> hm = new LinkedHashMap<>();
        for(int i=0; i<n; i++){
            int ind = arr[i].indexOf('-');
            String str = arr[i].substring(ind+1);
            hm.put(str, hm.getOrDefault(str, 0)+1);
        }
        for(String s : hm.keySet()){
            System.out.println(s+"-"+hm.get(s));
        }
//        for(Map.Entry<String, Integer> entry : hm.entrySet()){
//            System.out.println(entry.getKey() + "-" + entry.getValue());
//        }




        List<Map.Entry<String, Integer>> al = new ArrayList<>(hm.entrySet());
        al.sort((a,b)->b.getValue().compareTo(a.getValue()));
        for(Map.Entry<String, Integer> entry : al){
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

    }
}



// if insertion order matters, take linked hm ; if freq order matters, take priority queue