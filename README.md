# Tutorial APAP

## Authors

* **Anisa Hasna Nabila** - *1806146865* - *A*

## Tutorial 1

### What I have learned today

### Github
1. **Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?**
   Issue Tracker adalah sebuah *software* yang dapat digunakan oleh pengguna untuk melaporkan masalah yang dialami. Issue Tracker ini nantinya akan mencatat masalah tersebut dan dilaporkan kepada *support agents* atau tim *developer* untuk dilacak hingga masalah berhasil diselesaikan. Pengguna juga dapat melihat perkembangan penyelesaian masalah yang sudah dilaporkan dan penanggung jawab melalui Issue Tracker. Issue tracker ini juga sering disebut sebagai **Bug Tracking System**. Masalah yang dapat ditangani oleh Issue Tracker meliputi masalah-masalah yang dialami pengguna ketika menggunakan sistem mulai dari masalah dengan tingkat urgensi tinggi hingga rendah seperti masalah *login*, pengunduhan data, bug-bug minor di beberapa bagian sistem, dan lain-lain.

2. **Apa perbedaan dari git merge dan git merge --squash?**
   Git merge akan mem-*push* semua commit yang ada pada *branch* asal ke *branch* tujuan. Sedangkan, git merge --squash akan mengemas semua *commit* yang ada di *branch* asal menjadi satu *commit* besar baru kemudian di *push* ke *branch* tujuan. Git merge --squash ini berfungsi untuk menghilangkan *commit-commit* yang tidak terlalu penting dengan menjadikannya satu *commit* dengan maksud yang sama.

3. **Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?**
   - Automatisasi backup file
   - Memantau perkembangan dari pembangunan sebuah aplikasi
   - Ketika ada anggota baru yang bergabung dalam  tim *development*, mereka dapat dengan mudah mengunduh versi terbaru dari aplikasi yang sedang dikembangkan melalui Version Control System menuju *local environment* mereka
   - Dapat dengan mudah membandingkan versi aplikasi saat ini dengan sebelumnya ketika muncul masalah
   - Membuat pekerjaan dalam pengembangan aplikasi dilakukan secara bersamaan


### Spring
4. **Apa itu library & dependency?**
   **Library** adalah kumpulan dari kode yang sudah di-*compile* dan memiliki fungsionalitas, serta dapat digunakan pada program komputer. Library ini dapat terdiri dari *functions*, *object*, dokumentasi, dan lain-lain. Sebuah code library yang digunakan pada suatu program komputer disebut sebagai **dependency** dari program komputer tersebut. Dependency dapat disebut juga sebagai hubungan antara dua kode.

5. **Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?**
   - Maven lebih mudah digunakan untuk pemula karena hanya memerlukan konfigurasi minimal
   - Maven dapat secara otomatis menambah dependencies yang dibutuhkan hanya dengan membaca POM file
   - Build system Maven yang terstandardisasi
   - Dapat melakukan *multiple build* di saat yang bersamaan
   Alternatif lain yang dapat digunakan selain Maven antara lain Gradle, Jenkins, Jira, Ant, dan lain-lain.

6. **Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?**
   - Berkomunikasi dengan database seperti Oracle, MySQL, MongoDB, dan Redis
   - Melakukan pekerjaan dengan jangka waktu yang panjang seperti melakukan perintah SQL yang mengupdate jutaan baris *database*
   - Membuat *test*
   - Mengubah aplikasi menjadi sesuatu yang *executable*
   - Mengintegrasi media sosial (Facebook, Twitter, dll) dengan aplikasi yang sedang dikembangkan

7. **Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?**
   @RequestParam dan @PathVariable memiliki tujuan yang sama yaitu mengakses *value* dari *request*. Perbedaanya adalah pada dimana *value* dari *request* tersebut akan dibaca. 
   - @RequestParam mengakses/membaca *value* pada QueryParameters (segala sesuatu setelah tanda ?) dari *URI call/request*. Contohnya adalah localhost:8080/hitung-bmi?height=178&weight=70 dimana *value* diambil dari value pada masing-masing key weight dan height. @RequestParam lebih baik digunakan pada website tradisonal yang umumnya mem-*passing* data melalui ***query abatements***
   - @PathVariable mengakses/membaca *value* pada pola *URI call/request*. Contohnya adalah localhost:8080/hitung-bmi/178/70 dimana pola dari *request* adalah hitung-bmi/tinggi badan/berat badan. @PathVariable lebih baik digunakan pada **RESTful web services** dimana URL mengandung *values*.


