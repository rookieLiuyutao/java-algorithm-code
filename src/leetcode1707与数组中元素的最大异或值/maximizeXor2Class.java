package leetcode1707与数组中元素的最大异或值;

/**
 * @see
 */
public class maximizeXor2Class {

    class Trie{
        Trie[] children = new Trie[2];
        int min = Integer.MAX_VALUE;

        public void insert(int x){
            Trie p = this;
            p.min = Math.min(p.min,x);
            for (int i = 30;i>=0;i--){
                int m  = x>>i&1;
                if (p.children[m]==null){
                    p.children[m] = new Trie();
                }
                p =p.children[m];
                p.min = Math.min(p.min, x);

            }
        }
        public int query(int x,int limit){
            Trie node = this;
            if (node.min>limit){
                return -1;
            }
            int ans = 0;
            for (int i = 30;i>=0;i--){
                int m = x>>i&1;
                if (node.children[m^1] !=null&&node.children[m^1].min<=limit){
                        ans|=1<<i;
                        m ^=1;
                }
                node = node.children[m];
            }
            return ans;

        }

    }
    public int [] maximizeXor(int[] nums,int [][]queries){
        Trie root = new Trie();
        for (int x:nums){
            root.insert(x);
        }
        int n = queries.length;
        int [] ans = new int[n];
        for(int i = 0; i <n; i++) {
          ans[i] = root.query(queries[i][0],queries[i][1]);
        }

        return ans;
    }

}
