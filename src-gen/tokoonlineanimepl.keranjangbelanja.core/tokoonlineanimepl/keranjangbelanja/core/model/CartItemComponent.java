package tokoonlineanimepl.keranjangbelanja.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="cartitem_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CartItemComponent implements CartItem{
	protected int quantity;
	protected int harga_satuan;
	@ManyToOne(targetEntity=tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanjaComponent.class)
	public KeranjangBelanja keranjangBelanja;
	@ManyToOne(targetEntity=tokoonlineanimepl.produk.core.model.ProdukComponent.class)
	public Produk produk;
	protected String objectName = CartItemComponent.class.getName();

	public CartItemComponent() {

	} 

	public CartItemComponent(
        int id_cart_item, int quantity, int harga_satuan, KeranjangBelanjaImpl keranjangBelanja, ProdukImpl produk
    ) {
        this.id_cart_item = id_cart_item;
        this.quantity = quantity;
        this.harga_satuan = harga_satuan;
        this.keranjangBelanja = keranjangBelanja;
        this.produk = produk;
    }

	public int getId_cart_item() {
		return this.id_cart_item;
	}

	public void setId_cart_item(int id_cart_item) {
		this.id_cart_item = id_cart_item;
	}
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getHarga_satuan() {
		return this.harga_satuan;
	}

	public void setHarga_satuan(int harga_satuan) {
		this.harga_satuan = harga_satuan;
	}
	public abstract KeranjangBelanjaImpl getKeranjangBelanja();
	public abstract void setKeranjangBelanja(KeranjangBelanjaImpl keranjangBelanja);
	
	public abstract ProdukImpl getProduk();
	public abstract void setProduk(ProdukImpl produk);
	
 
	public abstract boolean setProduct(int id_produk, int quantity);

	public abstract CartItemImpl getByKeranjang(int id_keranjang);

	@Override
    public String toString() {
        return "{" +
            " id_cart_item='" + getId_cart_item() + "'" +
            " quantity='" + getQuantity() + "'" +
            " harga_satuan='" + getHarga_satuan() + "'" +
            " keranjangBelanja='" + getKeranjangBelanja() + "'" +
            " produk='" + getProduk() + "'" +
            "}";
    }
	
}
