package com.algoluo.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @author yongchun.luo@56qq.com
 * @version 创建时间：${date}.
 * @Description: 快速排序算法
 * 算法流程
 * 1、选择左边第一个元素作为基准 temp，所有元素为一个分区
 * 2、所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面。
 * 3、将分区，一分为二 此时左边分区全部比右边分区小已完成一次分区有序
 * 4、循环1-3，将每个分区都实现有序
 *
 * 时间复杂度
 * 最好情况：nlgn,最坏情况：1/2*n^2
 * 严格证明很难
 *  理解：若每次都五五平分 则会有lgn次分区，每次分区排序复杂度为n
 *
 */
public class QuickSort {

    public static void quickSort(int[] a, int left, int right) {
        // 结束迭代
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = a[left];// 设置基准值，将最左端元素作为基准值
        while (i != j) {
            // 往左移位，直到大于temp
            while (i < j && a[j] >= temp) {
                j--;
            }
            // 往右移位，直到小于temp
            while (i < j && a[i] <= temp) {
                i++;
            }
            if (i < j) {
                // 交换彼此的数据
                int tt = a[i];
                a[i] = a[j];
                a[j] = tt;
            }
        }
        // 交换基位数据
        int kk = a[i];
        a[i] = temp;
        a[left] = kk;
        System.out.println(JSONObject.toJSON(a));
        System.out.println(i+" "+j);
        // 下一次迭代 此时 i j 都为一样大 为基准下标-1
        quickSort(a, left, i - 1);// 左半边
        quickSort(a, j + 1, right);// 右半边
    }

    public static void main (String args[]){
        int[] a = {20,17,15,10,25,27,30};
        quickSort(a,0,a.length-1);
    }
}
