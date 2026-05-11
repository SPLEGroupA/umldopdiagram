package tokoonlineanimepl.akunpengguna.sistempoinloyalitas.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaDecorator;
import tokoonlineanimepl.akunpengguna.core.model.AkunPengguna;
import tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaComponent;

@Entity(name="akunpengguna_sistempoinloyalitas")
@Table(name="akunpengguna_sistempoinloyalitas")
public class AkunPenggunaImpl extends AkunPenggunaDecorator {

	protected int poin;
	public AkunPenggunaImpl() {
        super();
		this.id_akun = UUID.randomUUID();
        this.objectName = AkunPenggunaImpl.class.getName();
    }

	public AkunPenggunaImpl(AkunPenggunaComponent record, int poin) {
		super(record, AkunPenggunaImpl.class.getName());
		this.poin = poin;
		this.objectName = AkunPenggunaImpl.class.getName();
	}

	public int getPoin() {
		return this.poin;
	}

	public void setPoin(int poin) {
		this.poin = poin;
	}

	protected boolean redeemPoin(UUID id_akun, int jumlah_poin) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("id_akun", id_akun);
		map.put("poin", getPoin());

        return map;
    }

}
