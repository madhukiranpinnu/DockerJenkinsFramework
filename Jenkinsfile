pipeline{
	agent any
    stages{
		stage("Build jar"){
			steps{
				bat "mvn clean package -DskipTests"
            }
        }
        stage("Build image"){
			steps{
				bat "docker build -t7013918149/selenium:latest ."
            }
        }

        stage("push image"){
			environment{
				// assuming you have stored the credentials with this name
                DOCKER_HUB = credentials('dockerhub-cred')
            }
            steps{
				bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                bat "docker push 7013918149/selenium:latest"
                bat "docker tag 7013918149/selenium:latest 7013918149/selenium:${env.BUILD_NUMBER}"
                bat "docker push 7013918149/selenium:${env.BUILD_NUMBER}"
            }
        }
    }
    post {
		always {
			bat 'docker logout'
        }
    }
}