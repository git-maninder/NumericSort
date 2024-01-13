package git.maninder.sort.impl;

import git.maninder.sort.Sort;

public class HeapSort implements Sort {
    @Override
    public void sort(int[] unsortedElements) {
        if (unsortedElements == null ||
            unsortedElements.length == 1)
            return;

        int elementCount = unsortedElements.length;

        buildInArrayHeap(unsortedElements, elementCount);

        while(elementCount > 1)
        {
            swapElements(unsortedElements, 0, elementCount - 1);
            elementCount--;
            heapifyElements(unsortedElements, elementCount, 0);
        }
    }

    private void buildInArrayHeap(int[] unsortedElements, int elementCount) {
        for (int parentNodeIndex = elementCount / 2;
            parentNodeIndex >= 0; parentNodeIndex--)
            heapifyElements(unsortedElements, elementCount, parentNodeIndex);
    }

    private void heapifyElements(int[] unsortedElements, int elementCount, int parentNodeIndex) {
        int leftNodeIndex = parentNodeIndex * 2 + 1;
        int rightNodeIndex = parentNodeIndex * 2 + 2;

        int greaterValueIndex = parentNodeIndex;

        if (leftNodeIndex < elementCount &&
            unsortedElements[leftNodeIndex] > unsortedElements[greaterValueIndex])
            greaterValueIndex = leftNodeIndex;
        if (rightNodeIndex < elementCount &&
                unsortedElements[rightNodeIndex] > unsortedElements[greaterValueIndex])
            greaterValueIndex = rightNodeIndex;

        if (greaterValueIndex != parentNodeIndex)
        {
            swapElements(unsortedElements, greaterValueIndex, parentNodeIndex);
            heapifyElements(unsortedElements, elementCount, greaterValueIndex);
        }
    }
}
