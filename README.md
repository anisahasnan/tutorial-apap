# Tutorial APAP

## Authors

* **Anisa Hasna Nabila** - *1806146865* - *A*

## Tutorial 1

### What I have learned today

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
   Issue Tracker adalah sebuah *software* yang dapat digunakan oleh pengguna untuk melaporkan masalah yang dialami. Issue Tracker ini nantinya akan mencatat masalah tersebut dan dilaporkan kepada *support agents* atau tim *developer* untuk dilacak hingga masalah berhasil diselesaikan. Pengguna juga dapat melihat perkembangan penyelesaian masalah yang sudah dilaporkan dan penanggung jawab melalui Issue Tracker. Issue tracker ini juga sering disebut sebagai **Bug Tracking System**. Masalah yang dapat ditangani oleh Issue Tracker meliputi masalah-masalah yang dialami pengguna ketika menggunakan sistem mulai dari masalah dengan tingkat urgensi tinggi hingga rendah seperti masalah *login*, pengunduhan data, bug-bug minor di beberapa bagian sistem, dan lain-lain.
2. Apa perbedaan dari git merge dan git merge --squash?
   Git merge akan mem-*push* semua commit yang ada pada *branch* asal ke *branch* tujuan. Sedangkan, git merge --squash akan mengemas semua *commit* yang ada di *branch* asal menjadi satu *commit* besar baru kemudian di *push* ke *branch* tujuan. Git merge --squash ini berfungsi untuk menghilangkan *commit-commit* yang tidak terlalu penting dengan menjadikannya satu *commit* dengan maksud yang sama.
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
   - Automatisasi backup file
   - Memantau perkembangan dari pembangunan sebuah aplikasi
   - Ketika ada anggota baru yang bergabung dalam  tim *development*, mereka dapat dengan mudah mengunduh versi terbaru dari aplikasi yang sedang dikembangkan melalui Version Control System menuju *local environment* mereka
   - Dapat dengan mudah membandingkan versi aplikasi saat ini dengan sebelumnya ketika muncul masalah
   - Membuat pekerjaan dalam pengembangan aplikasi dilakukan secara bersamaan


### Spring
4. Apa itu library & dependency?
   **Library** adalah kumpulan dari kode yang sudah di-*compile* dan memiliki fungsionalitas, serta dapat digunakan pada program komputer. Library ini dapat terdiri dari *functions*, *object*, dokumentasi, dan lain-lain. Sebuah code library yang digunakan pada suatu program komputer disebut sebagai **dependency** dari program komputer tersebut. Dependency dapat disebut juga sebagai hubungan antara dua kode.
5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
   - Maven lebih mudah digunakan untuk pemula karena hanya memerlukan konfigurasi minimal
   - Maven dapat secara otomatis menambah dependencies yang dibutuhkan hanya dengan membaca POM file
   - Build system Maven yang terstandardisasi
   - Dapat melakukan *multiple build* di saat yang bersamaan
   Alternatif lain yang dapat digunakan selain Maven antara lain Gradle, Jenkins, Jira, Ant, dan lain-lain.
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
   - Berkomunikasi dengan database seperti Oracle, MySQL, MongoDB, dan Redis
   - Melakukan pekerjaan dengan jangka waktu yang panjang seperti melakukan perintah SQL yang mengupdate jutaan baris *database*
   - Membuat *test*
   - Mengubah aplikasi menjadi sesuatu yang *executable*
   - Mengintegrasi media sosial (Facebook, Twitter, dll) dengan aplikasi yang sedang dikembangkan
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
   @RequestParam dan @PathVariable memiliki tujuan yang sama yaitu mengakses *value* dari *request*. Perbedaanya adalah pada dimana *value* dari *request* tersebut akan dibaca. 
   - @RequestParam mengakses/membaca *value* pada QueryParameters (segala sesuatu setelah tanda ?) dari *URI call/request*. Contohnya adalah localhost:8080/hitung-bmi?height=178&weight=70 dimana *value* diambil dari value pada masing-masing key weight dan height. @RequestParam lebih baik digunakan pada website tradisonal yang umumnya mem-*passing* data melalui ***query abatements***
   - @PathVariable mengakses/membaca *value* pada pola *URI call/request*. Contohnya adalah localhost:8080/hitung-bmi/178/70 dimana pola dari *request* adalah hitung-bmi/tinggi badan/berat badan. @PathVariable lebih baik digunakan pada **RESTful web services** dimana URL mengandung *values*.


### What I did not understand
- [ ] Kenapa saya harus belajar APAP?
- [ ] Kenapa akun github saya yang sebelumnya tidak dapat digunakan?