class Client {
    String name;
    int riskScore;
    double balance;

    Client(String n, int r, double b) {
        name = n;
        riskScore = r;
        balance = b;
    }
}

public class week3and4 {

    static void bubbleSort(Client[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].balance < key.balance))) {

                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Client[] arr = {
                new Client("A", 20, 1000),
                new Client("B", 50, 2000),
                new Client("C", 80, 1500)
        };

        bubbleSort(arr);
        insertionSort(arr);

        for (Client c : arr) {
            System.out.println(c.name + " " + c.riskScore);
        }
    }
}