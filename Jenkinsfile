pipeline {
    agent any

    tools {
        jdk 'jdk-21'
        maven 'maven-3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test (H2)') {
            steps {
              
                sh 'mvn clean test'
            }
        }

        stage('Package JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
    }

    post {
        success {
            echo '¡Éxito! La API se compiló y pasó las pruebas correctamente.'
        }
        failure {
            echo 'Fallo: Hubo un error en la compilación o en las pruebas unitarias.'
        }
    }
}