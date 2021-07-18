package leetcode990等式方程的可满足性;

/**
 *并查集
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 */
public class EquationsPossible {

    int n;
    int [] p = new int[n+1];

    /**
     * 并查集合并集合
     * 因为只有26个字母，所以最多有26种集合
     * @param x 元素
     * @return 公共的祖先
     */
    int find(int x){
        if (x!=p[x]){
            p[x] = find(p[x]);
        }
    return p[x];
    }


    public boolean equationsPossible(String[] e) {
        n = e.length;
        for(int i = 0; i <26; i++) {
          p[i] = i;
        }
        for(int i = 0; i <n; i++) {
            int a = e[i].charAt(0)-'a';
            int b = e[i].charAt(3)-'a';
            if (e[i].charAt(1)=='=') {
                p[find(a)] = find(b);
            }
        }
        for(int i = 0; i <n; i++) {
          int a = e[i].charAt(0)-'a';
          int b = e[i].charAt(3)-'a';
          if (e[i].charAt(1)=='!'){
              if (find(a)==find(b)){
                  return true;
              }
          }
        }
        return false;
    }

}
