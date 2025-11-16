pipeline {
    agent none

    stages {
        stage('Checkout Code') {
            agent any
            steps {
                git branch: 'main', url: 'https://github.com/fahdahmadee072-wq/hello-java-docker.git'
            }
        }

        stage('Build with Maven (Docker)') {
            agent {
                docker {
                    image 'maven:3.8.1-adoptopenjdk-11'
                }
            }
            steps {
                sh 'mvn -version'
                sh 'mvn clean compile'
            }
        }

        stage('Build Docker Image') {
            agent any
            steps {
                sh '''
                  docker build -t hello-java:v1 .
                '''
            }
        }
    }
}
