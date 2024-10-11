pipeline{
    agent any
    tools{
        maven 'LOCALMAVEN'
    }
    stages{
        stage("code checkout"){
            steps{
            checkout scm
            }
        }   
        stage("code build"){
            steps{
            bat "mvn clean"
            }
        }
        stage("unit test"){
            steps{
            bat "mvn test"
            }
        }
          
	    stage("Publish to Artifactory"){
            steps{
                rtMavenDeployer(
                    id: 'deployer',
                    serverId: '3144394@artifactory',
                    releaseRepo: 'nagp.2024.arpit.3144394',
                    snapshotRepo: 'nagp.2024.arpit.3144394'
                )
                rtMavenRun(
                    pom: 'pom.xml',
                    goals: 'clean test',
                    deployerId: 'deployer'
                    )
                rtPublishBuildInfo(
                    serverId:'3144394@artifactory',
                )
            }        
        }
 
    }
 
    post{
        success{
            bat "echo success"
            }
        }
}
