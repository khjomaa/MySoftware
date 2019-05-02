pipeline {
    agent any
    triggers {
        pollSCM '*/30 * * * *'
    }
    stages {
        stage('checkout') {
            steps {
                git "https://github.com/khjomaa/MySoftware.git"
            }
        }
        stage("run something") {
            steps {
                sh 'python3 app.py'
            }
        }
    }
}