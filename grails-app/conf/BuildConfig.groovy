grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
grails.tomcat.nio = true
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// grails.war.resources = { stagingDir, args ->
//     File mysqlJar = new File(stagingDir, 'WEB-INF/lib/mysql-connector-java-5.1.24.jar')
//     mysqlJar.delete()
// }


grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
        //        includes 'grails-plugin-log4j', 'log4j'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    dependencies {
        test "org.grails:grails-datastore-test-support:1.0-grails-2.4"
        runtime 'mysql:mysql-connector-java:5.1.33'
        compile "org.springframework.cloud:spring-cloud-cloudfoundry-connector:1.0.0.RELEASE"
        compile "org.springframework.cloud:spring-cloud-spring-service-connector:1.0.0.RELEASE"

    }

    plugins {
        build ":tomcat:7.0.55"

        // plugins for the compile step
        compile ":scaffolding:2.1.2"
        compile ':cache:1.1.8'
        compile ":asset-pipeline:1.9.6"
        compile "org.grails.plugins:rabbitmq:1.0.0"

        // plugins needed at runtime but not for compilation
        runtime ":hibernate4:4.3.5.5" // or ":hibernate:3.6.10.17"
        runtime ":database-migration:1.4.0"
        runtime ":jquery:1.11.1"
//        compile "org.grails:grails-plugin-log4j:2.5.3"
    }
}
