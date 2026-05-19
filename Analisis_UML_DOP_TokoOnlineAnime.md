# Analisis UML DOP — Toko Online Anime

## 1. Struktur Keseluruhan

```
tokoonlineanimepl  «vm»
├── MKatalogProduk       «module»     ← mandatory
├── MKeranjangBelanja    «module»     ← mandatory
├── MCartItem            «module»     ← mandatory
├── MAkunPengguna        «module»     ← mandatory
├── MPembayaran          «module»     ← mandatory
├── MManajemenPesanan    «module»     ← mandatory
├── MOrderItem           «module»     ← mandatory
├── MPreOrder            «module»     ← mandatory
├── DKatalogProdukEksklusif  «delta»  ← optional
├── DKatalogProdukPreOwned   «delta»  ← optional
├── DPembayaranEWallet       «delta»  ← optional
├── DWishlist                «delta»  ← optional
├── DReviewDanRating         «delta»  ← optional
├── DSistemMembership        «delta»  ← optional
└── DSistemPoinLoyalitas     «delta»  ← optional
```

---

## 1.1 CRUD Standar (Auto-generated oleh VMJ)

Setiap core class di module secara otomatis mendapatkan operasi CRUD berikut dari VMJ. Operasi ini **tidak perlu didefinisikan di UML** karena sudah di-generate:

| Operasi | Parameter | Return | Keterangan |
|---------|-----------|--------|------------|
| getById() | id: Integer | Object | Ambil satu record by ID |
| getAll() | — | Object [*] | Ambil semua record |
| deleteById() | id: Integer | Boolean | Hapus by ID |
| updateById() | id: Integer, data | Boolean | Update by ID |
| create() | data | Boolean | Buat record baru |

> Operasi yang didefinisikan di UML hanya operasi **custom** yang tidak tercakup oleh CRUD standar di atas.

---

## 2. Core Modules «module»

Berisi class dan interface **mandatory** (core features). Pada UML aktual, setiap fitur mandatory dipisah ke package module masing-masing.

### 2.1 MKatalogProduk: KatalogProdukImpl → implements KatalogProduk ✅

| Atribut | Tipe | Visibility |
|---------|------|------------|
| id_produk | Integer | protected |
| nama | String | protected |
| harga | Integer | protected |
| kategori | String | protected |
| deskripsi | String | protected |
| stok | Integer | protected |
| gambar_url | String | protected |

> Tidak ada operasi custom — cukup CRUD standar.

---

### 2.2 MKeranjangBelanja: KeranjangBelanjaImpl → implements KeranjangBelanja ✅

| Atribut | Tipe | Visibility | Keterangan |
|---------|------|------------|------------|
| id_keranjang | Integer | protected | |
| akun_ref | String | protected | Referensi ke pemilik keranjang |

| Operasi | Parameter | Return |
|---------|-----------|--------|
| getByUser() | email: String | Boolean |
| addItem() | id_cart_item: Integer | Boolean |
| checkout() | — | Boolean |

---

### 2.3 MCartItem: CartItemImpl → implements CartItem ✅

| Atribut | Tipe | Visibility | Keterangan |
|---------|------|------------|------------|
| id_cart_item | Integer | protected | |
| quantity | Integer | protected | Jumlah produk |
| harga_satuan | Integer | protected | Harga snapshot saat ditambahkan |
| keranjang_ref | String | protected | Referensi ke keranjang |
| produk_ref | String | protected | Referensi ke produk |

| Operasi | Parameter | Return |
|---------|-----------|--------|
| setProduct() | id_produk: Integer, quantity: Integer | Boolean |
| getByKeranjang() | id_keranjang: Integer | Boolean |

---

### 2.4 MAkunPengguna: AkunPenggunaImpl → implements AkunPengguna ✅

| Atribut | Tipe | Visibility |
|---------|------|------------|
| id_akun | Integer | protected |
| email | String | protected |
| nama | String | protected |
| alamat | String | protected |
| no_telepon | String | protected |

> Tidak ada operasi custom — cukup CRUD standar.

---

### 2.5 MPembayaran: PembayaranImpl → implements Pembayaran ✅

