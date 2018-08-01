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
		sh './quickstart/gradlew clean test -p quickstart/'
            }			
        }
	 
        stage('Deploy') {
            steps {
                echo 'Deploying....'
		sh './quickstart/gradlew clean build -p quickstart/'
            }
        }
    }
	post {
        always {
            archiveArtifacts artifacts: 'quickstart/build/**/*.jar', fingerprint: true
            junit 'quickstart/build/test-results/test/*.xml'
        }
    }
}

