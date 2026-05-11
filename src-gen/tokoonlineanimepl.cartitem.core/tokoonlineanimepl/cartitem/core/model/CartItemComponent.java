package tokoonlineanimepl.cartitem.core.model;

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
	@Id
	protected UUID id_cart_item; 
	protected int quantity;
	protected int harga_satuan;
	protected String keranjang_ref;
	protected String produk_ref;
	protected String objectName = CartItemComponent.class.getName();

	public CartItemComponent() {

	} 

	public CartItemComponent(
        UUID id_cart_item, int quantity, int harga_satuan, String keranjang_ref, String produk_ref
    ) {
        this.id_cart_item = id_cart_item;
        this.quantity = quantity;
        this.harga_satuan = harga_satuan;
        this.keranjang_ref = keranjang_ref;
        this.produk_ref = produk_ref;
    }

	public UUID getId_cart_item() {
		return this.id_cart_item;
	}

	public void setId_cart_item(UUID id_cart_item) {
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
	public String getKeranjang_ref() {
		return this.keranjang_ref;
	}

	public void setKeranjang_ref(String keranjang_ref) {
		this.keranjang_ref = keranjang_ref;
	}
	public String getProduk_ref() {
		return this.produk_ref;
	}

	public void setProduk_ref(String produk_ref) {
		this.produk_ref = produk_ref;
	}
 
	public abstract boolean setProduct(UUID id_produk, int quantity);

	public abstract boolean getByKeranjang(UUID id_keranjang);

	@Override
    public String toString() {
        return "{" +
            " id_cart_item='" + getId_cart_item() + "'" +
            " quantity='" + getQuantity() + "'" +
            " harga_satuan='" + getHarga_satuan() + "'" +
            " keranjang_ref='" + getKeranjang_ref() + "'" +
            " produk_ref='" + getProduk_ref() + "'" +
            "}";
    }
	
}
