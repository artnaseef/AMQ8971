# AMQ8971 Test Application

Tests AMQ-8971 using a karaf docker container together with an AMQ docker container.

Uses the `karaf-maven-plugin` to build a distribution of Karaf to run the test application and verifies that the
application starts up and connects to the ActiveMQ broker.


# Prerequisites

* Maven
* Docker

# To Use

## Confirm the problem

    $ mvn clean install
    
* Verify the build fails


    [INFO] BUILD FAILURE


* The following error is seen in the history


    application> org.apache.felix.resolver.reason.ReasonException: Unable to resolve root: missing requirement [root] osgi.identity; osgi.identity=test-app; type=karaf.feature; version="[1.0.0.SNAPSHOT,1.0.0.SNAPSHOT]"; filter:="(&(osgi.identity=test-app)(type=karaf.feature)(version>=1.0.0.SNAPSHOT)(version<=1.0.0.SNAPSHOT))" [caused by: Unable to resolve test-app/1.0.0.SNAPSHOT: missing requirement [test-app/1.0.0.SNAPSHOT] osgi.identity; osgi.identity=com.artnaseef.AMQ8971.test-app; type=osgi.bundle; version="[1.0.0.SNAPSHOT,1.0.0.SNAPSHOT]"; resolution:=mandatory [caused by: Unable to resolve com.artnaseef.AMQ8971.test-app/1.0.0.SNAPSHOT: missing requirement [com.artnaseef.AMQ8971.test-app/1.0.0.SNAPSHOT] osgi.wiring.package; filter:="(&(osgi.wiring.package=javax.jms)(version>=1.1.0)(!(version>=2.0.0)))"]]


## Verify the fix

* Update and build ActiveMQ features
* Edit `pom.xml` - change the activemq.version to the new version of AMQ (SNAPSHOTs work); for example:


    <activemq.version>5.18.0-SNAPSHOT</activemq.version>
    <!--<activemq.version>5.17.1</activemq.version>--> <!-- fails -->

* Build


    $ mvn clean install
    
* Verify the build is successful


    [INFO] BUILD SUCCESS
    