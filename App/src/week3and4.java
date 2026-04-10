import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String n, double r, double v) {
        name = n;
        returnRate = r;
        volatility = v;
    }
}

public class week3and4 {

    static void quickSort(Asset[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    static int partition(Asset[] arr, int l, int r) {
        Asset pivot = arr[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (arr[j].returnRate > pivot.returnRate ||
                    (arr[j].returnRate == pivot.returnRate &&
                            arr[j].volatility < pivot.volatility)) {

                i++;
                Asset t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        Asset t = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = t;

        return i + 1;
    }

    public static void main(String[] args) {

        Asset[] arr = {
                new Asset("AAPL", 12, 5),
                new Asset("TSLA", 8, 7),
                new Asset("GOOG", 15, 4)
        };

        quickSort(arr, 0, arr.length - 1);

        for (Asset a : arr) {
            System.out.println(a.name + " " + a.returnRate);
        }
    }
}