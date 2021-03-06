SUMMARY = "DPAA2 Resource Manager Tool"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=ec8d84e9cd4de287e290275d09db27f0"

RDEPENDS_${PN} += "bash"

SRC_URI = "git://github.com/qoriq-open-source/restool.git;nobranch=1 \
    file://0001-restool-fix-build-error-with-gcc7.patch"

SRCREV = "f01f2ea4ab2d5b2432c4497cc772d2fd8cca3eb3"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CC="${CC}" EXTRA_CFLAGS="-Wno-missing-field-initializers -Wno-missing-braces"'

do_install () {
    oe_runmake install DESTDIR=${D}
}

COMPATIBLE_MACHINE = "(ls2080ardb|ls2088ardb|ls1088ardb)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

