def installdep(){
    echo "installing the dependecies"
    sh 'npm install'
}
def buildpushimg(){
    echo 'building the docker image'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh 'docker build -t ahmedsherifmo/maven-app:mvn-2.0 .'
        sh "echo ${PASS} | docker login -u ${USER} --password-stdin"
        sh 'docker push ahmedsherifmo/maven-app:mvn-2.0'
    }
}
def Deploying(){
    echo "Deploying the app"
}
return this