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
        stage('Build'){
            steps {
                script{
                    echo "Building the pipeline from ${BRANCH_NAME}"
                    gv.installdep()
                }  
            }
        }
        stage('build image'){
            when {
                expression {
                    BRANCH_NAME == 'master'
                } 
            }
            steps {
                script{
                    gv.buildpushimg()
                }
            }
        }
        stage('Deliver'){
            when {
                expression {
                    BRANCH_NAME == 'master'
                } 
            }
            steps {
                script{
                   gv.deployingApp()
                }
            }
        }
    }
        
}

