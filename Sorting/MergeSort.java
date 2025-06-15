public class MergeSort {

    public static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] leftarr = new int[n1];
        int[] rightarr = new int[n2];

        for(int i = 0; i < n1; i++) {
            leftarr[i] = arr[l + i];
        }
        for(int j = 0; j < n2; j++) {
            rightarr[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(leftarr[i] <= rightarr[j]){
                arr[k] = leftarr[i];
                i++;
            } else {
                arr[k] = rightarr[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = leftarr[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = rightarr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original array:");
        for(int num : arr){
            System.out.print(num + " ");
        }

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array:");
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
