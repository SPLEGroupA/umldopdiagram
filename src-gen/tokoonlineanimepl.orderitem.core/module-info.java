module tokoonlineanimepl.orderitem.core {
	exports tokoonlineanimepl.orderitem;
	exports tokoonlineanimepl.orderitem.core.model;
	exports tokoonlineanimepl.orderitem.core.resource;
	exports tokoonlineanimepl.orderitem.core.service;
	requires id.ac.ui.cs.prices.winvmj.core;
	requires id.ac.ui.cs.prices.winvmj.hibernate;
	requires id.ac.ui.cs.prices.winvmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens tokoonlineanimepl.orderitem to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
	opens tokoonlineanimepl.orderitem.core.model to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
}
