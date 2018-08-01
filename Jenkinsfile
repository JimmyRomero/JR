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
