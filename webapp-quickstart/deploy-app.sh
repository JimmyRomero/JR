echo 'Stopping Tomcat service...'
sudo systemctl stop tomcat
sudo rm -f /opt/tomcat/webapps/webapp-quickstart.war, ignoreError: true
sudo rm -rf /opt/tomcat/webapps/webapp-quickstart, ignoreError: true

echo 'Sending war file...'
sudo cp -f /tmp/webapp-quickstart.war /opt/tomcat/webapps/webapp-quickstart.war, ignoreError: true
sudo rm /tmp/webapp-quickstart.war

echo 'Starting Tomcat service...'
sudo systemctl start tomcat
