package sorting;

public final class Sort_7 extends ArrayPI_7{
    public int[] sortDec(int[] masiv_sort){
        int temp = 0;
        for(int i = 0; i < masiv_sort.length; i++) {
            for (int j = 1; j < masiv_sort.length - i; j++) {
                if (masiv_sort[j - 1] < masiv_sort[j]) {
                    temp = masiv_sort[j];
                    masiv_sort[j] = masiv_sort[j - 1];
                    masiv_sort[j - 1] = temp;
                }
            }
        }
        return masiv_sort;
    }

    public int[] sortInc(int[] masiv_sort){
        int temp = 0;
        for(int i = 0; i < masiv_sort.length; i++) {
            for (int j = 1; j < masiv_sort.length - i; j++) {
                if (masiv_sort[j - 1] > masiv_sort[j]) {
                    temp = masiv_sort[j - 1];
                    masiv_sort[j - 1] = masiv_sort[j];
                    masiv_sort[j] = temp;
                }
            }
        }
        return masiv_sort;
    }
}
