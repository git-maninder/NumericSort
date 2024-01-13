package git.maninder.sort;

import git.maninder.sort.factory.SortFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortTest {

    static int[] unsortedElements = {90, 40, 6, 2, 1, 5, 63, 87, 200, 4, 67, 6};
    private final SortFactory sortFactory = new SortFactory();

    @BeforeEach
    public void resetElements()
    {
        unsortedElements = new int[] {90, 40, 6, 2, 1, 5, 63, 87, 200, 4, 67, 6};
    }

    @Test
    public void whenMergeSortIsUsedElementsAreSorted()
    {
        Sort mergeSort = sortFactory.getSorter(SortType.MERGE_SORT);
        mergeSort.sort(unsortedElements);

        int[] expectedResult = {1, 2, 4, 5, 6, 6, 40, 63, 67, 87, 90, 200};
        Assertions.assertArrayEquals(expectedResult, unsortedElements, "Error in merge sort!");
    }

    @Test
    public void whenQuickSortIsUsedElementsAreSorted()
    {
        Sort quickSort = sortFactory.getSorter(SortType.QUICK_SORT);
        quickSort.sort(unsortedElements);

        int[] expectedResult = {1, 2, 4, 5, 6, 6, 40, 63, 67, 87, 90, 200};
        Assertions.assertArrayEquals(expectedResult, unsortedElements, "Error in quick sort!");
    }

    @Test
    public void whenHeapSortIsUsedElementsAreSorted()
    {
        Sort heapSort = sortFactory.getSorter(SortType.HEAP_SORT);
        heapSort.sort(unsortedElements);

        int[] expectedResult = {1, 2, 4, 5, 6, 6, 40, 63, 67, 87, 90, 200};
        Assertions.assertArrayEquals(expectedResult, unsortedElements, "Error in heap sort!");
    }
}
