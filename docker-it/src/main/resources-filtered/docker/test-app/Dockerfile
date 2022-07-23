ARG KARAF_VERSION

FROM openjdk:11-jre

ADD target/dependency/test-app-assembly.tar.gz /app
ADD stage/app/assembly-${project.version}/etc /app/assembly-${project.version}/etc

WORKDIR /app/assembly-${project.version}
EXPOSE 8181 8101

ENTRYPOINT ["bin/karaf"]
CMD ["daemon"]

