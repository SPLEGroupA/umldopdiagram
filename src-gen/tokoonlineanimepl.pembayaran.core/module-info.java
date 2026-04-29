module tokoonlineanimepl.pembayaran.core {
	exports tokoonlineanimepl.pembayaran;
	exports tokoonlineanimepl.pembayaran.core.model;
	exports tokoonlineanimepl.pembayaran.core.resource;
	exports tokoonlineanimepl.pembayaran.core.service;
	requires id.ac.ui.cs.prices.winvmj.core;
	requires id.ac.ui.cs.prices.winvmj.hibernate;
	requires id.ac.ui.cs.prices.winvmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens tokoonlineanimepl.pembayaran to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
	opens tokoonlineanimepl.pembayaran.core.model to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
}
