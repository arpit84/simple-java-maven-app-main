pipeline {
    agent any
    tools {
    	  ant 'LOCALANT'
          git 'LOCALGIT'    
		  jdk 'LOCALJDK17'
        maven 'LOCALMAVEN'		  
    }
    stages {
        stage("Code Checkout") {
            steps {
                checkout scm
            }
        }
        stage("Code Build") {
            steps {
                bat "mvn clean"
            }
        }
        stage("Unit Test") {
            steps {
                bat "mvn test"
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
