package git.maninder.sort.impl;

import git.maninder.sort.Sort;

public class MergeSort implements Sort {
    @Override
    public void sort(int[] unsortedElements) {
        if (unsortedElements == null || unsortedElements.length <= 1) return;

        int[] leftPartition = partitionLeft(unsortedElements);
        int[] rightPartition = partitionRight(unsortedElements);

        sort(leftPartition);
        sort(rightPartition);

        merge(unsortedElements, leftPartition, rightPartition);
    }

    private int[] partitionLeft(int[] unsortedElements) {
        int leftPartitionSize = unsortedElements.length / 2;
        int[] leftPartition = new int[leftPartitionSize];

        System.arraycopy(unsortedElements, 0, leftPartition, 0, leftPartitionSize);
        return leftPartition;
    }

    private int[] partitionRight(int[] unsortedElements) {
        int leftPartitionSize = unsortedElements.length / 2;
        int rightPartitionSize = unsortedElements.length - leftPartitionSize;
        int[] rightPartition = new int[rightPartitionSize];

        System.arraycopy(unsortedElements, leftPartitionSize, rightPartition, 0, rightPartitionSize);
        return rightPartition;
    }

    private void merge(int[] unsortedElements, int[] leftPartition, int[] rightPartition) {
        int leftPartitionIndex = 0;
        int rightPartitionIndex = 0;
        boolean isLeftPartitionCopied = false;
        boolean isRightPartitionCopied = false;

        for (int unsortedElementsIndex = 0; unsortedElementsIndex < unsortedElements.length;
            unsortedElementsIndex++)
        {
            if (isRightPartitionCopied || (!isLeftPartitionCopied &&
                    leftPartition[leftPartitionIndex] < rightPartition[rightPartitionIndex])) {
                unsortedElements[unsortedElementsIndex] = leftPartition[leftPartitionIndex++];
                isLeftPartitionCopied = leftPartitionIndex == leftPartition.length;
            }
            else {
                unsortedElements[unsortedElementsIndex] = rightPartition[rightPartitionIndex++];
                isRightPartitionCopied = rightPartitionIndex == rightPartition.length;
            }
        }
    }
}