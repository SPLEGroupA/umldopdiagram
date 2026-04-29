package tokoonlineanimepl.akunpengguna.sistemmembership.model;

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

@Entity(name="akunpengguna_sistemmembership")
@Table(name="akunpengguna_sistemmembership")
public class AkunPenggunaImpl extends AkunPenggunaDecorator {

	protected String membership_level;
	public AkunPenggunaImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = AkunPenggunaImpl.class.getName();
    }

	public AkunPenggunaImpl(AkunPenggunaComponent record, String membership_level) {
		super(record, AkunPenggunaImpl.class.getName());
		this.membership_level = membership_level;
		this.objectName = AkunPenggunaImpl.class.getName();
	}

	public String getMembership_level() {
		return this.membership_level;
	}

	public void setMembership_level(String membership_level) {
		this.membership_level = membership_level;
	}

	protected String checkMembership() {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("", );
		map.put("membership_level", getMembership_level());

        return map;
    }

}
