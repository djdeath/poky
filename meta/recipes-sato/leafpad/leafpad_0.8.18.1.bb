DESCRIPTION = "Simple GTK+ Text Editor"
HOMEPAGE = "http://tarot.freeshell.org/leafpad/"
BUGTRACKER = ""

LICENSE = "GPLv2 & GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
                    file://src/leafpad.h;endline=20;md5=d3d6a89f5e61e8b13bdea537511ba1fa \
                    file://src/utils.c;endline=20;md5=0d2cc6584ba3202448bb274f62739571"

DEPENDS = "gtk+ intltool-native"
DEPENDS_append_poky = " libowl"
SRC_URI = "http://savannah.nongnu.org/download/${BPN}/${BPN}-${PV}.tar.gz \
	   file://leafpad.desktop"

SRC_URI[md5sum] = "254a72fc67505e3aa52884c729cd7b97"
SRC_URI[sha256sum] = "959d22ae07f22803bc66ff40d373a854532a6e4732680bf8a96a3fbcb9f80a2c"
PR = "r1"

SRC_URI_append_poky += " file://owl-menu.patch;apply=yes "

inherit autotools pkgconfig

EXTRA_OECONF = " --enable-chooser --disable-gtktest --disable-print"

do_install_append () {
        install -d ${D}/${datadir}
        install -d ${D}/${datadir}/applications
        install -m 0644 ${WORKDIR}/leafpad.desktop ${D}/${datadir}/applications
}

FILES_${PN} += "${datadir}/applications/leafpad.desktop"
