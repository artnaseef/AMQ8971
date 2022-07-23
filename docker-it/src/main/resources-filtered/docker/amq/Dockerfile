FROM openjdk:11-jre

ARG ACTIVEMQ_VERSION
ENV ACTIVEMQ_HOME /opt/apache-activemq-$ACTIVEMQ_VERSION

ADD target/dependency/apache-activemq.tar.gz /opt

RUN useradd -r -M -d $ACTIVEMQ_HOME activemq && \
    chown -R activemq:activemq /opt/$ACTIVEMQ_PKGNAME && \
    chown -h activemq:activemq $ACTIVEMQ_HOME

USER activemq

COPY target/classes/docker/amq/jetty.xml $ACTIVEMQ_HOME/conf/jetty.xml

WORKDIR $ACTIVEMQ_HOME
EXPOSE 61616 8161

CMD ["/bin/sh", "-c", "bin/activemq console"]