### What I did not understand
- [ ] Kenapa saya harus belajar APAP?
- [ ] Kenapa akun github saya yang sebelumnya tidak dapat digunakan?


## Tutorial 2

1. **Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut: http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi**
Muncul halaman Whitelabel Error Page. Hal ini dikarenakan view/file html yang sudah dicantumkan pada Controller "add-hotel" belum dibuat.

2. **Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat**
Menurut saya, anotasi `@Autowired` pada class Controller merupakan implementasi dari Inversion of Control (IoC). Anotasi `@Autowired` ini memungkinkan Spring untuk me-*resolve* dan meng-*inject beans* yang berhubungan dengan *bean* lain. Anotasi `@Autowired` sebelum properties `hotelService`. Maka, selama *startup process* Spring Container akan mencari class yang meng-*implement interface* `HotelService` dan menginject class tersebut, dalam hal ini class `HotelInMemoryService`, ke `HotelController`. Hal inilah yang memungkinkan class `HotelController` dapat menggunakan method-method yang ada pada class `HotelInMemoryService`.

3. **Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut: http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**
Muncul halaman Whitelabel Error Page. Hal ini dikarenakan teradpat salah satu request parameter yang belum dipenuhi, yaitu noTelepon. Parameter noTelepon wajib dicantumkan pada URL untuk menambahkan hotel karena value dari label required pada noTelepon adalah true. Jika parameter noTelepon tidak dicantumkan, maka akan muncul Error.

4. **Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus diakses?**
http://localhost:8080/hotel/view?idHotel=1

5. **Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/hotel/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu**
Saya menambahkan 1 hotel lain melalui link berikut http://localhost:8080/hotel/add?idHotel=2&namaHotel=Mama%20APAP&alamat=Tarung%20Fasilkom&noTelepon=082xxx .Setelah mengakses viewall, halaman berisi seluruh hotel yang terdapat di dalam list akan dimunculkan. Semua informasi mengenai hotel pun akan ditampilkan seperti nama hotel, id hotel, alamat, dan no telepon. Berikut screenshoot halaman viewall dapat dibuka di link https://ibb.co/kg8HSr8

## Tutorial 3

1. **Pada class KamarDb, terdapat method findByHotelId, apakah kegunaan dari method tersebut?**
Method findByHotelId merupakan sebuah query method untuk KamarDb. Query method ini  dibuat menggunakan API kriteria JPA. Kode berikut,
`List<KamarModel> findByHotelId(Long hotelId);` dapat diterjemahkan dalam bentuk SQL statement menjadi `select k from KamarModel k where k.hotelId = ?1`. Kegunaan dari method findByHotelId adalah mengambil semua kamar yang memiliki hotelId sesuai dengan parameter kemudian memasukkannya ke dalam List.
2. **Pada class HotelController, jelaskan perbedaan method addHotelFormPage dan addHotelSubmit?**
Method addHotelFormPage digunakan untuk membuat HotelModel dan me-render form add hotel untuk memasukkan informasi-informasi yang dibutuhkan dalam membuat HotelModel seperti Nama Hotel, Alamat Hotel, dan Nomor Telepon Hotel.
Method addHotelSubmit digunakan untuk menyimpan HotelModel yang sudah dibuat dan diisi informasinya menggunakan form pada method addHotelFormPage ke dalam database. Method addHotelSubmit juga digunakan untuk meng-generate id untuk HotelModel tersebut. 
3. **Jelaskan kegunaan dari JPA Repository!**
JPA adalah cara untuk mempertahankan Java Object ke dalam database relasional. JPA dapat melakukan mapping Class ke database relasional serta API EntityManager untuk mengakses object, mendefinisikan dan mengeksekusi query seperti menyimpan, mengupdate, mendelete, dan mengambil data dari database relasional ke Java Object, serta masih banyak lagi. JPA mengizinkan developer untuk bekerja langsung dengan Object dibandingkan dengan SQL statement. Beberapa method yang terdapat pada JPA Repository antara lain,
- deleteAllInBatch() untuk menghapus semua entity pada batch call
- findAll() untuk mendapat semua isi repository
- findAllById(Iterable<ID> ids) untuk mendapat semua isi repository yang berkaitan dengan id
- flush() untuk memflush semua perubahan yang tertunda ke database
- getOne(ID id) untuk mendapatkan sebuah entity dengan id tersebut
4. **Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat?**
Pada class KamarModel, di bagian kode berikut
`@ManyToOne(fetch = FetchType.EAGER, optional = false)
 @JoinColumn(name = "hotelId", referencedColumnName = "id", nullable = false)
 @OnDelete(action = OnDeleteAction.CASCADE)
 @JsonIgnore
 private HotelModel hotel;`
 Pada bagian ini, diinisiasi sebuah relasi antara KamarModel dan HotelModel yang memiliki relasi ManyToOne, artinya Banyak KamarModel terhubung dengan Satu HotelModel. Attribute pada HotelModel yang menjadi reference key pada KamarModel adalah "id" yang dinamai "hotelId" pada KamarModel dan tidak boleh bernilai null.
