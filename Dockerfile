FROM jboss/wildfly:17.0.1.Final

COPY target/randomproject.war /opt/jboss/wildfly/standalone/deployments/ROOT.war