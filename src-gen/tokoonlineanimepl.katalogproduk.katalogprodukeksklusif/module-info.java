module tokoonlineanimepl.katalogproduk.katalogprodukeksklusif {
	requires tokoonlineanimepl.katalogproduk.core;
	exports tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.model;
	exports tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.resource;
	exports tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.service;

	requires id.ac.ui.cs.prices.winvmj.core;
	requires id.ac.ui.cs.prices.winvmj.hibernate;
	requires id.ac.ui.cs.prices.winvmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens tokoonlineanimepl.katalogproduk.katalogprodukeksklusif.model to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
}
