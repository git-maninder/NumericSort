package git.maninder.sort.factory;

import git.maninder.sort.Sort;
import git.maninder.sort.SortType;
import git.maninder.sort.impl.HeapSort;
import git.maninder.sort.impl.MergeSort;
import git.maninder.sort.impl.QuickSort;

public class SortFactory
{
    public Sort getSorter(SortType sortType)
    {
        if (sortType == SortType.MERGE_SORT)
            return new MergeSort();
        else if (sortType == SortType.QUICK_SORT)
            return new QuickSort();
        else if (sortType == SortType.HEAP_SORT)
            return new HeapSort();

        throw new IllegalArgumentException("SortType " +  sortType + " not supported");
    }
}