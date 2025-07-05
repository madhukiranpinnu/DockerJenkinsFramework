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
                bat "docker build -t7013918149/selenium ."
            }
        }

        stage("push image"){
            steps{
                bat "docker push 7013918149/selenium"
            }
        }

    }
}