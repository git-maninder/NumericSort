package git.maninder.sort;

public interface Sort {
    public void sort(int[] unsortedElements);

    default void swapElements(int[] elements, int sourceIndex, int destinationIndex)
    {
        int swapValue = elements[sourceIndex];
        elements[sourceIndex] = elements[destinationIndex];
        elements[destinationIndex] = swapValue;
    }
}
