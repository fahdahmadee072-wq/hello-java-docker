pipeline {
    agent none

    stages {
        stage('Checkout Code') {
            agent { label 'master' }
            steps {
                git branch: 'main', url: 'https://github.com/<your-username>/hello-java-docker.git'
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

        stage('Run Application (Docker)') {
            agent {
                docker {
                    image 'openjdk:11'
                }
            }
            steps {
                sh 'java -cp target/classes Main'
            }
        }
    }
}
