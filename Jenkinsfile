pipeline{
	agent any
    stages{
		stage("Buildjar"){
			agent{
				docker{
					image 'maven:3.9.3-eclipse-temurin-17-focal'
                    args '-u root -v /tmp/m2:/root/.m2'
                }
             }
             steps{
				sh "mvn clean package -DskipTests"
             }
        }
        stage("Building the image"){
			steps{
				script{
					app=docker.build("7013918149/selenium")
                    }
            }
        }
        stage("Pushing the image"){
			steps{
				script{
					//To push with credentials
            //First parameter space because not necessary in local
            docker.withRegistry('','dockerhub-cred')
            app.push("latest")
             }
            }
        }
    }
}