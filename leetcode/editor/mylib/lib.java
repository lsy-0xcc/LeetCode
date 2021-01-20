package editor.mylib;

public class lib {
    public int biSearch(int[] array, int begin, int end, int target) {
        if (begin < 0 || end < 0 || begin >= array.length || end >= array.length) {
            return -1;
        }
        if (target < array[begin] || array[end] < target) {
            return -1;
        }

        int diff = end - begin;
        if (diff < 0) {
            return -1;
        } else if (diff == 0) {
            if (array[begin] == target) {
                return begin;
            }
        } else if (diff == 1) {
            if (array[end] == target) {
                return end;
            } else if (array[begin] == target) {
                return begin;
            }
        } else {
            int middle = (begin + end) / 2;
            if (target <= array[middle]) {
                return biSearch(array, begin, middle, target);
            } else {
                return biSearch(array, middle+1,end,target);
            }
        }
        return -1;
    }
}
