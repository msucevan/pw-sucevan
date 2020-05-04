FROM airhacks/glassfish
COPY ./target/sdsad.war ${DEPLOYMENT_DIR}
