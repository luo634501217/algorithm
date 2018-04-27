package com.algoluo.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @author yongchun.luo@56qq.com
 * @version 创建时间：${date}.
 * @Description: 快速排序算法
 */
public class QuickSort {

    public static void quickSort(int[] a, int left, int right) {
        // 结束迭代
        if (left > right) {
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
        // 下一次迭代
        quickSort(a, left, i - 1);// 左半边
        quickSort(a, j + 1, right);// 右半边
    }

    public static void main (String args[]){
        int[] a = {212,232,34,122,454,2431,1,232,22};
        quickSort(a,0,a.length-1);
    }
}