| Atribut | Tipe | Visibility | Keterangan |
|---------|------|------------|------------|
| id_pembayaran | Integer | protected | |
| metode | String | protected | Kartu kredit (default mandatory) |
| jumlah | Integer | protected | |
| status | String | protected | Status pembayaran |
| pesanan_ref | String | protected | Referensi ke pesanan |

> Tidak ada operasi custom — cukup CRUD standar. Pembayaran di-create saat checkout.

---

### 2.6 MManajemenPesanan: ManajemenPesananImpl → implements ManajemenPesanan ✅

| Atribut | Tipe | Visibility | Keterangan |
|---------|------|------------|------------|
| id_pesanan | Integer | protected | |
| status | String | protected | Status pesanan (pending, shipped, dll) |
| tanggal_pesan | String | protected | |
| total_harga | Integer | protected | |
| akun_ref | String | protected | Referensi ke pemilik pesanan |

| Operasi | Parameter | Return |
|---------|-----------|--------|
| getByUser() | email: String | Boolean |

---

### 2.7 MOrderItem: OrderItemImpl → implements OrderItem ✅

| Atribut | Tipe | Visibility | Keterangan |
|---------|------|------------|------------|
| id_order_item | Integer | protected | |
| quantity | Integer | protected | Jumlah produk |
| harga_satuan | Integer | protected | Harga locked saat checkout |
| pesanan_ref | String | protected | Referensi ke pesanan |
| produk_ref | String | protected | Referensi ke produk |

| Operasi | Parameter | Return |
|---------|-----------|--------|
| getByPesanan() | id_pesanan: Integer | Boolean |

---

### 2.8 MPreOrder: PreOrderImpl → implements PreOrder ✅

| Atribut | Tipe | Visibility | Keterangan |
|---------|------|------------|------------|
| id_preorder | Integer | protected | |
| tanggal_rilis | String | protected | Estimasi rilis produk |
| status | String | protected | Status pre-order |
| produk_ref | String | protected | Referensi ke produk yang di-preorder |
| akun_ref | String | protected | Referensi ke user yang pre-order |

> Tidak ada operasi custom — cukup CRUD standar.

---

## 3. Delta Packages

Setiap delta memodifikasi class yang ada di module dengan menambahkan atribut/operasi baru.

### 3.1 DKatalogProdukEksklusif «delta»

**Modifies:** MKatalogProduk::KatalogProdukImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Atribut | label_eksklusif | String, protected | «adds» |
| Operasi | getKeteranganEksklusif() | return String | «adds» |

---

### 3.2 DKatalogProdukPreOwned «delta»

**Modifies:** MKatalogProduk::KatalogProdukImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Atribut | kondisi | String, protected | «adds» |
| Operasi | getKondisi() | return String | «adds» |

---

### 3.3 DPembayaranEWallet «delta»

**Modifies:** MPembayaran::PembayaranImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Atribut | ewallet_provider | String, protected | «adds» |
| Operasi | payWithEWallet() | amount: Integer → Boolean | «adds» |

---

### 3.4 DWishlist «delta»

**Modifies:** MAkunPengguna::AkunPenggunaImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Operasi | addToWishlist() | id_produk: Integer → Boolean | «adds» |
| Operasi | removeFromWishlist() | id_produk: Integer → Boolean | «adds» |

---

### 3.5 DReviewDanRating «delta»

**Modifies:** MKatalogProduk::KatalogProdukImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Atribut | average_rating | Integer, protected | «adds» |
| Operasi | addReview() | rating: Integer → Boolean | «adds» |

---

### 3.6 DSistemMembership «delta»

**Modifies:** MAkunPengguna::AkunPenggunaImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Atribut | membership_level | String, protected | «adds» |
| Operasi | checkMembership() | return String | «adds» |

---

### 3.7 DSistemPoinLoyalitas «delta»

**Modifies:** MAkunPengguna::AkunPenggunaImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Atribut | poin | Integer, protected | «adds» |
| Operasi | redeemPoin() | jumlah_poin: Integer → Boolean | «adds» |

---

## 4. Mapping Delta → Module Class

