#include <iostream>
using namespace std;

void print(int aww[], int sizedani) {
    for (int i = 0; i < sizedani; i++) {
        cout << aww[i];
        if (i < sizedani - 1) cout << ", ";
    }
    cout << "]" << endl;
}

void mrg(int ar[], int low, int mid, int high, int& comparisons, int& mov) {
    int ls = mid - low + 1;
    int rs = high - mid;
    int l[ls];
    int r[rs];

    for (int i = 0; i < ls; i++) {
        l[i] = ar[low + i];
        mov++;
    }

    for (int j = 0; j < rs; j++) {
        r[j] = ar[mid + 1 + j];
        mov++;
    }

    int i = 0, j = 0, k = low;

    while (i < ls && j < rs) {
        comparisons++;
        if (l[i] <= r[j]) { // Perubahan di sini untuk mengurutkan secara descending
            ar[k] = r[j];
            j++;
        } else {
            ar[k] = l[i];
            i++;
        }
        k++;
        mov++;
    }

    while (i < ls) {
        ar[k] = l[i];
        i++;
        k++;
        mov++;
    }

    while (j < rs) {
        ar[k] = r[j];
        j++;
        k++;
        mov++;
    }
}

void ms(int aww[], int low, int high, int& comparisons, int& movements) {
    if (low < high) {
        int mid = low + (high - low) / 2;
        cout << "Memecah List [";
        print(aww + low, mid - low + 1);
        ms(aww, low, mid, comparisons, movements);
        cout << "Memecah List [";
        print(aww + mid + 1, high - mid);
        ms(aww, mid + 1, high, comparisons, movements);
        cout << "Menggabungkan List [";
        print(aww + low, high - low + 1);
        mrg(aww, low, mid, high, comparisons, movements);
    }
}

int main() {
    int data[100], sizedani;
    int comparisons = 0, movements = 0;

    cout << "Masukan 10 elemen : ";
    for (int i = 0; i < 10; i++) {
        cin >> data[i];
    }

    system("cls");

    cout << "Data awal: [";
    for (int i = 0; i < 10; i++) {
        cout << data[i];
        if (i < 10 - 1) cout << ", ";
    }
    cout << "]" << endl;

    ms(data, 0, 10 - 1, comparisons, movements);

    cout << "\nData terurut secara descending: [";
    for (int i = 0; i < 10; i++) {
        cout << data[i];
        if (i < 10 - 1) cout << ", ";
    }
    cout << "]" << endl;
    
    return 0;
}
