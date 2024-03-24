	// Program ini mengimplementasikan algoritma Quick Sort untuk mengurutkan array integer secara descending (dari besar ke kecil)

#include <iostream>
#include <algorithm>
using namespace std;

// Fungsi part digunakan untuk melakukan partisi pada array
// dengan memilih pivot terakhir dan memindahkan elemen-elemen
// yang lebih besar dari pivot ke bagian kiri, dan yang lebih kecil ke bagian kanan
int part(int ar[], int lowdani, int highfahdlu) {
   int pivot = ar[highfahdlu]; // Pivot dipilih sebagai elemen terakhir
   int a = lowdani - 1; // Inisialisasi indeks pemisah

   // Lakukan partisi dengan memindahkan elemen lebih besar dari pivot
   // ke bagian kiri, dan yang lebih kecil ke bagian kanan
   for (int j = lowdani; j < highfahdlu; j++) {
       if (ar[j] < pivot) { // Perubahan di sini untuk mengurutkan secara descending
           a++;
           swap(ar[a], ar[j]);
       }
   }

   // Tempatkan pivot pada posisi yang tepat
   swap(ar[a + 1], ar[highfahdlu]);

   // Kembalikan indeks pivot
   return a + 1;
}

// Fungsi qs mengimplementasikan algoritma Quick Sort secara rekursif
void qs(int rr[], int lowdani, int highfahdlu) {
   if (lowdani < highfahdlu) {
       // Lakukan partisi dan temukan pivot
       int pi = part(rr, lowdani, highfahdlu);

       // Tampilkan array pada setiap langkah partisi
       cout << "[ ";
       for (int a = 0; a < 10; a++) {
           cout << rr[a] << " ";
       }
       cout << " ]";
       cout << endl;

       // Lakukan Quick Sort secara rekursif pada sub-array kiri dan kanan
       qs(rr, lowdani, pi - 1);
       qs(rr, pi + 1, highfahdlu);
   }
}

int main() {
   int ar[100];

   // Meminta input 10 data dari pengguna
   cout << "masukkan 10 data: [ ";
   for (int a = 0; a < 10; a++) {
       cin >> ar[a];
   }
   cout << "]" << endl;

   // Membersihkan layar
   system("cls");

   // Menampilkan data yang akan diurutkan
   cout << "Data yang akan di sort : [ ";
   for (int a = 0; a < 10; a++) {
       cout << ar[a] << " ";
   }
   cout << "]" << endl << endl;

   cout << "Quick Sort: " << endl;

   // Memanggil fungsi Quick Sort
   qs(ar, 0, 10 - 1);

   return 0;
}
