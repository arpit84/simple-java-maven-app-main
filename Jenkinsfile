pipeline {
    agent any
    tools {
	    ant 'LOCALANT'
	    git 'LOCALGIT'
	    jdk 'LOCALJDK17'
	  maven 'LOCALMAVEN'		  
    }
    stages {
        stage('Source') {
            steps {
                git branch: 'master',
                    changelog: false,
                    poll: false,
                    url: 'https://github.com/arpit84/simple-java-maven-app-main.git'
            }
        }
        stage("Clean") {
            steps {
                bat "mvn clean"
            }
        }
        stage("Test") {
            steps {
                bat "mvn test"
            }
        }
	stage("Package") {
            steps {
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
