package 排序算法;

import java.util.Arrays;

public class mySort {
    /**
     * 选择排序
     *
     * @param arr
     * @return
     */
    public static void chooseSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }

            }
            if (min != i) {
                swap(arr, i, min);
            }
        }
        System.out.println(Arrays.toString(arr));


    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j++) {
                swap(arr, j, j + 1);
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 冒泡排序
     *
     * @param arr 把n个数中最大的数字冒到最后，在剩下的n-1个数里把最大的冒到最后，以此类推
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 交换两个整数的函数
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 归并排序（分治算法）
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));


    }

    public static void sortProcess(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 2);
        sortProcess(arr, l, mid);
        sortProcess(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] tempArr = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            tempArr[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
//        System.out.println(i);
        while (p1 <= mid) {
            tempArr[i++] = arr[p1++];
        }
        while (p2 <= r) {
            tempArr[i++] = arr[p2++];
        }
        for (i = 0; i < tempArr.length; i++) {
            arr[l + i] = tempArr[i];
        }


    }

    /**
     * 快速排序
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int j = l + (int) (Math.random() * (r - l + 1));
            swap(arr, j, r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    /**
     * 堆排序
     *
     * @param arr
     */

    public static void heapSort(int[] arr) {
        if (arr.length <= 2 || arr == null) {
            return;
        }
        //-----建立大根堆的过程-----
        for (int i = 0; i < arr.length; i++) {
            heapInsert(i, arr);
        }
        //-----------------------
        //
        int heapSize = arr.length;
        //将倒数第二个数与堆顶进行交换，再将堆的范围-1，就做到了弹出堆顶元素；
        //即每次把最大的数放入数组中
        swap(arr, 0, --heapSize);
        //新的子堆再进行调整
        while (heapSize > 0) {
            heapIfy(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void heapInsert(int index, int[] arr) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapIfy(int[] arr, int index, int size) {
        int left = index * 2 + 1;

        //在当前节点的左子节点没有越界时，执行如下循环
        while (left < size) {
            int right = left + 1;
            //当 当前节点的有子节点也没有越界时，把最大标记给两个子节点中较大的一个
            int largest = right < size && arr[right] > arr[left] ? right : left;
            largest = arr[largest] > arr[index] ? largest : index;
            //执行完这两句后，就选出了 父，左，右，三者中的最大值
            //---------------------------------------
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;

            left = index * 2 + 1;
        }
    }

    /**
     * 给定一个数组，求如果排序之后，相邻两数的最大差值，
     * 要求时间复杂度O(N)，且要求不能用非基于比较的排序。
     *
     * @param nums
     * @return
     */
    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        //让最小值等于系统最大值，最大值等于系统最小值；
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //利用for循环，找出数组内的最大值和最小值；
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        //排除数组只有一个数的情况
        if (max == min) {
            return 0;
        }
        //桶排序一定要有n+1个桶，是为了保证一定有一个空桶，可以有多个空桶
        boolean[] hasNum = new boolean[nums.length + 1];
        //maxs数组记录每个桶中的最大值
        //mins数组记录每个桶中的最小值
        int[] maxs = new int[nums.length + 1];
        int[] mins = new int[nums.length + 1];

        int bid = 0;
        for (int i = 0; i < nums.length; i++) {
            //bid记录了桶的序号
            bid = bucket(nums[i], nums.length, min, max);
            //找出一个桶中最小的一个数
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(mins[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= nums.length; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;


    }

    public static int bucket(long num, long len, long min, long max) {
        //以(最大值-最小值)/数组中数的个数 为一个桶的容量，把整个数组分成几个桶
        //(当前数-最小值)/桶的长度 判断当前值应该在哪个桶里
        return (int) ((num - min) * len / (max - min));
        //(int)是向下取整
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 7, 2, 2, 10, 9, 1, 1, 5};
//        mergeSort(arr);
//        quickSort(arr);
        heapSort(arr);
        System.out.println(maxGap(arr));

    }


}
