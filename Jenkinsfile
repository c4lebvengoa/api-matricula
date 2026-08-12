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

        stage('Empaquetado JAR sin tests') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Generar Artefacto JAR'){
            steps{
               archiveArtifacts artifacts: 'target/*jar', fingerprint:true
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

