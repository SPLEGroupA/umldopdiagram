package tokoonlineanimepl.pembayaran.pembayaranewallet.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import tokoonlineanimepl.pembayaran.core.model.PembayaranDecorator;
import tokoonlineanimepl.pembayaran.core.model.Pembayaran;
import tokoonlineanimepl.pembayaran.core.model.PembayaranComponent;

@Entity(name="pembayaran_pembayaranewallet")
@Table(name="pembayaran_pembayaranewallet")
public class PembayaranImpl extends PembayaranDecorator {

	protected String ewallet_provider;
	public PembayaranImpl() {
        super();
		this.id_pembayaran = UUID.randomUUID();
        this.objectName = PembayaranImpl.class.getName();
    }

	public PembayaranImpl(PembayaranComponent record, String ewallet_provider) {
		super(record, PembayaranImpl.class.getName());
		this.ewallet_provider = ewallet_provider;
		this.objectName = PembayaranImpl.class.getName();
	}

	public String getEwallet_provider() {
		return this.ewallet_provider;
	}

	public void setEwallet_provider(String ewallet_provider) {
		this.ewallet_provider = ewallet_provider;
	}

	protected boolean payWithEWallet(UUID id_pembayaran, int amount) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("id_pembayaran", id_pembayaran);
		map.put("ewallet_provider", getEwallet_provider());

        return map;
    }

}
