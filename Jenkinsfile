def gv
pipeline {
    agent any
    stages {
        stage('init'){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage('Build') {
            steps {
                script{
                    gv.installdep()
                }  
            }
        }
        stage('build image') {
            steps {
                script{
                    gv.buildpushimg()
                    }
                }
            }
        }
        stage('Deliver') {
            steps {
                script{
                   gv.Deploying()
                }
            }
        }
    }
}
