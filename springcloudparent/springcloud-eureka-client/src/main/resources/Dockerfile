FROM docker.io/frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD mobile-zuul-server-1.0.0.jar mobile-zuul-server-1.0.0.jar
RUN sh -c 'touch /mobile-zuul-server-1.0.0.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom $PARAMS -jar /mobile-zuul-server-1.0.0.jar" ]

