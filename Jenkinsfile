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
    post {
            success {

                    mail to: 'sakinabaranwala123@gmail.com',
                    subject: 'Build Successful: $JOB_NAME - $BUILD_NUMBER',
                    body: "The build was successful.\n\nCheck the build details at: $BUILD_URL"

            }
            failure {

                    mail to: 'sakinabaranwala123@gmail.com',
                    subject: 'Build Failed: $JOB_NAME - $BUILD_NUMBER',
                    body: "The build failed.\n\nCheck the build details at: $BUILD_URL"

            }
            always{
            cleanWs()
            }
    }
}
