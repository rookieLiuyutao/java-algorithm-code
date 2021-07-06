package leetcode22括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * @see dfs https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    int len;
    List<String> ans = new ArrayList<>();
    public void dfs(int lc,int rc, String path){
        if (lc==len&&rc==len){
            ans.add(path);

        }else {
            if (lc<len){
                dfs(lc+1,rc,path+"(");
            }
            if (rc<len&&lc>rc){
                dfs(lc,rc+1,path+")");
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        len = n;
        dfs(0,0,"");
        return ans;
    }

}
