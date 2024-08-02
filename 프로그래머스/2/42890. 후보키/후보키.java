import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[][] relation) {
        int colCnt = relation[0].length;
        List<List<Integer>> subset = new ArrayList<List<Integer>>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        subset = subsets(colCnt);
        
        for (int i = 0; i < subset.size(); i++) {
            if (IsUnique(subset.get(i), relation) && IsMin(subset.get(i), ans)) {
                ans.add(new ArrayList<Integer>(subset.get(i)));
            }
        }
        
        return ans.size();
    }
    
    public List<List<Integer>> subsets(int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        backtrack(n, 0, new ArrayList<Integer>(), ans);
        
        return ans;
    }
    
    private void backtrack(int n, int start, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() >= 1) {                      // base case
            ans.add(new ArrayList<Integer>(cur));   // save result
        }
        
        for (int i = start; i < n; i++) {           // every case
            cur.add(i);                             // making choices
            
            backtrack(n, i + 1, cur, ans);          // recursive call(pruning)
            
            cur.remove(cur.size() - 1);             // undo choices
        }
    }
    
    private boolean IsUnique(List<Integer> input, String[][] relation) {
        Set<List<String>> set = new HashSet<List<String>>();
        int rowCnt = relation.length;
        
        for (int i = 0; i < rowCnt; i++) {
            List<String> list = new ArrayList<String>();

            for (int j = 0; j < input.size(); j++) {
                list.add(relation[i][input.get(j)]);
            }
            
            set.add(new ArrayList<String>(list));
        }
        
        if (set.size() == rowCnt)
            return true;
        else
            return false;
    }
    
    private boolean IsMin(List<Integer> input, List<List<Integer>> ans) {
        for (int i = 0; i < ans.size(); i++) {
            if (input.containsAll(ans.get(i)))
                return false;
        }

        return true;
    } 
}