import org.springframework.cloud.CloudFactory
import org.springframework.cloud.CloudException

def cloud = null
try {
    cloud = new CloudFactory().cloud
} catch (CloudException) {}

environments {
  development {
    dataSource {
                url = "jdbc:mysql://localhost/cfsample?useUnicode=true&zeroDateTimeBehavior=convertToNull&characterEncoding=UTF-8"
                username = "root"
                password = ""
                dbCreate = "create-drop"
                driverClassName = "com.mysql.jdbc.Driver"
                dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
    }    
  }
  
  production {
    dataSource {
                def dbInfo = cloud?.getServiceInfo('mysql')
                url = dbInfo?.jdbcUrl
                username = dbInfo?.userName
                password = dbInfo?.password
                dbCreate = "create-drop"
                driverClassName = "com.mysql.jdbc.Driver"
                dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
    }      
  }
}


// code_snippet gsg-grails-s5 end


