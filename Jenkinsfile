pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test (H2)') {
            steps {

                bat 'mvn clean test'
            }
        }

        stage('Package JAR') {
            steps {
                bat 'mvn clean package -DskipTests'
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