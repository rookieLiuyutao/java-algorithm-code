package 基本数据结构;

/**
 * 用数组结构实现大小固定的队列和栈
 */

public class dataStructure {
    /**
     * 用数组实现了栈结构；
     */
    public static class ArrayStack {
        private Integer[] arr;
        //用size记录栈内元素个数的情况
        private Integer size;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("栈已满");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        /**
         * 返回栈顶元素
         *
         * @return
         */
        public Integer peak() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        /**
         * 向栈中添加元素
         *
         * @param obj
         */
        public void push(Integer obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("栈已满");
            }
            arr[size++] = obj;
        }

        /**
         * 弹出栈顶元素
         *
         * @return
         */
        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("栈已空");
            }
            return arr[--size];
        }
    }

    /**
     *
     */
    public static class ArrayQueue {

        private Integer[] arr;
        //用size来记录队列内元素个数
        private Integer size;
        //first记录队列头的位置
        private Integer first;
        //last是遍历队列的指针
        private Integer last;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("队列长度小于0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;

        }

        /**
         * 返回对列头元素
         * @return
         */
        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[first];
        }

        /**
         * 元素入队列
         * @param obj
         */
        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("对列已满");

            }
            size++;
            arr[last]=obj;
            last = last==arr.length ? 0 : last+1;
        }

        /**
         * 队列头元素出队列
         * @return
         */
        public Integer poll(){
            if (size==0){
                throw new ArrayIndexOutOfBoundsException("队列已空");
            }
            size--;
            int temp = first;
            first = first==arr.length-1?0:first+1;
            return arr[temp];
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(5);
        arrayStack.push(4);
        arrayStack.push(3);
        System.out.println(arrayStack.pop());
    }

}
