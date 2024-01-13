package git.maninder.sort.impl;

import git.maninder.sort.Sort;

public class QuickSort implements Sort {
    @Override
    public void sort(int[] unsortedElements) {
        if (unsortedElements == null)
            return;

        sortOnPivot(unsortedElements, 0, unsortedElements.length - 1);
    }

    private void sortOnPivot(int[] unsortedElementsPartition, int partitionStart, int partitionEnd) {
        if (partitionStart >= partitionEnd)
            return;

        int pivotIndex = partitionByPivot(unsortedElementsPartition, partitionStart, partitionEnd);

        sortOnPivot(unsortedElementsPartition, 0, pivotIndex - 1);
        sortOnPivot(unsortedElementsPartition, pivotIndex + 1, partitionEnd);
    }

    private int partitionByPivot(int[] unsortedElementsPartition, int partitionStart, int partitionEnd) {
        int pivotElement = unsortedElementsPartition[partitionEnd];
        int pivotElementIndexLocator = partitionStart;

        for (int unsortedElementsPartitionIndex = partitionStart;
            unsortedElementsPartitionIndex <= partitionEnd;
            unsortedElementsPartitionIndex++)
        {
            if (unsortedElementsPartition[unsortedElementsPartitionIndex] <= pivotElement)
            {
                swapElements(unsortedElementsPartition,
                        unsortedElementsPartitionIndex,
                        pivotElementIndexLocator);

                if (unsortedElementsPartitionIndex == partitionEnd)
                    break;

                pivotElementIndexLocator++;
            }
        }

        return pivotElementIndexLocator;
    }
}