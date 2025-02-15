class Config16 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                configureArgs       : '--enable-dtrace --with-vendor-name="International Business Machines Corporation" --with-vendor-version-string="16.0.2.0" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage: [
                        hotspot     : 'adoptopenjdk/centos6_build_image',
                        openj9      : 'adoptopenjdk/centos7_build_image'
                ],
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalTestLabels: [
                        openj9      : '!(sw.os.cent.6||sw.os.rhel.6)'
                ],
                configureArgs       : [
                        'openj9'      : '--enable-dtrace --enable-jitserver --with-vendor-name="International Business Machines Corporation" --with-vendor-version-string="16.0.2.0" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                        'hotspot'     : '--enable-dtrace'
                ]
        ],

        x64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes'
        ],

        aarch64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes'
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: 'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                cleanWorkspaceAfterBuild: true,
                configureArgs       : '--with-vendor-name="International Business Machines Corporation" --with-vendor-version-string="16.0.2.0" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-jdk-rc-name="IBM Semeru Runtime"',
                test                : 'default'
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        hotspot: 'xlc16&&aix710',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
                ],
                test                : 'default',
                configureArgs       : [
                        openj9: '--disable-ccache --with-vendor-name="International Business Machines Corporation" --with-vendor-version-string="16.0.2.0" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
                ],
                cleanWorkspaceAfterBuild: true
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : '--enable-dtrace --with-vendor-name="International Business Machines Corporation" --with-vendor-version-string="16.0.2.0" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                additionalNodeLabels: 'centos7',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        'hotspot'     : '--enable-dtrace',
                        'openj9'      : '--enable-dtrace --enable-jitserver --with-vendor-name="International Business Machines Corporation" --with-vendor-version-string="16.0.2.0" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
                ]
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerNode         : 'sw.tool.docker',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.aarch64 && sw.os.linux'
                ],
                test                : 'default',
                configureArgs       : '--enable-dtrace --with-version-pre=ea --without-version-opt --with-vendor-name="International Business Machines Corporation" --with-vendor-version-string="16.0.2.0" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
        ]
  ]

}

Config16 config = new Config16()
return config.buildConfigurations
