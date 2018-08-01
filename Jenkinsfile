pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
		sh '''
		chmod +x quickstart/gradlew
		./quickstart/gradlew clean assemble -p quickstart/
		'''
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
		sh './gradle/quickstart/gradlew test jacocoTestReport -p gradle/quickstart/'
            }			
        }	 
    }
	post {
        always {            			
            junit 'quickstart/build/test-results/test/*.xml'
        }
		success {
            archiveArtifacts artifacts: 'gradle/quickstart/build/libs/*.jar', fingerprint: true
		}
    }
}
