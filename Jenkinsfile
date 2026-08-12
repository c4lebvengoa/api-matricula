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
                sh 'mvn clean test'
            }
        }

        stage('Empaquetado JAR sin tests') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Generar Artefacto JAR'){
            steps{
               archiveArtifacts artifacts: 'target/*.jar', fingerprint:true
            }
        }
    }

    post {
        success {
            echo '¡Éxito! La API se compiló y paso las pruebas correctamente'
        }
        failure {
            echo 'Fallo: Hubo un error en la compilación o en las pruebas unitarias'
        }
    }
}