5. **Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER!**
- FetchType.EAGER berfungsi untuk meload sekaligus menyimpan pada memori semua data yang berhubungan dengan class relasi di saat yang sama dengan kita meload data pada class terkait. Tipe fetch ini biasanya digunakan untuk tipe relasi AlltoOne. Seperti pada contoh di class KamarModel di bawah,
`@ManyToOne(fetch = FetchType.EAGER, optional = false)
 @JoinColumn(name = "hotelId", referencedColumnName = "id", nullable = false)
 @OnDelete(action = OnDeleteAction.CASCADE)
 @JsonIgnore
 private HotelModel hotel;`
 Ketika kita meload data kamar, data mengenai hotel yang berhubungan dengan kamar teresbut akan ikut terload dan tersimpan ke dalam memory.
- FetchType.LAZY berfungsi untuk meload data yang berhubungan dengan class relasi hanya jika dibutuhkan atau kita secara eksplisit memanggilnya. Tipe fetch ini biasanya digunakan untuk tipe relasi AlltoMany. Seperti pada contoh di class HotelModel di bawah,
`@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
 private List<KamarModel> listKamar;`
 Ketika kita meload data hotel, data mengenai kamar yang berhubungan dengan hotel tersebut hanya akan terload ketika kita memanggilnya secara eksplisit dengan findAllKamarByIdHotel().
- CascadeType.ALL berfungsi untuk mem-propagate semua operasi EntityManager seperti `PERSIST, REMOVE, REFRESH, MERGE, DETACH` pada entity terkait. Pada sisi ManyToOne, CascadeType.ALL akan mem-propagate dari Parent entity sampai Child entity.

## Tutorial 4

1. **Jelaskan perbedaan th:include dan th:replace!**
   Pada `th:include`, konten-konten yang berada di dalam fragment akan dimasukkan ke dalam body dari host tag. Sedangkan, pada `th:replace`, host tag saat ini akan digantikan dengan tag lain yang mendefinisikan fragment.
2. **Jelaskan apa fungsi dari th:object!**
   `th:object` digunakan untuk menampung object yang akan digunakan oleh data formulir. ketika form disubmit, value yang diisi pada `th:object` akan dipost menuju controller. 
3. **Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?**
   - simbol `$` digunakan untuk memilih object yang dioper dari controller untuk digunakan pada html. simbol `$` dipakai ketika ada object yang dioper oleh controller. 
   - simbol `*` digunakan untuk mengambil properties dari object yang sudah didefinisikan terlebih dahulu pada th:objcet. simbol `*` digunakan ketika sudah ada object yang didefinisikan pada th:objcet.
4. **Bagaimana kamu menyelesaikan latihan nomor 3?**
   Untuk menyelesaikan latihan nomor 3, saya menggunakan konsep parameter inclusion. Pada fragments.html, saya menambahkan argumen "menu" untuk fragment navbar. Argumen "menu" ini akan menampung value berupa judul menu sesuai dengan masukan untuk masing-masing halaman html. Contohnya, pada home.html, fragment navbar('Home') akan mereplace tag yang memanggilnya. Pada kasus ini, judul menu yang di-pass ke parameter adalah 'Home'. Nantinya, value dari argumen "menu" akan diambil untuk diterapkan di dalam fragment navbar itu sendiri.  

