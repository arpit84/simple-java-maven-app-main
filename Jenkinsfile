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
        stage("Publish to Artifactory") {
            steps {
                script {
                    def server = Artifactory.server('3144394@artifactory')
                    def rtMaven = Artifactory.newMavenBuild()
                    rtMaven.resolver server: server, releaseRepo: 'nagp.2024.arpit.3144394', snapshotRepo: 'nagp.2024.arpit.3144394'
                    rtMaven.deployer server: server, releaseRepo: 'nagp.2024.arpit.3144394', snapshotRepo: 'nagp.2024.arpit.3144394'
                    
                    rtMaven.run pom: 'pom.xml', goals: 'clean install'
                    
                    server.publishBuildInfo(rtMaven.buildInfo)
                }
            }
        }
    }
    post {
        success {
            bat "echo success"
        }
    }
}
