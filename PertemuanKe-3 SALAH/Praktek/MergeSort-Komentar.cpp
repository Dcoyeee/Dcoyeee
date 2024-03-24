// Program ini mengimplementasikan algoritma Merge Sort untuk 
//mengurutkan array integer secara descending (dari besar ke kecil)

#include <iostream>
using namespace std;

// Fungsi print digunakan untuk menampilkan array dalam tanda kurung siku
void print(int aww[], int sizedani) {
   for (int i = 0; i < sizedani; i++) {
       cout << aww[i];
       if (i < sizedani - 1) cout << ", ";
   }
   cout << "]" << endl;
}

// Fungsi mrg digunakan untuk menggabungkan dua sub-array yang sudah terurut
// ke dalam satu array yang terurut
void mrg(int ar[], int low, int mid, int high, int& comparisons, int& mov) {
   int ls = mid - low + 1; // Ukuran sub-array kiri
   int rs = high - mid; // Ukuran sub-array kanan

   int l[ls]; // Array sementara untuk sub-array kiri
   int r[rs]; // Array sementara untuk sub-array kanan

   // Menyalin elemen-elemen dari sub-array kiri ke array sementara l
   for (int i = 0; i < ls; i++) {
       l[i] = ar[low + i];
       mov++;
   }

   // Menyalin elemen-elemen dari sub-array kanan ke array sementara r
   for (int j = 0; j < rs; j++) {
       r[j] = ar[mid + 1 + j];
       mov++;
   }

   int i = 0, j = 0, k = low; // Indeks untuk iterasi

   // Menggabungkan dua sub-array terurut ke dalam array utama
   while (i < ls && j < rs) {
       comparisons++;
       if (l[i] >= r[j]) { // Mengurutkan secara descending
           ar[k] = l[i];
           i++;
       } else {
           ar[k] = r[j];
           j++;
       }
       k++;
       mov++;
   }

   // Menangani elemen-elemen yang tersisa di sub-array kiri
   while (i < ls) {
       ar[k] = l[i];
       i++;
       k++;
       mov++;
   }

   // Menangani elemen-elemen yang tersisa di sub-array kanan
   while (j < rs) {
       ar[k] = r[j];
       j++;
       k++;
       mov++;
   }
}

// Fungsi ms mengimplementasikan algoritma Merge Sort secara rekursif
void ms(int aww[], int low, int high, int& comparisons, int& movements) {
   if (low < high) {
       int mid = low + (high - low) / 2; // Mencari indeks tengah

       // Memecah array menjadi dua sub-array
       cout << "Memecah List [";
       print(aww + low, mid - low + 1);
       ms(aww, low, mid, comparisons, movements); // Merge Sort pada sub-array kiri

       cout << "Memecah List [";
       print(aww + mid + 1, high - mid);
       ms(aww, mid + 1, high, comparisons, movements); // Merge Sort pada sub-array kanan

       cout << "Menggabungkan List [";
       print(aww + low, high - low + 1);
       mrg(aww, low, mid, high, comparisons, movements); // Menggabungkan dua sub-array terurut
   }
}

int main() {
   int data[100], sizedani;
   int comparisons = 0, movements = 0; // Variabel untuk menghitung jumlah perbandingan dan perpindahan

   cout << "Masukan 10 elemen : ";
   for (int i = 0; i < 10; i++) {
       cin >> data[i]; // Meminta input 10 elemen dari pengguna
   }

   system("cls"); // Membersihkan layar

   cout << "Data awal: [";
   for (int i = 0; i < 10; i++) {
       cout << data[i];
       if (i < 10 - 1) cout << ", ";
   }
   cout << "]" << endl;

   ms(data, 0, 10 - 1, comparisons, movements); // Memanggil Merge Sort pada array data

   cout << "\nData terurut secara descending: [";
   for (int i = 0; i < 10; i++) {
       cout << data[i];
       if (i < 10 - 1) cout << ", ";
   }
   cout << "]" << endl;
   
   return 0; 
}
