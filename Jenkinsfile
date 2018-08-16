pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh'''
                chmod +x quickstart/gradlew
                ./quickstart/gradlew clean assemble -p quickstart/
                '''
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh'./quickstart/gradlew test -p quickstart/'
            }
        }
        stage('CodeQuality') {
            steps {
                echo 'Code Quality..'
                sh'./quickstart/gradlew sonarqube -p quickstart/'
            }
        }        
    }
    post {
		always {
			junit 'quickstart/build/test-results/test/*.xml'
            publishHTML (target: [
              allowMissing: false,
              alwaysLinkToLastBuild: false,
              keepAll: true,
              reportDir: 'quickstart/build/reports/tests/test',
              reportFiles: 'index.html',
              reportName: "Junit Reports"
              ])
            }

        success {
			archiveArtifacts artifacts: 'quickstart/build/libs/*.jar', fingerprint: true
        }
    }
}
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh'./webapp-quickstart/gradlew clean assemble -p webapp-quickstart/'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh'./webapp-quickstart/gradlew test -p webapp-quickstart/'
            }
        }
        stage('CodeQuality') {
            steps {
                echo 'Code Quality..'
                sh'./webapp-quickstart/gradlew sonarqube -p webapp-quickstart/'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy..'
                sh'./webapp-quickstart/gradlew -b deploy.gradle deploy -Pdev_server=10.28.109.116 -Pwar_path=war -Pwar_name=webapp-quickstart -p webapp-quickstart/'
            }
        }          
    }
    post {
		always {
			junit 'webapp-quickstart/build/test-results/test/*.xml'
            publishHTML (target: [
              allowMissing: false,
              alwaysLinkToLastBuild: false,
              keepAll: true,
              reportDir: 'webapp-quickstart/build/reports/tests/test',
              reportFiles: 'index.html',
              reportName: "Junit Reports"
              ])
            }

        success {
			archiveArtifacts artifacts: 'webapp-quickstart/build/libs/*.war', fingerprint: true
        }
    }
}

