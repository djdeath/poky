SUMMARY = "Asynchronous I/O library"
DESCRIPTION = "Asynchronous input/output library that uses the kernels native interface"
HOMEPAGE = "http://lse.sourceforge.net/io/aio.html"

LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d8045f3b8f929c1cb29a1e3fd737b499"

PR = "r0"

SRC_URI = "${DEBIAN_MIRROR}/main/liba/libaio/libaio_${PV}.orig.tar.gz \
           file://00_arches.patch \
           file://toolchain.patch \
           file://destdir.patch"

SRC_URI[md5sum] = "435a5b16ca6198eaf01155263d855756"
SRC_URI[sha256sum] = "bf4a457253cbaab215aea75cb6e18dc8d95bbd507e9920661ff9bdd288c8778d"

EXTRA_OEMAKE =+ "prefix=${prefix} includedir=${includedir} libdir=${libdir}"

do_install () {
    oe_runmake install DESTDIR=${D}
}
