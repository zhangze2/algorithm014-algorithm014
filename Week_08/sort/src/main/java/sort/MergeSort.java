package sort;

import sort.SortUtil.Sort;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] data) {
        int[] temp = new int[data.length];
        mergeSort(data, temp, 0, data.length - 1);
    }

    private void mergeSort(int[] data, int[] temp, int left, int right) {
        int mid = (left + right) / 2;
        if (left == right) {
            return;
        }
        //左
        mergeSort(data, temp, left, mid);
        mergeSort(data, temp, mid + 1, right);

        for (int i = left; i <= right; i++) {
            temp[i] = data[i];
        }

        int i1 = left;
        int i2 = mid + 1;

        for (int cur = left; cur <= right; cur++) {
            if (i1 == mid + 1)
                data[cur] = temp[i2++];
            else if (i2 > right)
                data[cur] = temp[i1++];
            else if (temp[i1] < temp[i2])
                data[cur] = temp[i1++];
            else
                data[cur] = temp[i2++];
        }
    }



    // 方案二

    public void sort2(int[] data) {
        int[] intArr = { 7, 2, 4, 3, 12, 1, 9, 6, 8, 5,11,10};
        data = intArr;
        mergeSort2(data, 0, data.length - 1);
    }

    public static void mergeSort2(int[] data, int left, int right) {
        if (left >= right)
            return;
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        mergeSort2(data, left, center);
        // 对右边数组进行递归
        mergeSort2(data, center + 1, right);
        // 合并
        mergeResult(data, left, center, right);
        SortUtil.printSortArgs(data);
    }

    /**
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
     *
     * @param data
     *            数组对象
     * @param left
     *            左数组的第一个元素的索引
     * @param center
     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
     * @param right
     *            右数组最后一个元素的索引
     */
    public static void mergeResult(int[] data, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[data.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }

}
