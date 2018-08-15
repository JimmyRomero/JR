echo 'Stopping Tomcat service...'
sudo systemctl stop tomcat
sudo rm -f "${tomcat_webapps}/${war_name}.war", ignoreError: true
sudo rm -rf "${tomcat_webapps}/${war_name}", ignoreError: true

echo 'Sending war file...'
sudo cp -f /tmp/"${war_name}.war" "${tomcat_webapps}/${war_name}.war", ignoreError: true
sudo rm /tmp/"${war_name}.war"

echo 'Starting Tomcat service...'
sudo systemctl start tomcat