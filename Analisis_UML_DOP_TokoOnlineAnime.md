# Analisis UML DOP — Toko Online Anime

## 1. Struktur Keseluruhan

```
tokoonlineanimepl  «vm»
├── MTokoOnlineAnime  «module»        ← core/mandatory
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

## 2. Module: MTokoOnlineAnime «module»

Berisi semua class dan interface **mandatory** (core features).

### 2.1 ProdukImpl → implements Produk ✅

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

### 2.2 KeranjangBelanjaImpl → implements KeranjangBelanja ✅

| Atribut | Tipe | Visibility | Keterangan |
|---------|------|------------|------------|
| id_keranjang | Integer | protected | |
| akunPengguna | AkunPenggunaImpl [1] | — | Relasi ke pemilik keranjang |

| Operasi | Parameter | Return |
|---------|-----------|--------|
| getByUser() | email: String | KeranjangBelanjaImpl |
| addItem() | id_cart_item: Integer | Boolean |
| checkout() | — | OrderImpl |

---

### 2.3 CartItemImpl → implements CartItem ✅

| Atribut | Tipe | Visibility | Keterangan |
|---------|------|------------|------------|
| id_cart_item | Integer | protected | |
| quantity | Integer | protected | Jumlah produk |
| harga_satuan | Integer | protected | Harga snapshot saat ditambahkan |
| keranjangBelanja | KeranjangBelanjaImpl [1] | — | Relasi ke keranjang |
| produk | ProdukImpl [1] | — | Relasi ke produk |

| Operasi | Parameter | Return |
|---------|-----------|--------|
| setProduct() | id_produk: Integer, quantity: Integer | Boolean |
| getByKeranjang() | id_keranjang: Integer | CartItemImpl [*] |

---

### 2.4 AkunPenggunaImpl → implements AkunPengguna ✅

| Atribut | Tipe | Visibility |
|---------|------|------------|
| id_akun | Integer | protected |
| email | String | protected |
| nama | String | protected |
| alamat | String | protected |
| no_telepon | String | protected |

> Tidak ada operasi custom — cukup CRUD standar.

---

### 2.5 PembayaranImpl → implements Pembayaran ✅

| Atribut | Tipe | Visibility | Keterangan |
|---------|------|------------|------------|
| id_pembayaran | Integer | protected | |
| metode | String | protected | Kartu kredit (default mandatory) |
| jumlah | Integer | protected | |
| status | String | protected | Status pembayaran |
| id_pesanan | Integer | protected | Relasi ke pesanan |

> Tidak ada operasi custom — cukup CRUD standar. Pembayaran di-create saat checkout.

---

### 2.6 OrderImpl → implements Order ✅

| Atribut | Tipe | Visibility | Keterangan |
|---------|------|------------|------------|
| id_pesanan | Integer | protected | |
| status | String | protected | Status pesanan (pending, shipped, dll) |
| tanggal_pesan | String | protected | |
| total_harga | Integer | protected | |
| akunPengguna | AkunPenggunaImpl [1] | — | Relasi ke pemilik pesanan |

| Operasi | Parameter | Return |
|---------|-----------|--------|
| getByUser() | email: String | OrderImpl [*] |

---

### 2.7 OrderItemImpl → implements OrderItem ✅

| Atribut | Tipe | Visibility | Keterangan |
|---------|------|------------|------------|
| id_order_item | Integer | protected | |
| quantity | Integer | protected | Jumlah produk |
| harga_satuan | Integer | protected | Harga locked saat checkout |
| pesanan | OrderImpl [1] | — | Relasi ke pesanan |
| produk | ProdukImpl [1] | — | Relasi ke produk |

| Operasi | Parameter | Return |
|---------|-----------|--------|
| getByPesanan() | id_pesanan: Integer | OrderItemImpl [*] |

---

### 2.8 PreOrderImpl → implements PreOrder ✅

| Atribut | Tipe | Visibility | Keterangan |
|---------|------|------------|------------|
| id_preorder | Integer | protected | |
| tanggal_rilis | String | protected | Estimasi rilis produk |
| status | String | protected | Status pre-order |
| produk | ProdukImpl [1] | — | Relasi ke produk yang di-preorder |
| akunPengguna | AkunPenggunaImpl [1] | — | Relasi ke user yang pre-order |

> Tidak ada operasi custom — cukup CRUD standar.

---

## 3. Delta Packages

Setiap delta memodifikasi class yang ada di module dengan menambahkan atribut/operasi baru.

### 3.1 DKatalogProdukEksklusif «delta»

**Modifies:** ProdukImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Atribut | is_eksklusif | Boolean, protected | «adds» |
| Operasi | checkEksklusif() | return Boolean | «adds» |

---

### 3.2 DKatalogProdukPreOwned «delta»

**Modifies:** ProdukImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Atribut | kondisi | String, protected | «adds» |
| Operasi | checkPreOwned() | return Boolean | «adds» |

---

### 3.3 DPembayaranEWallet «delta»

**Modifies:** PembayaranImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Atribut | ewallet_provider | String, protected | «adds» |
| Operasi | payWithEWallet() | amount: Integer → Boolean | «adds» |

---

### 3.4 DWishlist «delta»

**Modifies:** AkunPenggunaImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Operasi | addToWishlist() | id_produk: Integer → Boolean | «adds» |
| Operasi | removeFromWishlist() | id_produk: Integer → Boolean | «adds» |

---

### 3.5 DReviewDanRating «delta»

**Modifies:** ProdukImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Atribut | average_rating | Integer, protected | «adds» |
| Operasi | addReview() | rating: Integer → Boolean | «adds» |

---

### 3.6 DSistemMembership «delta»

**Modifies:** AkunPenggunaImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Atribut | membership_level | String, protected | «adds» |
| Operasi | checkMembership() | return String | «adds» |

---

### 3.7 DSistemPoinLoyalitas «delta»

**Modifies:** AkunPenggunaImpl

| Elemen | Nama | Detail | Stereotip |
|--------|------|--------|-----------|
| Atribut | poin | Integer, protected | «adds» |
| Operasi | redeemPoin() | jumlah_poin: Integer → Boolean | «adds» |

---

## 4. Mapping Delta → Module Class

| Delta | Target Class | Adds Attributes | Adds Operations |
|-------|-------------|-----------------|-----------------|
| DKatalogProdukEksklusif | ProdukImpl | is_eksklusif | checkEksklusif() |
| DKatalogProdukPreOwned | ProdukImpl | kondisi | checkPreOwned() |
| DPembayaranEWallet | PembayaranImpl | ewallet_provider | payWithEWallet() |
| DWishlist | AkunPenggunaImpl | — | addToWishlist(), removeFromWishlist() |
| DReviewDanRating | ProdukImpl | average_rating | addReview() |
| DSistemMembership | AkunPenggunaImpl | membership_level | checkMembership() |
| DSistemPoinLoyalitas | AkunPenggunaImpl | poin | redeemPoin() |

---

## 5. Mapping ke Feature Model (UVL)

| Feature (UVL) | Tipe | Package DOP | Stereotip |
|---------------|------|-------------|-----------|
| KatalogProduk | mandatory | MTokoOnlineAnime | «module» |
| KeranjangBelanja | mandatory | MTokoOnlineAnime | «module» |
| AkunPengguna | mandatory | MTokoOnlineAnime | «module» |
| PembayaranKartuKredit | mandatory | MTokoOnlineAnime | «module» |
| ManajemenPesanan (Order) | mandatory | MTokoOnlineAnime | «module» |
| PreOrderProduk | mandatory | MTokoOnlineAnime | «module» |
| KatalogProdukEksklusif | optional | DKatalogProdukEksklusif | «delta» |
| KatalogProdukPreOwned | optional | DKatalogProdukPreOwned | «delta» |
| PembayaranEWallet | optional | DPembayaranEWallet | «delta» |
| Wishlist | optional | DWishlist | «delta» |
| ReviewDanRatingProduk | optional | DReviewDanRating | «delta» |
| SistemMembership | optional | DSistemMembership | «delta» |
| SistemPoinLoyalitas | optional | DSistemPoinLoyalitas | «delta» |

---

## 6. Asosiasi (Relasi)

### 6.1 Relasi antar Module Class

| Dari | Ke | Multiplicity | Keterangan |
|------|-----|-------------|------------|
| KeranjangBelanjaImpl | AkunPenggunaImpl | [1] | Setiap keranjang milik satu user |
| CartItemImpl | KeranjangBelanjaImpl | [1] | Setiap item milik satu keranjang |
| CartItemImpl | ProdukImpl | [1] | Setiap item merujuk ke satu produk |
| OrderImpl | AkunPenggunaImpl | [1] | Setiap pesanan milik satu user |
| OrderItemImpl | OrderImpl | [1] | Setiap order item milik satu pesanan |
| OrderItemImpl | ProdukImpl | [1] | Setiap order item merujuk ke satu produk |
| PreOrderImpl | ProdukImpl | [1] | Setiap pre-order merujuk ke satu produk |
| PreOrderImpl | AkunPenggunaImpl | [1] | Setiap pre-order milik satu user |

### 6.2 Relasi Delta → Module (modifies)

| Dari (Delta) | Ke (Module) | Stereotip |
|-------------|-------------|-----------|
| DKatalogProdukEksklusif::ProdukImpl | MTokoOnlineAnime::ProdukImpl | «modifies» |
| DKatalogProdukPreOwned::ProdukImpl | MTokoOnlineAnime::ProdukImpl | «modifies» |
| DPembayaranEWallet::PembayaranImpl | MTokoOnlineAnime::PembayaranImpl | «modifies» |
| DWishlist::AkunPenggunaImpl | MTokoOnlineAnime::AkunPenggunaImpl | «modifies» |
| DReviewDanRating::ProdukImpl | MTokoOnlineAnime::ProdukImpl | «modifies» |
| DSistemMembership::AkunPenggunaImpl | MTokoOnlineAnime::AkunPenggunaImpl | «modifies» |
| DSistemPoinLoyalitas::AkunPenggunaImpl | MTokoOnlineAnime::AkunPenggunaImpl | «modifies» |
