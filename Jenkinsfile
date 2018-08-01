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
			post {
        	always {
           	   junit 'quickstart/build/test-results/test/*.xml'
        	}
		  }
        }
	 
        stage('Deploy') {
            steps {
                echo 'Deploying....'
		sh './quickstart/gradlew clean build -p quickstart/'
            }
        }
    }
}

