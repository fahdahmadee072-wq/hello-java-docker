pipeline {
    agent any

    environment {
        DOCKERHUB_USER = "fahd81"
        IMAGE_NAME = "hello-java"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/fahdahmadee072-wq/hello-java-docker.git'
            }
        }

        stage('Build Java Code') {
            agent {
                docker { image 'maven:3.8.1-adoptopenjdk-11' }
            }
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKERHUB_USER/$IMAGE_NAME:latest .'
            }
        }

        stage('Login & Push Image') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'dockerhub-creds',
                        usernameVariable: 'USER',
                        passwordVariable: 'PASS'
                    )
                ]) {
                    sh '''
                    echo "$PASS" | docker login -u "$USER" --password-stdin
                    docker push $DOCKERHUB_USER/$IMAGE_NAME:latest
                    '''
                }
            }
        }
    }
}
