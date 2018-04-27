package com.algoluo.sort;

import com.alibaba.fastjson.JSONObject;


/**
 * @author yongchun.luo@56qq.com
 * @version 创建时间：${date}.
 * @Description: 大小堆排序算法
 *
 * 概念
 *  最大堆：根结点的键值是所有堆结点键值中最大者，且每个结点的值都比其孩子的值大。
 *  最小堆：根结点的键值是所有堆结点键值中最小者，且每个结点的值都比其孩子的值小。
 *  堆序列化则为二叉树层级遍历
 *
 *
 * 算法流程
 * 1、构造大小堆
 * 2、循环调整堆
 *
 * 时间复杂度
 *  初始化建堆过程时间：O(n)
 *  更改堆元素后重建堆时间：O(nlogn)
 *
 */
public class HeapSort {
    public static void sort(Comparable[] data) {
        // 构建最大堆
        buildMaxHeap(data);
        System.out.println(JSONObject.toJSON(data));
        // 循环，每次把根节点和最后一个节点调换位置
        for (int i = data.length; i > 1; i--) {
            Comparable tmp = data[0];
            data[0] = data[i - 1];
            data[i - 1] = tmp;
            // 堆的长度减少1，排除置换到最后位置的根节点
            maxHeapify(data, 1, i - 1);
        }
    }

    // 根据输入数组构建一个最大堆
    private static void buildMaxHeap(Comparable[] data) {
        for (int i = data.length / 2; i > 0; i--) {
            maxHeapify(data, i, data.length);
        }
    }

    // 堆调整，使其生成最大堆
    private static void maxHeapify(Comparable[] data, int parentNodeIndex,
                                   int heapSize) {
        // 左子节点索引
        int leftChildNodeIndex = parentNodeIndex * 2;
        // 右子节点索引
        int rightChildNodeIndex = parentNodeIndex * 2 + 1;
        // 最大节点索引
        int largestNodeIndex = parentNodeIndex;
        // 如果左子节点大于父节点，则将左子节点作为最大节点
        if (leftChildNodeIndex <= heapSize
                && data[leftChildNodeIndex - 1]
                .compareTo(data[parentNodeIndex - 1]) > 0) {
            largestNodeIndex = leftChildNodeIndex;
        }
        // 如果右子节点比最大节点还大，那么最大节点应该是右子节点
        if (rightChildNodeIndex <= heapSize
                && data[rightChildNodeIndex - 1]
                .compareTo(data[largestNodeIndex - 1]) > 0) {
            largestNodeIndex = rightChildNodeIndex;
        }
        // 最后，如果最大节点和父节点不一致，则交换他们的值
        if (largestNodeIndex != parentNodeIndex) {
            Comparable tmp = data[parentNodeIndex - 1];
            data[parentNodeIndex - 1] = data[largestNodeIndex - 1];
            data[largestNodeIndex - 1] = tmp;
            // 交换完父节点和子节点的值，对换了值的子节点检查是否符合最大堆的特性
            maxHeapify(data, largestNodeIndex, heapSize);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {2, 3, 4, 5, 4, 5, 46, 5, 65, 3, 4, 34, 3, 4, 5, 4, 6, 5};
        sort(a);
        System.out.println(JSONObject.toJSON(a));
    }
}