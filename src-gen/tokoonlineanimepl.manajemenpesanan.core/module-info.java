module tokoonlineanimepl.manajemenpesanan.core {
	requires tokoonlineanimepl.akunpengguna.core;
	requires tokoonlineanimepl.manajemenpesanan.core;
	requires tokoonlineanimepl.katalogproduk.core;
	exports tokoonlineanimepl.manajemenpesanan;
	exports tokoonlineanimepl.manajemenpesanan.core.model;
	exports tokoonlineanimepl.manajemenpesanan.core.resource;
	exports tokoonlineanimepl.manajemenpesanan.core.service;
	requires id.ac.ui.cs.prices.winvmj.core;
	requires id.ac.ui.cs.prices.winvmj.hibernate;
	requires id.ac.ui.cs.prices.winvmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens tokoonlineanimepl.manajemenpesanan to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
	opens tokoonlineanimepl.manajemenpesanan.core.model to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
}
