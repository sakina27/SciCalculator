pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "saki2726/scientific-calculator"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/saki2726/Scientific-Calculator.git'
            }
        }

        stage('Build JAR with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withDockerRegistry([credentialsId: 'DockerHubCred']) {
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }

        stage('Deploy Using Ansible') {
            steps {
                sh 'ansible-playbook deploy.yml'
            }
        }

        stage('Attach to Running Container') {
            steps {
                sh 'docker attach scientificCalculator'
            }
        }
    }
}