| Delta | Target Class | Adds Attributes | Adds Operations |
|-------|-------------|-----------------|-----------------|
| DKatalogProdukEksklusif | KatalogProdukImpl | label_eksklusif | getKeteranganEksklusif() |
| DKatalogProdukPreOwned | KatalogProdukImpl | kondisi | getKondisi() |
| DPembayaranEWallet | PembayaranImpl | ewallet_provider | payWithEWallet() |
| DWishlist | AkunPenggunaImpl | — | addToWishlist(), removeFromWishlist() |
| DReviewDanRating | KatalogProdukImpl | average_rating | addReview() |
| DSistemMembership | AkunPenggunaImpl | membership_level | checkMembership() |
| DSistemPoinLoyalitas | AkunPenggunaImpl | poin | redeemPoin() |

---

## 5. Mapping ke Feature Model (UVL)

| Feature (UVL) | Tipe | Package DOP | Stereotip |
|---------------|------|-------------|-----------|
| KatalogProduk | mandatory | MKatalogProduk | «module» |
| KeranjangBelanja | mandatory | MKeranjangBelanja | «module» |
| CartItem | mandatory | MCartItem | «module» |
| AkunPengguna | mandatory | MAkunPengguna | «module» |
| PembayaranKartuKredit | mandatory | MPembayaran | «module» |
| ManajemenPesanan | mandatory | MManajemenPesanan | «module» |
| OrderItem | mandatory | MOrderItem | «module» |
| PreOrderProduk | mandatory | MPreOrder | «module» |
| KatalogProdukEksklusif | optional | DKatalogProdukEksklusif | «delta» |
| KatalogProdukPreOwned | optional | DKatalogProdukPreOwned | «delta» |
| PembayaranEWallet | optional | DPembayaranEWallet | «delta» |
| Wishlist | optional | DWishlist | «delta» |
| ReviewDanRatingProduk | optional | DReviewDanRating | «delta» |
| SistemMembership | optional | DSistemMembership | «delta» |
| SistemPoinLoyalitas | optional | DSistemPoinLoyalitas | «delta» |

---

## 6. Asosiasi (Relasi)

### 6.1 Referensi antar Core Module Class

| Class | Reference Attribute | Tipe | Keterangan |
|-------|---------------------|------|------------|
| KeranjangBelanjaImpl | akun_ref | String | Setiap keranjang merujuk ke satu user |
| CartItemImpl | keranjang_ref | String | Setiap item merujuk ke satu keranjang |
| CartItemImpl | produk_ref | String | Setiap item merujuk ke satu produk |
| PembayaranImpl | pesanan_ref | String | Setiap pembayaran merujuk ke satu pesanan |
| ManajemenPesananImpl | akun_ref | String | Setiap pesanan merujuk ke satu user |
| OrderItemImpl | pesanan_ref | String | Setiap order item merujuk ke satu pesanan |
| OrderItemImpl | produk_ref | String | Setiap order item merujuk ke satu produk |
| PreOrderImpl | produk_ref | String | Setiap pre-order merujuk ke satu produk |
| PreOrderImpl | akun_ref | String | Setiap pre-order merujuk ke satu user |

### 6.2 Relasi Delta → Module (modifies)

| Dari (Delta) | Ke (Module) | Stereotip |
|-------------|-------------|-----------|
| DKatalogProdukEksklusif::KatalogProdukImpl | MKatalogProduk::KatalogProdukImpl | «modifies» |
| DKatalogProdukPreOwned::KatalogProdukImpl | MKatalogProduk::KatalogProdukImpl | «modifies» |
| DPembayaranEWallet::PembayaranImpl | MPembayaran::PembayaranImpl | «modifies» |
| DWishlist::AkunPenggunaImpl | MAkunPengguna::AkunPenggunaImpl | «modifies» |
| DReviewDanRating::KatalogProdukImpl | MKatalogProduk::KatalogProdukImpl | «modifies» |
| DSistemMembership::AkunPenggunaImpl | MAkunPengguna::AkunPenggunaImpl | «modifies» |
| DSistemPoinLoyalitas::AkunPenggunaImpl | MAkunPengguna::AkunPenggunaImpl | «modifies» |