## Tutorial 5
1. **Apa itu Postman? Apa kegunaannya?**
   Postman merupakan alat untuk pengembangan API berupa GUI API caller yang membantu membangun, menguji, dan memodifikasi API. Postman dapat digunakan untuk membuat berbagai jenis permintaan HTTP seperti GET, POST, PUT, dan DELETE, menyimpan environments untuk digunakan nanti, serta mengubah API menjadi kode untuk berbagai bahasa (seperti JavaScript, Python)

2. **Jelaskan fungsi dari anotasi `@JsonIgnoreProperties` dan `@JsonProperty.`**
   - `@JsonIgnoreProperties` digunakan untuk mengabaikan properti logika yang sudah dispesifikasi atau spesifik dalam serialisasi dan deserialisasi JSON. `@JsonIgnoreProperties` dianotasi di tingkat class
   - `@JsonIgnore` digunakan untuk mengabaikan properti logis yang digunakan dalam serialisasi dan deserialisasi. `@JsonIgnore` bisa digunakan di setter, getter, atau field

3. **Apa kegunaan atribut WebClient?**
   WebClient menyediakan metode umum untuk mengirim data ke atau menerima data dari resource lokal, intranet, atau Internet yang diidentifikasi oleh URI. WebClient menggunakan kelas WebRequest untuk menyediakan akses ke resource
   
4. **Apa itu `ResponseEntity` dan `BindingResult`? Apa kegunaannya?**
   - `ResponseEntity` mewakili respons HTTP, termasuk header, body, dan status.  `ResponseEntity` dapat digunakan untuk mengonfigurasi respons HTTP sepenuhnya
   - `BindingResult` adalah objek yang menyimpan hasil validasi,  binding, serta error yang mungkin telah terjadi. `BindingResult` harus muncul tepat setelah objek model yang divalidasi. `BindingResult` digunakan untuk melihat hasil validasi

## Tutorial 6
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
   - Otentikasi adalah proses verifikasi atau pembuktian identitas seseorang. Otentikasi biasa dilakukan menggunakan username dan password. Sistem nantinya akan mengotentikasi apakah username dan password sudah sesuai. Otentikasi diterapkan pada class `WebSecurityConfig` tepatnya pada fungsi `configAuthentication` dimana sistem akan memvalidasi username dan password yang dimasukkan oleh pengguna sudah sesuai dengan yang tersimpan di database atau belum.
   - Otorisasi adalah proses yang terjadi setelah pengguna terautentikasi. Otorisasi akan memberikan akses kepada pengguna sesuai dengan peran yang dimiliki untuk menelusuri sistem. Otorisasi diterapkan pada class `WebSecurityConfig`, tepatnya pada fungsi `configure`. Pada fungsi configure, dituliskan kode `.antMatchers("/hotel/**").hasAuthority("RECEPTIONIST")` yang berarti hanya pengguna dengan role "Receptionist" yang dapat mengakses url tersebut. 

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
   BCryptPasswordEncoder adalah sebuah kelas yang mengimplementasikan `PasswordEncoder` dan berfungsi untuk melakukan *password encode atau hashing*. BCrypt akan mengubah password menjadi *random salt* atau *random string*. Setiap pemanggilan fungsi `encode`, hasil *random salt* yang di-generate akan berbeda-beda namun tetap sesuai dengan format hasil *random salt*.

3. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
   UUID atau Universally Unique Identifier adalah salah satu identifier yang sering digunakan. Bentuk dari UUID merupakan angka dengan panjang 128 bit. UUID ini digunakan untuk mengidentifikasi objek secara unik di internet.

4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserServiceImpl.java?
   `UserDetailsServiceImpl.java` merupakan core interface pada security framework service dan hanya memiliki satu method yaitu `loadUserByUserName`. Class `UserDetailsServiceImpl` ini digunakan untuk mengambil informasi mengenai otentikasi dan otorisasi milik pengguna. Sedangkan, class `UserServiceImpl` berisi method atau service yang dapat digunakan oleh model user dan tidak berkaitan dengan otorisasi atau otentikasi.

