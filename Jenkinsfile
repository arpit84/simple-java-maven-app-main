    pipeline {
        agent any
        tools {
            ant 'LOCALANT'
            git 'LOCALGIT'
            jdk 'LOCALJDK17'
            maven 'LOCALMAVEN'
        }
        stages {

             stage('Checkout') {
                 steps {
                     script {
                              bat 'git --version'
                            }
                // Perform the checkout to ensure Git config is correct
                checkout scm
            }
        }

            stage('Source') {
                steps {
                    echo 'Getting Requirements....'
                    git branch: 'master',
                    changelog: false,
                    poll: false,
                    url: 'https://github.com/arpit84/simple-java-maven-app-main.git'
                }
            }
            stage("Clean") {
                steps {
                    echo 'Cleaning....'
                    bat "mvn clean"
                }
            }
            stage("Test") {
                steps {
                    echo 'Testing....'
                    bat "mvn test"
                }
            }
            stage("Package") {
                steps {
                    echo 'Packaging....'
                    bat "mvn package -DskipTests"
                }
            }

        }
        post {
            success {
                bat "echo success"
            }
        }
    }
