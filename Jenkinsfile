pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "saki2726/scientific-calculator"
        DOCKER_REGISTRY_URL = "https://index.docker.io/v1/"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/sakina27/SciCalculator.git'
            }
        }

        stage('Build JAR with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {  // ✅ This ensures tests run in Jenkins
             steps {
                 sh 'mvn test'
                 }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withDockerRegistry([credentialsId: 'DockerHubCred', url: DOCKER_REGISTRY_URL]) {
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }

        stage('Deploy Using Ansible') {
            steps {
                sh 'ansible-playbook -i inventory.ini deploy.yml'
            }
        }


    }
}
